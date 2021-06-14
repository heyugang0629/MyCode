package com.plat.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heyugang on 2021/3/22.
 */
@Service
public class MyQueue {

    @Autowired

    public static void main(String[] args) {
        List< Long > list = new ArrayList<>();
        list.add( 175L );
        list.add( 176L );
        list.add( 177L );
        Test t = new Test();
        MyTest test = new MyTest();
        list.forEach( d->{
            t.setId( d );
            test.ss( t);
        });
    }
}
