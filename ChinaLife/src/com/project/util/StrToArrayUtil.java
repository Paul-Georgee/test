package com.project.util;
/**
 * ��������ɵ��ַ���ת�����������
 * �������� �ַ���Ϊ"12,58,56,89"
 * @author SherLock
 *
 */
public class StrToArrayUtil {

	public static int[] toArray(String NumberStr){
		String [] arrayStr = NumberStr.split(",");
		int [] array = new int[arrayStr.length];
		for (int i = 0; i < array.length; i++) {
			array[i]=Integer.parseInt(arrayStr[i]);
		}
		return array;
	}
}
