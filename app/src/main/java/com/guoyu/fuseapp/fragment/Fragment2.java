package com.guoyu.fuseapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GoodsDetailsViewpagerAdapter;
import com.guoyu.fuseapp.adapter.WeiguanAdapter;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.bean.WeiguanListBean;
import com.guoyu.fuseapp.customview.ScaleTransitionPagerTitleView;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.CityMicroInsertActivity;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/9/29.
 */

public class Fragment2 extends BaseFragment {

    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.vp)
    ViewPager mViewPager;

    private FragmentManager mFragmentManager;
    private GoodsDetailsViewpagerAdapter mViewPagerFragmentAdapter;
    private List<Fragment> fragmentList;

    private ArrayList<String> mTitleDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);

        ButterKnife.bind(this, view);
        mFragmentManager = getChildFragmentManager();
        initData();

        return view;
    }

    private void initData() {

        fragmentList = new ArrayList<>();
        fragmentList.add(FragmentWeiguan.newInstance("0"));
        fragmentList.add(FragmentWeiguan.newInstance("1"));
        fragmentList.add(FragmentWeiguan.newInstance("2"));
        mViewPagerFragmentAdapter = new GoodsDetailsViewpagerAdapter(mFragmentManager, fragmentList);
        mViewPager.setAdapter(mViewPagerFragmentAdapter);

        mTitleDataList = new ArrayList<>();
        mTitleDataList.add("最新");
        mTitleDataList.add("热门");
        mTitleDataList.add("我的微观");

        CommonNavigator commonNavigator = new CommonNavigator(getContext());
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
                simplePagerTitleView.setPadding(70, 0, 70, 0);
//                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#D62424"));
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
//        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
//        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        titleContainer.setDividerPadding(UIUtil.dip2px(this, 15));
//        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(magicIndicator, mViewPager);

    }

    @OnClick({R.id.btn_add})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_add:
                if(SpUtils.getReal(getContext()).equals("2")){
                    intent.setClass(getContext(), CityMicroInsertActivity.class);
                    startActivity(intent);
                }else if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    ToastUtil.showShort(getContext(), "实名认证用户可发布！");
                }
                break;
        }
    }

}
