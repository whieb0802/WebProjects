package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.ConnectionDao;
import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.TradeDao;
import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.model.Config;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Trade;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.MyComparator;
import com.whieb.digitalhome.util.Parameter;

/*
 * @author   yujifang
 * 关联规则挖掘
 */
@Component
public class ConnectionService {

	private ConnectionDao connectionDao;
	private TradeDao tradeDao;
	private UserDao userDao;
	private ItemDao itemDao;
	private ParameterService ps;
	

	private Map<Integer, List<Integer>> data; // 保存最原始的itemId数据,key为userId,value为与用户查看过的itemId
	private int max; // 存放一项集的最大值
	private int[] k1Value; // 一项集的支持度
	private int[] pk1; // 存放一项频繁集数据
	private List<Connection> pk2;// 存放二项频繁集数据
	private int agree; // 最小支持度阈值
	private double believe; // 最小置信度阈值
	private List<Integer> userIds;// 所有用户Id

	public ParameterService getPs() {
		return ps;
	}

	@Resource(name = "parameterService")
	public void setPs(ParameterService ps) {
		this.ps = ps;
	}

	public ConnectionDao getConnectionDao() {
		return connectionDao;
	}

	@Resource
	public void setConnectionDao(ConnectionDao connectionDao) {
		this.connectionDao = connectionDao;
	}

	public TradeDao getTradeDao() {
		return tradeDao;
	}

	@Resource(name = "tradeDao")
	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	@Resource(name = "itemDao")
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void run() {
		max = 0;
		userIds = new ArrayList<Integer>();
		data = new HashMap<Integer, List<Integer>>();
		delete();
		initData();
		getParameter();
		initRegex();
		calculate();
		save();
	}
	
	//清除数据库之前的数据
	private void delete(){
		List<Connection> con = connectionDao.getAllConnection();
		if(con.size() != 0)
			connectionDao.deleteConnection(con);
	}

	// 从rating表中查找所有的userId及与其相关的itemId
	private void initData() {
		List<User> users = userDao.findAllUser();
		for (User u : users)
			userIds.add(Integer.parseInt(u.getId().getId()));
		for (int l : userIds) {
			List<Trade> trade = tradeDao.findTradeByuserId(l);
			List<Integer> itemIds = new ArrayList<Integer>();
			for (Trade t : trade)
				itemIds.add((int) t.getItemId());
			data.put(l, itemIds);
			for (Integer i : itemIds)
				if (max < i) {
					max = i;
				}
		}
	}

	// 计算一项集的支持度并填充一频繁集
	private void initRegex() {
		int count = 0;
		k1Value = new int[max];
		for (int l : userIds) {
			List<Integer> itemIds = data.get(l);
			for (int lo : itemIds) {
				k1Value[lo - 1] += 1; // 一项集的支持度
			}
		}
		for (int i = 0; i < max; i++) { // 统计一项频繁集的数量
			if (k1Value[i] >= agree)
				count++;
		}
		pk1 = new int[count];
		int a = 0;
		for (int i = 0; i < max; i++) { // 填充一项频繁集
			if (k1Value[i] >= agree) {
				pk1[a] = i + 1;
				a++;
			}
		}
	}

	// 计算二项频繁集的置信度
	private void calculate() {
		pk2 = new ArrayList<Connection>();
		for (int i = 0; i < pk1.length; i++) {
			for (int j = i + 1; j < pk1.length; j++) {
				int count = 0;
				double bel = 0;
				double sup = 0;
				List<Integer> temp = new ArrayList<Integer>(); // 临时存放二项集
				temp.add(pk1[i]);
				temp.add(pk1[j]);
				for (int l : userIds) {
					List<Integer> li = data.get(l);
					if (li.containsAll(temp))
						count++; // 得到二项集的支持度
				}
				sup = count / (double) userIds.size(); // 支持度计算
				bel = count / (double) k1Value[pk1[i] - 1]; // 置信度计算
				if (bel >= believe) {
					Connection c = new Connection();
					c.setResourceId((long) pk1[i]);
					c.setRelativeId((long) pk1[j]);
					c.setSupportLevel(sup);
					c.setConfidence(bel);
					pk2.add(c);
				}
			}
		}
	}

	// 保存二项频繁集
	private void save() {
		for (Connection c : pk2)
			connectionDao.saveOrUpdata(c);
	}

