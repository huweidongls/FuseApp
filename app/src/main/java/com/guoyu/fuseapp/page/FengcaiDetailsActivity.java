package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.Fragment3Bean;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FengcaiDetailsActivity extends BaseActivity {

    private Context context = FengcaiDetailsActivity.this;

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_content)
    TextView tvContent;

    private Fragment3Bean.DataBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fengcai_details);

        bean = (Fragment3Bean.DataBean) getIntent().getSerializableExtra("bean");
        ButterKnife.bind(FengcaiDetailsActivity.this);
        initData();

    }

    private void initData() {

        tv.setText(bean.getTitle());
        RichText.from(bean.getContent()).bind(this)
                .showBorder(false)
                .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                .into(tvContent);

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
