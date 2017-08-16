package com.project.admin.video.service;

import com.project.bean.CutPageBean;
import com.project.bean.VideoBean;

/**
 * ����Ա������Ƶģ��
 * @author SherLock
 *
 */
public interface IVideoService {
	
	/**
	 *  �鿴��Ƶ��ҳ�б�
	 * @param pageNo ҳ��
	 * @param speaker ������
	 * @param videoName ��Ƶ����
	 * @param permission Ȩ������(Ҳ����Ա���Ľ�ɫ)
	 * @return ��ҳ����
	 */
	public CutPageBean<VideoBean> findByItem(int pageNo,String speaker,String videoName,
			String permission);
	
	/**
	 * �����Ƶ
	 * @param vbean
	 * @param permission Ȩ������
	 */
	public void add(VideoBean vbean,String[] permission);
	
	/**
	 * �鿴��Ƶ
	 * @param id ��Ƶid
	 * @return ��Ƶ����
	 */
	public VideoBean findById(int id);
	
	/**
	 * �޸���Ƶ�ɹۿ�Ȩ��
	 * @param id ��Ƶid
	 * @param permission �µ�Ȩ�޵�����
	 */
	public void update(int id,String[] permission);
	
	/**
	 * ɾ����Ƶ
	 * @param id ��Ƶid
	 */
	public void del(int id);
}
