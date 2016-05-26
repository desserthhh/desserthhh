package edu.nju.onlinestock.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import edu.nju.onlinestock.dao.ManagerDao;
import edu.nju.onlinestock.model.Manager;
import edu.nju.onlinestock.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	@Override
	public Manager registerManager(Manager manager) {
		// TODO Auto-generated method stub
		Manager m = managerDao.save(manager);
		return m;
	}
	
	@Override
	public boolean checkLogin(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.findByAccountAndPassword(manager);
	}
	
	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return managerDao.getNameByAccount(account);
	}

}