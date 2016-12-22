package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Currentime;
import com.scs.model.Message;
import com.scs.model.Relation;
import com.scs.model.Report;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.RelationService;
import com.scs.service.ReportService;
import com.scs.service.RoleService;
import com.scs.service.StorageService;
import com.scs.service.UserService;

@SuppressWarnings("serial")
public class FinanceAction extends ActionSupport  {

	Map<String, Object> request;
	private int currentime;
	
	private BillService billService;
	private UserService userService;
	private RelationService relationService;
	private StorageService storageService;
	private FundService fundService;
	private CurrentimeService currentimeService;
	private RoleService roleService;
	private ReportService reportService;
	
	@SuppressWarnings("unchecked")
	public FinanceAction() {
		request = (Map<String, Object>) ActionContext.getContext().get(
				"request");
	}
	
	public String profitReport(){
		Currentime currentime1 = (Currentime)currentimeService.getCurrentime(Currentime.class, currentime);
		List<Report> list = reportService.findReport("from Report r where r.currentime=?",currentime1);
		request.put("list", list);
		return "profitReport";
	}

	//利润表
	public String profit(){
		User user = (User) ActionContext.getContext().getSession().get("session");
		Currentime currentime1 = (Currentime)currentimeService.getCurrentime(Currentime.class, currentime);
		
		List<Report> list = reportService.findReport("from Report r where r.user=? and r.currentime=?",new Object[]{user,currentime1});
		if(user.getIscomplete()==-1 || list.size()==0){
			ActionContext.getContext().put("message", Message.msg38);
			return "error";
		}
		Report report = list.get(0);
		request.put("profit", report);
		return "profit";
	}
	
	//权益表
	public String equity(){
		User user = (User) ActionContext.getContext().getSession().get("session");
		Currentime currentime1 = currentimeService.getCurrentime(Currentime.class, currentime);
		
		
		List<Report> list = reportService.findReport("from Report r where r.user=? and r.currentime=?",new Object[]{user,currentime1});
		if(user.getIscomplete()==-1 || list.size()==0){
			ActionContext.getContext().put("message", Message.msg38);
			return "error";
		}
		Report report = list.get(0);
		request.put("profit", report);
		return "equity";
	}
	


	public int getCurrentime() {
		return currentime;
	}

	public void setCurrentime(int currentime) {
		this.currentime = currentime;
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

	public RoleService getRoleService() {
		return roleService;
	}
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ReportService getReportService() {
		return reportService;
	}
	@Resource
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
}
