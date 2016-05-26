package edu.nju.onlinestock.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.dao.BaseDao;
import edu.nju.onlinestock.dao.CommodityDao;
import edu.nju.onlinestock.model.Commodity;
import edu.nju.onlinestock.model.Member;
import hibernate3.support.YeekuHibernateDaoSupport;

public class CommodityDaoImpl extends YeekuHibernateDaoSupport implements CommodityDao {
	
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean save(Commodity com) {
		// TODO Auto-generated method stub
		baseDao.save(com);
		return true;
	}

	@Override
	public boolean update(Commodity com) {
		// TODO Auto-generated method stub
		baseDao.update(com);
		return true;
	}

	@Override
	public Commodity getCommodity(Commodity com) {
		// TODO Auto-generated method stub
		return (Commodity)baseDao.load(Commodity.class, com.getCid());
	}

	@Override
	public List<Commodity> getAllCommodity() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Commodity";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public Commodity getCommodityByCid(int cid) {
		// TODO Auto-generated method stub
		/*String hql = "from edu.nju.onlinestock.model.Commodity where cid ='"+cid+"'";
		Session session = baseDao.getNewSession();
		session.createQuery(hql).list().get(0)*/
		return (Commodity)baseDao.load(Commodity.class, cid) ;
	}

}
