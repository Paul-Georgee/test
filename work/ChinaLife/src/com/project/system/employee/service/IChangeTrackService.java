package com.project.system.employee.service;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.bean.UserBean;

public interface IChangeTrackService {
	/**
	 *  查看用户的有效保单
	 * @param userId 用户id 
	 * @param pageNo 分页页码
	 * @return 用户保单分页对象
	 */
	public CutPageBean<GuranteeBean> gurantees(int userId,int pageNo);
	
	/**
	 * 员工离职后,员工的客户更换跟进员工
	 * @param userId 新指派的跟进的员工的id
	 * @param gurantees 需要跟进的保单id
	 */
	public void changeTrack(int userId,int[] gurantees);
	/**
	 * 查询用户同一部门的在职的业务员
	 * @param id 当前用户id
	 * @param pageNo 页码
	 * @param trueName 名字
	 * @return 同一部门的其他业务员
	 */
	public CutPageBean<UserBean> findUserInDepartment(int id,int pageNo,String trueName);
}
