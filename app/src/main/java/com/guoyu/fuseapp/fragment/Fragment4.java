package com.guoyu.fuseapp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.donkingliang.imageselector.utils.ImageSelectorUtils;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.bean.UserGetOneBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.ComplaintConsultationActivity;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.page.MemberSetupActivity;
import com.guoyu.fuseapp.page.MyYuyueActivity;
import com.guoyu.fuseapp.page.PersonInformationActivity;
import com.guoyu.fuseapp.page.RealNameActivity;
import com.guoyu.fuseapp.page.RegisterActivity;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/9/29.
 */

public class Fragment4 extends BaseFragment {

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ll_register)
    LinearLayout llRegister;
    @BindView(R.id.ll_forgot)
    LinearLayout llForgot;
    @BindView(R.id.v)
    View v;

    private int REQUEST_CODE = 101;
    private String pic="";
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        String id = SpUtils.getUserId(getContext());
        if(id.equals("0")){
            llRegister.setVisibility(View.VISIBLE);
            llForgot.setVisibility(View.GONE);
            v.setVisibility(View.GONE);
            Glide.with(getContext()).load(R.mipmap.timg).into(ivHead);
            tvName.setText("未登录用户");
            tvPhone.setText(null);
        }else {
            llRegister.setVisibility(View.GONE);
            llForgot.setVisibility(View.VISIBLE);
            v.setVisibility(View.VISIBLE);
            Map<String, String> map = new LinkedHashMap<>();
            map.put("id", SpUtils.getUserId(getContext()));
            ViseUtil.Get(getContext(), NetUrl.CitizenUsergetOne, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
//                    Logger.e("123123", s);
                    Gson gson = new Gson();
                    UserGetOneBean bean = gson.fromJson(s, UserGetOneBean.class);
                    if(bean.getData().getUserPic() != null){
                        String[] heads = bean.getData().getUserPic().split(",");
                        Glide.with(getContext()).load(NetUrl.BASE_URL+heads[0]).into(ivHead);
                    }
                    tvName.setText(bean.getData().getNick());
                    tvPhone.setText(bean.getData().getPhone());
                    int status = bean.getData().getStatus();
                    SpUtils.setReal(getContext(), status+"");
                    SpUtils.setXiaoquId(getContext(), bean.getData().getCommunityInfo()+"");
                    SpUtils.setXiaoquName(getContext(), bean.getData().getCommName());
                    SpUtils.setShequId(getContext(), bean.getData().getCommunity()+"");
                    SpUtils.setShequName(getContext(), bean.getData().getCommunityName());
                }
            });
        }
    }

    private void initData() {//apiupdateheadPortrait

    }

    @OnClick({R.id.lzixun, R.id.ll_register, R.id.ll_real, R.id.ll_person, R.id.tv_set, R.id.rl_login,R.id.iv_head, R.id.ll_forgot,
    R.id.ll_yuyue})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.ll_yuyue:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), MyYuyueActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.lzixun:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), ComplaintConsultationActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.iv_head:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    //限数量的多选(比喻最多9张)
                    ImageSelector.builder()
                            .useCamera(true) // 设置是否使用拍照
                            .setSingle(false)  //设置是否单选
                            .setMaxSelectCount(1) // 图片的最大选择数量，小于等于0时，不限数量。
                            .setViewImage(true) //是否点击放大图片查看,，默认为true
                            .start(this, REQUEST_CODE); // 打开相册
                }
                break;
            case R.id.ll_register:
                intent.setClass(getContext(), RegisterActivity.class);
                intent.putExtra("type", "0");
                startActivity(intent);
                break;
            case R.id.ll_real:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else if(SpUtils.getReal(getContext()).equals("4")){
                    ToastUtil.showShort(getContext(), "审批中");
                }else if(SpUtils.getReal(getContext()).equals("2")){
                    ToastUtil.showShort(getContext(), "已实名");
                }else {
                    intent.setClass(getContext(), RealNameActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.ll_person:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), PersonInformationActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.tv_set:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), MemberSetupActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.rl_login:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.ll_forgot:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), RegisterActivity.class);
                    intent.putExtra("type", "1");
                    startActivity(intent);
                }
                break;
        }
    }

    private void upload_head(){
        //提交接口
        dialog = WeiboDialogUtils.createLoadingDialog(getContext(), "请等待...");
        File file = new File(pic);
        ViseHttp.UPLOAD(NetUrl.apiupdateheadPortrait)
                .addParam("id", SpUtils.getUserId(getContext()))
                .addFile("file0", file)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                ToastUtil.showShort(getContext(), jsonObject.optString("errorMsg"));
                                Glide.with(getContext()).load(pic).into(ivHead);
                            }else {
                                ToastUtil.showShort(getContext(), jsonObject.optString("errorMsg"));
                            }
                            WeiboDialogUtils.closeDialog(dialog);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        WeiboDialogUtils.closeDialog(dialog);
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            //获取选择器返回的数据
            ArrayList<String> images = data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);
            if (images.size() > 0) {
                pic = images.get(0);
                upload_head();
            }
        }
    }

}
