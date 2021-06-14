package com.plat.demo;

/**
 * 递归
 * Created by heyugang on 2021/3/18.
 */
public class Demo002 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        for ( int i = 0 ; i < 10000 ; i++ ){
//            System.out.println( f( i ) );
//        }

        factorial( 40 );
        long endTime = System.currentTimeMillis();
        System.out.println( "本次执行消耗时间：" + ( endTime - startTime ) / 1000 + "s" );
    }

    /**
     * 例子1 ：java允许函数是递归的
     * @param x
     * @return
     */
    public static int f( int x ) {
        return x == 0 ? 0 : 2 * f(x - 1) + (int) Math.pow( x , 2 );
    }


    /**
     * 例子2：检验效率
     * @param n
     * @return
     */
    private static long factorial( int n ){
        return n <= 1 ? 1 : factorial( n -1 ) + factorial( n -2 );
    }
}
