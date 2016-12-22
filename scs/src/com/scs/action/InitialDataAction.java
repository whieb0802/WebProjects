package com.scs.action;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.scs.model.Message;
import com.scs.service.BillService;
import com.scs.service.ConsumeService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.GrowlineService;
import com.scs.service.InventoryService;
import com.scs.service.OrderService;
import com.scs.service.RelationService;
import com.scs.service.ReportService;
import com.scs.service.StorageService;
import com.scs.service.UserService;

public class InitialDataAction {
	
	private BillService billService;
	private UserService userService;
	private RelationService relationService;
	private StorageService storageService ;
	private FundService fundService;
	private CurrentimeService currentimeService;
	private InventoryService inventoryService;
	private GrowlineService growlineService;
	private ConsumeService consumeService;
	private ReportService reportService;
	private OrderService orderService;
	
	public InitialDataAction(){
	}
	
	public String initialData(){
		fundService.deleteAll(fundService.findFund("from Fund"));
		consumeService.deleteAll(consumeService.findConsume("from Consume"));
		growlineService.deleteAll(growlineService.findGrowline("from Growline"));
		inventoryService.deleteAll(inventoryService.findInventory("from Inventory"));
		reportService.deleteAll(reportService.findReport("from Report"));
		storageService.deleteAll(storageService.findStorage("from Storage"));
		billService.deleteAll(billService.findBill("from Bill"));
		orderService.deleteAll(orderService.findOrder("from Order"));
		relationService.deleteAll(relationService.findRelation("from Relation"));
		userService.deleteAll(userService.findUser("from User"));
		currentimeService.deleteAll(currentimeService.findCurrentime("from Currentime"));
		
		ActionContext.getContext().put("message", Message.msg44);
		
		return "initialData";
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

	public InventoryService getInventoryService() {
		return inventoryService;
	}
	@Resource
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public GrowlineService getGrowlineService() {
		return growlineService;
	}
	@Resource
	public void setGrowlineService(GrowlineService growlineService) {
		this.growlineService = growlineService;
	}

	public ConsumeService getConsumeService() {
		return consumeService;
	}
	@Resource
	public void setConsumeService(ConsumeService consumeService) {
		this.consumeService = consumeService;
	}

	public ReportService getReportService() {
		return reportService;
	}
	@Resource
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	@Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
