package edu.nju.onlinestock.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.model.Plan;


public class SetplanAction extends BaseAction {
	private String success = "success";
	private String input = "input";
	
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
		ServletContext sc = request.getServletContext();
		
		if(request.getParameter("store")==""||request.getParameter("date")==""||request.getParameter("cid")==""||request.getParameter("num")==""||request.getParameter("price")==""){
			return input;
	    }else{
			Plan plan = new Plan((String)request.getParameter("store"), (String)request.getParameter("date"),Integer.parseInt((String)request.getParameter("cid")) ,Integer.parseInt((String)request.getParameter("price")) , Integer.parseInt((String)request.getParameter("num")),0);
			planService.setPlan(plan);
			return success;
		}
	}
}
