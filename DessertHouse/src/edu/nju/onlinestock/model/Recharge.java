package edu.nju.onlinestock.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recharge")
public class Recharge implements Serializable {

	@Id
	private int rid;
	private int account;
	private int cost;
	private String date;
	
	
	public Recharge(){}

	public Recharge(int mid,int cost,String time){
		this.setAccount(mid);
		this.setCost(cost);
		this.date = time;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

}
