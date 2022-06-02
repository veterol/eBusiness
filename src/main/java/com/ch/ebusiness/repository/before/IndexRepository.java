package com.ch.ebusiness.repository.before;

import java.util.List;

import com.ch.ebusiness.entity.BUser;
import com.ch.ebusiness.entity.View;
import org.apache.ibatis.annotations.Mapper;

import com.ch.ebusiness.entity.Goods;
import com.ch.ebusiness.entity.GoodsType;

@Mapper
public interface IndexRepository {
	public List<Goods> selectAdvertisementGoods();
	public List<GoodsType> selectGoodsType();
	public List<Goods> makeGoodsRecommend();
	public List<Goods> selectRecommendGoods(Integer tid);
	public List<Goods> selectLastedGoods(Integer tid);
	public Goods selectAGoods(Integer id);
	public View selectAView(Integer id);
	public int checkAView(Integer id);
	public int updateAView(Integer id);
	public int addStaytime(Integer uid, Integer during, Integer typeid);
	public List<Goods> search(String mykey);
}
