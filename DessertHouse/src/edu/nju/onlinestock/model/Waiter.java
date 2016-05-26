package edu.nju.onlinestock.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waiter")
public class Waiter implements Serializable {

	/**
	 * 
	 */
	
	private int wid;
	@Id
	private int account;
	private String name;
	private String password;
	private String store;
	
	public Waiter(){}

	public Waiter(int account, String password){
		this.account = account;
		this.password = password;
	}
	
	public Waiter(int account, String name,String password,String store){
		this.account = account;
		this.name = name;
		this.password = password;
		this.store = store;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
	
	
}
