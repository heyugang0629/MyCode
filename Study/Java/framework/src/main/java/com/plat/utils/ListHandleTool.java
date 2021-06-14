package com.plat.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 * @author ooo
 * @date 2021/5/10
 */
public class ListHandleTool {

	//7M的传输大小 byte*kb*M
	private static final int MAX_LENGTH = 1024 * 1024 * 7;

	public enum UNIT {
		BYTE, KB, M
	}

	/**
	 * 按照dubbo的传输容量把集合分段传输
	 * @param objects
	 * @return
	 */
	public static synchronized List < List > split( List objects ) {
		if ( !CollectionUtils.isEmpty( objects ) ) {
			String s = JSON.toJSONString( objects );
			int initialCapacity = 0;
			if ( !StringUtils.isEmpty( s ) ) {
				initialCapacity = ( s.length() / MAX_LENGTH ) + 1;
			}
			return execute( objects, initialCapacity );
		}
		return null;
	}

	/**
	 * 按单位跟容量分段
	 * @param objects
	 * @return
	 */
	public static synchronized List < List > split( List objects, UNIT unit, int initialCapacity ) {
		switch ( unit ) {
			case M:
				initialCapacity = initialCapacity * 1024 * 1024;
				break;
			case KB:
				initialCapacity = initialCapacity * 1024;
				break;
			case BYTE:
				break;
			default:
				break;
		}
		if ( !CollectionUtils.isEmpty( objects ) ) {
			String s = JSON.toJSONString( objects );
			if ( !StringUtils.isEmpty( s ) ) {
				initialCapacity = ( s.length() / MAX_LENGTH ) + 1;
			}
			return execute( objects, initialCapacity );
		}
		return null;
	}

	/**
	 *==================================================================
	 * @description: 执行
	 * @author: ooo
	 * @businessModule
	 *==================================================================
	 **/
	private static synchronized List < List > execute( List objects, int initialCapacity ) {
		List < List > lists = new ArrayList <>( initialCapacity );
		int size = objects.size();
		int consult = size / initialCapacity;
		for ( int i = 0 ; i < initialCapacity ; i++ ) {
			int end = consult * ( i + 1 );
			int begin = i * consult;
			if ( i == initialCapacity - 1 ) {
				end = size;
			}
			lists.add( objects.subList( begin, end ) );
		}
		return lists;
	}

	/**
	 *==================================================================
	 * @description:  List To Map
	 * @author: ooo
	 * @businessModule
	 *==================================================================
	 **/
	public static Map setToMap( List list, String key ) {
		Map map = new HashMap();
		if ( !CollectionUtils.isEmpty( list ) ) {
			list.forEach( d -> {
				try {
					Method method = d.getClass().getMethod( "get" + StringHandleTool.upperFirst( key ), new Class[]{});
					map.put( method.invoke( d , new Object[]{} ) , d );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			} );
		}
		return map;
	}
}
