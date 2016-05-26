package edu.nju.onlinestock.service;

import java.util.List;
import edu.nju.onlinestock.model.Manager;

public interface ManagerService {
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	Manager registerManager(Manager manager);
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	boolean checkLogin(Manager manager);
	
	String getNameByAccount(int account);
	

}