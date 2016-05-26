package edu.nju.onlinestock.service.impl;


import java.util.List;

import edu.nju.onlinestock.dao.PlanDao;
import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Plan;

import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.service.PlanService;

public class PlanServiceImpl implements PlanService {
	private PlanDao planDao;
	
	public void setPlanDao(PlanDao planDao) {
		this.planDao = planDao;
	}
	
	@Override
	public Plan getPlanByPid(int pid) {
		// TODO Auto-generated method stub
		return planDao.getPlanByPid(pid);
	}

	@Override
	public boolean setPlan(Plan plan) {
		// TODO Auto-generated method stub
		return planDao.save(plan);
	}

	@Override
	public boolean allowPlanByPid(int pid) {
		// TODO Auto-generated method stub
		Plan p = planDao.getPlanByPid(pid);
		p.setStatus(1);
		return planDao.update(p);
	}

	@Override
	public List<Plan> getAllPlan() {
		// TODO Auto-generated method stub
		return planDao.getAllPlan();
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		return planDao.update(plan);
	}

	@Override
	public String[] getAllSale(int pid) {
		// TODO Auto-generated method stub
		return planDao.getAllsale(pid);
	}

	@Override
	public boolean setAllsale(Allsale allsale) {
		// TODO Auto-generated method stub
		return planDao.saveAllsale(allsale);
	}
	

}