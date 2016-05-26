package edu.nju.onlinestock.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.MemberService;
import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.model.Recharge;

public class AccountAction extends BaseAction {
	private Member member;
	
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}

	private String success = "success";

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		int account = Integer.parseInt((String)sc.getAttribute("account"));
		setMember(memberService.getMemberByAccount(account));
		
		sc.setAttribute("tel",Integer.toString(member.getTel()));//个人信息界面
		sc.setAttribute("credit", Integer.toString(member.getCredit()));
		sc.setAttribute("money", Integer.toString(member.getMoney()));
		switch(member.getLevel()){
		case 0:sc.setAttribute("level", "普卡");break;
		case 1:sc.setAttribute("level", "银卡");break;
		case 2:sc.setAttribute("level", "金卡");break;
		case 3:sc.setAttribute("level", "钻石卡");break;
		default:sc.setAttribute("level", "未知");
		}
		switch(member.getStatus()){
		case -2:sc.setAttribute("status", "停止使用");break;
		case -1:sc.setAttribute("status", "暂停使用");break;
		case 0:sc.setAttribute("status", "未激活");break;
		case 1:sc.setAttribute("status", "活跃");break;
		default:sc.setAttribute("status", "未知");
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
		sc.setAttribute("num_cost", time_cost.length);
		sc.setAttribute("money_recharge", money_recharge);
		sc.setAttribute("time_recharge", time_recharge);
		sc.setAttribute("num_recharge", time_recharge.length);
		}
		
		
		return success;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
