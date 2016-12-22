package com.scs.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import com.scs.model.Area;
import com.scs.model.Groupinfo;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.AreaService;
import com.scs.service.GroupinfoService;
import com.scs.service.RelationService;
import com.scs.service.RoleService;
import com.scs.service.UserService;

//fenzu
public class Group  {

	private UserService us;
	private AreaService as;
	private RoleService ros;
	private RelationService res;
	private GroupinfoService groupinfoService;
	
	List<User> listUser;
	List<Role> listRole;
	List<Area> listArea;
    
	int a;    //每组生产商个数
	int b;    //每组代理商个数
	int c;    //每组零售商个数
	int n;    //组数
     
	public Group() {
		
		Groupinfo groupinfo = groupinfoService.getGroupinfo(Groupinfo.class, 1);
		listUser = us.findUser("from User");
		listRole = ros.findRole("from Role");
		listArea = as.findArea("from Area");

		a = groupinfo.getManCount();
		b = groupinfo.getAgentCount();
		c = groupinfo.getRetailerCount();
		n = groupinfo.getGroupCount();
	}

	public void saveRelation() {
		Relation relation = new Relation();
		for (int i = 0; i < listUser.size(); i++) {
			relation.setUserid(listUser.get(i).getUserid());
			relation.setArea(listArea.get(0));
			relation.setRole(listRole.get(0));
			relation.setUpstream(listUser.get(i).getUserid());
			res.saveRelation(relation);
		}
	}

	public void groupBegin() {
		List<Relation> listRelation1 = new ArrayList<Relation>();
		List<Relation> listRelation2 = new ArrayList<Relation>();
		List<Relation> listRelation3 = new ArrayList<Relation>();

		List<Relation> listRelation = res.findRelation("from Relation");
		int m = 0;

		while (m < n) {
			for (int i = 0; i < listUser.size(); i++) {

				if (listRelation.get(i).getUserid() <= (a + (a + b + c) * m)
						&& listRelation.get(i).getUserid() > (a + b + c) * m) {
					listRelation.get(i).setRole(listRole.get(0));
					listRelation.get(i).setArea(listArea.get(m));
					listRelation1.add(listRelation.get(i));
					res.updateRelation(listRelation.get(i));
				} else if (listRelation.get(i).getUserid() <= (a + b + (a + b + c)
						* m)
						&& listRelation.get(i).getUserid() > (a + b + c) * m) {
					listRelation.get(i).setRole(listRole.get(1));
					listRelation.get(i).setArea(listArea.get(m));
					listRelation2.add(listRelation.get(i));
					res.updateRelation(listRelation.get(i));
				} else if (listRelation.get(i).getUserid() <= ((a + b + c) + (a
						+ b + c)
						* m)
						&& listRelation.get(i).getUserid() > (a + b + c) * m) {
					listRelation.get(i).setRole(listRole.get(2));
					listRelation.get(i).setArea(listArea.get(m));
					listRelation3.add(listRelation.get(i));
					res.updateRelation(listRelation.get(i));
				}
				groupUpstream(listRelation1, listRelation2, a, b);
				groupUpstream(listRelation2, listRelation3, b, c);
			}
			listRelation1.clear();
			listRelation2.clear();
			listRelation3.clear();
			m++;
		}
	}

	public void groupUpstream(List<Relation> listRelation4,
			List<Relation> listRelation5, int x, int y) {
		int p = x;
		while (p >= 1) {
			for (int i = 0; i < listRelation5.size(); i++) {
				if (i < p * y / x) {
					listRelation5.get(i).setUpstream(
							listRelation4.get(p - 1).getUserid());
					res.updateRelation(listRelation5.get(i));
				}
			}
			p--;
		}

	}
	
	public UserService getUs() {
		return us;
	}
    @Resource(name="userService")
	public void setUs(UserService us) {
		this.us = us;
	}

	public AreaService getAs() {
		return as;
	}
    @Resource(name="areaService")
	public void setAs(AreaService as) {
		this.as = as;
	}

	public RoleService getRos() {
		return ros;
	}
    @Resource(name="roleService")
	public void setRos(RoleService ros) {
		this.ros = ros;
	}

	public RelationService getRes() {
		return res;
	}
    @Resource(name="relationService")
	public void setRes(RelationService res) {
		this.res = res;
	}

	public GroupinfoService getGroupinfoService() {
		return groupinfoService;
	}
    @Resource(name="groupinfoService")
	public void setGroupinfoService(GroupinfoService groupinfoService) {
		this.groupinfoService = groupinfoService;
	}

}
