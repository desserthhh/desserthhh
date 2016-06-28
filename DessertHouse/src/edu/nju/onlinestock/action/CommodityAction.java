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
	
	
	public CommodityService getCommodityService() {
		return commodityService;
	}


	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}


	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		List<Commodity> cl = commodityService.getCommodity();
		int len = cl.size();
		
		String[] cids = new String[15];
		String[] c_names = new String[15];
		String[] images = new String[15];
		String[] cidd = new String[5];
		String[] d_names = new String[5];
		String[] d_images = new String[5];
		for(int i=0;i<15;i++){
			cids[i] = Integer.toString(cl.get(i).getCid());
			c_names[i] = cl.get(i).getName();
			images[i] = "../images/commodity/"+(cl.get(i).getCid())+".jpg";
			System.out.println(images[i]);
		}
		
		for(int i=14;i<len;i++){
			cidd[i-15] = Integer.toString(cl.get(i).getCid());
			d_names[i-15] = cl.get(i).getName();
			d_images[i-15] = "../images/commodity/"+(cl.get(i).getCid())+".jpg";
			System.out.println(images[i-15]);
		}
		sc.setAttribute("cids", cids);
		sc.setAttribute("c_names", c_names);
		sc.setAttribute("images", images);
		sc.setAttribute("cidd", cidd);
		sc.setAttribute("d_names", d_names);
		sc.setAttribute("d_images", d_images);
		
		return success;
	}
	
}
