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
		//所有业绩
		List<CompanyStatementBean> list = service.statements(start, end);
		//所有部门数量统计
		int countDepart = DeService.countDepart();
		//所有险种数量统计
		int countInsurance = DeService.countInsurance();
		//所有部门
		List<DepartmentBean> deList = DeService.departments();
		//所有险种
		List<InsuranceBean> inList = DeService.insurances();

		//map集合中的数据：各险种销量，各险种销量的json数组，各险种的总数，各部门名称数组
		Map map = new HashMap();
		List insNumList = new ArrayList();
		String[] insNameArray = new String[countInsurance];
		//为每个险种创建一个Integer数组，用来存放销量 ，一一对应存入list集合
		for(int i=0;i<inList.size();i++){
			int[] inArray = new int[countDepart];
			InsuranceBean obj = inList.get(i);
			insNameArray[i] = obj.getInsuName();
			insNumList.add(inArray);
		}
		//创建一个标题数组存放部门名字，以便前台使用
		String[] titleArray = new String[countDepart];
		map.put("title", titleArray);
		map.put("countInsurance", countInsurance);
		map.put("insName",insNameArray);
		
		for(int i=0;i<deList.size();i++){
			String title = deList.get(i).getDepartName();
			titleArray[i] = title;
			
			String depart = deList.get(i).getDepartName(); 
			
			//循环遍历所有的销量数据集合
			for(int k=0;k<inList.size();k++){
				
				String ins = inList.get(k).getInsuName();
				
				for(int j=0;j<list.size();j++){
					//获取map中的各个险种的 integer 数组
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
		
		//匹配完的的险种数组放回 Map 集合
		map.put("insNum",insNumList);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(),map);
	}
}
