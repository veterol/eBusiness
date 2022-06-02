package com.ch.ebusiness.controller.before;

import com.ch.ebusiness.entity.BUser;
import com.ch.ebusiness.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ebusiness.service.before.IndexService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;
	@RequestMapping("/")
	public String index(Model model, Integer tid) {
		return indexService.index(model, tid);
	}
	@RequestMapping("/goodsDetail")
	public String goodsDetail(Model model, Integer id) {
		return indexService.goodsDetail(model, id);
	}
	@RequestMapping("/search")
	public String search(Model model, String mykey) {
		return indexService.search(model, mykey);
	}
	@RequestMapping("/staytime")
	@ResponseBody
	public String staytime(@RequestBody Goods goods, Model model, HttpSession session, @RequestParam("staytime") int stime) {
		return indexService.staytime(model, session, goods.getGoodstype_id(), stime);
	}
}
