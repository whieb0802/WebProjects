package com.whieb.digitalhome.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.SourceDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Source;

public class SourceService {
	private SourceDao sourceDao;
	private ItemDao itemDao;
	
	public SourceDao getSourceDao() {
		return sourceDao;
	}

	public void setSourceDao(SourceDao sourceDao) {
		this.sourceDao = sourceDao;
	}
	
	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void loadData() {
		sourceDao.clear();
		File file = new File("E:/SkyDrive/数字家庭项目文档/数据源/Fw_ 回复_ Re_ 武汉理工--海南有线数据需求/vod详单/vod详单.txt");
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(file));
			List<Source> sous = new ArrayList<Source>();
			boolean flag = false;
			while ((line = br.readLine()) != null) {
				if (!flag) {
					flag = true;
					continue;
				}
				try {
					transfer(line, sous);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (sous.size() >= 50) {
					sourceDao.saveOrUpdateAll(sous);
					System.out.println("insert into database " + sous.size());
					sous.clear();
				}
			}
			sourceDao.saveOrUpdateAll(sous);
			sous = null;
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Source> transfer(String line, List<Source> sous)
			throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (null == sous) {
			sous = new ArrayList<Source>();
		}
		if (null == line || "".equals(line)) {
			return sous;
		}
		String[] strs = line.split(",");
		if (strs.length < 14) {
			return sous;
		}
		String TVid = strs[2];
		String name = new String(strs[5].getBytes(), "utf-8");
		Date s_time = format.parse(strs[12]);
		Date e_time = format.parse(strs[13]);
		Source s = new Source(TVid, name, s_time, e_time);
		sous.add(s);
		return sous;
	}
	
	public void validate(){
		List<Source> ss = sourceDao.listAllSource();
		List<Item> items = itemDao.getAllItems();
		int sourceSize = ss.size();
		int itemSize = items.size();
		for(int i=0 ;i<sourceSize ;i++) {
			for(int j=0 ; j<itemSize ; j++){
				if(ss.get(i).getName().replaceAll("\"", "").equals(items.get(j).getTitle())) {
					System.out.println("i="+ i + "replace with" + "j=" + j);
				}
			}
		}
	}
}
