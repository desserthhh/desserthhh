package edu.nju.onlinestock.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager implements Serializable {

	/**
	 * 
	 */
	private int mid;
	@Id
	private int account;
	private String name;
	private String password;
	
	public Manager(){}

	public Manager(int account, String password){
		this.account = account;
		this.password = password;
	}
	
	public Manager(int account,String name, String password){
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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
}
