package com.plat.utils;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * @author hyg
 * @date 2021/5/18
 */
public class NumberUtil {

    public static BigDecimal nullToZero( BigDecimal val ){
        return null == val ? BigDecimal.ZERO : val;
    }

    public static Integer nullToZero( Integer val ){
        return null == val ? 0 : val;
    }

    public static Double nullToZero( Double val ){
        return null == val ? 0.0 : val;
    }

    public static BigDecimal nullToOne( BigDecimal val ){
        return null == val ? BigDecimal.ONE : val;
    }

    public static Integer nullToOne( Integer val ){
        return null == val ? 1 : val;
    }

    public static Double nullToOne( Double val ){
        return null == val ? 1.0 : val;
    }

    public static Long nullToZero( Long val ){
        return null == val ? 0L : val;
    }

    public static boolean compareToZero( BigDecimal number , Symbol symbol){
        if ( symbol == Symbol.GREATER ){
            if ( nullToZero( number ).compareTo( BigDecimal.ZERO ) == 1 ){
                return true;
            }
        }else if ( symbol == Symbol.LESS ){
            if ( nullToZero( number ).compareTo( BigDecimal.ZERO ) == -1 ){
                return true;
            }
        } else {
            if ( nullToZero( number ).compareTo( BigDecimal.ZERO ) == 0 ){
                return true;
            }
        }
        return false;
    }

    public static BigDecimal nullToZero( String val ){
        return StringUtils.isEmpty( val ) ? BigDecimal.ZERO : new BigDecimal( val );
    }

    /**
     *==================================================================
     * @description: 比较符号 大于、小于、等于
     * @author:ooo
     *==================================================================
     **/
    public enum Symbol{
        GREATER,LESS,EQUAL
    }
}

