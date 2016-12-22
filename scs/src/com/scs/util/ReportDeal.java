package com.scs.util;

import java.util.List;
import javax.annotation.Resource;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Growline;
import com.scs.model.Relation;
import com.scs.model.Report;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.GrowlineService;
import com.scs.service.RelationService;
import com.scs.service.ReportService;
import com.scs.service.UserService;

public class ReportDeal {
	
    private static ReportService reportService ;
    private static FundService fundService ;
    private static CurrentimeService currentimeService ;
    private static UserService userService ;
    private static RelationService relationService ;
    private static BillService billService;
    private static GrowlineService growlineService ;
	
    public static  void saveReport(int userid,int currentimeid){
    	
    	FinanceManage financeManage = new FinanceManage();
        Report report  = new Report();
        StorageCost storageCost = new StorageCost() ;

    	User user = userService.getUser(User.class, userid);
    	Currentime currentime = currentimeService.getCurrentime(Currentime.class, currentimeid);
    	Role role = relationService.getRelation(Relation.class, userid).getRole();
    	List<Growline> growline = growlineService.findGrowline("from Growline g where g.user=? and g.currentime=?", new Object[]{user,currentime});
    	//�ֽ�
    	List<Fund> listFund = fundService.findFund("from Fund f where f.user=? and f.currentime=?", new Object[]{user,currentime});
    	int currentmoney = listFund.get(0).getCurrentmoney();
    	//��������
    	List<Bill> listBill = billService.findBill("from Bill b where b.bfrom=? and b.currentime=?", new Object[]{userid,currentime});
    	int saleincome = financeManage.saleIncome(listBill.get(0));
    	//ֱ�ӳɱ�
    	int directcost = ProductValue.directCost(currentimeid, userid);
    	//�ֿ����
    	int storagerentcost = financeManage.rentCost(role, user, currentime);
    	//����Ʒ
    	int productstoragevalue = ProductValue.leftCost(currentimeid, userid);
    	//�������
    	float fundcost1 = listFund.get(0).getInterest();
    	int fundcost = (int)fundcost1;
    	//��Ʒ������
    	int productstoragecost = storageCost.storageCost(user, currentime);
    	//�ֿ��ʲ�
    	int storagevalue = financeManage.storageMoney(role, user, currentime);
    	//�������ʲ�
    	int growlinevalue = 0;
    	if(role.getRoleid()==1){
    		growlinevalue = financeManage.growLineValue(growline.get(0));
    	}
    	
    	//�ۼƴ����
    	int totalloan = listFund.get(0).getTotaloan();
    	//�ɶ��ʱ�
    	int initialcapital = financeManage.initialCapital(role);
    	//��������
    	int profitleft = 0;
    	if(currentimeid==1){
    		profitleft = 0;
    	}else{
    		profitleft = financeManage.profit(currentimeid-1, userid);
    	}
    	//Ϣǰ����
    	int taxbefore = financeManage.taxbefore(currentimeid, userid);
    	//���ھ���
    	int currentprofit = financeManage.profit(currentimeid, userid);
    	//����˰
    	int tax = taxbefore - currentprofit;
    	//Ӧ�տ�
    	int receivablemoney = 0;
    	
    	report.setCurrentime(currentime);
    	report.setCurrentmoney(currentmoney);
    	report.setCurrentprofit(currentprofit);
    	report.setDirectcost(directcost);
    	report.setFundcost(fundcost);
    	report.setGrowlinevalue(growlinevalue);
    	report.setInitialcapital(initialcapital);
    	report.setProductstoragecost(productstoragecost);
    	report.setProductstoragevalue(productstoragevalue);
    	report.setProfitleft(profitleft);
    	report.setReceivableMoney(receivablemoney);
    	report.setSaleincome(saleincome);
    	report.setStoragerentcost(storagerentcost);
    	report.setStoragevalue(storagevalue);
    	report.setTax(tax);
    	report.setTotalloan(totalloan);
    	report.setUser(user);
    	reportService.saveReport(report);
    }

	public static ReportService getReportService() {
		return reportService;
	}
	@Resource
	public static void setReportService(ReportService reportService) {
		ReportDeal.reportService = reportService;
	}

	public static FundService getFundService() {
		return fundService;
	}
	@Resource
	public static void setFundService(FundService fundService) {
		ReportDeal.fundService = fundService;
	}

	public static CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	@Resource
	public static void setCurrentimeService(CurrentimeService currentimeService) {
		ReportDeal.currentimeService = currentimeService;
	}

	public static UserService getUserService() {
		return userService;
	}
	@Resource
	public static void setUserService(UserService userService) {
		ReportDeal.userService = userService;
	}

	public static RelationService getRelationService() {
		return relationService;
	}
	@Resource
	public static void setRelationService(RelationService relationService) {
		ReportDeal.relationService = relationService;
	}

	public static BillService getBillService() {
		return billService;
	}
	@Resource
	public static void setBillService(BillService billService) {
		ReportDeal.billService = billService;
	}

	public static GrowlineService getGrowlineService() {
		return growlineService;
	}
    @Resource
	public static void setGrowlineService(GrowlineService growlineService) {
		ReportDeal.growlineService = growlineService;
	}
}
