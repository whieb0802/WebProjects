package com.scs.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.scs.dao.GroupinfoDao;
import com.scs.model.Groupinfo;

@Component("groupinfoService")
public class GroupinfoService{

	private GroupinfoDao GroupinfoDao;
    @Resource
	public void setGroupinfoDao(GroupinfoDao GroupinfoDao) {
		this.GroupinfoDao = GroupinfoDao;
	}

	public GroupinfoDao getGroupinfoDao() {
		return GroupinfoDao;
	}

	public void saveGroupinfo(Groupinfo Groupinfo) {
		GroupinfoDao.saveGroupinfo(Groupinfo);

	}
	
	public void deleteGroupinfo(Groupinfo Groupinfo) {
		GroupinfoDao.deleteGroupinfo(Groupinfo);
	}
	
	public void deleteAll(List<Groupinfo> Groupinfo) {
		GroupinfoDao.deleteAll(Groupinfo);
	}
	
	public void updateGroupinfo(Groupinfo Groupinfo) {
		GroupinfoDao.updateGroupinfo(Groupinfo);
	}
	
	public Groupinfo getGroupinfo(Class<Groupinfo> groupinfo,int id){
		return (Groupinfo)GroupinfoDao.getGroupinfo(groupinfo,id);
	}

	public List<Groupinfo> findGroupinfo(String Groupinfo,Object o){
		return GroupinfoDao.findGroupinfo(Groupinfo,o);
	}
	
	public List<Groupinfo> findGroupinfo(String Groupinfo){
		return GroupinfoDao.findGroupinfo(Groupinfo);
	}

}
