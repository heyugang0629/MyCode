package com.plat.demo;

import java.util.Collection;

/**
 * 拆半查找
 * Created by heyugang on 2021/3/19.
 */
public class Demo004 {
    public static void main(String[] args) {

//        System.out.println( binarySearch( new Integer[]{ 1 , 2 , 3 , 4 , 2 , 1 } , 1 ) );


        System.out.println( allSearch( new Integer[]{ 1 , 2 , 3 , 4 , 2  } , 1 ) ) ;
    }

    /**
     * 对半搜索
     * @param a
     * @param x
     * @return
     */
    public static int binarySearch( Integer[] a , Integer x ){
        int low = 0;
        int high = a.length -1;
        int i = 0 ;
        while ( low <= high ){
            i ++;
            int mid = ( low + high ) / 2 ;
            if( a[ mid ].compareTo( x ) < 0 ) {
                low = mid + 1 ;
            }else if ( a[ mid ].compareTo( x ) > 0 ){
                high = mid -1 ;
            }else {
                System.out.println( "执行次数：" + i );
                return mid;
            }
        }
        System.out.println( "执行次数：" + i );
        return -1;
    }

    /**
     * 全查
     * @param a
     * @param x
     * @return
     */
    public static int allSearch( Integer[] a , Integer x ){
        int high = a.length;
        int i = 0 ;
        while ( i <= high ){
            i ++;
            if( a[ i-1 ].compareTo( x ) == 0 ) {
                System.out.println( "执行次数：" + i );
                return i;
            }
        }
        Collection< String > collection =null;
        collection.add( "asdasd" );
        System.out.println( collection.toString() );
        System.out.println( "执行次数：" + i );
        return -1;
    }
}
