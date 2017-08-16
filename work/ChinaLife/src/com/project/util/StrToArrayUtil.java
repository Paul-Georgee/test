package com.project.util;
/**
 * 将数字组成的字符串转变成整型数组
 * 仅作用于 字符串为"12,58,56,89"
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
