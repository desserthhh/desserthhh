package edu.nju.onlinestock.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.model.Commodity;
import edu.nju.onlinestock.model.Plan;
import edu.nju.onlinestock.service.CommodityService;
import edu.nju.onlinestock.service.PlanService;

public class ShowAction extends BaseAction{
	String success = "success";
	String fail = "fail";
	
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
		ServletContext sc = request.getServletContext();
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println(cid);
		Commodity c = commodityService.getCommodityByCid(cid);
		List<Plan> pl = planService.getPlanByCid(cid);
		String pid = null;
		String price = null;
		String num = null;
		String date = null;
		String image = "../images/commodity/"+(cid+1)+".jpg";
		if(pl.size()>0){
			num = Integer.toString(pl.get(0).getNum());
			if(pl.get(0).getNum()>0){
				price = Integer.toString(pl.get(0).getPrice());
				pid = Integer.toString(pl.get(0).getPid());
				date = pl.get(0).getDate();
			}
			else{
				return fail;
			}
		}
		else{
			return fail;
		}
		
		sc.setAttribute("c_name", c.getName());
		sc.setAttribute("pid", pid);
		sc.setAttribute("price", price);
		sc.setAttribute("num", num);
		sc.setAttribute("date", date);
		sc.setAttribute("cid", Integer.toString(cid));
		sc.setAttribute("image", image);
		
		
		return success;
		
	}

}
