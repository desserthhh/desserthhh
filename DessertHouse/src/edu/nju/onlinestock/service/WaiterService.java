package edu.nju.onlinestock.service;

import java.util.List;
import edu.nju.onlinestock.model.Waiter;

public interface WaiterService {
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	Waiter registerWaiter(Waiter waiter);
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	boolean checkLogin(Waiter waiter);
	
	String getNameByAccount(int account);
	
	List<Waiter> getAllWaiter();
	
	Waiter getWaiterByAccount(int a);
	
}
