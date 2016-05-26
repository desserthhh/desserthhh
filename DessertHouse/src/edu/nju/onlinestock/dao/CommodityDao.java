package edu.nju.onlinestock.dao;

import java.util.List;
import edu.nju.onlinestock.model.Commodity;

public interface CommodityDao {
	boolean save(Commodity com);
	
	boolean update(Commodity com);

	Commodity getCommodity(Commodity com);
	
	List<Commodity> getAllCommodity();
	
	Commodity getCommodityByCid(int cid);
}
