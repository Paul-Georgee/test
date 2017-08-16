package com.project.admin.rules.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.admin.rules.service.IRulesService;
import com.project.bean.RulesBean;
import com.project.util.JacksonUtil;

/**
 * 规章制度Action
 * 
 * @author Edison
 *
 */
@Controller
@RequestMapping("/rules")
public class rulesAction {
	@Resource
	private IRulesService service;

	/**
	 * 显示所有规则制度,传给ajax
	 * 
	 * @param response
	 *            请求
	 */
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response) {
		List<RulesBean> list = service.rules();
		JacksonUtil.outJson(response, list, "rulesJson", "");
	}

	/**
	 * 添加新规章制度
	 * 
	 * @param rule
	 *            规章制度对象
	 * @return 规则制度主界面
	 */
	@RequestMapping("/add")
	public String add(RulesBean rule) {
		service.add(rule);
		return "redirect:/jsp/admin/regime.jsp";
	}

	/**
	 * 根据ID查找规章制度,转到修改页面
	 * 
	 * @param id
	 *            规章制度ID
	 * @param request
	 *            请求
	 * @return 转到修改页面
	 */
	@RequestMapping("/findById")
	public String findById(int id, HttpServletRequest request) {
		RulesBean rulesBean = service.findById(id);
		request.getSession().setAttribute("rules", rulesBean);
		return "/jsp/admin/regimeUpdate.jsp";
	}

	/**
	 * 修改规章制度
	 * 
	 * @param id
	 *            规章制度ID
	 * @param content
	 *            规章制度内容
	 * @return 规章制度主界面
	 */
	@RequestMapping("/update")
	public String update(int id, String content) {
		service.update(id, content);
		return "/jsp/admin/regime.jsp";
	}
}
