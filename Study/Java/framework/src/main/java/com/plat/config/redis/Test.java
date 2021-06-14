package com.plat.config.redis;

/**
 * Created by jack on 2021/4/29.
 */
public class Test {

    public static void main(String[] args) {
        String str = "select * from T_UR_USER";

        System.out.println( str );
        String str1 = encode( str );
        System.out.println( str1 );

        System.out.println( decode( str1 ) );
    }

    /**
     * 加密，把一个字符串在原有的基础上+1
     * @param data 需要解密的原字符串
     * @return 返回解密后的新字符串
     */
    public static String encode(String data) {
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for(int i=0;i<b.length;i++) {
            b[i] += 1;//在原有的基础上+1
        }
        return new String(b);
    }

    /**
     * 解密：把一个加密后的字符串在原有基础上-1
     * @param data 加密后的字符串
     * @return 返回解密后的新字符串
     */
    public static String decode(String data) {
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for(int i=0;i<b.length;i++) {
            b[i] -= 1;//在原有的基础上-1
        }
        return new String(b);
    }
}
