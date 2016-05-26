package edu.nju.onlinestock.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.service.WaiterService;
import edu.nju.onlinestock.model.Plan;
import edu.nju.onlinestock.model.Waiter;
import edu.nju.onlinestock.service.CommodityService;

import edu.nju.onlinestock.model.Commodity;


public class SaleAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private PlanService planService;
	
	private CommodityService commodityService;
	private WaiterService waiterService;
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
	
	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
				ServletContext sc = request.getServletContext();
//				String account_type = (String)sc.getAttribute("account_type");
//				if(account_type.equals("member")||account_type==null){
//					return index;
//				}
				
				String account_type = (String)sc.getAttribute("accountType");
				
				List<Plan> pl = planService.getAllPlan();
				for(int i = 0;i<pl.size();i++){
					if(pl.get(i).getStatus()!=1){
						pl.remove(i);
						i--;
					}
				}
				if(account_type.equals("waiter")){
					int account = Integer.parseInt((String)sc.getAttribute("account"));
					Waiter waiter=waiterService.getWaiterByAccount(account);			
					String wstore = waiter.getStore();
					for(int i = 0;i<pl.size();i++){
						if(!pl.get(i).getStore().equals(wstore)){
							pl.remove(i);
							i--;
						}
					}
				}
				System.out.println("pl长度"+pl.size());
				
				List<Commodity> all_com = commodityService.getCommodity();
				System.out.println("c_len长度"+all_com.size());
				String[] all_cname = new String[all_com.size()];
				String[] all_cid = new String[all_com.size()];
				for(int i = 0;i<all_com.size();i++){
					all_cname[i] = all_com.get(i).getName();
					all_cid[i]  = Integer.toString(all_com.get(i).getCid());
				}
				
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
					//System.out.println(m.getName());
					Commodity commodity=commodityService.getCommodityByCid(pl.get(i).getCid());
					date[i] = pl.get(i).getDate();
					store[i] = pl.get(i).getStore();
					c_name[i] = commodity.getName();
					c_type[i] = commodity.getType();
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
				sc.setAttribute("all_cid", all_cid);
				sc.setAttribute("all_cname", all_cname);
				sc.setAttribute("c_len", all_com.size());
				
				return success;
	}
}
