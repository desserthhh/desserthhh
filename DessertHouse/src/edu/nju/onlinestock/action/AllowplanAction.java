package edu.nju.onlinestock.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.model.Plan;
import edu.nju.onlinestock.service.CommodityService;

import edu.nju.onlinestock.model.Commodity;


public class AllowplanAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private PlanService planService;

	private CommodityService commodityService;
	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	
	
	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		
		List<Plan> pl = planService.getAllPlan();
		System.out.println("pl长度:"+pl.size());
		for(int i = 0;i<pl.size();i++){
			if(pl.get(i).getStatus()!=0){
				pl.remove(i);
				i--;
			}
		}
		
		System.out.println("pl长度:"+pl.size());
		
		String[] date = new String[pl.size()];
		String[] store =  new String[pl.size()];
		String[] c_name =  new String[pl.size()];
		String[] c_type = new String[pl.size()];	   
		String[] price = new String[pl.size()];
		String[] pid =  new String[pl.size()];
        String[] num = new String[pl.size()];
		
		for(int i = 0;i<pl.size();i++){
			System.out.println(pl.size());
			//Movie m = movieService.getMovieByMid(pl.get(i).getMid());
			System.out.println("cid:"+pl.get(i).getCid());
			Commodity commodity=commodityService.getCommodityByCid(pl.get(i).getCid());
			date[i] = pl.get(i).getDate();
			store[i] =parse(pl.get(i).getStore());
			c_name[i] = commodity.getName();
			c_type[i] = commodity.getType();
			System.out.println( commodity.getName());
			num[i]=Integer.toString(pl.get(i).getNum());
			price[i] = Integer.toString(pl.get(i).getPrice());
			pid[i] = Integer.toString(pl.get(i).getPid());
		}
		
		sc.setAttribute("date", date);
		sc.setAttribute("store", store);
		sc.setAttribute("c_name", c_name);
		sc.setAttribute("c_type", c_type);
		sc.setAttribute("price", price);
		sc.setAttribute("num", num);
		sc.setAttribute("pid", pid);
		sc.setAttribute("p_len", pl.size());
		
		return success;
	}
	
	String parse(String s){
		String store=null;
		if(s.equals("nj"))
			store = "南京";
		else if(s.equals("sh"))
			store = "上海";
		return store;
			
	}
}
