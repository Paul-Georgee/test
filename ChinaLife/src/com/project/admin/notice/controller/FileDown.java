package com.project.admin.notice.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.util.FileDownUtil;

@Controller
@RequestMapping("/admin/notice")
public class FileDown {
	
	@RequestMapping("/down")
	public void down(HttpServletResponse response,String fileName){
		System.out.println(fileName);
		try {
			FileDownUtil.downLoad("C:/apache-tomcat-7.0.68/webapps/ChinaLife/WEB-INF/upload/" +fileName, response, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
