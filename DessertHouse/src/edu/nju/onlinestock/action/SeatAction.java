package edu.nju.onlinestock.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.model.Plan;
import edu.nju.onlinestock.model.Recharge;
import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Commodity;
import edu.nju.onlinestock.model.Member;

import edu.nju.onlinestock.service.CommodityService;
import edu.nju.onlinestock.service.MemberService;


public class SeatAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	private String login = "login";
	private String myaccount = "myaccount";
	private String nomoney = "nomoney";
	
	@Autowired
	private PlanService planService;
	private MemberService memberService;
	private CommodityService commodityService;
	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
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
		
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		System.out.println("pid:"+pid);
		Plan plan = planService.getPlanByPid(pid);
		System.out.println("cid:"+plan.getCid());
		Commodity commodity=commodityService.getCommodityByCid(plan.getCid());
		int num =plan.getNum();
		int price = plan.getPrice();
		
		int account = 0;
		String acccount_type = (String)sc.getAttribute("accountType");
		
		if(acccount_type == null){
			return login;
		}else if(acccount_type.equals("member")){
			System.out.println("member:"+account);
			account = Integer.parseInt((String)sc.getAttribute("account"));
			Member member = memberService.getMemberByAccount(account);
			int allcost = member.getAllcost();
			if(member.getMoney()<=50){
				return nomoney;
			}
			if(allcost<200){
				return myaccount;
			}else if(allcost>=200&&allcost<1000){
				price = (int) (price*0.9);
			}else if(allcost>=1000&&allcost<5000){
				price = (int) (price*0.8);
			}else if(allcost>=5000&&allcost<10000){
				price = (int) (price*0.7);
			}else if(allcost>=10000){
				price = (int) (price*0.6);
			}
		}else if(acccount_type.equals("waiter")){
			String act = request.getParameter("account");
			System.out.println("waiter:"+act);
			if(act!=""){
				account = Integer.parseInt(act);
				sc.setAttribute("member", act);
				Member member = memberService.getMemberByAccount(account);
				int allcost = member.getAllcost();
				if(member.getMoney()<=50){
					return nomoney;
				}
				if(allcost<200){
					return myaccount;
				}else if(allcost>=200&&allcost<1000){
					price = (int) (price*0.9);
				}else if(allcost>=1000&&allcost<5000){
					price = (int) (price*0.8);
				}else if(allcost>=5000&&allcost<10000){
					price = (int) (price*0.7);
				}else if(allcost>=10000){
					price = (int) (price*0.6);
				}
				
				sc.setAttribute("mid",act);
				sc.setAttribute("m_name", member.getName());
				sc.setAttribute("m_tel", Integer.toString(member.getTel()));
				
				switch(member.getLevel()){
				case 0:sc.setAttribute("m_level", "普卡");break;
				case 1:sc.setAttribute("m_level", "银卡");break;
				case 2:sc.setAttribute("m_level", "金卡");break;
				case 3:sc.setAttribute("m_level", "钻石卡");break;
				default:sc.setAttribute("m_level", "未知");
				}
				
				List<Allsale> sl = memberService.getAllsaleByAccount(account);//我的消费缴费
				List<Recharge> rl = memberService.getRechargeByAccount(account);
				if(sl!=null){
				String[] money_cost = new String[sl.size()];
				String[] time_cost = new String[sl.size()];
				String[] money_recharge = new String[rl.size()];
				String[] time_recharge = new String[rl.size()];
				for(int i = 0;i<sl.size();i++){
					money_cost[i] = Integer.toString(sl.get(i).getPrice());
					time_cost[i] = sl.get(i).getDate().substring(0,16);
					System.out.println(sl.get(i).getAid());
					System.out.println(money_cost[i]);
					System.out.println(time_cost[i]);
				}
				for(int i = 0;i<rl.size();i++){
					money_recharge[i] = Integer.toString(rl.get(i).getCost());
					time_recharge[i] = rl.get(i).getDate().substring(0,16);
				}
						
				sc.setAttribute("money_cost", money_cost);
				sc.setAttribute("time_cost", time_cost);
				sc.setAttribute("num_cost", Integer.toString(time_cost.length));
				sc.setAttribute("money_recharge", money_recharge);
				sc.setAttribute("time_recharge", time_recharge);
				sc.setAttribute("num_recharge", Integer.toString(time_recharge.length));
				}


			}else{
				sc.setAttribute("member", null);
			}
		}
		
		
		
		
		
		String name =commodity.getName();
		String date = plan.getDate();
		String type = commodity.getType();
		String image =  "../images/commodity/"+commodity.getCid()+".jpg";
		System.out.println(image);
		sc.setAttribute("image", image);
		sc.setAttribute("price",Integer.toString( price));
		sc.setAttribute("date", date);
		sc.setAttribute("num", Integer.toString(num));
		sc.setAttribute("pid", Integer.toString(pid));
		sc.setAttribute("name", name);
		sc.setAttribute("type", type);
		
		
		return success;
	}

}
