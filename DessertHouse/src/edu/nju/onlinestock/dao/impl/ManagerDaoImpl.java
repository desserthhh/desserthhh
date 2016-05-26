package edu.nju.onlinestock.dao.impl;

import hibernate3.support.YeekuHibernateDaoSupport;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




import edu.nju.onlinestock.dao.BaseDao;
import edu.nju.onlinestock.dao.ManagerDao;
import edu.nju.onlinestock.model.Manager;
import edu.nju.onlinestock.model.Member;

public class ManagerDaoImpl extends YeekuHibernateDaoSupport
	implements ManagerDao {
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Manager save(Manager manager) {
		Manager m = new Manager();
		// TODO Auto-generated method stub
		baseDao.save(manager);
		System.out.println("save:name:"+manager.getName());
		return m;
	}
	
	@Override
	public boolean findByAccountAndPassword(Manager manager) {
		// TODO Auto-generated method stub
		Manager m = null;
		String hql = "from edu.nju.onlinestock.model.Manager where account ='"+manager.getAccount()+"'";
		Session session = baseDao.getNewSession();
		List<Manager> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
		}else{
			System.out.println("找不到");
		}
//		Manager m = (Manager) baseDao.load(Manager.class, manager.getAccount());
//		
//		System.out.println(manager.getAccount());
//		
//		if(m==null){
//			System.out.println("找不到");
//			return false;
//		}
		
		System.out.println(m.getPassword());
		if(m.getPassword().equals(manager.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public Manager getManagerByAccount(int account) {
		// TODO Auto-generated method stub
		Manager m = null;
		String hql = "from edu.nju.onlinestock.model.Manager where account ='"+account+"'";
		Session session = baseDao.getNewSession();
		List<Manager> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
		}else{
			System.out.println("找不到");
		}
		
		return m;
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Manager";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}
	
	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		Manager m = getManagerByAccount(account);
		
		if(m==null){
			return "";
		}else{
			System.out.println(m.getName());
			return m.getName();
		}
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		
	}

}
