package com.project.publicinfo.forum.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CommentBean;
import com.project.bean.CutPageBean;
import com.project.bean.ForumBean;
import com.project.bean.PostBean;
import com.project.publicinfo.forum.service.ICommentService;
import com.project.publicinfo.forum.service.IForumService;
import com.project.publicinfo.forum.service.IPostService;

/**
 *  论坛模块
 * @author SherLock
 *
 */
@Controller
@RequestMapping("/public")
public class ForumServiceController {

	@Resource
	private IForumService Fservice;
	
	@Resource
	private IPostService Pservice;
	
	@Resource
	private ICommentService Cservice;
	
	
	
	
	/**论坛首页*/
	@RequestMapping("/forum")
	public String Findex(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		List<ForumBean> froums = Fservice.forums();
		request.setAttribute("forums", froums);
		return "/jsp/admin/forum.jsp";
	}
	
	/**进入板块*/
	@RequestMapping("/forum/{forumId}")
	public String enter(@PathVariable("forumId")int forumId,HttpServletRequest request){
		request.getSession().setAttribute("forumId", forumId);
		return "redirect:/jsp/admin/forumMain.jsp";
	}
	
	/**ajax获取帖子
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException */
	@RequestMapping("/forum/posts")
	public void getPost(HttpServletResponse response,int pageNo,HttpServletRequest request,
			String username,String title,Date start,Date end) throws JsonGenerationException, JsonMappingException, IOException{
		int fId = (Integer)request.getSession().getAttribute("forumId");
		CutPageBean<PostBean> posts = Pservice.posts(fId, pageNo,
				username, title, start, end);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), posts);
		
	}
	
	@RequestMapping("/forum/posts/{postId}")
	public String postInfo(@PathVariable("postId")int id,HttpServletRequest request){
		PostBean post = Pservice.postInfo(id);
		request.setAttribute("post", post);
		return "/jsp/admin/post.jsp";
	}
	
	/**管理员删除评论功能*/
	@RequestMapping("/forum/comments/del/{commentId}")
	public String delComment(@PathVariable("commentId")int id, int postId,
			HttpServletRequest request){
		Cservice.delComment(id);
		PostBean post = Pservice.postInfo(postId);
		request.setAttribute("post", post);
		return "/jsp/admin/post.jsp";
	}
	
	@RequestMapping("/forum/posts/del/{psotId}")
	public String delPost(@PathVariable("postId")int id){
		
		return "redirect:/jsp/admin/forumMain.jsp";
	}
	
	/**发布新帖子*/
	@RequestMapping("/forum/publish")
	public String publish(PostBean post){
		Pservice.publish(post);
		return "redirect:/jsp/admin/forumMain.jsp";
	}
	
	
	/**添加新评论,有问题(已解决)*/
	@RequestMapping("/forum/comment")
	public String comment(CommentBean comment,HttpServletRequest request){
		Cservice.comment(comment);
		PostBean post = Pservice.postInfo(comment.getPostId());
		request.setAttribute("post", post);
		return "/jsp/admin/post.jsp";
	}
	
}
