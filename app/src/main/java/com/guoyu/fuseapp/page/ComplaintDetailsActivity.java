package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.ComplaintDetailBean;
import com.guoyu.fuseapp.bean.ConsultationTypeBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplaintDetailsActivity extends AppCompatActivity {

    private Context context = ComplaintDetailsActivity.this;

    private String id = "";
    @BindView(R.id.iv_img)
    ImageView iv_img;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.tv_fk)
    TextView tv_fk;
    @BindView(R.id.tv_name_time)
    TextView tv_name_time;
    @BindView(R.id.tv_bumen)
    TextView tv_bumen;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);
        id = getIntent().getStringExtra("id");
        ButterKnife.bind(ComplaintDetailsActivity.this);
        initData();
    }

    @OnClick({R.id.iv_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_black:
                finish();
                break;
        }
    }

    private void initData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", id);
        ViseUtil.Get(ComplaintDetailsActivity.this, NetUrl.AppConsultationInfogetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Log.e("778787878787878", s);
                Gson gson = new Gson();
                ComplaintDetailBean bean = gson.fromJson(s, ComplaintDetailBean.class);
                if (bean.getData().getUserPic() != null) {
                    String[] pics = bean.getData().getUserPic().split(",");
                    if (pics.length > 0) {
                        GlideUtils.into(context, NetUrl.BASE_URL + pics[0], iv_img);
                    }
                }
                if (bean.getData().getContentPic() != null) {
                    String[] pics = bean.getData().getContentPic().split(",");
                    if (pics.length > 0) {
                        GlideUtils.into(context, NetUrl.BASE_URL + pics[0], iv);
                    }
                }
                tvTitle.setText(bean.getData().getTitle());
                tvSubTitle.setText(bean.getData().getContentTop());
                tv_bumen.setText(bean.getData().getDeptName());
                tv_type.setText(bean.getData().getConsTypeName());
                tv_name.setText(bean.getData().getUsername());
                tv_time.setText(bean.getData().getCreateDate());
                tv_content.setText(bean.getData().getContent());
                if (bean.getData().getStatusid() == 1) {//待反馈
                    tv_fk.setVisibility(View.GONE);
                    tv_name_time.setVisibility(View.GONE);
                } else {//已反馈
                    tv_fk.setVisibility(View.VISIBLE);
                    tv_name_time.setVisibility(View.VISIBLE);
                    tv_fk.setText(bean.getData().getFeeMemo());
                    tv_name_time.setText(bean.getData().getFeeDate() + "由:" + bean.getData().getFeeUserName() + "反馈");
                }
            }
        });
    }
}
