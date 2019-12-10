package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.donkingliang.imageselector.utils.ImageSelectorUtils;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.dialog.InformationSexDialog;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/10/9.
 */

public class RealNameActivity extends BaseActivity {

    private Context context = RealNameActivity.this;
    private int REQUEST_CODE = 101;
    private int REQUEST_CODE1 = 102;
    @BindView(R.id.iv_img)
    ImageView iv1;
    @BindView(R.id.iv_img2)
    ImageView iv2;
    @BindView(R.id.ed_name)
    EditText ed_name;
    @BindView(R.id.ed_sex)
    TextView ed_sex;
    @BindView(R.id.ed_code)
    EditText ed_code;
    @BindView(R.id.iv_del1)
    ImageView ivDel1;
    @BindView(R.id.iv_del2)
    ImageView ivDel2;

    private String pic1 = "";
    private String pic2 = "";

    private Dialog dialog;

    private String sex = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realnameauthentication);

        ButterKnife.bind(RealNameActivity.this);

    }

    @OnClick({R.id.rl_back, R.id.identitycard, R.id.idCardreflection, R.id.iv_del1, R.id.iv_del2, R.id.btn_submit,
    R.id.ll_sex})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_del1:
                pic1 = "";
                Glide.with(context).load("#ffffff").into(iv1);//@mipmap/img0203x
                ivDel1.setVisibility(View.GONE);
                break;
            case R.id.iv_del2:
                pic2 = "";
                Glide.with(context).load("#ffffff").into(iv2);
                ivDel2.setVisibility(View.GONE);
                break;
            case R.id.identitycard:
                //限数量的多选(比喻最多9张)
                ImageSelector.builder()
                        .useCamera(true) // 设置是否使用拍照
                        .setSingle(false)  //设置是否单选
                        .setMaxSelectCount(1) // 图片的最大选择数量，小于等于0时，不限数量。
                        .setViewImage(true) //是否点击放大图片查看,，默认为true
                        .start(RealNameActivity.this, REQUEST_CODE); // 打开相册
                break;
            case R.id.idCardreflection:
                //限数量的多选(比喻最多9张)
                ImageSelector.builder()
                        .useCamera(true) // 设置是否使用拍照
                        .setSingle(false)  //设置是否单选
                        .setMaxSelectCount(1) // 图片的最大选择数量，小于等于0时，不限数量。
                        .setViewImage(true) //是否点击放大图片查看,，默认为true
                        .start(RealNameActivity.this, REQUEST_CODE1); // 打开相册
                break;
            case R.id.btn_submit:
                SubmitRealName();
                break;
            case R.id.ll_sex:
                InformationSexDialog sexDialog = new InformationSexDialog(context, new InformationSexDialog.ClickListener() {
                    @Override
                    public void onNan() {
                        sex = "男";
                        ed_sex.setText(sex);
                    }

                    @Override
                    public void onNv() {
                        sex = "女";
                        ed_sex.setText(sex);
                    }
                });
                sexDialog.show();
                break;
        }
    }

    private void SubmitRealName() {
        final String name = ed_name.getText().toString();
        final String idCard = ed_code.getText().toString();//
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(sex)) {
            ToastUtil.showShort(context, "请把信息填写完整!");
        } else {
            if (StringUtils.isEmpty(pic1) || StringUtils.isEmpty(pic2)) {
                ToastUtil.showShort(context, "请选择照片!");
            } else {
                //提交接口
                dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                File file = new File(pic1);
                File file1 = new File(pic2);
                ViseHttp.UPLOAD(NetUrl.realNameAuthentication)
                        .addParam("phone", SpUtils.getPhoneNum(context))
                        .addParam("id", SpUtils.getUserId(context))
                        .addParam("realName", name)
                        .addParam("appuserId", idCard)
                        .addParam("sex", sex)
                        .addFile("file0", file)
                        .addFile("file1", file1)
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                try {
                                    JSONObject jsonObject = new JSONObject(data);
                                    if(jsonObject.optString("status").equals("200")){
                                        ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                        finish();
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
                                WeiboDialogUtils.closeDialog(dialog);
                            }
                        });
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            //获取选择器返回的数据
            ArrayList<String> images = data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);
            if (images.size() > 0) {
                Glide.with(context).load(images.get(0)).into(iv1);
                pic1 = images.get(0);
                ivDel1.setVisibility(View.VISIBLE);
            }
        } else if (requestCode == REQUEST_CODE1 && data != null) {
            //获取选择器返回的数据
            ArrayList<String> images = data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);
            if (images.size() > 0) {
                Glide.with(context).load(images.get(0)).into(iv2);
                pic2 = images.get(0);
                ivDel2.setVisibility(View.VISIBLE);
            }
            // RealnameauThenticationEcho();
        }
    }
}
