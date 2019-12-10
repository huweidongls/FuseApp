package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.ShequBean;
import com.guoyu.fuseapp.bean.UserGetOneBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.vise.xsnow.http.ViseHttp.getContext;

/**
 * Created by Administrator on 2019/10/9.
 */

public class PersonInformationActivity extends BaseActivity {

    private Context context = PersonInformationActivity.this;

    @BindView(R.id.et_water)
    EditText et_water;
    @BindView(R.id.et_electric)
    EditText et_electric;
    @BindView(R.id.et_social)
    EditText et_social;
    @BindView(R.id.et_gold)
    EditText et_gold;
    @BindView(R.id.et_vehicle)
    EditText et_vehicle;
    @BindView(R.id.tv_real_type)
    TextView tvRealType;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_xiaoqu_name)
    TextView tvXiaoquName;
    @BindView(R.id.et_nick)
    EditText et_nick;
    @BindView(R.id.ll_status)
    LinearLayout ll_status;
    @BindView(R.id.ll_shequz)
    LinearLayout llShequZ;
    @BindView(R.id.tv_shequ_name)
    TextView tvShequName;
    @BindView(R.id.et_address)
    EditText etAddress;

    private Dialog dialog;
    private String xiaoquId = "";
    private String xiaoquName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinformation);
        //Log.e("skdfhjksdhfj",SpUtils.getToken(context));
        ButterKnife.bind(PersonInformationActivity.this);
        initData();

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", SpUtils.getUserId(context));
        ViseUtil.Get(context, NetUrl.CitizenUsergetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Logger.e("123123", s);
                Gson gson = new Gson();
                UserGetOneBean bean = gson.fromJson(s, UserGetOneBean.class);
                int status = bean.getData().getStatus();

                if(status == 1){
                    tvRealType.setText("已注册");
                    ll_status.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setClass(context, RealNameActivity.class);
                            startActivity(intent);
                        }
                    });
                }else if(status == 2){
                    tvRealType.setText("已实名");
                }else if(status == 3){
                    tvRealType.setText("审批拒绝");
                    ll_status.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setClass(context, RealNameActivity.class);
                            startActivity(intent);
                        }
                    });
                }else if(status == 4){
                    tvRealType.setText("审批中");
                }
                tvName.setText(bean.getData().getRealName());
                tvPhone.setText(bean.getData().getPhone());
                et_water.setText(bean.getData().getWaterNo());
                et_electric.setText(bean.getData().getEleNo());
                et_social.setText(bean.getData().getSsNo());
                et_gold.setText(bean.getData().getFoundNo());
                et_vehicle.setText(bean.getData().getCarNo());
                et_nick.setText(bean.getData().getNick());
                etAddress.setText(bean.getData().getAddress());
                if(bean.getData().getCommName()!=null){
                    xiaoquId = bean.getData().getCommunityInfo()+"";
                    xiaoquName = bean.getData().getCommName();
                    tvXiaoquName.setText(xiaoquName);
                }
                if(bean.getData().getCommunityName()!=null){
                    llShequZ.setVisibility(View.VISIBLE);
                    tvShequName.setText(bean.getData().getCommunityName());
                }else {
                    llShequZ.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001&&resultCode == 1002&&data != null){
            xiaoquId = data.getStringExtra("id");
            tvXiaoquName.setText(data.getStringExtra("name"));
        }
    }

    @OnClick({R.id.rl_back,R.id.btn_submits, R.id.ll_shequ})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_submits:
                 Commit();
                break;
            case R.id.ll_shequ:
                intent.setClass(context, ShequListActivity.class);
                startActivityForResult(intent, 1001);
                break;
        }
    }

    private void Commit(){
        final String shui = et_water.getText().toString();
        final String dian = et_electric.getText().toString();
        final String she = et_social.getText().toString();
        final String jin = et_gold.getText().toString();
        final String che = et_vehicle.getText().toString();
        final String nick = et_nick.getText().toString();
        final String address = etAddress.getText().toString();
        if (StringUtils.isEmpty(shui)||StringUtils.isEmpty(dian)||StringUtils.isEmpty(she)||StringUtils.isEmpty(jin)||StringUtils.isEmpty(che)
                ||StringUtils.isEmpty(xiaoquId) || StringUtils.isEmpty(nick) || StringUtils.isEmpty(address)){
            ToastUtil.showShort(context, "请把信息填写完整!");
        }else{
            //提交接口
            dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
            Map<String, String> map = new LinkedHashMap<>();
            map.put("id", SpUtils.getUserId(context));
            map.put("waterNo", shui);
            map.put("eleNo", dian);
            map.put("ssNo", she);
            map.put("foundNo", jin);
            map.put("carNo", che);
            map.put("communityInfo", xiaoquId);
            map.put("nick",nick);
            map.put("address", address);
            ViseUtil.Post(context, NetUrl.CitizenUserupdate, map, dialog, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    Logger.e("123123", s);
                    try {
                        Gson gson = new Gson();
                        ShequBean shequBean = gson.fromJson(s, ShequBean.class);
                        SpUtils.setShequId(context, shequBean.getData().getParentCommId());
                        SpUtils.setShequName(context, shequBean.getData().getParentCommName());
                        JSONObject jsonObject = new JSONObject(s);
                        SpUtils.setXiaoquId(context, xiaoquId);
                        SpUtils.setXiaoquName(context, xiaoquName);
                        ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                        finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
