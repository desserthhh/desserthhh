package edu.nju.onlinestock.service;

import java.util.List;

import edu.nju.onlinestock.model.Commodity;


public interface CommodityService {
	Commodity getCommodityByCid(int cid);
	
	boolean setCommodity(Commodity com);//添加
	
	boolean updateCommodity(Commodity com);
	
	List<Commodity> getCommodity();
}
