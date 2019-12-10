package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GoodsDetailsViewpagerAdapter;
import com.guoyu.fuseapp.bean.ComplaintConsultationBean;
import com.guoyu.fuseapp.bean.SearchBean;
import com.guoyu.fuseapp.customview.ScaleTransitionPagerTitleView;
import com.guoyu.fuseapp.fragment.Fragment1;
import com.guoyu.fuseapp.fragment.Fragment2;
import com.guoyu.fuseapp.fragment.Fragment3;
import com.guoyu.fuseapp.fragment.FragmentComplaint;
import com.guoyu.fuseapp.fragment.FragmentConsultationType;
import com.guoyu.fuseapp.fragment.FragmentOther;
import com.guoyu.fuseapp.fragment.FragmentSearch;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplaintConsultationActivity extends AppCompatActivity {

    private Context context = ComplaintConsultationActivity.this;

    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.vp)
    ViewPager mViewPager;
    @BindView(R.id.rl_magic)
    RelativeLayout rl_magic;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;

    private FragmentManager mFragmentManager;
    private GoodsDetailsViewpagerAdapter mViewPagerFragmentAdapter;
    private List<Fragment> fragmentList;

    private ArrayList<String> mTitleDataList;

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_consultation);
        ButterKnife.bind(ComplaintConsultationActivity.this);
        mFragmentManager = getSupportFragmentManager();
        initData();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
       /* fragmentList.add(new FragmentConsultationType());
        fragmentList.add(new FragmentComplaint());
        fragmentList.add(new FragmentOther());*/
        mTitleDataList = new ArrayList<>();
        ViseUtil.Get(context, NetUrl.AppConsultationInfofindType, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                ComplaintConsultationBean bean = gson.fromJson(s, ComplaintConsultationBean.class);
                if (bean.getData().size() > 0) {
                    empty_order_bloacks.setVisibility(View.GONE);
                    rl_magic.setVisibility(View.VISIBLE);
                    mViewPager.setVisibility(View.VISIBLE);
                    for (ComplaintConsultationBean.DataBean Bean : bean.getData()) {
                        mTitleDataList.add(Bean.getSubName());
                        fragmentList.add(FragmentConsultationType.newInstance(Bean.getId() + ""));
                    }
                    mViewPagerFragmentAdapter = new GoodsDetailsViewpagerAdapter(mFragmentManager, fragmentList);
                    mViewPager.setAdapter(mViewPagerFragmentAdapter);
                    CommonNavigator commonNavigator = new CommonNavigator(context);
                    commonNavigator.setAdapter(new CommonNavigatorAdapter() {
                        @Override
                        public int getCount() {
                            return mTitleDataList == null ? 0 : mTitleDataList.size();
                        }

                        @Override
                        public IPagerTitleView getTitleView(Context context, final int index) {
                            SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                            simplePagerTitleView.setText(mTitleDataList.get(index));
                            //设置字体
                            simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
//                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                            simplePagerTitleView.setNormalColor(Color.parseColor("#D62424"));
                            simplePagerTitleView.setSelectedColor(Color.parseColor("#D62424"));
                            simplePagerTitleView.setPadding(20, 0, 20, 0);
                            simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mViewPager.setCurrentItem(index);
                                }
                            });
                            return simplePagerTitleView;
                        }

                        @Override
                        public IPagerIndicator getIndicator(Context context) {
                            LinePagerIndicator indicator = new LinePagerIndicator(context);
                            indicator.setColors(Color.parseColor("#D62424"));
                            return indicator;
                        }
                    });
                    magicIndicator.setNavigator(commonNavigator);
                    ViewPagerHelper.bind(magicIndicator, mViewPager);
                    mViewPager.setCurrentItem(index);
                } else {
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    rl_magic.setVisibility(View.GONE);
                    mViewPager.setVisibility(View.GONE);
                }
            }
        });

    }

    @OnClick({R.id.iv_black, R.id.tv_add})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_black:
                finish();
                break;
            case R.id.tv_add:
                if (SpUtils.getReal(context).equals("2")) {
                    intent.setClass(context, ComplaintInsertActivity.class);
                    context.startActivity(intent);
                } else {
                    ToastUtil.showShort(context, "实名用户才能发布");
                }
                break;
        }
    }
}
