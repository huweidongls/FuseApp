package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.SearchViewpagerAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.SearchBean;
import com.guoyu.fuseapp.customview.ScaleTransitionPagerTitleView;
import com.guoyu.fuseapp.fragment.FragmentSearch;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

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

public class SearchActivity extends BaseActivity {

    private Context context = SearchActivity.this;

    @BindView(R.id.et_titles)
    EditText etSearch;
    @BindView(R.id.magic)
    MagicIndicator magicIndicator;
    @BindView(R.id.vp)
    ViewPager mViewPager;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout rl;

    private FragmentManager mFragmentManager;
    private SearchViewpagerAdapter mViewPagerFragmentAdapter;
    private List<Fragment> fragmentList;

    private ArrayList<String> mTitleDataList;

    private InputMethodManager manager;//输入法管理器

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(SearchActivity.this);
        mFragmentManager = getSupportFragmentManager();
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        search();

    }

    private void search() {
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(etSearch.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    String search = etSearch.getText().toString();
                    if(!TextUtils.isEmpty(search)){
                        onSearch(search);
                    }
                }
                //记得返回false
                return false;
            }
        });
    }

    private void onSearch(String search) {

        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("search", search);
        if(!SpUtils.getUserId(context).equals("0")){
            map.put("userId", SpUtils.getUserId(context));
        }
        ll.setVisibility(View.GONE);
        rl.setVisibility(View.GONE);
        if(mTitleDataList == null){
            mTitleDataList = new ArrayList<>();
            fragmentList = new ArrayList<>();
        }else {
            mTitleDataList.clear();
            fragmentList.clear();
        }
        ViseUtil.Get(context, NetUrl.AppSearchqueryList, map, dialog, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                SearchBean bean = gson.fromJson(s, SearchBean.class);
                Log.e("878974844848",s);
                if(bean.getData().size()>0){
                    ll.setVisibility(View.VISIBLE);
                    rl.setVisibility(View.GONE);
                    for (SearchBean.DataBean dataBean : bean.getData()){
                        mTitleDataList.add(dataBean.getTitle());
                        fragmentList.add(FragmentSearch.newInstance(dataBean.getTitle(), dataBean.getContent()));
                    }
                    mViewPagerFragmentAdapter = new SearchViewpagerAdapter(mFragmentManager, fragmentList);
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
                            simplePagerTitleView.setPadding(30, 0, 30, 0);
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
                    //fragmentList.clear();
                    //fragmentList = new ArrayList<>();
                }else {
                    ll.setVisibility(View.GONE);
                    rl.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @OnClick({R.id.rl_back, R.id.iv_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_btn:
                String search = etSearch.getText().toString();
                if(!TextUtils.isEmpty(search)){
                    onSearch(search);
                }
                break;
        }
    }

}
