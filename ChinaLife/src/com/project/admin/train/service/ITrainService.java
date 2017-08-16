package com.project.admin.train.service;

import com.project.bean.CutPageBean;
import com.project.bean.TrainBean;

/**
 * 管理员的培训模块接口
 * @author SherLock
 *
 */
public interface ITrainService {
	/**
	 * 查询培训的分页对象
	 * @param pageNo 分页页码
	 * @return 分页对象
	 */
	public CutPageBean<TrainBean> trains(int pageNo);
	
	/**
	 * 添加会议
	 * @param train 会议对象
	 * @param arrayUsersId 参加培训的用户的id数组集合
	 * (刚开始添加的时候是没有分数的,如果实体类中设置的是int类型而不是integer类型,那么在插入到数据库的时候
	 * 应该将分数转换isNull(grade,0))
	 */
	public void add(TrainBean train,int[] arrayUsersId);
	
	/**
	 *  查看培训详情,同时需要查询出培训的人员集合
	 * @param id 培训的id
	 * @return 培训对象
	 */
	public TrainBean findById(int id);
	
	
	/**
	 *  给培训的员工打分
	 * @param trainId 中间表培训的id
	 * @param point 分数
	 */
	public void insertPoint(int trainId,int point);
	
	/**
	 * 修改培训状态为培训结束
	 * @param id 培训id
	 */
	public void endTrain(int id);
	
}
