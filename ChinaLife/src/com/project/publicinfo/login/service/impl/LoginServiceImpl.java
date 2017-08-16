package com.project.publicinfo.login.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.login.service.ILoginService;

@Service("log")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class LoginServiceImpl extends BaseService implements ILoginService {

//	µÇÂ¼
	@Override
	public UserBean login(String username, String password) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		map.put("loginTime", new Date(System.currentTimeMillis()));
		UserBean bean=this.session.selectOne("publicinfologin.login",map);
		/**Ð´ÈëµÇÂ¼ÈÕÖ¾*/
		this.session.insert("publicinfologin.insertLog", map);
		return bean;
	}
	
}
