package edu.nju.onlinestock.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.model.Plan;



public class AllowandAlterAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	
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
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int allow = Integer.parseInt(request.getParameter("allow"));
		System.out.println("pid:"+pid+" allow:"+allow);
		Plan plan = planService.getPlanByPid(pid);
		plan.setStatus(allow);
		System.out.println(planService.updatePlan(plan));
		
		return success;
	}
}
