package com.plat.demo;

/**
 * 选择问题，选出一组数中的最大值
 * Created by heyugang on 2021/3/17.
 */
public class Demo001 {

    public static void main(String[] args) {
        double[] doubles = new double[10];
        for ( int i = 0 ; i< doubles.length ; i ++ ){
            double num = Math.random();
            doubles[i] = num;
            System.out.println( "第" + (i+1) + "个数:" + num );
        }
        System.out.println( "最大值：" + bubbleSortByMax( doubles ) );
        System.out.println( "最小值：" + bubbleSortByMin( doubles ) );
    }

    /**
     * 冒泡排序(返回最大的数值)
     *
     * @return
     */
    private static double bubbleSortByMax( double[] doubles ) {
        double maxNum = doubles[0];
        for ( double db : doubles ) {
            if ( maxNum < db ){
                maxNum = db;
            }
        }
        return maxNum;
    }

    /**
     * 冒泡排序(返回最小的数值)
     *
     * @return
     */
    private static double bubbleSortByMin( double[] doubles ) {
        double maxNum = doubles[0];
        for ( double db : doubles ) {
            if ( maxNum > db ){
                maxNum = db;
            }
        }
        return maxNum;
    }
}
