package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Storageinfo;
import com.scs.service.StorageinfoService;

public class StorageinfoAction extends ActionSupport implements ModelDriven<Storageinfo> {
	
	Storageinfo storageinfo = new Storageinfo();
	
	private StorageinfoService storageinfoService;
	Map<String,Object> request;
	
	@SuppressWarnings("unchecked")
	public StorageinfoAction(){
		request = (Map<String,Object>)ActionContext.getContext().get("request");
	}
	
	public String bedParamSet(){
		List<Storageinfo> list = storageinfoService.findStorageinfo("from Storageinfo");
		request.put("list", list);
		
		return "bedParamSet";
	}
	
     public String bedParamUpdate(){
    	Storageinfo storageinfo1 = storageinfoService.getStorageinfo(Storageinfo.class, storageinfo.getId());
    	storageinfo1.setP1count(storageinfo.getP1count());
    	storageinfo1.setP2count(storageinfo.getP2count());
    	storageinfo1.setP3count(storageinfo.getP3count());
    	storageinfo1.setRentprice(storageinfo.getRentprice());
    	storageinfo1.setBuyprice(storageinfo.getBuyprice());
    	storageinfoService.updateStorageinfo(storageinfo1);
		return "bedParamUpdate";
	}

	@Override
	public Storageinfo getModel() {
		return storageinfo;
	}
	
	public StorageinfoService getStorageinfoService() {
		return storageinfoService;
	}
    @Resource
	public void setStorageinfoService(StorageinfoService storageinfoService) {
		this.storageinfoService = storageinfoService;
	}

}
