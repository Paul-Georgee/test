package com.project.bean;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
/**
 *  培训实体类
 *  使用方法:管理员在查看培训列表的时候,点击一次培训传递id,通过id从第三张(中间表)查询
 *  数据同时查询培训员工的详情,带分数,也就是用json传递usertrain实体类数据;
 * @author SherLock
 *
 */
@Alias("trainBean")
public class TrainBean {

	private int id;
	/**培训开始时间*/
	private Date trainTime = new Date(System.currentTimeMillis());
	/**培训结束时间*/
	private Date endTime;
	/**培训内容*/
	private String content;
	/**培训地点*/
	private String location;
	/**培训状态未开始或者已完成*/
	private String state = "未完成";
	/**培训时长*/
	private String duration;
	/**一次培训的具体参与的员工以及员工的成绩*/
	private List<UserTrainBean> trains;
	

	public List<UserTrainBean> getTrains() {
		return trains;
	}

	public void setTrains(List<UserTrainBean> trains) {
		this.trains = trains;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}


	public TrainBean() {
		super();
	}

	public TrainBean(Date trainTime, String content, String location, String duration) {
		super();
		this.trainTime = trainTime;
		this.content = content;
		this.location = location;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TrainBean [id=" + id + ", trainTime=" + trainTime + ", endTime=" + endTime + ", content=" + content
				+ ", location=" + location + ", state=" + state + ", duration=" + duration + ", trains=" + trains + "]";
	}
	
}
