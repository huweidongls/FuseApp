package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.FindNumBean;
import com.guoyu.fuseapp.bean.JiazhengDetailsBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JiazhengDetailsActivity extends BaseActivity {

    private Context context = JiazhengDetailsActivity.this;

    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_fu_title)
    TextView tvFuTitle;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_liulan_num)
    TextView tvLiulanNum;
    @BindView(R.id.tv_zan_num)
    TextView tvZanNum;
    @BindView(R.id.iv_zan)
    ImageView ivZan;

    private String id = "";
    private String phone = "";
    private String title = "";
    private String funCode = "";
    private int zanNum = 0;
    private boolean isZan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiazheng_details);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("id");
        ButterKnife.bind(JiazhengDetailsActivity.this);
        initData();

    }

    private void initData() {

        tvTopTitle.setText(title+"详情");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", id);
        ViseUtil.Get(context, NetUrl.AppHouseServiceInfogetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                JiazhengDetailsBean bean = gson.fromJson(s, JiazhengDetailsBean.class);
                phone = bean.getData().getTelephone();
                GlideUtils.into(context, NetUrl.BASE_URL+bean.getData().getTopPic(), ivTitle);
                tvTitle.setText(bean.getData().getTitle());
                tvAddress.setText("公司地址："+bean.getData().getAddress());
                tvFuTitle.setText(bean.getData().getContentTop());
                tvPhone.setText(bean.getData().getTelephone());
                RichText.from(bean.getData().getContent()).bind(this)
                        .showBorder(false)
                        .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                        .into(tvContent);
            }
        });

        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("businessId", id);
        map1.put("funCode", funCode);
        ViseUtil.Get(context, NetUrl.AppShareListPraiseTimesfindNum, map1, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                FindNumBean bean = gson.fromJson(s, FindNumBean.class);
                tvLiulanNum.setText("浏览： "+bean.getData().getListTimes());
                zanNum = bean.getData().getPraiseTimes();
                tvZanNum.setText(zanNum+"");
            }
        });

    }

    @OnClick({R.id.rl_back, R.id.tv_yuyue, R.id.ll_zan})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_yuyue:
                if(!StringUtils.isEmpty(phone)){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:" + phone);
                    intent.setData(data);
                    startActivity(intent);
                }
                break;
            case R.id.ll_zan:
                zan();
                break;
        }
    }

    private synchronized void zan() {

        if(!isZan){
            Map<String, String> map = new LinkedHashMap<>();
            map.put("businessId", id);
            map.put("funCode", funCode);
            ViseUtil.Get(context, NetUrl.AppShareListPraiseTimesclickLikes, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    zanNum = zanNum + 1;
                    tvZanNum.setText(zanNum+"");
                    isZan = true;
                    Glide.with(context).load(R.mipmap.zan).into(ivZan);
                }
            });
        }

    }

}
