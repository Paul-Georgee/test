package com.project.publicinfo.video.service.impl;

import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.VideoBean;

public interface IVideoService {

	/**
	 * ����Ȩ������ҳ��ʾ������Ƶ
	 * @param permission Ȩ�޵�ģ���ַ���
	 * @return ������Ƶ
	 */
	public List<VideoBean> findVideoTop2(String permission);
	
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
	 *  ����id�鿴��Ƶ
	 * @param id ��Ƶ��id
	 * @return ��Ƶ���� 
	 */
	public VideoBean findById(int id);
}
