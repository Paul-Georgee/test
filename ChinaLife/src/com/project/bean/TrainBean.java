package com.project.bean;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
/**
 *  ��ѵʵ����
 *  ʹ�÷���:����Ա�ڲ鿴��ѵ�б��ʱ��,���һ����ѵ����id,ͨ��id�ӵ�����(�м��)��ѯ
 *  ����ͬʱ��ѯ��ѵԱ��������,������,Ҳ������json����usertrainʵ��������;
 * @author SherLock
 *
 */
@Alias("trainBean")
public class TrainBean {

	private int id;
	/**��ѵ��ʼʱ��*/
	private Date trainTime = new Date(System.currentTimeMillis());
	/**��ѵ����ʱ��*/
	private Date endTime;
	/**��ѵ����*/
	private String content;
	/**��ѵ�ص�*/
	private String location;
	/**��ѵ״̬δ��ʼ���������*/
	private String state = "δ���";
	/**��ѵʱ��*/
	private String duration;
	/**һ����ѵ�ľ�������Ա���Լ�Ա���ĳɼ�*/
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
