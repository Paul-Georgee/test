package com.project.publicinfo.forum.service.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CommentBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.forum.service.ICommentService;

@Service("commentService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class CommentServiceImpl extends BaseService implements ICommentService {

	@Override
	public void comment(CommentBean comment) {
		this.session.insert("publicinfoforum.comment", comment);
	}

	@Override
	public void delComment(int id) {
		this.session.delete("publicinfoforum.delComment", id);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		ICommentService service = (ICommentService)context.getBean("commentService");
//		service.comment(new CommentBean("Œ“ø…√ª¥µ≈£",1,1));
//		service.delComment(5);
	}
}
