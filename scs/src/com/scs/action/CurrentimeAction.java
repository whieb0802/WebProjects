package com.scs.action;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Currentime;
import com.scs.service.CurrentimeService;

public class CurrentimeAction extends ActionSupport implements ModelDriven<Currentime> {
	private static final long serialVersionUID = 1L;
	Currentime currentime = new Currentime();
	CurrentimeService cts;

	public CurrentimeAction() {
	}

	public String registerEnd1() {
		
		currentime.setCurrentime(1);
		cts.saveCurrentime(currentime);
		
		return "registerEnd1";
	}
	
	public String registerEnd2() {
		
		return "registerEnd2";
	}
	
    public String check() {
    	List<Currentime> list = cts.findCurrentime("from Currentime");
    	if(list.get(list.size()-1).getCurrentime()!=0)
    		return SUCCESS;
    	else
		    return ERROR;
	}

	public Currentime getModel() {
		return currentime;
	}
	
	public CurrentimeService getCts() {
		return cts;
	}
    @Resource(name="currentimeService")
	public void setCts(CurrentimeService cts) {
		this.cts = cts;
	}
	
}
