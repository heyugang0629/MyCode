package com.plat.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyg
 * @date 2021/5/25
 */
public class BeanHandleTool {

	/**
	 *==================================================================
	 * @description: 两个对象比较并且返回一个差异类
	 * @author: ooo
	 * @businessModule
	 *==================================================================
	 **/
	public static Object beanCompare( Object source , Object target ){
		if ( ObjectUtils.isEmpty( source ) || ObjectUtils.isEmpty( target ) ){
			return null;
		}
		Map result = new HashMap();
		Map sourceMap = BeanUtil.beanToMap( source );
		Map targetMap = BeanUtil.beanToMap( target );
		for ( Object key : sourceMap.keySet() ) {
			if ( sourceMap.get( key ) != targetMap.get( key ) ){
				result.put( key , targetMap.get( key ) );
			}
		}
		return BeanUtil.mapToBean( result , target.getClass() , true );
	}

	/**
	 *==================================================================
	 * @description: 比较对象里面的值，返回匹配程度最高的
	 * @author: ooo
	 * @businessModule
	 *==================================================================
	 **/
	public static Map< Integer , Object > beanCompareRetrunMap( Object source , Object target ){
		Map< Integer , Object > map = new HashMap <>();
		if ( ObjectUtils.isEmpty( source ) || ObjectUtils.isEmpty( target ) ){
			return null;
		}
		Map sourceMap = BeanUtil.beanToMap( source );
		Map targetMap = BeanUtil.beanToMap( target );
		int i = 1;
		for ( Object key : sourceMap.keySet() ) {
			if ( null == sourceMap.get( key ) || null == targetMap.get( key ) ){
				continue;
			}
			if ( sourceMap.get( key ).equals( targetMap.get( key ) ) ){
				map.put( i++ , targetMap.get( key ) );
			}
		}
		return map;
	}

	public static void main( String[] args ) {
		Demo demo1 = new Demo();
		demo1.setStr( "123" );
		Demo demo2 = new Demo();
		demo2.setStr( "123" );
		System.out.println( beanCompareRetrunMap( demo1 , demo2 ) );
	}
}
