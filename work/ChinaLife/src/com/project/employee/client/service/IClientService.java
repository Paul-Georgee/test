package com.project.employee.client.service;

import com.project.bean.ClientBean;
import com.project.bean.CutPageBean;

/**
 *  业务员的客户资料接口
 * @author SherLock
 *
 */
public interface IClientService {

	/**
	 *  业务员的客户资料模糊查询分页对象
	 * @param pageNo 页码
	 * @param userId 业务员的id(跟进人的id,签单人和跟进人默认是同一个人)
	 * @param clientName 客户的姓名
	 * @param profession 客户的职业
	 * @return 分页对象
	 */
	public CutPageBean<ClientBean> clients(int pageNo,int userId,
			String clientName,String profession);
	
	/**
	 *  添加客户
	 * @param client 客户对象
	 */
	public void clientAdd(ClientBean client);
	
	/**
	 *  查看客户详情
	 * @param clientId 客户的id
	 * @return 客户对象
	 */
	public ClientBean clientInfo(int clientId);
	
	/**
	 *  修改客户的资料
	 * @param clientId 客户的id
	 * @param salary 收入
	 * @param profession 职业
	 * @param tel 电话
	 * @param family 家庭情况
	 */
	public void editInfo(int clientId,int salary,String profession,String tel,
			String family);
}
