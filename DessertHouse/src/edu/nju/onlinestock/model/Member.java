package edu.nju.onlinestock.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member implements Serializable {

	/**
	 * 
	 */
	
	private int mid;
	@Id
	private int account;
	private String name;
	private String password;
	private int tel;
	private String card;
	private int money;
	private int allcost;
	private int level;
	private int status;
	private int credit;
	private Date date;
	
	public Member(){}

	public Member(int account, String password){
		this.account = account;
		this.password = password;
	}
	
	public Member(String name, String password,
			int tel, int status, int credit) {
		super();
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.setStatus(status);
		this.credit = credit;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int id) {
		this.mid = id;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getAllcost() {
		return allcost;
	}

	public void setAllcost(int allcost) {
		this.allcost = allcost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
