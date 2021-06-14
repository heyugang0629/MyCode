package com.plat.utils;

/**
 * @author hyg
 * @date 2021/5/25
 */
public class StringHandleTool {

	/**
	 * 首字母大写
	 */
	public static String upperFirst(String str){
		char[] chars = str.toCharArray();
		if(chars[0]>='a' && chars[0]<='z'){
			chars[0] = (char) (chars[0]-32);
		}
		return new String(chars);
	}

	public static String nullToString( Object val ){
		return null == val ? "" : val.toString();
	}
}
