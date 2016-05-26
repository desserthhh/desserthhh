package edu.nju.onlinestock.service.impl;

import java.util.List;

import edu.nju.onlinestock.dao.CommodityDao;
import edu.nju.onlinestock.model.Commodity;
import edu.nju.onlinestock.service.CommodityService;

public class CommodityServiceImpl implements CommodityService {

	private CommodityDao commodityDao;
	
	
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	@Override
	public Commodity getCommodityByCid(int cid) {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityByCid(cid);
	}

	@Override
	public boolean setCommodity(Commodity com) {
		// TODO Auto-generated method stub
		return commodityDao.save(com);
	}

	@Override
	public boolean updateCommodity(Commodity com) {
		// TODO Auto-generated method stub
		return commodityDao.update(com);
	}

	@Override
	public List<Commodity> getCommodity() {
		// TODO Auto-generated method stub
		return commodityDao.getAllCommodity();
	}

}
