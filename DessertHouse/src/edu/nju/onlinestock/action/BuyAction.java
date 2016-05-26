package edu.nju.onlinestock.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.PlanService;
import edu.nju.onlinestock.model.Plan;


import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.service.MemberService;
import edu.nju.onlinestock.model.Member;

public class BuyAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	private String login = "login";
	private String nomoney = "nomoney";
	private String a = "a";
	
	@Autowired
	private PlanService planService;

	private MemberService memberService;
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
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		Plan plan = planService.getPlanByPid(pid);
		int price = plan.getPrice();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		sc.setAttribute("cost", Integer.toString(num*price));
		
		String account_type = (String)sc.getAttribute("accountType");
		if(account_type.equals("member")){
			int account = Integer.parseInt((String)sc.getAttribute("account"));
			Member member = memberService.getMemberByAccount(account);
			int allcost = member.getAllcost();
			if(allcost>=200&&allcost<1000){
				price = (int) (price*0.9);
			}else if(allcost>=1000&&allcost<5000){
				price = (int) (price*0.8);
			}else if(allcost>=5000&&allcost<10000){
				price = (int) (price*0.7);
			}else if(allcost>=10000){
				price = (int) (price*0.6);
			}
			member.setMoney(member.getMoney()-(price*num));
			
			if(member.getMoney()<0){
				return nomoney;
			}else{
				memberService.update(member);
			}
			 
			Allsale allsale = new Allsale(account,pid,price*num,"time",num);
			planService.setAllsale(allsale);
			
			plan.setNum(plan.getNum()-num);
			planService.updatePlan(plan);
			
			return success;
		}else if(account_type.equals("waiter")){
			String act = (String) sc.getAttribute("mid");
			if(act==null){
				Allsale allsale = new Allsale(pid,price*num,"time",num);
				planService.setAllsale(allsale);
				
				plan.setNum(plan.getNum()-num);
				planService.updatePlan(plan);
			}else{
				int account = Integer.parseInt(act);
				Member member = memberService.getMemberByAccount(account);
				int allcost = member.getAllcost();
				if(allcost>=200&&allcost<1000){
					price = (int) (price*0.9);
				}else if(allcost>=1000&&allcost<5000){
					price = (int) (price*0.8);
				}else if(allcost>=5000&&allcost<10000){
					price = (int) (price*0.7);
				}else if(allcost>=10000){
					price = (int) (price*0.6);
				}
				
				Allsale allsale = new Allsale(account,pid,price*num,"time",num);
				planService.setAllsale(allsale);
				
				String pay=request.getParameter("pay");
				if(pay.equals("0")){ price = 0;};
				member.setMoney(member.getMoney()-(price*num));
				
				if(member.getMoney()<0){
					return nomoney;
				}else{
					memberService.update(member);
				}
				 
				plan.setNum(plan.getNum()-num);
				planService.updatePlan(plan);
			}
			return success;
		}else{
			return login;
		}
	}
}
