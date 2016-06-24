package edu.nju.onlinestock.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.model.Commodity;
import edu.nju.onlinestock.service.CommodityService;

public class CommodityAction extends BaseAction{
	private String success = "success";
	
	@Autowired
	private CommodityService commodityService;
	
	
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		List<Commodity> cl = commodityService.getCommodity();
		int len = cl.size();
		
		String[] cids = new String[len];
		String[] c_names = new String[len];
		String[] images = new String[len];
		for(int i=0;i<len;i++){
			cids[i] = Integer.toString(cl.get(i).getCid());
			c_names[i] = cl.get(i).getName();
			images[i] = "../images/commodity/"+cids[i]+".jpg";
		}
		
		sc.setAttribute("cids", cids);
		sc.setAttribute("c_names", c_names);
		sc.setAttribute("images", images);
		
		return success;
	}
	
}
