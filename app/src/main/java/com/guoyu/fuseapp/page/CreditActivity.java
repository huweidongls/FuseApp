package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditActivity extends BaseActivity {

    private Context context = CreditActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_idcard)
    EditText etIdCard;

    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        title = getIntent().getStringExtra("title");
        ButterKnife.bind(CreditActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);

    }

    @OnClick({R.id.rl_back, R.id.btn_commit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_commit:
                String idCard = etIdCard.getText().toString();
                if(StringUtils.isEmpty(idCard)){
                    ToastUtil.showShort(context, "企业名称不能为空");
                }else {
                    Intent intent = new Intent();
                    intent.setClass(context, CreditListActivity.class);
                    intent.putExtra("id", idCard);
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
                break;
        }
    }

}
