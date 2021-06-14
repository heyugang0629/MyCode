package com.plat.utils;

import org.springframework.util.StringUtils;

/**
 * @author hyg
 * @date 2021/5/10
 */
public class StringArrayUtil {

    public static boolean isNull( String ... strs ){
        boolean b = false;
        for ( String str : strs ){
            if ( null == str ){
                return true;
            }
        }
        return b;
    }

    public static boolean isEmpty( String ... strs ){
        boolean b = false;
        for ( String str : strs ){
            if ( StringUtils.isEmpty( str ) ){
                return true;
            }
        }
        return b;
    }

    public static boolean isNotEmpty( String ... strs ){
        return !isEmpty( strs );
    }

    public static boolean isNotNull( String ... strs ){
        return !isNull( strs );
    }
}
