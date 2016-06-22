package edu.nju.onlinestock.dao;

import java.util.List;

import edu.nju.onlinestock.model.Allsale;

import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.model.Recharge;


public interface MemberDao {
	Member save(Member member);
	
	boolean saveRecharge(Recharge recharge);
	
	boolean update(Member member);
	
	boolean findByAccount(Member member);
	
	Member findByTel(Member member);
	
	boolean findByAccountAndPassword(Member member);
	
	boolean findByTelAndPassword(Member member);
	
	String getNameByAccount(int account);

	Member getMemberByAccount(int account);
	
	List<Member> getAllMembers();
	

	
	List<Recharge> getRecharge(int account);
	
	List<Allsale> getAllsale(int account);
}