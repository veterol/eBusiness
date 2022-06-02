package com.ch.ebusiness.service.before;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface IndexService {
	public String index(Model model, Integer tid);
	public String goodsDetail(Model model, Integer id);
	public String search(Model model, String mykey);
//	public String updateView(Model model, Integer id);
	public String staytime(Model model, HttpSession session, Integer gtid, int stime);
}
