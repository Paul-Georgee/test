package com.project.util;


import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

/**
 * jackson工具类
 * @author zhangli
 *
 */
public class JacksonUtil {
	/**
	 * 输出指定的JSON字符串
	 * @param response   响应对象
	 * @param beanobj     需要输出json字符串的对象
	 * @param beanJson   实体类json过滤器名称
	 * @param filterField   需要过滤的属性（写“...”相当于String[] 区别是“...”不用去new 一个String数组） 
	 */
	public static void outJson(HttpServletResponse response, Object beanObj, String beanJson, String ... filterField){
		ObjectMapper om =new ObjectMapper();
		SimpleFilterProvider sp = new  SimpleFilterProvider().setFailOnUnknownId(false);
		sp.addFilter(beanJson, SimpleBeanPropertyFilter.serializeAllExcept(filterField));
		om.setFilters(sp);
		try {
			om.writeValue(response.getWriter(), beanObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
