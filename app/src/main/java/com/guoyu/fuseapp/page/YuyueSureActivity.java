package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppAppointmentgetOneByTimeBean;
import com.guoyu.fuseapp.bean.AppBookingBusinessqueryListManageBean;
import com.guoyu.fuseapp.bean.YyCommitmentAppgetOneBean;
import com.guoyu.fuseapp.bean.YyMzsmAppgetOneBean;
import com.guoyu.fuseapp.dialog.DialogYuyueTishi;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuyueSureActivity extends BaseActivity {

    private Context context = YuyueSureActivity.this;

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_idcard)
    EditText etIdcard;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.tv1_1)
    TextView tv11;
    @BindView(R.id.tv1_2)
    TextView tv12;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;

    private AppAppointmentgetOneByTimeBean.DataBean.ListBean bean;
    private String content;

    private Dialog dialog;

    private boolean isIv1 = false;
    private boolean isIv2 = false;
    private boolean isIv3 = false;

    private String mzTitle = "";
    private String mzContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_sure);

        bean = (AppAppointmentgetOneByTimeBean.DataBean.ListBean) getIntent().getSerializableExtra("bean");
        content = getIntent().getStringExtra("content");
        ButterKnife.bind(YuyueSureActivity.this);
        initData();

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", "1");
        ViseUtil.Get(context, NetUrl.yyCommitmentAppgetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Logger.e("123123", s);
                Gson gson = new Gson();
                YyCommitmentAppgetOneBean bean1 = gson.fromJson(s, YyCommitmentAppgetOneBean.class);
//                int size = bean1.getData().getCommitmentSize();
//                tv11.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
//                tv12.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
//                tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
//                tv3.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
                tv11.setText("我已经阅读并同意");
                tv12.setText("免责声明");
                tv2.setText(bean1.getData().getCommitment());
                tv3.setText("上述信息是我本人填写，本人对信息内容的真实性和完整性负责，如果信息有误或缺失，本人愿意承担相应法律责任。本人保证遵守防疫管控的各项规定，配合并听从各项措施和要求。");
                mzTitle = bean1.getData().getTitle();
                mzContent = bean1.getData().getContent();
            }
        });

    }

    @OnClick({R.id.rl_back, R.id.btn_yuyue, R.id.iv1, R.id.iv2, R.id.iv3, R.id.tv1_2})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv1_2:
                mianzeShow();
                break;
            case R.id.iv1:
                if(!isIv1){
                    isIv1 = true;
                    iv1.setImageResource(R.mipmap.duihao_blue);
                }
                break;
            case R.id.iv2:
                if(!isIv2){
                    isIv2 = true;
                    iv2.setImageResource(R.mipmap.duihao_blue);
                }
                break;
            case R.id.iv3:
                if(!isIv3){
                    isIv3 = true;
                    iv3.setImageResource(R.mipmap.duihao_blue);
                }
                break;
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_yuyue:
                yuyue();
                break;
        }
    }

    private void mianzeShow() {

        DialogYuyueTishi dialogYuyueTishi = new DialogYuyueTishi(context, mzTitle,
                mzContent);
        dialogYuyueTishi.show();

    }

    private void yuyue() {

        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String idcard = etIdcard.getText().toString();

        if(isIv1&&isIv2&&isIv3){
            if(StringUtils.isEmpty(name)||StringUtils.isEmpty(phone)||StringUtils.isEmpty(idcard)){
                ToastUtil.showShort(context, "请完善信息后提交");
            }else if(!StringUtils.isPhoneNumberValid(phone)){
                ToastUtil.showShort(context, "请输入正确的电话号码");
            }else if(!StringUtils.isLegalId(idcard)){
                ToastUtil.showShort(context, "请输入合法身份证号");
            }else {
                dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                Map<String, String> map = new LinkedHashMap<>();
                map.put("userId", SpUtils.getUserId(context));
                map.put("username", name);
                map.put("idCard", idcard);
                map.put("phone", phone);
                map.put("hallId", bean.getHallId()+"");
                map.put("nyrTime", bean.getNyrTime());
                map.put("timeId", bean.getTimeId()+"");
                ViseUtil.Post(context, NetUrl.AppAppointmentinsertInformationApp, map, dialog, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Intent intent = new Intent();
                        intent.setClass(context, YuyueSuccessActivity.class);
                        intent.putExtra("nyrTime", bean.getNyrTime());
                        intent.putExtra("time", bean.getTimeSlot());
                        intent.putExtra("content", content);
                        startActivity(intent);
                        finish();
                    }
                });
//            Map<String, String> map = new LinkedHashMap<>();
//            map.put("hallName", bean.getHallName());
//            map.put("depName", bean.getDepName());
//            map.put("busName", bean.getBusinessName());
//            map.put("detailsName", bean.getDetailsName());
//            map.put("manageId", bean.getId()+"");
//            map.put("businessUserId", SpUtils.getUserId(context));
//            map.put("businessUserName", name);
//            map.put("businessUserIdnumber", idcard);
//            map.put("businessUserPhone", phone);
//            map.put("businessDate", bean.getOrderYearMonth()+" "+bean.getOrderStartTime()+"-"+bean.getOrderEndTime());
//            map.put("businessQd", "1");
//            ViseUtil.Post(context, NetUrl.AppBookingBusinesstoUpdate, map, dialog, new ViseUtil.ViseListener() {
//                @Override
//                public void onReturn(String s) {
//                    ToastUtil.showShort(context, "预约成功");
//                    finish();
//                }
//            });
            }
        }else {
            ToastUtil.showShort(context, "请勾选协议之后在提交");
        }

    }

}
