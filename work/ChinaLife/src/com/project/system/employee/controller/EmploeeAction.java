package com.project.system.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.GuranteeBean;
import com.project.bean.UserBean;
import com.project.system.employee.service.IChangeTrackService;
import com.project.system.employee.service.IEmpService;
import com.project.util.UploadUtil;

/**
 * 系统管理员管理所有员工表现层实体类
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emploee")
public class EmploeeAction {

	@Resource
	private IChangeTrackService icService;
	@Resource
	private IEmpService ieService;

	// 页面加载时显示数据 根据真实姓名 与 职务 进行 动态分页
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo, String trueName, String duty, HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		CutPageBean<UserBean> cutBean = ieService.emps(pageNo, trueName, duty);
		System.out.println(cutBean);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}

	// 添加员工 先查询出所有部们的名称与id 根据指定字段来判断道理是请求转发到哪一个页面
	@RequestMapping("/findDepartName")
	public String findDepartName(HttpServletRequest request) {
		if (request.getSession().getAttribute("depart")==null) {
			List<DepartmentBean> list = ieService.findItem();
			request.getSession().setAttribute("depart", list);
		}
			return "/jsp/superadmin/userControl/addUser.jsp";
		
	}

	// 添加用户 完成后重定向到主页面
	@RequestMapping("/addUser")
	public String addUser(UserBean ubean,HttpServletRequest request,@RequestParam(	name= "head") CommonsMultipartFile mfile) throws Exception {
		String fileName=UploadUtil.upload(mfile, request, "/images");
		ubean.setAvatar(fileName);
		ieService.empsAdd(ubean);
		return "redirect:/jsp/superadmin/userControl/userControl.jsp";
	}

	// 修改用户信息之前先查询出用户的详细信息
	@RequestMapping("/findUserById")
	public String findUserById(int id, HttpServletRequest request) {
		if (request.getSession().getAttribute("depart")==null) {
			List<DepartmentBean> list = ieService.findItem();
			request.getSession().setAttribute("depart", list);
		}
		UserBean ubean = ieService.findById(id);
		request.getSession().setAttribute("userBinfo", ubean);
		return "/jsp/superadmin/userControl/updateUser.jsp";
	}

	// 修改员工信息 先查询出员工的信息 修改完成后重定向到主页面
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(int id, String duty, String tel, int departId, String role) {
		ieService.update(id, duty, tel, departId, role);
		return "redirect:/jsp/superadmin/userControl/userControl.jsp";
	}

	// 删除用户
	// 首先查询出当前用户所有的有效保单,因为有分页业务所以使用session先将该用户id存起来
	@RequestMapping("/findInsuranceById")
	public String findInsuranceById(int id,HttpServletRequest request){
		request.getSession().setAttribute("userInsuId", id);
		if (ieService.del(id)) {
			return "redirect:/jsp/superadmin/userControl/userControl.jsp";
		}
		return "redirect:/jsp/superadmin/userControl/delUser.jsp";	
	}

	//查询用户当前有效保单并且分页
	@RequestMapping("/findGuranteeItemById")
	public void findGuranteeItemById(int pageNo,HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		int id=(Integer)request.getSession().getAttribute("userInsuId");
		CutPageBean<GuranteeBean> cutBean=icService.gurantees(id, pageNo);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	// 动态分页条件查询 同一部门的其他员工
	@RequestMapping("/findUserInDepartment")
	public void findUserInDepartment(int pageNo, String trueName, HttpServletResponse response,HttpServletRequest request)
			throws JsonGenerationException, JsonMappingException, IOException {
		int id=(Integer)request.getSession().getAttribute("userInsuId");
		CutPageBean<UserBean> cutBean = icService.findUserInDepartment(id, pageNo, trueName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}

	// 修改对应保单的跟单人 修改完后重定向到主页面
	@RequestMapping("/changeTrack")
	public String changeTrack(int id, int[] gurantees,HttpServletRequest request) {
		icService.changeTrack(id, gurantees);
		//然后在判断一次看用户是否还有有效单子
		int uid=(Integer)request.getSession().getAttribute("userInsuId");
		ieService.del(uid);
		return "redirect:/jsp/superadmin/userControl/userControl.jsp";
	}

	
	// 最会当对象没有有效保单是就修改用户状态为离职
	
}
