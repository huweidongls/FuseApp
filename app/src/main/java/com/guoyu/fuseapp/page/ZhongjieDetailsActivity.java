package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.FindNumBean;
import com.guoyu.fuseapp.bean.NoticegetOneBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.youth.banner.Banner;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhongjieDetailsActivity extends BaseActivity {

    private Context context = ZhongjieDetailsActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_liulan_num)
    TextView tvLiulanNum;
    @BindView(R.id.tv_zan_num)
    TextView tvZanNum;
    @BindView(R.id.ll_pic)
    LinearLayout llPic;
    @BindView(R.id.iv_zan)
    ImageView ivZan;
    @BindView(R.id.banner)
    Banner banner;

    private String id = "";
    private String title = "";
    private String funCode = "";
    private int zanNum = 0;
    private ImageView imageView;
    private boolean isZan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhongjie_details);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("id");
        ButterKnife.bind(ZhongjieDetailsActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title+"详情");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", id);
        ViseUtil.Get(context, NetUrl.AppAgentServicegetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Logger.e("123123", s);
                Gson gson = new Gson();
                NoticegetOneBean bean = gson.fromJson(s, NoticegetOneBean.class);

                String img = bean.getData().getImgUrl();
                if(!StringUtils.isEmpty(img)){
                    String[] ss = img.split(",");
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i<ss.length; i++){
                        list.add(NetUrl.BASE_URL+ss[i]);
                    }
                    initBanner(banner, list);
                }

                RichText.from(bean.getData().getContent()).bind(this)
                        .showBorder(false)
                        .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                        .into(tvContent);
                if(bean.getData().getContentPic() != null){
                    String[] pics = bean.getData().getContentPic().split(",");
                    if(pics.length>0){
                        for (int i = 0; i<pics.length; i++){
                            imageView = new ImageView(context);
                            Glide.with(context).load(NetUrl.BASE_URL+pics[i]).into(imageView);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setAdjustViewBounds(true);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.topMargin = 8;
                            llPic.addView(imageView, layoutParams);
                        }
                    }
                }else {
                    llPic.setVisibility(View.GONE);
                }
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

    @OnClick({R.id.rl_back, R.id.ll_zan})
    public void onClick(View view){
        switch (view.getId()){
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
