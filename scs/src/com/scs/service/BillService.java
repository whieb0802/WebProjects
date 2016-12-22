package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.BillDao;
import com.scs.model.Bill;
import com.scs.model.Currentime;

@Component("billService")
public class BillService{
	
	private BillDao billDao;
	
	@Resource
	public void setBillDao(BillDao billDao) {
		this.billDao = billDao;
	}

	public BillDao getBillDao() {
		return billDao;
	}

	public void updateBill(Bill bill) {
		billDao.updateBill(bill);
	}

	public void deleteBill(Bill bill) {
		billDao.deleteBill(bill);
	}
	public void deleteAll(List<Bill> bill) {
		billDao.deleteAll(bill);
	}
	public void saveBill(Bill bill) {
		billDao.saveBill(bill);

	}
	public Bill getBill(Class<Bill> bill,int id) {
		return (Bill)billDao.getBill(bill,id);
	}
	
	public List<Bill> findBill(String bill,Object o){
		return billDao.findBill(bill,o);
	}
	
	public List<Bill> findBill(String bill){
		return billDao.findBill(bill);
	}
	public List<Bill> findBill(String bill,Object[] objects){
		return billDao.findBill(bill,objects);
	}
	public boolean ifexists(int bfrom , int bto,Currentime currentime){
		return billDao.ifexists(bfrom, bto, currentime);
	}
}
