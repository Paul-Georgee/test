package com.project.admin.insurance.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.insurance.service.IIsuranceService;
import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;
import com.project.commonservice.BaseService;

@Service("AdmininsuranceService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class InsuranceServiceImpl extends BaseService implements IIsuranceService {

	@Override
	public void add(InsuranceBean insurance) {
		this.session.insert("adminInsurance.add",insurance);
	}

	@Override
	public void inValid(int id) {
		this.session.update("adminInsurance.update",id);
	}

	@Override
	public CutPageBean<InsuranceBean> insurances(int pageNo, String insuName, String state) {
		Map map = new HashMap();
		map.put("insuName", insuName);
		map.put("state", state);
		CutPageBean cutBean = this.getCutPage(pageNo, "adminInsurance.listSql", "adminInsurance.countSql", map);
		return cutBean;
	}

	@Override
	public InsuranceBean findById(int id) {
		return this.session.selectOne("adminInsurance.findById",id);
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IIsuranceService service = (IIsuranceService)context.getBean("insuranceService");
//		service.add(new InsuranceBean("浜哄淇濋櫓",6666,"鎵�璋撲汉韬繚闄╁悎鍚屾槸涓�绉嶄互浜虹殑瀵垮懡鍜岃韩浣撲负淇濋櫓鏍囩殑鐨勫悎鍚屻�備负浜嗛槻姝㈣祵鍗氬拰鍑忓皯閬撳痉鍗遍櫓銆婁繚闄╂硶銆嬪浜鸿韩淇濋櫓鍚堝悓鐨勮淇濋櫓浜轰綔鍑轰簡涓ユ牸鐨勮瀹氥�傛牴鎹�婁繚闄╂硶銆嬬浜斿崄浜屾潯绗簲鍗佸洓鏉°�佺浜斿崄浜旀潯涔嬭瀹氾紝涓嬪垪浜哄憳鍙互浣滀负浜鸿韩淇濋櫓鍚堝悓鐨勮淇濋櫓浜�","浜鸿韩淇濋櫓"));
//		System.out.println(service.findById(1));
//		service.inValid(1);
		System.out.println(service.insurances(1, null, "鏈夋晥"));
	}

	@Override
	public CutPageBean<InsuranceBean> insurances(int pageNo, String insuName) {
		Map map = new HashMap();
		map.put("insuName", insuName);
		
		return this.getCutPage(pageNo, "adminInsurance.publicIn",
				"adminInsurance.publicCount", map);
	}
}
