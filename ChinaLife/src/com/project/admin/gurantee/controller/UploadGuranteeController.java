package com.project.admin.gurantee.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.admin.gurantee.service.IGuranteeService;
import com.project.bean.GuranteeBean;
import com.project.util.ReadExcelToObj;

import jxl.read.biff.BiffException;

@Controller
@RequestMapping("/admin")
public class UploadGuranteeController {

	@Resource
	private IGuranteeService service;
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("files") CommonsMultipartFile[] files) throws BiffException, IOException{
		List<GuranteeBean> gurantees = ReadExcelToObj.Filter(files);
		service.upload(gurantees);
		return "redirect:/jsp/index.jsp";
	}
}
