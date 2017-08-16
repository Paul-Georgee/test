package com.project.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadUtil {
			public static String upload(CommonsMultipartFile mfile,
					HttpServletRequest request, String dirPath){
				//得到上传文件名
				String fileName = mfile.getOriginalFilename();
				//用事件毫秒数连接文件名，目的是为了不让文件重名
				fileName = System.currentTimeMillis()+fileName;
				//得到上传文件的真实路径
				String realPath = request.getServletContext().getRealPath(dirPath + "/"+fileName);
				//将二进制数据写入指定文件
				try {
					mfile.transferTo(new File(realPath));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return fileName;
			}
}
