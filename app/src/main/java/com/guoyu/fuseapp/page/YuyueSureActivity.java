package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppAppointmentgetOneByTimeBean;
import com.guoyu.fuseapp.bean.AppBookingBusinessqueryListManageBean;
import com.guoyu.fuseapp.net.NetUrl;
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

    private AppAppointmentgetOneByTimeBean.DataBean.ListBean bean;
    private String content;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_sure);

        bean = (AppAppointmentgetOneByTimeBean.DataBean.ListBean) getIntent().getSerializableExtra("bean");
        content = getIntent().getStringExtra("content");
        ButterKnife.bind(YuyueSureActivity.this);

    }

    @OnClick({R.id.rl_back, R.id.btn_yuyue})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_yuyue:
                yuyue();
                break;
        }
    }

    private void yuyue() {

        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String idcard = etIdcard.getText().toString();
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

    }

}
