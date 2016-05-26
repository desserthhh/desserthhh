package edu.nju.onlinestock.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.MemberService;
import edu.nju.onlinestock.model.Member;

public class CardAction extends BaseAction {
	private String name;
	private String password;
	private String card;
	private int money;
	
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}


	private String success = "success";
	private String input = "input";
	private String mon = "money";
	private String car = "card";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}


	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("pw:"+request.getParameter("password")+ " card:"+request.getParameter("card"));
		if(request.getParameter("password")==""||request.getParameter("money")==""){
			return input;
		}
		try{
			setMoney(Integer.parseInt(request.getParameter("money")));
			setPassword(request.getParameter("password"));
			
			ServletContext sc = request.getServletContext();
			int account = Integer.parseInt((String) sc.getAttribute("account"));

			if(request.getParameter("card")==""){
				if(memberService.getCardByAccount(account)){
					return car;
				}else{
					if(memberService.recharge(account, password, money)){
						return success;
					}else{
						return input;
					}
				}
			}else{
				if(memberService.setCard(account, password, request.getParameter("card"))){
					if(money<200){
						memberService.setCard(account, password, null);
						return mon;
					}else{
						if(memberService.recharge(account, password, money)){
							return success;
						}else{
							System.out.println("there");
							return input;
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
