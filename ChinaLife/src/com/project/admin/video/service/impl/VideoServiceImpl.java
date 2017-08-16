package com.project.admin.video.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.rules.service.IRulesService;
import com.project.admin.video.service.IVideoService;
import com.project.bean.CutPageBean;
import com.project.bean.RulesBean;
import com.project.bean.VideoBean;
import com.project.commonservice.BaseService;


@Service("videoService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class VideoServiceImpl extends BaseService implements IVideoService{

	@Override
	public CutPageBean<VideoBean> findByItem(int pageNo, 
			String speaker, String videoName, String permission) {
		Map map = new HashMap<>();
		map.put("speaker", speaker);
		map.put("videoName", videoName);
		map.put("permission", permission);
		CutPageBean<VideoBean> cutBean = this.getCutPage(pageNo
				, "video.findByItem", "video.count", map);
		return cutBean;
	}

	@Override
	public void add(VideoBean vbean, String[] permission) {
		 StringBuffer strbuf = new StringBuffer();
		    for( int i = 0; i < permission.length; i++ ) {
		        strbuf.append( "," ).append( permission[i] );
		    }
		   String str = strbuf.deleteCharAt( 0 ).toString();
		   vbean.setPermission(str);
		this.session.insert("video.add",vbean);
	}

	@Override
	public VideoBean findById(int id) {
		VideoBean bean = this.session.selectOne("video.findById",id);
		return bean;
	}

	@Override
	public void update(int id, String[] permission) {
		 StringBuffer strbuf = new StringBuffer();
		    for( int i = 0; i < permission.length; i++ ) {
		        strbuf.append( "," ).append( permission[i] );
		    }
		   String str = strbuf.deleteCharAt( 0 ).toString();
		Map map = new HashMap<>();
		map.put("id", id);
		map.put("str", str);
		this.session.update("video.update",map);
	}

	@Override
	public void del(int id) {
		this.session.delete("video.del",id);
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IVideoService service = (IVideoService) context.getBean("videoService");
//		System.out.println(service.findByItem(1, "", "", "").getObjects());
//		service.add(new VideoBean("如何与上级交流","4.jpg","www.4399.com","刚","技能培训"), new String[]{"领导"});
//		System.out.println(service.findById(2));
//		service.update(1, new String[]{"部门负责人,领导"});
		service.del(4);
	}
}