	// 调用方法，获取参数
	private void getParameter() {
		String support = ps.getConfig().getValue(Parameter.ASSOCIATION_MINSUPPORT);
		String confidence = ps.getConfig().getValue(Parameter.ASSOCIATION_MINCONFIDENCE);
		agree = (int) (userIds.size() * Integer.parseInt(support));
//		agree = (int) (userIds.size() * Double.parseDouble(support));
		System.out.println(agree);
		believe = Double.parseDouble(confidence); 
		System.out.println(believe);
	}

	/*
	 * 以下方法用于根据关联结果进行实时推荐
	 */
	// 根据推荐的connection集合得到item集合
	public List<Item> getConnectionData(List<Connection> con) {
		List<Item> item = itemDao.getItemByConnection(con);
		return item;
	}

	// 根据用户正在看的item得到关联规则挖掘后推荐的connection集合,过滤用户已经看过的item
	public List<Connection> getConnection(Long userId, Long itemId) {
		List<Connection> con = connectionDao.getConnectionByResourceId(itemId);
		List<Trade> t = tradeDao.findTradeByuserId(userId);
		con = select(con, t);
		return con;
	}
    
	// 根据用户正在看的item得到关联规则挖掘后推荐的connection集合,不过滤用户已经看过的item
	public List<Connection> getConnection(Long itemId){
		List<Connection> con = connectionDao.getConnectionByResourceId(itemId);
		con = select(con);
		return con;
	}
	
	// 从结果中挑选topN个item，不足topN个进行补足，要进行二次填充
	@SuppressWarnings("unchecked")
	private List<Connection> selectPrepare(List<Connection> con, List<Trade> tra) {
		int num = 0;
		List<Connection> c = new ArrayList<Connection>();
		List<Connection> cb = new ArrayList<Connection>();
		int topN = ps.getTopN();
		Boolean f = true;
		while (f) {
			cb = remove(con, tra);
			c.addAll(cb);
			if (c.size() < topN) { // 判断推荐的item个数是否小于topN
				Long itemId = getMax(c);
				con = connectionDao.getConnectionByResourceId(itemId);
			} else if (c.size() >= topN) {
				@SuppressWarnings("rawtypes")
				Comparator comp = new MyComparator(); // ？？？？排序问题待解决：因区分排序，如要二次获取con，则一次获取的con应全部显示，在才二次获取的con中显示部分
				Collections.sort(cb, comp); // 排序取confidence靠前的Connection
				c.removeAll(cb);
				num = topN - c.size();
				cb = cb.subList(0, num);
				c.addAll(cb);
				f = false;
			}
		}
		return c;
	}
	
	//从结果中挑选topN个结果，不进行二次填充,过滤用户已经看过的
	private List<Connection> select(List<Connection> con, List<Trade> tra) {
		int num = 0;
		List<Connection> c = new ArrayList<Connection>();
		int topN = ps.getTopN();
		c = remove(con, tra);
		//排序
		@SuppressWarnings("rawtypes")
		Comparator comp = new MyComparator(); 
		Collections.sort(c, comp); // 排序取confidence靠前的Connection
		
		if (c.size() >= topN) {
			c = c.subList(0, topN);
			}
		return c;
	}
	
	//从结果中挑选topN个结果，不进行二次填充,不过滤用户已经看过的
	private List<Connection> select(List<Connection> con) {
		List<Connection> c = con ;
		int topN = ps.getTopN();
		//排序
		@SuppressWarnings("rawtypes")
		Comparator comp = new MyComparator(); 
		Collections.sort(c, comp); // 排序取confidence靠前的Connection
		if (c.size() >= topN) {
			c = c.subList(0, topN);
		}
		return c;
	}
   
	// 去掉用户看过的item
	private List<Connection> remove(List<Connection> con, List<Trade> tra) {
		Boolean f = true;
		List<Connection> conn = new ArrayList<Connection>();
		for (Connection c : con) { // 去掉用户已看过的item
			for (Trade t : tra)
				if (c.getRelativeId() == t.getItemId())
					f = false;
				else
					f = true;
			if (f)
				conn.add(c);
		}
		return conn;
	}

	// 从结果中取出置信度最大的itemId
	private long getMax(List<Connection> con) {
		double temp = con.get(0).getConfidence();
		long itemId = con.get(0).getRelativeId();
		for (int i = 0; i < con.size(); i++) {
			double confidence = con.get(i).getConfidence();
			if (confidence > temp) {
				temp = confidence;
				itemId = con.get(i).getRelativeId();
			}
		}
		return itemId;
	}
}
