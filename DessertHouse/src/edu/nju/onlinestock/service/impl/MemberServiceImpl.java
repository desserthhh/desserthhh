package edu.nju.onlinestock.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


import edu.nju.onlinestock.dao.MemberDao;

import edu.nju.onlinestock.model.Allsale;
import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.model.Recharge;
import edu.nju.onlinestock.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	
	@Override
	public Member registerMember(Member member) {
		// TODO Auto-generated method stub
		Member m = memberDao.findByTel(member);
		if(m == null){
			System.out.println("222");
			int account = 0;
			do{
				Random r = new Random(); 
				account = r.nextInt(99999999);
			}while(account>10000000&&memberDao.getNameByAccount(account).equals(""));
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			//member.setDate((java.sql.Date)(new Date()));
			member.setAccount(account);
			m = memberDao.save(member);
			return m;
		}else{
			m = null;
		}
		return m;
	}
	
	@Override
	public boolean checkLogin(Member member) {
		// TODO Auto-generated method stub
		return memberDao.findByTelAndPassword(member);
	}
	
	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getNameByAccount(account);
	}

	@Override
	public boolean recharge(int account, String password, int money) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		m.setAllcost(m.getAllcost()+money);
		m.setMoney(m.getMoney()+money);
		if(m.getMoney()>30){
			m.setStatus(1);
		}
		if(m.getAllcost()>1000){
			m.setLevel(1);
		}
		if(m.getAllcost()>5000){
			m.setLevel(2);
		}
		if(m.getAllcost()>10000){
			m.setLevel(3);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		Recharge recharge = new Recharge(account,money,time);
		memberDao.saveRecharge(recharge);
		memberDao.update(m);
		return true;
	}

	@Override
	public int getStatusByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		return m.getStatus();
	}

	@Override
	public boolean setCard(int account, String password, String card) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		if(m.getPassword().equals(password)){
			m.setCard(card);
			return memberDao.update(m);
		}else{
			return false;
		}
	}

	@Override
	public int getLevelByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		return m.getAllcost();
	}

	@Override
	public boolean getCardByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		return m.getCard()==null;
	}

	@Override
	public Member getMemberByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getMemberByAccount(account);
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		memberDao.update(member);
	}

	
	@Override
	public List<Allsale> getAllsaleByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getAllsale(account);
	}


	@Override
	public List<Recharge> getRechargeByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getRecharge(account);
	}
}