package edu.nju.onlinestock.dao.impl;

import hibernate3.support.YeekuHibernateDaoSupport;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.nju.onlinestock.dao.BaseDao;
import edu.nju.onlinestock.dao.WaiterDao;
import edu.nju.onlinestock.model.Waiter;

public class WaiterDaoImpl extends YeekuHibernateDaoSupport
	implements WaiterDao {
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Waiter save(Waiter waiter) {
		Waiter w = new Waiter();
		// TODO Auto-generated method stub
		baseDao.save(waiter);
		System.out.println("save:name:"+waiter.getName());
		return w;
	}

	@Override
	public boolean findByAccount(Waiter waiter) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Waiter> result = (List<Waiter>)getHibernateTemplate().
				find("from member as m where "
				+"m.account=?", waiter.getAccount());
		if(result.size() != 0)
			return true;
		return false;
	}
	
	@Override
	public boolean findByAccountAndPassword(Waiter waiter) {
		// TODO Auto-generated method stub
		
		Waiter w = (Waiter) baseDao.load(Waiter.class, waiter.getAccount());
		
		if(w==null){
			return false;
		}
		
		System.out.println(w.getPassword());
		System.out.println(w.getName());
		if(w.getPassword().equals(waiter.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public Waiter getWaiterByAccount(int account) {
		// TODO Auto-generated method stub
		Waiter w = (Waiter) baseDao.load(Waiter.class, account);
		
		return w;
	}

	@Override
	public List<Waiter> getAllWaiters() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Waiter";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		Waiter w = (Waiter) baseDao.load(Waiter.class, account);
		
		if(w==null){
			return "";
		}else{
			return w.getName();
		}
	}

	@Override
	public void update(Waiter waiter) {
		// TODO Auto-generated method stub
		
	}

}
