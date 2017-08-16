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
 * 鍏憡Action
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
	 * 鏄剧ず鎵�鏈夊叕鍛�
	 * 
	 * @param response
	 *            璇锋眰,浼犵粰ajax
	 */
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response) {
		List<NoticeBean> bean = service.notices();
		JacksonUtil.outJson(response, bean, "noticeJson", "");
	}

	/**
	 * 鍙戝竷鍏憡
	 * 
	 * @param mfile
	 *            闄勪欢
	 * @param notice
	 *            鍏憡瀹炰綋绫�
	 * @param request
	 *            璇锋眰
	 * @param title
	 *            鏍囬
	 * @param genre
	 *            绫诲瀷
	 * @param content鍐呭
	 * @return 鍏憡涓荤晫闈�
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
	 * 鏍规嵁ID鏌ユ壘鍏憡,骞舵樉绀哄埌椤甸潰
	 * 
	 * @param id
	 *            鍏憡ID
	 * @param request璇锋眰
	 * @return 鏄剧ず椤甸潰
	 */
	@RequestMapping("/show")
	public String show(int id, HttpServletRequest request) {
		NoticeBean noticeBean = service.notice(id);
		request.setAttribute("notice", noticeBean);
		return "/jsp/admin/noticeInfo.jsp";
	}

	/**
	 * 鏍规嵁ID鍒犻櫎鍏憡
	 * 
	 * @param id
	 *            鍏憡ID
	 * @return 鍏憡涓荤晫闈�
	 */
	@RequestMapping("/del")
	public String del(int id) {
		service.del(id);
		return "redirect:/jsp/admin/notice.jsp";
	}
}
