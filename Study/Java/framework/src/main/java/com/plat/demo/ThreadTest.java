package com.plat.demo;

import lombok.Synchronized;

/**
 * Created by jack on 2021/3/29.
 */
public class ThreadTest {

    /**
     * 售票数量
     */
    private static int num = 10000;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int number = 10000000;
        noThread( number );
        long end = System.currentTimeMillis();
        System.out.println( "一个人卖"+ num +"张票，消耗时间" + ( end - startTime ) );
        thread( number );
        long end2 = System.currentTimeMillis( );
        System.out.println( "三个人卖"+ num +"张票，消耗时间" + ( end2 - end ) );
    }


    /**
     * 三个窗口一起跑
     * @param number
     */
    private static void thread( int number ){
        for ( int i = 0 ; i < number; i++ ){
            new Thread(() -> {
                sales( "小红" );
            }).start();

            new Thread(() -> {
                sales( "小明" );
            }).start();
        }
    }

    /**
     * 一个人跑
     * @param number
     */
    private static void noThread( int number ){
        for ( int i = 0 ; i < number; i++ ){
            sales( "小红" );
        }
    }

    /**
     * 销售
     */
    @Synchronized
    private static void sales( String name ){
        while ( num > 0 ){
            System.out.println( name + "卖出了第" + num + "张票！" );
            num --;
            if ( num <= 0 ){
                System.out.println( "本次抢购已售罄!请下次关注!" );
            }
        }
    }
}
