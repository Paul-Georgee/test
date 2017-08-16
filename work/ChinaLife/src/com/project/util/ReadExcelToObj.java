package com.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.bean.ClientBean;
import com.project.bean.GuranteeBean;
import com.project.bean.InsuranceBean;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelToObj {

	
	public static List<GuranteeBean> Filter(CommonsMultipartFile[] files,HttpServletRequest request) throws BiffException, IOException{
		List<GuranteeBean> gurantees = new ArrayList<GuranteeBean>();
		/**锟斤拷锟斤拷锟斤拷锟叫碉拷锟侥硷拷锟斤拷锟斤拷**/
//		getData(files[0],request, gurantees);
		for (int i = 0; i < files.length; i++) {
			/**取锟斤拷锟侥硷拷锟斤拷,锟叫讹拷锟侥硷拷锟角诧拷锟斤拷Excel锟斤拷锟斤拷募锟�**/
//			if (files[i].getName().indexOf(".xls")>0) {
				/**锟斤拷锟斤拷锟紼xcel锟侥硷拷,锟斤拷么锟酵斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷*/
				getData(files[i],request, gurantees);
//			}
		}
		return gurantees;
	}
	
	
	public static void getData(CommonsMultipartFile file,HttpServletRequest request,List<GuranteeBean> gurantees) throws BiffException, IOException{
		
		DiskFileItem fi = (DiskFileItem) file.getFileItem();
//		System.out.println(fi.getStoreLocation().getAbsolutePath());
		/**锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷,锟斤拷锟斤拷锟斤拷取Excel锟侥硷拷*/
		String path = UploadUtil.upload(file, request, "/WEB-INF/upload");
		System.out.println(path);
		InputStream is = new FileInputStream("C:/apache-tomcat-7.0.68/wtpwebapps/ChinaLife/WEB-INF/upload/"+path);
		
		Workbook wb = Workbook.getWorkbook(is);
		/**Excel锟斤拷页签锟斤拷*/
		int sheet_size = wb.getNumberOfSheets();
		/**锟斤拷锟斤拷页签锟斤拷*/
		for (int index = 0; index < sheet_size; index++) {
			/**锟斤拷取一页*/
			Sheet sheet = wb.getSheet(index);
			/**锟斤拷取Excel锟侥硷拷锟斤拷锟斤拷锟斤拷**/
			for (int i = 1; i < sheet.getRows(); i++) {
				/**锟斤拷取Excel锟侥硷拷锟斤拷锟斤拷锟斤拷**/
				for (int j = 0; j < sheet.getColumns(); j++) {
					/**锟斤拷取Excel锟叫碉拷锟斤拷锟斤拷*/
					/**签锟斤拷锟斤拷锟斤拷*/
					Date insuTime = Date.valueOf(sheet.getCell(j++, i).getContents().trim().replace("/", "-"));
					System.out.println(insuTime);
					/**锟斤拷锟斤拷锟斤拷*/
					String favoree = sheet.getCell(j++, i).getContents();
					System.out.println(favoree);
					/**签锟斤拷锟斤拷*/
					String signer = sheet.getCell(j++, i).getContents();
					System.out.println(signer);
					/**锟斤拷锟斤拷锟斤拷锟�*/
					String number = sheet.getCell(j++, i).getContents();
					System.out.println(number);
					/**锟斤拷锟斤拷时锟斤拷*/
					String duration = sheet.getCell(j++, i).getContents();
					System.out.println(duration);
					/**锟斤拷锟街碉拷id*/
					String insureId = sheet.getCell(j++, i).getContents();
					System.out.println(insureId);
					/**投锟斤拷锟剿碉拷id也锟斤拷锟角客伙拷锟斤拷id*/
					String toubaoId = sheet.getCell(j++, i).getContents();
					System.out.println(toubaoId);
					/**锟斤拷锟斤拷锟斤拷id锟斤拷实也锟斤拷锟角刚匡拷始业锟斤拷员锟斤拷id*/
					String followId = sheet.getCell(j++, i).getContents();
					System.out.println(followId);
					String departmentId = sheet.getCell(j++, i).getContents();
					System.out.println(departmentId);
					/**锟铰斤拷guranteebean锟斤拷锟斤拷锟斤拷拥锟斤拷锟斤拷锟斤拷锟饺�*/
					gurantees.add(new GuranteeBean(insuTime,favoree,signer,number,
							Integer.parseInt(followId.trim()),Integer.parseInt(departmentId.trim())
							,Integer.parseInt(duration.trim()),
							new InsuranceBean(Integer.parseInt(insureId.trim())),
							new ClientBean(Integer.parseInt(toubaoId.trim()))));
				}
			}
		}
		/**锟斤拷锟截硷拷锟斤拷*/
//		System.out.println(gurantees.size());
	}

}
