package edu.nju.onlinestock.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.model.Plan;



public class CountAction extends BaseAction {
	private String success = "success";
	
	@Autowired
	private PlanService planService;

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return success;
	}
}
