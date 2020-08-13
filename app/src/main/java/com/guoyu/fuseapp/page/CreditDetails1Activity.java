package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.CreditList1Bean;
import com.guoyu.fuseapp.util.Logger;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditDetails1Activity extends BaseActivity {

    private Context context = CreditDetails1Activity.this;

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.tv11)
    TextView tv11;
    @BindView(R.id.tv12)
    TextView tv12;
    @BindView(R.id.tv13)
    TextView tv13;
    @BindView(R.id.tv14)
    TextView tv14;
    @BindView(R.id.tv15)
    TextView tv15;
    @BindView(R.id.tv16)
    TextView tv16;
    @BindView(R.id.tv17)
    TextView tv17;
    @BindView(R.id.tv18)
    TextView tv18;
    @BindView(R.id.tv19)
    TextView tv19;
    @BindView(R.id.tv20)
    TextView tv20;
    @BindView(R.id.tv21)
    TextView tv21;
    @BindView(R.id.tv22)
    TextView tv22;
    @BindView(R.id.tv23)
    TextView tv23;
    @BindView(R.id.tv24)
    TextView tv24;
    @BindView(R.id.tv25)
    TextView tv25;
    @BindView(R.id.tv26)
    TextView tv26;
//    @BindView(R.id.tv27)
//    TextView tv27;
//    @BindView(R.id.tv28)
//    TextView tv28;
//    @BindView(R.id.tv29)
//    TextView tv29;

    private CreditList1Bean.RowsBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_details1);

        bean = (CreditList1Bean.RowsBean) getIntent().getSerializableExtra("bean");
        ButterKnife.bind(CreditDetails1Activity.this);
        initData();

    }

    private void initData() {

        tv1.setText(bean.getXK_XDR_MC());
        tv2.setText(bean.getXK_XDR_LB());
        tv3.setText(bean.getXK_XDR_SHXYM());
        tv4.setText(bean.getXK_XDR_GSZC());
        tv5.setText(bean.getXK_XDR_ZZJG());
        tv6.setText(bean.getXK_XDR_SWDJ());
        tv7.setText(bean.getXK_XDR_SYDW());
        tv8.setText(bean.getXK_XDR_SHZZ());
        tv9.setText(bean.getXK_FRDB());
        tv10.setText(bean.getXK_FR_ZJLX());
        tv11.setText(bean.getXK_XDR_ZJLX());
        tv12.setText(bean.getXK_XKWS());
        tv13.setText(bean.getXK_WSH());
        tv14.setText(bean.getXK_XKLB());
        tv15.setText(bean.getXK_XKZS());
        tv16.setText(bean.getXK_XKBH());
        tv17.setText(bean.getXK_NR());
        tv18.setText(bean.getXK_JDRQ());
        tv19.setText(bean.getXK_YXQZ());
        tv20.setText(bean.getXK_YXQZI());
        tv21.setText(bean.getXK_XKJG());
        tv22.setText(bean.getXK_XKJGDM());
        tv23.setText(bean.getXK_ZT());
        tv24.setText(bean.getXK_LYDW());
        tv25.setText(bean.getXK_LYDWDM());
        tv26.setText(bean.getBZ());
//        tv27.setText(bean.getCREATE_DATE());
//        tv28.setText(bean.getPERSON_ID());
//        tv29.setText(bean.getCHECK_FLAG());

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
