package com.project.publicinfo.email.service;


import com.project.bean.CutPageBean;
import com.project.bean.EmailBean;
import com.project.bean.UserBean;

/**
 *  邮件服务相关接口
 * @author SherLock
 *
 */
public interface IEmailSendService {


	
	/**
	 *  查看邮件
	 * @param id 邮件的id
	 * @return 发件箱邮件对象
	 */
	public EmailBean email(int id);
	
	/**
	 * 用户的发件箱,状态为显示的邮件
	 * @param pageNo 页码
	 * @param userId 用户的id(也就是用户的id)
	 * @param title 邮件的标题
	 * @return 发件箱邮件分页对象
	 */
	public CutPageBean<EmailBean> emails(int pageNo,int userId,String title);
	
	/**
	 *  将发件箱的邮件丢到垃圾箱,注意:这里的id是邮件表的主键id
	 * @param id 邮件表的主键id
	 */
	public void ToTrash(int id);
	
		
	/**
	 *  用户发送邮件
	 * @param email 邮件对象
	 * @param receiversId 收件id的集合
	 * @param receivers 收件人的名称集合
	 */
	public void send(EmailBean email,int []receiverId,String receivers);

	/**
	 * 发邮件时按名字分页查询所有收件人
	 * @param pageNo      页码
	 * @param userName  用户名字
	 * @return    分页对象
	 */
	public CutPageBean<UserBean> sendEmailFindUser(int pageNo,String userName);
}
