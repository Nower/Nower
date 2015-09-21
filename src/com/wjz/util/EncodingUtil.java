package com.wjz.util;

/**
 * Created by wujiazhi on 15/9/12.
 */
public class EncodingUtil {

    private final static char[] HEX = "0123456789abcdef".toCharArray();

    /**
     * 字节流转成16进制输出
     * @param bys
     * @return
     */
    public static String bytes2HexString(byte[] bys) {
        char[] chs = new char[bys.length * 2 + bys.length - 1];
        for (int i = 0, offset = 0; i < bys.length; i++) {
            if (i > 0) {
                chs[offset++] = ' ';
            }
            chs[offset++] = HEX[bys[i] >> 4 & 0xf];
            chs[offset++] = HEX[bys[i] & 0xf];
//            System.out.print(bys[i]);
        }
//        System.out.println();
        return new String(chs);
    }
}
