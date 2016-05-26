package edu.nju.onlinestock.action;


import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.model.Waiter;
import edu.nju.onlinestock.service.WaiterService;



public class AdminAction extends BaseAction{
	private String success = "success";
	@Autowired
	WaiterService waiterService;

	

	public WaiterService getWaiterService() {
		return waiterService;
	}



	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}



	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		List<Waiter>  ml=  waiterService.getAllWaiter();
		String[] wid = new String[ml.size()];
		String[] w_name = new String[ml.size()];
		String[] w_store = new String[ml.size()];		
		
		for(int i=0;i<ml.size();i++){
			wid[i] =Integer.toString( ml.get(i).getAccount());
			w_name[i] = ml.get(i).getName();
			w_store[i] = ml.get(i).getStore();
		}
		
		sc.setAttribute("wid",  wid);
		sc.setAttribute("w_name", w_name);
		sc.setAttribute("w_store", w_store);
		sc.setAttribute("w_len", Integer.toString(ml.size()));
		return success;
	}
}
