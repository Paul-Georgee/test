package com.project.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service("pe")
@Aspect
public class PressException {
/** Ŀ�귽���׳������ִ�и÷���
 * execution(* com.sherlock.service..*.*(..))
 * 
 * ��һ��*��ʾ���ⷵ������
 * 
 * com.sherlock.service..*.*  ��ʾservice�������Լ��Ӱ���������з���
 * 
 * (..)  ��ʾ�����������
 *  */
	private static Logger log = Logger.getLogger(PressException.class);
	
	@AfterThrowing(value="execution(* com.project..*.*.*(..))",throwing="e")
	public void press(JoinPoint point,Exception e){
		/** Ŀ����� */
		Object target = point.getTarget();
		
		/** �õ�Ŀ�귽�������� */
		String method = point.getSignature().getName();
		
		/** �õ�Ŀ�귽������ */
		String classInfo = target.getClass().getName()+"��"+method
				+"����,�׳�"+e.getClass().getName()+"�쳣"+e.getMessage();
		log.error(classInfo);
	}
}
