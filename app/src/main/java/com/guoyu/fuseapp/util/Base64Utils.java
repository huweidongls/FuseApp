package com.guoyu.fuseapp.util;

import android.util.Base64;

/**
 * Created by Administrator on 2018/12/7.
 */

public class Base64Utils {

    /**
     * 加密
     * oldWord：需要加密的文字/比如密码
     */
    public static String setEncryption(String oldWord){

        return Base64.encodeToString(oldWord.getBytes(), Base64.DEFAULT);

    }

    /**
     * 解密
     * encodeWord：加密后的文字/比如密码
     */
    public static String setDecrypt(String encodeWord){

        return new String(Base64.decode(encodeWord.getBytes(), Base64.DEFAULT));


    }

}
