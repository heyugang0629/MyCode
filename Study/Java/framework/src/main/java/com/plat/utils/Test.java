package com.plat.utils;

import org.springframework.util.Base64Utils;

/**
 * @author hyg
 * @date 2021/5/10
 */
public class Test {
    /**
     * 把String的转换成base64码
     */
    public static String stringToBase64(String ss) {
        byte[] bytes = Base64Utils.encode(ss.getBytes());
        return new String( bytes );
    }

    public static void main(String[] args) {
        String base = stringToBase64("update T_SETTLE_REV_INVOICE_M SET BILLTO_LCODE='L059324',BILLTO_TCODE='T11555',PAYMENT_UNIT_TCODE='T264802',PAYMENT_UNIT_LCODE='L059324',\n" +
                "INVOICE_LCODE='L059324',INVOICE_TCODE='T11555' WHERE SYS_INVOICE_NO IN ('RYMZ210508000221','RYMZ210508000220');");
        System.out.println( base );
        System.out.println();
        byte[] bytes = Base64Utils.decode(base.getBytes());
        System.out.println( new String(bytes) );


        long beginTime = System.currentTimeMillis();
        System.out.println( 4 / 4 );
        System.out.println( "time" +( System.currentTimeMillis()-beginTime ));
        System.out.println( 4<< 2);
    }
}
