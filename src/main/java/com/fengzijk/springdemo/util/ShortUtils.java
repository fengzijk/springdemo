/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       JKHH120 LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2019年07月17日 14时33分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Discription
 *   -----------------------------------------------------------------------------------
 *  2019-07-17 14:33:24    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.util;

import java.security.MessageDigest;
import java.util.Random;

public class ShortUtils {


    public static String[] shortParam(String param) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "WXMP";
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"

        };
        // 对传入网址进行 MD5 加密
        String hex = md5ByHex(key + param);

        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            StringBuilder outChars = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars.append(chars[(int) index]);
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars.toString();
        }
        return resUrl;
    }

    /**
     * MD5加密(32位大写)
     *
     * @param src
     * @return
     */
    public static String md5ByHex(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = src.getBytes();
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            StringBuilder hs = new StringBuilder();
            String stmp = "";
            for (byte value : hash) {
                stmp = Integer.toHexString(value & 0xFF);
                if (stmp.length() == 1) {
                    hs.append("0").append(stmp);
                } else {
                    hs.append(stmp);
                }
            }
            return hs.toString().toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }


    public static String getShortsSence(String param) {
        //将产生4组6位字符串
        String[] aResult = shortParam(param);
        Random random = new Random();
        //产成4以内随机数
        int j = random.nextInt(4);
        return aResult[j];
    }
}
