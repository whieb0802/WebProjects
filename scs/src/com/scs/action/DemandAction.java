package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Demand;
import com.scs.service.DemandService;

public class DemandAction extends ActionSupport implements ModelDriven<Demand> {

	Map<String, Object> request;
	Demand demand = new Demand();
	DemandService demandService;

	@SuppressWarnings("unchecked")
	public DemandAction() {
	request = (Map<String, Object>) ActionContext.getContext().get("request");
	}

	public String demandSet() {
		List<Demand> list = demandService.findDemand("from Demand");
		request.put("list", list);
		return "demandSet";
	}
	
	public String demandUpdate() {
		demand.setP1maxdemand(demand.getP1maxdemand());
		demand.setP1mindemand(demand.getP1mindemand());
		demand.setP2maxdemand(demand.getP2maxdemand());
		demand.setP2mindemand(demand.getP2mindemand());
		demand.setP3maxdemand(demand.getP3maxdemand());
		demand.setP3mindemand(demand.getP3mindemand());
		demandService.updateDemand(demand);
		return "demandUpdate";
	}

	@Override
	public Demand getModel() {
		// TODO Auto-generated method stub
		return demand;
	}
	
	public DemandService getDemandService() {
		return demandService;
	}
    @Resource
	public void setDemandService(DemandService demandService) {
		this.demandService = demandService;
	}
	
}
