package edu.nju.onlinestock.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allsale")
public class Allsale implements Serializable {

	@Id
	private int aid;
	private int account;
	private int pid;
	private int price;
	private String date;
	private int num;
	
	
	public Allsale(){}
	
	public Allsale(int pid,int price,String date,int num){
		this.aid=aid;
		this.pid = pid;
		this.price = price;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		this.date = time;
		this.num=num;
	}

	public Allsale(int account,int pid,int price,String date,int num){
		this.account = account;
		this.pid = pid;
		this.price = price;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		this.date = time;
		this.num=num;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
