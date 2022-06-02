package com.ch.ebusiness.service.before;

import com.ch.ebusiness.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ch.ebusiness.repository.before.IndexRepository;

import javax.servlet.http.HttpSession;

@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexRepository indexRepository;
	@Override
	public String index(Model model, Integer tid) {
		if(tid == null)
			tid = 0;
		//广告区商品
		model.addAttribute("advertisementGoods", indexRepository.selectAdvertisementGoods());
		//导航栏商品类型
		model.addAttribute("goodsType", indexRepository.selectGoodsType());
		//推荐商品
		model.addAttribute("recommendGoods", indexRepository.selectRecommendGoods(tid));
		//最新商品
		model.addAttribute("lastedGoods", indexRepository.selectLastedGoods(tid));
		return "user/index";
	}
	@Override
	public String goodsDetail(Model model, Integer id) {
		//广告区商品
		model.addAttribute("advertisementGoods", indexRepository.selectAdvertisementGoods());
		//导航栏商品类型
		model.addAttribute("goodsType", indexRepository.selectGoodsType());
		//商品详情
		model.addAttribute("goods", indexRepository.selectAGoods(id));
		//商品详情浏览次数
		int c = indexRepository.checkAView(id);
		int n = indexRepository.updateAView(id);
		model.addAttribute("viewtime", indexRepository.selectAView(id));
		return "user/goodsDetail";
	}
	@Override
	public String search(Model model, String mykey) {
		//广告区商品
		model.addAttribute("advertisementGoods", indexRepository.selectAdvertisementGoods());
		//导航栏商品类型
		model.addAttribute("goodsType", indexRepository.selectGoodsType());
		//商品搜索
		model.addAttribute("searchgoods", indexRepository.search(mykey));
		return "user/searchResult";
	}
	@Override
	public String staytime(Model model, HttpSession session, Integer gtid, int stime){
		Integer uid = MyUtil.getUser(session).getId();
		indexRepository.addStaytime(uid, stime, gtid);
		return "user/goodsDetail";
	}


}
