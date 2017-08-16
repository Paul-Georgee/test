package com.project.publicinfo.email.service;

import com.project.bean.CutPageBean;
import com.project.bean.ReceiveBean;

public interface IEmailReceiveService {

	/**
	 * 用户收件箱,状态为不是垃圾箱的邮件,丢到垃圾箱的邮件也可以使用这个方法
	 * @param pageNo 页码
	 * @param receiverId 收件人的id(也就是用户的id)
	 * @param title 邮件的标题
	 * @param sender 邮件的发件人名称
	 * @return 分页对象
	 */
	public CutPageBean<ReceiveBean> receives(int pageNo,int receiverId,
			String title,String sender);
	
	/**
	 *  把邮件丢到垃圾桶,注意id是中间表的id
	 * @param id
	 */
	public void toTrash(int id);

	
	
	/**
	 *  查看邮件,同时将邮件阅读状态更改为已读状态
	 * @param id 中间表id
	 * @param receiverId 收件人的id
	 * @return 收件箱邮件对象
	 */
	public ReceiveBean email(int id);
}
