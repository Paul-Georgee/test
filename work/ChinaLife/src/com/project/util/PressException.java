package com.project.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service("pe")
@Aspect
public class PressException {
/** 目标方法抛出错误后执行该方法
 * execution(* com.sherlock.service..*.*(..))
 * 
 * 第一个*表示任意返回类型
 * 
 * com.sherlock.service..*.*  表示service包下面以及子包下面的所有方法
 * 
 * (..)  表示任意参数类型
 *  */
	private static Logger log = Logger.getLogger(PressException.class);
	
	@AfterThrowing(value="execution(* com.project..*.*.*(..))",throwing="e")
	public void press(JoinPoint point,Exception e){
		/** 目标对象 */
		Object target = point.getTarget();
		
		/** 得到目标方法的名称 */
		String method = point.getSignature().getName();
		
		/** 得到目标方法的类 */
		String classInfo = target.getClass().getName()+"的"+method
				+"方法,抛出"+e.getClass().getName()+"异常"+e.getMessage();
		log.error(classInfo);
	}
}
