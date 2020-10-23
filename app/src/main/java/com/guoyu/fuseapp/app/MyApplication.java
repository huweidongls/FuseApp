package com.guoyu.fuseapp.app;

import android.app.Activity;
import android.app.Application;

import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.RegisterTimeCount;
import com.guoyu.fuseapp.util.SpUtils;
import com.vise.xsnow.http.ViseHttp;
import com.zzhoujay.richtext.RichText;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/9/29.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private List<Activity> mList = new LinkedList<Activity>();
    // 修改密码获取验证码倒计时
    public static RegisterTimeCount registerTimeCount;

    public static int isWenjuan = 0;

    public MyApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("jnkjToken", SpUtils.getToken(getApplicationContext()));
        ViseHttp.init(this);
        ViseHttp.CONFIG().baseUrl(NetUrl.BASE_URL)
        .globalHeaders(map);
        registerTimeCount = new RegisterTimeCount(60000, 1000);
        RichText.initCacheDir(this);
    }

    public synchronized static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    // add Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    public void closeActivity(Class<? extends Activity> cls){

        for(int i = 0; i<mList.size(); i++){
            Activity y = mList.get(i);
            if(y.getClass().equals(cls)) {
                y.finish();
                mList.remove(i);
            }
        }

    }

    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

}
