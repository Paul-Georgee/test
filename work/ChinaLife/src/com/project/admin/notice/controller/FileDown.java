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
		try {
			FileDownUtil.downLoad("C:/apache-tomcat-7.0.68/wtpwebapps/ChinaLife/WEB-INF/upload/" +fileName, response, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
