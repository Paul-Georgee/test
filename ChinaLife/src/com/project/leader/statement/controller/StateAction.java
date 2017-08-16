package com.project.leader.statement.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CompanyStatementBean;
import com.project.bean.DepartmentBean;
import com.project.bean.InsuranceBean;
import com.project.leader.gurantees.service.IDepartmentService;
import com.project.leader.statement.service.IStatementService;


@Controller
@RequestMapping("/state")
public class StateAction {
	@Resource
	IStatementService service;
	@Resource
	IDepartmentService DeService;
	@RequestMapping("/findAll")
	public void findAll(Date start, Date end,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		//����ҵ��
		List<CompanyStatementBean> list = service.statements(start, end);
		//���в�������ͳ��
		int countDepart = DeService.countDepart();
		//������������ͳ��
		int countInsurance = DeService.countInsurance();
		//���в���
		List<DepartmentBean> deList = DeService.departments();
		//��������
		List<InsuranceBean> inList = DeService.insurances();

		//map�����е����ݣ�������������������������json���飬�����ֵ���������������������
		Map map = new HashMap();
		List insNumList = new ArrayList();
		String[] insNameArray = new String[countInsurance];
		//Ϊÿ�����ִ���һ��Integer���飬����������� ��һһ��Ӧ����list����
		for(int i=0;i<inList.size();i++){
			int[] inArray = new int[countDepart];
			InsuranceBean obj = inList.get(i);
			insNameArray[i] = obj.getInsuName();
			insNumList.add(inArray);
		}
		//����һ�����������Ų������֣��Ա�ǰ̨ʹ��
		String[] titleArray = new String[countDepart];
		map.put("title", titleArray);
		map.put("countInsurance", countInsurance);
		map.put("insName",insNameArray);
		
		for(int i=0;i<deList.size();i++){
			String title = deList.get(i).getDepartName();
			titleArray[i] = title;
			
			String depart = deList.get(i).getDepartName(); 
			
			//ѭ���������е��������ݼ���
			for(int k=0;k<inList.size();k++){
				
				String ins = inList.get(k).getInsuName();
				
				for(int j=0;j<list.size();j++){
					//��ȡmap�еĸ������ֵ� integer ����
					String testDepart = list.get(j).getDepartment();
					String testIns = list.get(j).getInsurance();
					int[] insurArray =  (int[]) insNumList.get(k);
					if(testDepart.equals(depart) && testIns.equals(ins)){
						insurArray[i] = list.get(j).getCount();	
							
						System.out.println(depart);
						System.out.println(ins);
						System.out.println(list.get(j));
						System.out.println(insurArray[i]);
						break;
					}else{				
						insurArray[i] = 0;		
					}
					insNumList.set(k, insurArray);					
			
				}
			}
			
		}
		
		//ƥ����ĵ���������Ż� Map ����
		map.put("insNum",insNumList);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(),map);
	}
}
