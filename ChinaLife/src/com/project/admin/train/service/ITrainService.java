package com.project.admin.train.service;

import com.project.bean.CutPageBean;
import com.project.bean.TrainBean;

/**
 * ����Ա����ѵģ��ӿ�
 * @author SherLock
 *
 */
public interface ITrainService {
	/**
	 * ��ѯ��ѵ�ķ�ҳ����
	 * @param pageNo ��ҳҳ��
	 * @return ��ҳ����
	 */
	public CutPageBean<TrainBean> trains(int pageNo);
	
	/**
	 * ��ӻ���
	 * @param train �������
	 * @param arrayUsersId �μ���ѵ���û���id���鼯��
	 * (�տ�ʼ��ӵ�ʱ����û�з�����,���ʵ���������õ���int���Ͷ�����integer����,��ô�ڲ��뵽���ݿ��ʱ��
	 * Ӧ�ý�����ת��isNull(grade,0))
	 */
	public void add(TrainBean train,int[] arrayUsersId);
	
	/**
	 *  �鿴��ѵ����,ͬʱ��Ҫ��ѯ����ѵ����Ա����
	 * @param id ��ѵ��id
	 * @return ��ѵ����
	 */
	public TrainBean findById(int id);
	
	
	/**
	 *  ����ѵ��Ա�����
	 * @param trainId �м����ѵ��id
	 * @param point ����
	 */
	public void insertPoint(int trainId,int point);
	
	/**
	 * �޸���ѵ״̬Ϊ��ѵ����
	 * @param id ��ѵid
	 */
	public void endTrain(int id);
	
}
