package edu.nju.onlinestock.service;

import java.util.List;

import edu.nju.onlinestock.model.Plan;

import edu.nju.onlinestock.model.Allsale;

public interface PlanService {
	
	Plan getPlanByPid(int pid);
	
	List<Plan> getPlanByCid(int cid);
	
	boolean setPlan(Plan plan);//添加放映计划
	
	boolean allowPlanByPid(int pid);//经理批准放映计划
	
	List<Plan> getAllPlan();//根据系统时间获取放映开始时间在当前系统时间之后的放映计划
	
	boolean updatePlan(Plan plan);//经理未批准，服务员修改放映计划
	
	String[] getAllSale(int pid);

	
	boolean setAllsale(Allsale allsale);
}