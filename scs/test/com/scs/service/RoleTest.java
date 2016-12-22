package com.scs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.model.Role;
import com.scs.model.User;


public class RoleTest {
	
	@Test	
	public void RoleSaveTest(){
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	RoleService us = (RoleService)ctx.getBean("roleService");
	Role Role = new Role();
	Role.setRolename("agent");
	us.saveRole(Role);
	}
	
	@Test
	public void GetRoleTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleService us = (RoleService)ctx.getBean("roleService");
		Role u = us.getRole(Role.class, 2);
		System.out.println(u.getRolename());
	}
	
	
	@Test
	public void FindRoleStringTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleService us = (RoleService)ctx.getBean("roleService");
		
		List<Role> list = (List<Role>)us.findRole("from Role");
		
		for(Role role:list){
			System.out.println(role.getRolename());
		}
	}
	
	@Test
	public void FindRoleStringObjectTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleService us = (RoleService)ctx.getBean("roleService");
		
		List<Role> list = (List<Role>)us.findRole("from Role r where r.roleid = ?", 2);
		
		for(Role role:list){
			System.out.println(role.getRolename());
		}
	}
}
