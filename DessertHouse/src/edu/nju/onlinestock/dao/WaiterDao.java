package edu.nju.onlinestock.dao;

import java.util.List;
import edu.nju.onlinestock.model.Waiter;

public interface WaiterDao {
	Waiter save(Waiter waiter);
	
	void update(Waiter waiter);
	
	boolean findByAccount(Waiter waiter);
	
	boolean findByAccountAndPassword(Waiter waiter);
	
	String getNameByAccount(int account);

	Waiter getWaiterByAccount(int account);
	
	List<Waiter> getAllWaiters();
	
}
