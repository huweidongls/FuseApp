package com.guoyu.fuseapp.wxapi;

/**
 * Created by Administrator on 2018/10/9.
 */

public interface OnResponseListener {
    void onSuccess();

    void onCancel();

    void onFail(String message);
}
