package com.project.admin.notice.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.admin.notice.service.INoticeService;
import com.project.bean.NoticeBean;
import com.project.util.JacksonUtil;
import com.project.util.UploadUtil;

/**
 * 公告Action
 * 
 * @author Edison
 *
 */
@Controller
@RequestMapping("/notice")
public class noticeController {
	@Resource
	private INoticeService service;

	/**
	 * 显示所有公告
	 * 
	 * @param response
	 *            请求,传给ajax
	 */
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response) {
		List<NoticeBean> bean = service.notices();
		JacksonUtil.outJson(response, bean, "noticeJson", "");
	}

	/**
	 * 发布公告
	 * 
	 * @param mfile
	 *            附件
	 * @param notice
	 *            公告实体类
	 * @param request
	 *            请求
	 * @param title
	 *            标题
	 * @param genre
	 *            类型
	 * @param content内容
	 * @return 公告主界面
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(name = "fujian") CommonsMultipartFile mfile, NoticeBean notice,
			HttpServletRequest request, String title, String genre, String content) {
		String path = UploadUtil.upload(mfile, request, "/WEB-INF/upload");
		notice.setFilePath(path);
		notice.setContent(content);
		notice.setGenre(genre);
		notice.setTitle(title);
		service.publish(notice);
		return "redirect:/jsp/admin/notice.jsp";
	}

	/**
	 * 根据ID查找公告,并显示到页面
	 * 
	 * @param id
	 *            公告ID
	 * @param request请求
	 * @return 显示页面
	 */
	@RequestMapping("/show")
	public String show(int id, HttpServletRequest request) {
		NoticeBean noticeBean = service.notice(id);
		request.getSession().setAttribute("notice", noticeBean);
		return "/jsp/admin/noticeInfo.jsp";
	}

	/**
	 * 根据ID删除公告
	 * 
	 * @param id
	 *            公告ID
	 * @return 公告主界面
	 */
	@RequestMapping("/del")
	public String del(int id) {
		service.del(id);
		return "redirect:/jsp/admin/notice.jsp";
	}
}
