package com.project.admin.train.service;


import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

public interface IEmployeeService {

	/**
	 * 管理员添加培训的时候需要读取出需要培训的人员列表
	 * @param pageNo 分页页码
	 * @param trueName 需要模糊查询的员工真实姓名
	 * @return 员工分页对象
	 */
	public CutPageBean<UserBean> trainers(int pageNo, String trueName);
}
