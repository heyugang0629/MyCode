package com.plat.demo;

/**
 * 西格玛计算
 * Created by jack on 2021/3/18.
 */
public class Demo003 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println( sum( 1000000000 ) );
        long endTime = System.currentTimeMillis();
        System.out.println( "本次执行消耗时间：" + ( endTime - startTime ) / 1000 + "s" );
    }


    private static int sum( int n ){
        int partialSum = 0 ;
        for ( int i = 1 ; i <=n ; i++ ){
            partialSum += Math.pow( i , 3 );
        }
        return partialSum;
    }
}
