package com.plat.dao;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @author ooo
 * @date 2021/6/11
 */
public class Test {
	public static void main( String[] args ) {
		Test1 t1 = new Test1();
		t1.setSs( new BigDecimal( "12.9887" ) );
		Test2 t2 = new Test2();
		BeanUtils.copyProperties( t1 , t2 );
		System.out.println( JSON.toJSONString( t2 ) );
	}
}
