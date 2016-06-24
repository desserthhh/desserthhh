package edu.nju.onlinestock.dao;

import java.util.List;

import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Plan;


public interface PlanDao {
	boolean save(Plan plan);
	
	boolean update(Plan plan);

	Plan getPlanByPid(int pid);
	
	List<Plan> getPlanByCid(int cid);
	
	List<Plan> getAllPlan();
	
	public boolean saveAllsale(Allsale allsale) ;
	
	public String[] getAllsale(int pid);



	
}