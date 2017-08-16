package com.project.publicinfo.email.service;

import com.project.bean.CutPageBean;
import com.project.bean.EmailBean;
import com.project.bean.ReceiveBean;

/**
 *  邮件服务相关接口
 * @author SherLock
 *
 */
public interface IEmailService {

	/**
	 * 用户收件箱
	 * @param pageNo 页码
	 * @param receiverId 收件人的id(也就是用户的id)
	 * @param title 邮件的标题
	 * @param sender 邮件的发件人名称
	 * @return 分页对象
	 */
	public CutPageBean<ReceiveBean> receives(int pageNo,int receiverId,
			String title,String sender);
	
	/**
	 *  把邮件丢到垃圾桶
	 * @param id
	 */
	public void toTrash(int id);
	
	/**
	 *  将邮件的设置为已读状态
	 * @param id
	 */
	public void read(int id);
	
	
	/**
	 *  查看邮件，同时修改该邮件的阅读状态为已读
	 * @param emailId 邮件的id
	 * @param receiverId 收件人的id
	 * @return 收件箱邮件对象
	 */
	public ReceiveBean email(int emailId,int receiverId);
	/**
	 * 用户的发件箱
	 * @param pageNo 页码
	 * @param userId 用户的id(也就是用户的id)
	 * @param title 邮件的标题
	 * @return 发件箱邮件分页对象
	 */
	public CutPageBean<EmailBean> emails(int pageNo,int userId,String title);
	
	/**
	 *  将发件箱的邮件丢到垃圾箱
	 * @param id
	 */
	public void sendToTrash(int id);
	
	
	/**
	 *  存一个草稿邮件到草稿箱
	 * @param email 邮件对象
	 */
	public void addToDrash(EmailBean email);
	
	/**
	 * 发送邮件
	 * @userId 发件人的id
	 * @param email 邮件对象
	 */
	public void send(int userId,EmailBean email);
	
	/**
	 *  添加中间表
	 * @param receivers 收件人的id集合
	 * @param emailId 邮件的id,其中,阅读状态和是否丢到垃圾箱是默认所以不需要写
	 */
	public void addReceive(int []receivers,int emailId);
	
	
}
