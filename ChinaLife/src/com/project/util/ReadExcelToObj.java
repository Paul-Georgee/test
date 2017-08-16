package com.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.bean.ClientBean;
import com.project.bean.GuranteeBean;
import com.project.bean.InsuranceBean;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelToObj {

	
	public static List<GuranteeBean> Filter(CommonsMultipartFile[] files) throws BiffException, IOException{
		List<GuranteeBean> gurantees = new ArrayList<GuranteeBean>();
		/**遍历所有的文件数组**/
		getData(files[0], gurantees);
//		for (int i = 0; i < files.length; i++) {
//			/**取出文件后,判断文件是不是Excel表格文件**/
//			if (files[i].getName().indexOf(".xls")>0) {
//				/**如果是Excel文件,那么就交个方法处理*/
//				getData(files[i], gurantees);
//			}
//		}
		return gurantees;
	}
	
	
	public static void getData(CommonsMultipartFile file,List<GuranteeBean> gurantees) throws BiffException, IOException{
		DiskFileItem fi = (DiskFileItem) file.getFileItem();
//		System.out.println(fi.getStoreLocation().getAbsolutePath());
		/**创建文件输入流,用来读取Excel文件*/
		InputStream is = new FileInputStream(fi.getStoreLocation().getAbsolutePath());
		
		Workbook wb = Workbook.getWorkbook(is);
		/**Excel的页签数*/
		int sheet_size = wb.getNumberOfSheets();
		/**遍历页签数*/
		for (int index = 0; index < sheet_size; index++) {
			/**获取一页*/
			Sheet sheet = wb.getSheet(index);
			/**获取Excel文件的行数**/
			for (int i = 1; i < sheet.getRows(); i++) {
				/**获取Excel文件的列数**/
				for (int j = 0; j < sheet.getColumns(); j++) {
					/**获取Excel中的数据*/
					/**签单日期*/
					Date insuTime = Date.valueOf(sheet.getCell(j++, i).getContents().trim().replace("/", "-"));
					System.out.println(insuTime);
					/**受益人*/
					String favoree = sheet.getCell(j++, i).getContents();
					System.out.println(favoree);
					/**签单人*/
					String signer = sheet.getCell(j++, i).getContents();
					System.out.println(signer);
					/**保单编号*/
					String number = sheet.getCell(j++, i).getContents();
					System.out.println(number);
					/**保险时长*/
					String duration = sheet.getCell(j++, i).getContents();
					System.out.println(duration);
					/**险种的id*/
					String insureId = sheet.getCell(j++, i).getContents();
					System.out.println(insureId);
					/**投保人的id也就是客户的id*/
					String toubaoId = sheet.getCell(j++, i).getContents();
					System.out.println(toubaoId);
					/**跟进人id其实也就是刚开始业务员的id*/
					String followId = sheet.getCell(j++, i).getContents();
					System.out.println(followId);
					String departmentId = sheet.getCell(j++, i).getContents();
					System.out.println(departmentId);
					/**新建guranteebean对象添加到集合中去*/
					gurantees.add(new GuranteeBean(insuTime,favoree,signer,number,
							Integer.parseInt(followId.trim()),Integer.parseInt(departmentId.trim())
							,Integer.parseInt(duration.trim()),
							new InsuranceBean(Integer.parseInt(insureId.trim())),
							new ClientBean(Integer.parseInt(toubaoId.trim()))));
				}
			}
		}
		/**返回集合*/
//		System.out.println(gurantees.size());
	}

}
