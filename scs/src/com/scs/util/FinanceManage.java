package com.scs.util;

import java.util.List;
import javax.annotation.Resource;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Growline;
import com.scs.model.Growlineinfo;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.Storageinfo;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.GrowlineinfoService;
import com.scs.service.RelationService;
import com.scs.service.StorageService;
import com.scs.service.StorageinfoService;
import com.scs.service.UserService;

public class FinanceManage {

	private BillService billService ;
	private UserService userService ;
	private RelationService relationService ;
	private StorageService storageService ;
	private FundService fundService ;
	private CurrentimeService currentimeService ;
	private StorageinfoService storageinfoService ;
	private GrowlineinfoService growlineinfoService ;
	
	//息前利润
	public int taxbefore(int currentime,int userid){
		User user = userService.getUser(User.class, userid);
		Currentime currentime1 = (Currentime)currentimeService.getCurrentime(Currentime.class, currentime);
		Relation relation = relationService.getRelation(Relation.class, userid);
		Role role = relation.getRole();
		List<Bill> billlist =  billService.findBill("from Bill b where b.currentime=? and b.bfrom=?", new Object[]{currentime1,userid});
		List<Fund> fundlist = fundService.findFund("from Fund f where f.user=? and f.currentime=?",new Object[]{user,currentime1});
		
		int saleIncome =0;
		if(billlist.size()!=0){
			Bill bill= billlist.get(0);
			saleIncome = saleIncome(bill);
		}

		int directCost = ProductValue.directCost(currentime, userid);
		
		int rentCost = rentCost(role,user,currentime1);
		
		StorageCost storageCost = new StorageCost();
		int productStoCost = storageCost.storageCost(user, currentime1);
		
		float fundCost = fundCost(fundlist.get(0));
		float profit =0;
		
		profit = saleIncome-rentCost-productStoCost-directCost-fundCost;
		
		return (int)profit ;
	}
	
	//息后利润
	public int profit(int currentime,int userid){
		float taxbefore = taxbefore(currentime,userid);
		float profit = 0;
		float tax = 0;
		if(taxbefore<=0){
			return (int)taxbefore;
		}
		
		if(currentime==1){
			tax = (float)(profit*0.17);
			profit = taxbefore - tax;
		}
		else{
			if(profit(currentime-1,userid)<0){
			    float profit1 = taxbefore+profit(currentime-1,userid) ;
			    tax = (float)(profit1*0.17);
				profit = taxbefore - tax;
			}else{
				tax = (float)(taxbefore*0.17);
				profit = taxbefore - tax;
			}
		}
		return (int)profit ;
	}
	
