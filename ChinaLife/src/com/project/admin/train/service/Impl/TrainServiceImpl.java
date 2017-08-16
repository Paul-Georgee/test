package com.project.admin.train.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.project.admin.train.service.ITrainService;
import com.project.bean.CutPageBean;
import com.project.bean.TrainBean;
import com.project.commonservice.BaseService;

@Service("adminTrainService")
public class TrainServiceImpl extends BaseService implements ITrainService {

	@Override
	public CutPageBean<TrainBean> trains(int pageNo) {
		
		return this.getCutPage(pageNo, "adminTrain.getTrains",
				"adminTrain.getTrainCount", new HashMap<>());
	}

	@Override
	public void add(TrainBean train, int[] arrayUsersId) {
		this.session.insert("adminTrain.addTrain", train);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("trainId", train.getId());
		map.put("arrayUsersId", arrayUsersId);
		this.session.insert("adminTrain.addTrainers", map);
	}

	@Override
	public TrainBean findById(int id) {
		return this.session.selectOne("adminTrain.getTrainInfo", id);
	}

	@Override
	public void insertPoint(int trainId, int point) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("point", point);
		map.put("id", trainId);
		this.session.insert("adminTrain.insertPoint", map);
	}

	@Override
	public void endTrain(int id) {
		this.session.update("adminTrain.endTrain", id);
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		ITrainService service = (ITrainService)context.getBean("adminTrainService");
//		System.out.println(service.trains(1));
//		System.out.println(service.findById(1).getTrains());
//		service.add(new TrainBean(new Date(System.currentTimeMillis()),"关于如何开展客户的培训",
//				"成都分公司","三天"),
//				new int[]{11,12,13,14});
		
		
	}
}
