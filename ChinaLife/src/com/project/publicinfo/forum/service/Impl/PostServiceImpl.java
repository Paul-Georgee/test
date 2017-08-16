package com.project.publicinfo.forum.service.Impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.PostBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.forum.service.IPostService;

@Service("postService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class PostServiceImpl extends BaseService implements IPostService {

	@Override
	public CutPageBean<PostBean> posts(int forumId, int pageNo, String username, String title, Date start, Date end) {
		Map<String, Object> map = new HashMap<>();
		map.put("forumId", forumId);
		map.put("title", title);
		map.put("username", username);
		map.put("start", start);
		map.put("end", end);
		return this.getCutPage(pageNo, "publicinfoforum.getPosts",
				"publicinfoforum.getPostCount", map);
	}

	@Override
	public void publish(PostBean post) {
		this.session.insert("publicinfoforum.addPost", post);
	}

	@Override
	public PostBean postInfo(int id) {
		return session.selectOne("publicinfoforum.getPost", id);
	}

	@Override
	public void del(int id) {
		this.session.delete("publicinfoforum.delPost", id);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IPostService service = (IPostService)context.getBean("postService");
		System.out.println(service.posts(1, 1, null, null, null, null));
//		System.out.println(service.postInfo(1));
//		service.publish(new PostBean("hello","helloofasdfasd",1,1));
//		service.del(7);
	}
}
