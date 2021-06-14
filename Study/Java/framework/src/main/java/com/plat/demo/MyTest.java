package com.plat.demo;

import org.springframework.stereotype.Service;

/**
 * Created by jack on 2021/3/23.
 */
@Service
public class MyTest {
    public void ss( Test test ){
        System.out.println( test.getId() );
    }
}