	//销售收入
	public int saleIncome(Bill bill){
		int saleIncome = 0;
		if(bill != null){
			saleIncome = bill.getCountp1()*bill.getP1price()+bill.getCountp2()*bill.getP2price()+bill.getCountp3()*bill.getP3price();
		}
		return saleIncome;
	}
	//仓库租金
	public int rentCost(Role role,User user,Currentime currentime){
		Storageinfo storageinfo1 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{1,role}).get(0);
		Storageinfo storageinfo2 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{2,role}).get(0);
		Storageinfo storageinfo3 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{3,role}).get(0);
	    List<Storage> list1 = storageService.findStorage("from Storage s where s.user=? and s.currentime<=?",new Object[]{user,currentime});
        
	  //小仓库个数
		int smallCount = 0;
		for(Storage s:list1){
			smallCount += s.getRent1count();
		}
		//中仓库个数
		int middleCount = 0;
		for(Storage s:list1){
			middleCount += s.getRent2count();
		}
		//大仓库个数
		int bigCount = 0;
		for(Storage s:list1){
			bigCount += s.getRent3count();
		}
		int rentCost = 0;
		rentCost = storageinfo1.getRentprice()*smallCount + storageinfo2.getRentprice()*middleCount + storageinfo3.getRentprice()*bigCount;
		return rentCost;
	}
	//仓库资产
	public int storageMoney(Role role,User user,Currentime currentime){
		Storageinfo storageinfo1 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{1,role}).get(0);
		Storageinfo storageinfo2 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{2,role}).get(0);
		Storageinfo storageinfo3 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{3,role}).get(0);
	    List<Storage> list1 = storageService.findStorage("from Storage s where s.user=? and s.currentime<=?",new Object[]{user,currentime});
	  //小仓库个数
		int smallCount = 0;
		for(Storage s:list1){
			smallCount += s.getBuy1count();
		}
		//中仓库个数
		int middleCount = 0;
		for(Storage s:list1){
			middleCount += s.getBuy2count();
		}
		//大仓库个数
		int bigCount = 0;
		for(Storage s:list1){
			bigCount += s.getBuy3count();
		}
	    
	    int storageMoney = 0;
	    storageMoney = storageinfo1.getBuyprice()*smallCount + storageinfo2.getBuyprice()*middleCount + storageinfo3.getBuyprice()*bigCount;
		return storageMoney;
	}
	
	//productStoCost产品存储费用已封装StorageCost
	
    //财务费用
	public int fundCost(Fund fund){
		float fundCost = 0;
		fundCost = fund.getInterest();
		return (int)fundCost;
	}
	
	//directCost直接成本已封装DirectCost
    
	//股东资本
	public int initialCapital(Role role){
		Storageinfo storageinfo1 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{1,role}).get(0);
		Storageinfo storageinfo2 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{2,role}).get(0);
		Storageinfo storageinfo3 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{3,role}).get(0);
		Growlineinfo p1growline = growlineinfoService.getGrowlineinfo(Growlineinfo.class,1);
		Growlineinfo p2growline  = growlineinfoService.getGrowlineinfo(Growlineinfo.class,2);
		Growlineinfo p3growline  = growlineinfoService.getGrowlineinfo(Growlineinfo.class,3);
		//初始库存
		int initialstorage = role.getSmallStorage()*storageinfo1.getBuyprice() + role.getMiddleStorage()*storageinfo2.getBuyprice() + role.getBigStorage()*storageinfo3.getBuyprice();
		//初始生产线
		int initialgrowline = role.getP1growline()*p1growline.getBuyprice() + role.getP2growline()*p2growline.getBuyprice() + role.getP3growline()*p3growline.getBuyprice();
		//初始资金
		int initialmoney = role.getInitialmoney();
		//初始产品
		int initialproduct = 0;
		int initialcapital = initialstorage + initialgrowline + initialmoney + initialproduct;
		return initialcapital;
	}
	//生产线资产
	public int growLineValue(Growline growline){
		Growlineinfo p1growline = growlineinfoService.getGrowlineinfo(Growlineinfo.class,1);
		Growlineinfo p2growline  = growlineinfoService.getGrowlineinfo(Growlineinfo.class,2);
		Growlineinfo p3growline  = growlineinfoService.getGrowlineinfo(Growlineinfo.class,3);
		int growlinevalue = growline.getBuyp1growline()*p1growline.getBuyprice() + growline.getBuyp2growline()*p2growline.getBuyprice()+growline.getBuyp3growline()*p3growline.getBuyprice();
		return growlinevalue;
	}
	
	public BillService getBillService() {
		return billService;
	}
    @Resource
	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RelationService getRelationService() {
		return relationService;
	}
	@Resource
	public void setRelationService(RelationService relationService) {
		this.relationService = relationService;
	}

	public StorageService getStorageService() {
		return storageService;
	}
	@Resource
	public void setStorageService(StorageService storageService) {
		this.storageService = storageService;
	}

	public FundService getFundService() {
		return fundService;
	}
	@Resource
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	@Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
	}

	public StorageinfoService getStorageinfoService() {
		return storageinfoService;
	}
	@Resource
	public void setStorageinfoService(StorageinfoService storageinfoService) {
		this.storageinfoService = storageinfoService;
	}

	public GrowlineinfoService getGrowlineinfoService() {
		return growlineinfoService;
	}
	@Resource
	public void setGrowlineinfoService(GrowlineinfoService growlineinfoService) {
		this.growlineinfoService = growlineinfoService;
	}
}
