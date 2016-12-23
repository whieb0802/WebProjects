package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;
import com.whieb.digitalhome.dao.TemplateDao;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Template;
import com.whieb.digitalhome.util.MyComparator;
import com.whieb.digitalhome.util.UtilDao;

@Component("templateDao")
public class TemplateDaoImpl implements TemplateDao {

	private UtilDao utilDao;
	
	public UtilDao getUtilDao() {
		return utilDao;
	}
    @Resource(name="utilDao")
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public List<Template> findTemplate() {
		List<Template> temp = utilDao.find("from Template t", null);
		return temp;
	}
	@Override
	public void save(Template t) {
		utilDao.update(t);
	}
   
	@Override
	public List<Template> findSequence() {
		List<Template> temp = utilDao.find("from Template t where t.sequence != ?", new Object[]{0});
		return temp;
	}
	@Override
	public List<Template> findNextTemplate(String type) {
		List<Template> temp = utilDao.find("from Template t where t.type = ?", new Object[]{type});
		int s = temp.get(0).getSequence() + 1;
		if(s == 1)
			return null;
		else {
			List<Template> template = utilDao.find("from Template t where t.sequence = ?", new Object[]{s});
		    return template;
		    }
	}
	
	@Override
	public List<Item> getNextData(long id, String type,int topN) {
		List<Connection> conn = utilDao.find("from Connection con where con.resourceId = ?", new Object[]{id});
		List<Item> item = new ArrayList<Item>();
		if(conn.size() > topN){
			Comparator comp = new MyComparator(); 
			Collections.sort(conn, comp);
			for(Connection c : conn){
				List<Item> i = utilDao.find("from Item i where i.id = ?", new Object[]{c.getRelativeId()});
				if(i.get(0).getType().equals(type)){
					item.add(i.get(0));
					if(item.size() == topN)
						return item;}
			}
		}
		else{
			for(Connection c : conn){
				List<Item> i = utilDao.find("from Item i where i.id = ?", new Object[]{c.getResourceId()});
				if(i.get(0).getType().equals(type))
					item.add(i.get(0));
			}
		}
		return item;
	}
	
}
