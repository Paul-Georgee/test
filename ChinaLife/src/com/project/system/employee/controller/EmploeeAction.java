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
 * ϵͳ����Ա��������Ա�����ֲ�ʵ����
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

	// ҳ�����ʱ��ʾ���� ������ʵ���� �� ְ�� ���� ��̬��ҳ
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo, String trueName, String duty, HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		CutPageBean<UserBean> cutBean = ieService.emps(pageNo, trueName, duty);
		System.out.println(cutBean);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}

	// ���Ա�� �Ȳ�ѯ�����в��ǵ�������id ����ָ���ֶ����жϵ���������ת������һ��ҳ��
	@RequestMapping("/findDepartName")
	public String findDepartName(HttpServletRequest request) {
		if (request.getSession().getAttribute("depart")==null) {
			List<DepartmentBean> list = ieService.findItem();
			request.getSession().setAttribute("depart", list);
		}
			return "/jsp/superadmin/userControl/addUser.jsp";
		
	}

	// ����û� ��ɺ��ض�����ҳ��
	@RequestMapping("/addUser")
	public String addUser(UserBean ubean,HttpServletRequest request,@RequestParam(	name= "head") CommonsMultipartFile mfile) throws Exception {
		String fileName=UploadUtil.upload(mfile, request, "/images");
		ubean.setAvatar(fileName);
		ieService.empsAdd(ubean);
		return "redirect:/jsp/superadmin/userControl/userControl.jsp";
	}

	// �޸��û���Ϣ֮ǰ�Ȳ�ѯ���û�����ϸ��Ϣ
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

	// �޸�Ա����Ϣ �Ȳ�ѯ��Ա������Ϣ �޸���ɺ��ض�����ҳ��
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(int id, String duty, String tel, int departId, String role) {
		ieService.update(id, duty, tel, departId, role);
		return "redirect:/jsp/superadmin/userControl/userControl.jsp";
	}

	// ɾ���û�
	// ���Ȳ�ѯ����ǰ�û����е���Ч����,��Ϊ�з�ҳҵ������ʹ��session�Ƚ����û�id������
	@RequestMapping("/findInsuranceById")
	public String findInsuranceById(int id,HttpServletRequest request){
		request.getSession().setAttribute("userInsuId", id);
		if (ieService.del(id)) {
			return "redirect:/jsp/superadmin/userControl/userControl.jsp";
		}
		return "redirect:/jsp/superadmin/userControl/delUser.jsp";	
	}

	//��ѯ�û���ǰ��Ч�������ҷ�ҳ
	@RequestMapping("/findGuranteeItemById")
	public void findGuranteeItemById(int pageNo,HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		int id=(Integer)request.getSession().getAttribute("userInsuId");
		CutPageBean<GuranteeBean> cutBean=icService.gurantees(id, pageNo);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	// ��̬��ҳ������ѯ ͬһ���ŵ�����Ա��
	@RequestMapping("/findUserInDepartment")
	public void findUserInDepartment(int pageNo, String trueName, HttpServletResponse response,HttpServletRequest request)
			throws JsonGenerationException, JsonMappingException, IOException {
		int id=(Integer)request.getSession().getAttribute("userInsuId");
		CutPageBean<UserBean> cutBean = icService.findUserInDepartment(id, pageNo, trueName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}

	// �޸Ķ�Ӧ�����ĸ����� �޸�����ض�����ҳ��
	@RequestMapping("/changeTrack")
	public String changeTrack(int id, int[] gurantees,HttpServletRequest request) {
		icService.changeTrack(id, gurantees);
		//Ȼ�����ж�һ�ο��û��Ƿ�����Ч����
		int uid=(Integer)request.getSession().getAttribute("userInsuId");
		ieService.del(uid);
		return "redirect:/jsp/superadmin/userControl/userControl.jsp";
	}

	
	// ��ᵱ����û����Ч�����Ǿ��޸��û�״̬Ϊ��ְ
	
}
