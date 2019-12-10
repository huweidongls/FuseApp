package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.FindNumBean;
import com.guoyu.fuseapp.bean.StylisticServiceContentBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StylisticServiceContentActivity extends BaseActivity {

    private Context context = StylisticServiceContentActivity.this;

    private String id = "";
    @BindView(R.id.iv_img)
    ImageView iv_img;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.tv_liulan_num)
    TextView tvLiulanNum;
    @BindView(R.id.tv_zan_num)
    TextView tvZanNum;
    @BindView(R.id.iv_zan)
    ImageView ivZan;

    private String title = "";
    private String funCode = "";
    private int zanNum = 0;
    private boolean isZan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylistic_service_content);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("id");
        ButterKnife.bind(StylisticServiceContentActivity.this);
        initData();

    }

    private void initData() {

        tvTopTitle.setText(title + "详情");
        if (id.isEmpty()) {
            ToastUtil.showShort(StylisticServiceContentActivity.this, "该ID不存在!");
            finish();
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("id", id);
            ViseUtil.Get(StylisticServiceContentActivity.this, NetUrl.AppStyleInfogetOne, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    Gson gson = new Gson();
                    StylisticServiceContentBean bean = gson.fromJson(s, StylisticServiceContentBean.class);
                    Glide.with(StylisticServiceContentActivity.this).load(NetUrl.BASE_URL + bean.getData().getTopPic()).into(iv_img);
                    tv_title.setText(bean.getData().getTitle());
                    tv_address.setText("活动地点：" + bean.getData().getActivityPlace());
                    tv_time.setText("时间：" + bean.getData().getActivityTime());
                    RichText.from(bean.getData().getContent()).bind(this)
                            .showBorder(false)
                            .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                            .into(tv_content);
                }
            });
        }

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

    @OnClick({R.id.rl_back, R.id.ll_zan})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
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
