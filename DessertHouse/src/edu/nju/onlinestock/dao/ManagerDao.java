package edu.nju.onlinestock.dao;

import java.util.List;
import edu.nju.onlinestock.model.Manager;

public interface ManagerDao {
	Manager save(Manager manager);
	
	void update(Manager manager);
	
	boolean findByAccountAndPassword(Manager manager);
	
	String getNameByAccount(int account);

	Manager getManagerByAccount(int account);
	
	List<Manager> getAllManagers();
	
}
