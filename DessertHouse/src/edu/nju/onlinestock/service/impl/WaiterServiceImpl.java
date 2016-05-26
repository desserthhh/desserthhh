package edu.nju.onlinestock.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import edu.nju.onlinestock.dao.WaiterDao;
import edu.nju.onlinestock.model.Waiter;
import edu.nju.onlinestock.service.WaiterService;

public class WaiterServiceImpl implements WaiterService {
	private WaiterDao waiterDao;
	
	public void setWaiterDao(WaiterDao waiterDao) {
		this.waiterDao = waiterDao;
	}
	
	@Override
	public Waiter registerWaiter(Waiter waiter) {
		// TODO Auto-generated method stub
		Waiter w = waiterDao.save(waiter);
		return w;
	}
	
	@Override
	public boolean checkLogin(Waiter waiter) {
		// TODO Auto-generated method stub
		return waiterDao.findByAccountAndPassword(waiter);
	}
	
	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return waiterDao.getNameByAccount(account);
	}

	@Override
	public List<Waiter> getAllWaiter() {
		// TODO Auto-generated method stub
		return waiterDao.getAllWaiters();
	}

	@Override
	public Waiter getWaiterByAccount(int a) {
		// TODO Auto-generated method stub
		return waiterDao.getWaiterByAccount(a);
	}

}