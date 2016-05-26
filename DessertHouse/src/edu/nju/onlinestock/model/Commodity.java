package edu.nju.onlinestock.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commodity")
public class Commodity implements Serializable {

	@Id
	private int cid;
	private String name;
	private String type;
	
	public Commodity(){}

	public Commodity(int cid){
		this.cid=cid;
	}
	
	public Commodity(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
