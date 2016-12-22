package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Bill;
import com.scs.model.Currentime;

@Component("billDao")
public class BillDao extends BaseDao {
	
	public void saveBill(Bill bill) {
		getHibernateTemplate().save(bill);
	}
	
	public void deleteBill(Bill bill) {
		getHibernateTemplate().delete(bill);
	}
	public void deleteAll(List<Bill> bill) {
		getHibernateTemplate().deleteAll(bill);
	}
	
	public void updateBill(Bill bill) {
		getHibernateTemplate().update(bill);
	}
	
	public Bill getBill(Class<Bill> bill,int id) {
		return (Bill)getHibernateTemplate().get(bill, id);
	}
	
	public List<Bill> findBill(String bill) {
		return getHibernateTemplate().find(bill);
	}

	public List<Bill> findBill(String bill,Object o) {
		return getHibernateTemplate().find(bill, o);
	}
	
	public List<Bill> findBill(String bill,Object[] objects) {
		return getHibernateTemplate().find(bill,objects);
	}
	
	public boolean ifexists(int bfrom , int bto,Currentime currentime){
		List list = getHibernateTemplate().find("from Bill b where b.bfrom = ? and b.bto = ?  and b.currentime = ?", new Object[]{bfrom,bto,currentime});
		if(list.size() != 0)
		   return true;
		else
		return false;
	}
}
