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
		/**�������е��ļ�����**/
		getData(files[0], gurantees);
//		for (int i = 0; i < files.length; i++) {
//			/**ȡ���ļ���,�ж��ļ��ǲ���Excel����ļ�**/
//			if (files[i].getName().indexOf(".xls")>0) {
//				/**�����Excel�ļ�,��ô�ͽ�����������*/
//				getData(files[i], gurantees);
//			}
//		}
		return gurantees;
	}
	
	
	public static void getData(CommonsMultipartFile file,List<GuranteeBean> gurantees) throws BiffException, IOException{
		DiskFileItem fi = (DiskFileItem) file.getFileItem();
//		System.out.println(fi.getStoreLocation().getAbsolutePath());
		/**�����ļ�������,������ȡExcel�ļ�*/
		InputStream is = new FileInputStream(fi.getStoreLocation().getAbsolutePath());
		
		Workbook wb = Workbook.getWorkbook(is);
		/**Excel��ҳǩ��*/
		int sheet_size = wb.getNumberOfSheets();
		/**����ҳǩ��*/
		for (int index = 0; index < sheet_size; index++) {
			/**��ȡһҳ*/
			Sheet sheet = wb.getSheet(index);
			/**��ȡExcel�ļ�������**/
			for (int i = 1; i < sheet.getRows(); i++) {
				/**��ȡExcel�ļ�������**/
				for (int j = 0; j < sheet.getColumns(); j++) {
					/**��ȡExcel�е�����*/
					/**ǩ������*/
					Date insuTime = Date.valueOf(sheet.getCell(j++, i).getContents().trim().replace("/", "-"));
					System.out.println(insuTime);
					/**������*/
					String favoree = sheet.getCell(j++, i).getContents();
					System.out.println(favoree);
					/**ǩ����*/
					String signer = sheet.getCell(j++, i).getContents();
					System.out.println(signer);
					/**�������*/
					String number = sheet.getCell(j++, i).getContents();
					System.out.println(number);
					/**����ʱ��*/
					String duration = sheet.getCell(j++, i).getContents();
					System.out.println(duration);
					/**���ֵ�id*/
					String insureId = sheet.getCell(j++, i).getContents();
					System.out.println(insureId);
					/**Ͷ���˵�idҲ���ǿͻ���id*/
					String toubaoId = sheet.getCell(j++, i).getContents();
					System.out.println(toubaoId);
					/**������id��ʵҲ���Ǹտ�ʼҵ��Ա��id*/
					String followId = sheet.getCell(j++, i).getContents();
					System.out.println(followId);
					String departmentId = sheet.getCell(j++, i).getContents();
					System.out.println(departmentId);
					/**�½�guranteebean������ӵ�������ȥ*/
					gurantees.add(new GuranteeBean(insuTime,favoree,signer,number,
							Integer.parseInt(followId.trim()),Integer.parseInt(departmentId.trim())
							,Integer.parseInt(duration.trim()),
							new InsuranceBean(Integer.parseInt(insureId.trim())),
							new ClientBean(Integer.parseInt(toubaoId.trim()))));
				}
			}
		}
		/**���ؼ���*/
//		System.out.println(gurantees.size());
	}

}
