package com.guoyu.fuseapp.util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import com.guoyu.fuseapp.page.LoginActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2019/10/11.
 */

public class ViseUtil {

    public static void Get(final Context context, final String url, Map<String, String> map, final RefreshLayout refreshLayout, final int type, final ViseListener listener){

        ViseHttp.GET(url)
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                listener.onReturn(data);
                            }else if(jsonObject.optString("status").equals("11")){
                                SpUtils.clear(context);
                                Intent intent = new Intent();
                                intent.setClass(context, LoginActivity.class);
                                context.startActivity(intent);
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(type == 0){
                            refreshLayout.finishRefresh(500);
                        }else if(type == 1){
                            refreshLayout.finishLoadMore(500);
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", url);
                        ToastUtil.showShort(context, "网络异常");
                        if(type == 0){
                            refreshLayout.finishRefresh(500);
                        }else if(type == 1){
                            refreshLayout.finishLoadMore(500);
                        }
                    }
                });

    }

    public static void Get(final Context context, final String url, Map<String, String> map, final ViseListener listener){

        ViseHttp.GET(url)
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                listener.onReturn(data);
                            }else if(jsonObject.optString("status").equals("11")){
                                SpUtils.clear(context);
                                Intent intent = new Intent();
                                intent.setClass(context, LoginActivity.class);
                                context.startActivity(intent);
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", url);
                        ToastUtil.showShort(context, "网络异常");
                    }
                });

    }

    public static void Get(final Context context, final String url, Map<String, String> map, final Dialog dialog, final ViseListener listener){

        ViseHttp.GET(url)
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                listener.onReturn(data);
                            }else if(jsonObject.optString("status").equals("11")){
                                SpUtils.clear(context);
                                Intent intent = new Intent();
                                intent.setClass(context, LoginActivity.class);
                                context.startActivity(intent);
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                            }
                            WeiboDialogUtils.closeDialog(dialog);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", url);
                        ToastUtil.showShort(context, "网络异常");
                        WeiboDialogUtils.closeDialog(dialog);
                    }
                });

    }

    public static void Post(final Context context, final String url, Map<String, String> map, final RefreshLayout refreshLayout, final int type, final ViseListener listener){

        ViseHttp.POST(url)
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                listener.onReturn(data);
                            }else if(jsonObject.optString("status").equals("11")){
                                Intent intent = new Intent();
                                intent.setClass(context, LoginActivity.class);
                                context.startActivity(intent);
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(type == 0){
                            refreshLayout.finishRefresh(500);
                        }else if(type == 1){
                            refreshLayout.finishLoadMore(500);
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", url);
                        ToastUtil.showShort(context, "网络异常");
                        if(type == 0){
                            refreshLayout.finishRefresh(500);
                        }else if(type == 1){
                            refreshLayout.finishLoadMore(500);
                        }
                    }
                });

    }

    public static void Post(final Context context, final String url, Map<String, String> map, final ViseListener listener){

        ViseHttp.POST(url)
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                listener.onReturn(data);
                            }else if(jsonObject.optString("status").equals("11")){
                                Intent intent = new Intent();
                                intent.setClass(context, LoginActivity.class);
                                context.startActivity(intent);
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", url);
                        ToastUtil.showShort(context, "网络异常");
                    }
                });

    }

    public static void Post(final Context context, final String url, Map<String, String> map, final Dialog dialog, final ViseListener listener){

        ViseHttp.POST(url)
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                listener.onReturn(data);
                            }else if(jsonObject.optString("status").equals("11")){
                                Intent intent = new Intent();
                                intent.setClass(context, LoginActivity.class);
                                context.startActivity(intent);
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                            }
                            WeiboDialogUtils.closeDialog(dialog);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", url);
                        ToastUtil.showShort(context, "网络异常");
                        WeiboDialogUtils.closeDialog(dialog);
                    }
                });

    }

    public interface ViseListener{
        void onReturn(String s);
    }

}
