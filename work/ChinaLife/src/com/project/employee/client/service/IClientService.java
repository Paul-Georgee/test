package com.project.employee.client.service;

import com.project.bean.ClientBean;
import com.project.bean.CutPageBean;

/**
 *  ҵ��Ա�Ŀͻ����Ͻӿ�
 * @author SherLock
 *
 */
public interface IClientService {

	/**
	 *  ҵ��Ա�Ŀͻ�����ģ����ѯ��ҳ����
	 * @param pageNo ҳ��
	 * @param userId ҵ��Ա��id(�����˵�id,ǩ���˺͸�����Ĭ����ͬһ����)
	 * @param clientName �ͻ�������
	 * @param profession �ͻ���ְҵ
	 * @return ��ҳ����
	 */
	public CutPageBean<ClientBean> clients(int pageNo,int userId,
			String clientName,String profession);
	
	/**
	 *  ��ӿͻ�
	 * @param client �ͻ�����
	 */
	public void clientAdd(ClientBean client);
	
	/**
	 *  �鿴�ͻ�����
	 * @param clientId �ͻ���id
	 * @return �ͻ�����
	 */
	public ClientBean clientInfo(int clientId);
	
	/**
	 *  �޸Ŀͻ�������
	 * @param clientId �ͻ���id
	 * @param salary ����
	 * @param profession ְҵ
	 * @param tel �绰
	 * @param family ��ͥ���
	 */
	public void editInfo(int clientId,int salary,String profession,String tel,
			String family);
}
