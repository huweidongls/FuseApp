package com.guoyu.fuseapp.util;

import android.content.Context;

import com.vise.xsnow.cache.SpCache;

/**
 * Created by Administrator on 2018/10/26.
 */

public class SpUtils {

    private static SpCache spCache;
    public static String USER_ID = "user_id";
    public static String PHONENUM = "phonenum";
    public static String TOKEN = "token";
    public static String SEARCH_HISTORY = "search_history";
    public static String REAL = "real";
    public static String XIAOQU_ID = "xiaoqu_id";
    public static String XIAOQU_NAME = "xiaoqu_name";
    public static String SHEQU_ID = "shequ_id";
    public static String SHEQU_NAME = "shequ_name";

    public static void setShequName(Context context, String shequName){
        spCache = new SpCache(context, "user_info");
        spCache.put(SHEQU_NAME, shequName);
    }

    public static String getShequName(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(SHEQU_NAME, "");
    }

    public static void setShequId(Context context, String shequId){
        spCache = new SpCache(context, "user_info");
        spCache.put(SHEQU_ID, shequId);
    }

    public static String getShequId(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(SHEQU_ID, "");
    }

    public static void setXiaoquName(Context context, String xiaoquName){
        spCache = new SpCache(context, "user_info");
        spCache.put(XIAOQU_NAME, xiaoquName);
    }

    public static String getXiaoquName(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(XIAOQU_NAME, "");
    }

    public static void setXiaoquId(Context context, String xiaoquId){
        spCache = new SpCache(context, "user_info");
        spCache.put(XIAOQU_ID, xiaoquId);
    }

    public static String getXiaoquId(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(XIAOQU_ID, "");
    }

    public static void setReal(Context context, String real){
        spCache = new SpCache(context, "user_info");
        spCache.put(REAL, real);
    }

    public static String getReal(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(REAL, "");
    }

    public static void setSearchHistory(Context context, String token){
        spCache = new SpCache(context, "user_info");
        spCache.put(SEARCH_HISTORY, token);
    }

    public static String getSearchHistory(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(SEARCH_HISTORY, "");
    }

    public static void setToken(Context context, String token){
        spCache = new SpCache(context, "user_info");
        spCache.put(TOKEN, token);
    }

    public static String getToken(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(TOKEN, "0");
    }

    public static void setPhoneNum(Context context, String phonenum){
        spCache = new SpCache(context, "user_info");
        spCache.put(PHONENUM, phonenum);
    }

    public static String getPhoneNum(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(PHONENUM, "0");
    }

    public static void setUserId(Context context, String userid){
        spCache = new SpCache(context, "user_info");
        spCache.put(USER_ID, userid);
    }

    public static String getUserId(Context context){
        spCache = new SpCache(context, "user_info");
        return spCache.get(USER_ID, "0");
    }

    public static void clear(Context context){
        spCache = new SpCache(context, "user_info");
        spCache.clear();
    }

}
