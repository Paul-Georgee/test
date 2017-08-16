package com.project.employee.client.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.ClientBean;
import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.employee.client.service.IClientService;
import com.project.util.JacksonUtil;

/**
 * 瀹㈡埛璧勬枡Action
 * 
 * @author Edison
 *
 */
@Controller
@RequestMapping("/client")
public class clientAction {
	@Resource
	private IClientService service;

	/**
	 * 妯＄硦鏌ヨ鏄剧ず褰撳墠鐧婚檰鐢ㄦ埛鐨勬墍鏈夊鎴�
	 * 
	 * @param pageNo
	 *            椤电爜
	 * @param clientName
	 *            瀹㈡埛濮撳悕
	 * @param profession
	 *            瀹㈡埛缃笟
	 * @param response
	 *            璇锋眰
	 */
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo, String clientName, String profession,
			HttpServletResponse response,HttpServletRequest request) {
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		CutPageBean<ClientBean> cutBean = service.clients(pageNo, ubean.getId(),
				clientName, profession);
		JacksonUtil.outJson(response, cutBean, "clientJson", "");
	}

	/**
	 * 娣诲姞瀹㈡埛
	 * 
	 * @param client
	 *            瀹㈡埛瀵硅薄
	 * @return 杞埌瀹㈡埛璧勬枡涓荤晫闈�
	 */
	@RequestMapping("/add")
	public String add(ClientBean client) {
		
		service.clientAdd(client);
		return "/jsp/employee/custormerDate/client.jsp";
	}

	/**
	 * 鏍规嵁ID鏌ユ壘瀹㈡埛,骞惰烦鍒板睍绀洪〉闈�
	 * 
	 * @param id
	 *            瀹㈡埛ID
	 * @param request
	 *            璇锋眰
	 * @return 杞埌灞曠ず椤甸潰
	 */
	@RequestMapping("/show")
	public String show(int id, HttpServletRequest request) {
		ClientBean clientBean = service.clientInfo(id);
		request.getSession().setAttribute("client", clientBean);
		return "/jsp/employee/custormerDate/showClient.jsp";
	}

	/**
	 * 鏍规嵁ID鏌ユ壘瀹㈡埛,骞惰浆鍒颁慨鏀归〉闈�
	 * 
	 * @param id
	 *            瀹㈡埛ID
	 * @param request
	 *            璇锋眰
	 * @return 杞埌淇敼椤甸潰
	 */
	@RequestMapping("/findById")
	public String findById(int id, HttpServletRequest request) {
		ClientBean clientBean = service.clientInfo(id);
		request.getSession().setAttribute("client", clientBean);
		return "/jsp/employee/custormerDate/updateClient.jsp";
	}

	/**
	 * 鏍规嵁ID淇敼瀹㈡埛淇℃伅
	 * 
	 * @param id
	 *            瀹㈡埛ID
	 * @param salary
	 *            瀹㈡埛鐨勬敹鍏�
	 * @param profession
	 *            瀹㈡埛鐨勮亴涓�
	 * @param tel
	 *            瀹㈡埛鐨勮仈绯绘柟寮�
	 * @param family
	 *            瀹㈡埛鐨勫搴儏鍐�
	 * @return 瀹㈡埛璧勬枡涓荤晫闈�
	 */
	@RequestMapping("update")
	public String update(int id, int salary, String profession, String tel, String family) {
		service.editInfo(id, salary, profession, tel, family);
		return "/jsp/employee/custormerDate/client.jsp";
	}
}
