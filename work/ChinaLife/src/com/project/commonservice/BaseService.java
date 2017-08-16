package com.project.commonservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.project.bean.CutPageBean;

public class BaseService {
	 private final int PAGESIZE=6;
	 
	 @Resource
	 protected SqlSession session;
	 
	 
	 public CutPageBean getCutPage( int  pageNo,String listSql,String countSqls,
			 Map<String,Object> map){
		 CutPageBean cbean=new  CutPageBean(); 
		 
		 if(map==null){
			 map=new  HashMap<String,Object>();
		 }
		 
		 map.put("first", (pageNo-1)*PAGESIZE);
		 map.put("pageSize",PAGESIZE );
		  cbean.setObjects(session.selectList(listSql, map));
		   
		  int count=session.selectOne(countSqls, map);
		  cbean.setCount(count);
		  
		  
		  if(cbean.getCount()%PAGESIZE==0){
			  cbean.setPages(cbean.getCount()/PAGESIZE);
		  }else{
			  cbean.setPages(cbean.getCount()/PAGESIZE+1);
		  }
		 return cbean;
	 }
	 
}
