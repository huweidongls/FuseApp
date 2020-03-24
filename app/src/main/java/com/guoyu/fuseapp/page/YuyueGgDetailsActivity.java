package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppointmentNoticeAppgetOneBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuyueGgDetailsActivity extends BaseActivity {

    private Context context = YuyueGgDetailsActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv)
    TextView tv;

    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_gg_details);

        id = getIntent().getStringExtra("id");
        ButterKnife.bind(YuyueGgDetailsActivity.this);
        initData();

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", id);
        ViseUtil.Get(context, NetUrl.AppointmentNoticeAppgetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppointmentNoticeAppgetOneBean bean = gson.fromJson(s, AppointmentNoticeAppgetOneBean.class);
                tvTitle.setText(bean.getData().getTitle());
                tvTime.setText(bean.getData().getCreateDate());
                RichText.from(bean.getData().getContent()).bind(this)
                        .showBorder(false)
                        .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                        .into(tv);
            }
        });

    }

    @OnClick({R.id.rl_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
