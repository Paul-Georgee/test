package com.project.admin.video.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.project.admin.video.service.IVideoService;
import com.project.bean.CutPageBean;
import com.project.bean.VideoBean;
import com.project.util.JacksonUtil;
import com.project.util.UploadUtil;

/**
 * 视屏Action
 * 
 * @author Edison
 *
 */
@Controller
@RequestMapping("/video")
public class videoAction {
	@Resource
	private IVideoService service;

	/**
	 * 模糊查询显示视屏
	 * 
	 * @param pageNo
	 *            页码
	 * @param speaker
	 *            主讲人
	 * @param videoName
	 *            视屏名字
	 * @param permission
	 *            权限
	 * @param response
	 *            请求
	 */
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo, String speaker, String videoName, String permission,
			HttpServletResponse response) {
		CutPageBean<VideoBean> cutBean = service.findByItem(pageNo, speaker, videoName, permission);
		JacksonUtil.outJson(response, cutBean, "videoJson", "");
	}

	/**
	 * 根据ID删除视频
	 * 
	 * @param id
	 *            视频ID
	 * @return 视屏主界面
	 */
	@RequestMapping("/del")
	public String del(int id) {
		service.del(id);
		return "redirect:/jsp/admin/photo.jsp";
	}

	/**
	 * 根据ID查找视频,转到修改页面
	 * 
	 * @param id
	 *            视频ID
	 * @param request
	 *            请求
	 * @return 转到修改页面
	 */
	@RequestMapping("/findById")
	public String findById(int id, HttpServletRequest request) {
		VideoBean videoBean = service.findById(id);
		request.getSession().setAttribute("video", videoBean);
		return "/jsp/admin/updateVideo.jsp";
	}

	/**
	 * 根据ID修改视频
	 * 
	 * @param id
	 *            视频ID
	 * @param permission
	 *            权限数组
	 * @return 视频主界面
	 */
	@RequestMapping("/update")
	public String update(int id, String[] permission) {
		service.update(id, permission);
		return "redirect:/jsp/admin/photo.jsp";
	}

	/**
	 * 添加视频
	 * 
	 * @param mfile
	 *            图片文件
	 * @param mfile1
	 *            视频文件
	 * @param title
	 *            视频标题
	 * @param videoName
	 *            视频名称
	 * @param speaker
	 *            主讲人
	 * @param permission
	 *            权限
	 * @param request
	 *            请求
	 * @return 视频主界面
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(name = "img") CommonsMultipartFile mfile,
			@RequestParam(name = "video") CommonsMultipartFile mfile1, String title, String videoName, String speaker,
			String[] permission, HttpServletRequest request) {
		String filePath = UploadUtil.upload(mfile1, request, "/video");
		String videoAvatar = UploadUtil.upload(mfile, request, "/images");
		VideoBean vbean = new VideoBean();
		vbean.setVideoAvatar(videoAvatar);
		vbean.setFilePath(filePath);
		vbean.setSpeaker(speaker);
		vbean.setTitle(title);
		vbean.setVideoName(videoName);
		service.add(vbean, permission);
		return "redirect:/jsp/admin/photo.jsp";
	}
	/**
	 * 根据ID查找视频,并转到播放页面
	 * @param id
	 * @return	转到播放页面
	 */
	@RequestMapping("/show")
	public String show(int id , HttpServletRequest request){
		VideoBean vbean =  service.findById(id);
		request.getSession().setAttribute("v",vbean);
		return "/jsp/admin/showVideo.jsp";
	}
}
