package edu.nju.onlinestock.service;

import java.util.List;


import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.model.Recharge;


public interface MemberService {
	
	Member registerMember(Member member);
	
	boolean checkLogin(Member member);
	
	String getNameByAccount(int account);
	
	Member getMemberByAccount(int account);
	
	void update(Member member);
	
	boolean setCard(int account,String password,String card);//绑定银行卡
	
	int getStatusByAccount(int account);//获取账户当前的状态，未激活：0；暂停：-1；激活/恢复：1；停止：-2
	
	int getLevelByAccount(int account);//获取账户当前的等级，根据消费总金额进行划分，激活后为普卡（9折），1000以上为银卡（8折），5000以上为金卡（7折），10000以上为钻石卡（6折）
	
	boolean recharge(int account,String password,int money);//验证密码，通过绑定的银行卡为账户充值
	
	boolean getCardByAccount(int account);//获取用户是否绑定银行卡
	

	
	List<Allsale> getAllsaleByAccount(int account);
	
	List<Recharge> getRechargeByAccount(int account);
	

}