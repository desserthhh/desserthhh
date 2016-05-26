package edu.nju.onlinestock.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.StringClobType;

@Entity
@Table(name="plan")
public class Plan implements Serializable {

	@Id
	private int pid;
	private String store;
	private String date;
	private int cid;	
	private int price;	
	private int num;
	private int status;
	
	public Plan(){}
	
	public Plan(String store, String date, int cid, int price, int num, int status) {
		super();
		this.store = store;
		this.date = date;
		this.cid=cid;
		this.price = price;
		this.num = num;
		this.status = status;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}




}
