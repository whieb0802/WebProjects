package com.whieb.digitalhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.TemplateDao;
import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Template;
/*
 * @author   yujifang
 * 业务模版
 */
@Component("templateService")
public class TemplateService {
	
	private TemplateDao td;
	private ItemDao idi;
	private ParameterService ps;
	
	public ParameterService getPs() {
		return ps;
	}
	@Resource(name="parameterService")
	public void setPs(ParameterService ps) {
		this.ps = ps;
	}
	public ItemDao getIdi() {
		return idi;
	}
    @Resource(name="itemDao")
	public void setIdi(ItemDao idi) {
		this.idi = idi;
	}

	public TemplateDao getTd() {
		return td;
	}

	@Resource(name="templateDao")
	public void setTd(TemplateDao td) {
		this.td = td;
	}

	public Map<Integer, String> getType() {
		List<Template> temp = td.findTemplate();
		Map<Integer , String> content = new HashMap<Integer , String>();
		for(Template t:temp){
			content.put((int)t.getId(), t.getType());
		}
		return content;
	}

	public void save(List<Integer> sequence) {
		List<Template> temp = td.findTemplate();
		int index = 1;
		//保存前顺序全部清零
		for(Template t:temp){
			t.setSequence(0);
		}
		//更新制定好的顺序
		for(Integer s:sequence){
			for(Template t:temp){
				if(s.equals((int)t.getId())){
					t.setSequence(index);
				}
			}
			index++;
		}
		for(Template t:temp){
		   td.save(t);
		}
	}
    
	//得到之前定制好的业务模版
	public String[] getSequence(){
		List<Template> temp = td.findSequence();
		int size = temp.size();
		if(size == 0){
			return null;
		}
		else {	
		   String[] message = new String[size];
		   for(Template t:temp){
			message[t.getSequence()-1] = t.getType();
		    }
		   return message;
		}
	}

	//根据条目ID获得模版推荐结果
	public List<Item> getNextData(long itemId) {
		String type;
		Item item = idi.findItem(itemId);
		List<Template> temp = td.findNextTemplate(item.getType());
		if(temp == null)
			return null;
		else {
			type = temp.get(0).getType();
		    List<Item> end = td.getNextData(itemId,type,ps.getConfig().getTopN());
		    return end;
		    }
	}
}
