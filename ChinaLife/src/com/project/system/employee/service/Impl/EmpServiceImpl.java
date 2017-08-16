package com.project.system.employee.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.system.employee.service.IEmpService;

/**
 * ϵͳ����Աҵ��ӿ�ʵ����
 * 
 * @author Administrator
 *
 */
@Service("syss")
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class EmpServiceImpl extends BaseService implements IEmpService {

	// ��̬��ҳ��ѯ
	@Override
	public CutPageBean<UserBean> emps(int pageNo, String trueName, String duty) {
		Map map = new HashMap<>();
		map.put("trueName", trueName);
		map.put("duty", duty);

		CutPageBean<UserBean> cutPageBean = this.getCutPage(pageNo, "system.listSql", "system.countSql", map);
		return cutPageBean;
	}

	// �޸�ǰ�Ȳ�ѯ�û�
	@Override
	public UserBean findById(int id) {
		UserBean ubean = session.selectOne("system.findUserById", id);
		return ubean;
	}

	// ��ѯ���в���
	@Override
	public List<DepartmentBean> findItem() {
		List<DepartmentBean> list = session.selectList("system.findDepartment");
		return list;
	}

	@Override
	public void empsAdd(UserBean user) {
		session.insert("system.addUserBean", user);
	}

	@Override
	public void update(int userId, String duty, String tel, int departId, String role) {
		Map map = new HashMap<>();
		map.put("id", userId);
		map.put("duty", duty);
		map.put("tel", tel);
		map.put("role", role);
		map.put("departId", departId);
		/**
		 * ���������ǲ�ͬ���ŵĸ�����ʱ! �ȸ���ID���в�ѯ��ǰ���û��ǲ���ĳ�����ŵĲ��Ÿ����� ����Ǹ���ʱ�͸ð��û���ǰ���� ����������Ϊ��
		 * ,��ѡ���ŵĸ����˵��޸�Ϊ��ǰ�û�
		 */
		// �Ȳ�ѯ����ǰ�û��Ĳ�����ְ��
		UserBean ubean = session.selectOne("system.findUserRole", userId);
		// �жϵ�ǰ�û��Ĳ���ְ���ǲ��ǲ��Ÿ����� �������ô�޸�ʱ��Ӧ�ý���ǰ�û��Ĳ��Ÿ���������Ϊnull
		Map map3 = new HashMap();
		map3.put("id", ubean.getDepartId());
		if ("���Ÿ�����".equals(ubean.getRole())) {
			session.update("system.updateDepartHeaderToNull", map3);
		}		
		// ͬ�����ڵĸ���
		Map map2 = new HashMap();
		map2.put("id", userId);
		map2.put("departId", departId);
		if ("���Ÿ�����".equals(role)) {
			session.update("system.updateDepartmentHeader", map2);
		}
		session.update("system.updateInfo", map);
	}

	// ɾ�� ���������Ч�����Ͳ���ɾ�� ����Ϊfalse ���û�� �ͻ��޸��û���ϢΪ��ְ,�����Ա��Ϊ���Ÿ����� �ǾͻὫ�ò��Ź������ÿ�
	@Override
	public boolean del(int userId) {
		int count = session.selectOne("system.findInsuranceById", userId);
		if (count > 0) {
			return false;
		} else {
			session.update("system.updateUserState", userId);
			return true;
		}

	}

//	 public static void main(String[] args) {
//	 ApplicationContext aContext=new ClassPathXmlApplicationContext("app-service.xml");
//	 IEmpService service=(IEmpService)aContext.getBean("syss");
//	 System.out.println(service.emps(1, null, null).getObjects());
//	// System.out.println(service.findItem().get(0).getDepartName());
//	// service.empsAdd(new UserBean("xxxxx", "����", "23dsdas32322@qq.com",
//	 //"13700980277", "��", Date.valueOf("1998-02-22"), "321321.jpg","����", "��ר",
//	 //1));
//	// service.update(1, "�ܹ�", "13777081132", 2, "���Ÿ�����");
//	// System.out.println(service.findById(1));
//	 }

}
