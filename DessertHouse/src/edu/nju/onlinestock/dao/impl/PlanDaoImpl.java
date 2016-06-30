package edu.nju.onlinestock.dao.impl;
import java.util.*; 
import hibernate3.support.YeekuHibernateDaoSupport;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.onlinestock.dao.BaseDao;
import edu.nju.onlinestock.dao.PlanDao;
import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.model.Plan;


public class PlanDaoImpl extends YeekuHibernateDaoSupport
	implements PlanDao {
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public boolean save(Plan plan) {
		// TODO Auto-generated method stub
		String hql = "select max(p.pid) from edu.nju.onlinestock.model.Plan p";
		Session session = baseDao.getNewSession();
		int id = (Integer)session.createQuery(hql).uniqueResult();
		System.out.println(id);
		plan.setPid(id+1);
		baseDao.save(plan);
		
		return true;
	}

	@Override
	public boolean update(Plan plan) {
		// TODO Auto-generated method stub
		baseDao.update(plan);
		Plan p = getPlanByPid(plan.getPid());
		
		return p.getClass().equals(plan);
	}

	@Override
	public Plan getPlanByPid(int pid) {
		// TODO Auto-generated method stub
		System.out.println(pid);
		return (Plan) baseDao.load(Plan.class, pid);
	}


	@Override
	public List<Plan> getPlanByCid(int cid) {
		String hql = "from edu.nju.onlinestock.model.Plan where date='"+getNow()+"' and cid='"+cid+"'";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	
	@Override
	public List<Plan> getAllPlan() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Plan where date>now() or date='"+getNow()+"'";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}


	@Override
	public boolean saveAllsale(Allsale allsale) {
		// TODO Auto-generated method stub
		String hql = "select max(s.aid) from edu.nju.onlinestock.model.Allsale s";
		Session session = baseDao.getNewSession();
		int id = (Integer)session.createQuery(hql).uniqueResult();
		System.out.println(id);
		allsale.setAid(id+1);
		baseDao.save(allsale);
		
		return true;
	}

	@Override
	public String[] getAllsale(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	String getNow(){
		Date now = new Date();
		DateFormat form = new SimpleDateFormat("yyyy-MM-dd "); 
		String an = form.format(now);
		return an;
	}

}
