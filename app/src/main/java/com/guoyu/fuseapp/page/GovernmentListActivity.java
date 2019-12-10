package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GovernmentListAdapter;
import com.guoyu.fuseapp.adapter.GovernmentTypeAdapter;
import com.guoyu.fuseapp.bean.GovernmentListBean;
import com.guoyu.fuseapp.bean.GovernmentServiceTypeBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GovernmentListActivity extends AppCompatActivity {

    private Context context = GovernmentListActivity.this;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;
    @BindView(R.id.refreshs)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.et_titles)
    EditText et_titles;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler_viewtype)
    RecyclerView recycler_viewtype;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.rl_type)
    RelativeLayout rl_type;

    private RecyclerView recyclerViews;
    private String title1 = "";
    private int radio = 0;
    private GovernmentListAdapter adapter;
    private GovernmentTypeAdapter adapter2;
    private List<GovernmentListBean.DataBean> mList;
    private PopupWindow popupWindow;
    private List<GovernmentServiceTypeBean.DataBean> mList2;
    private int page = 1;

    private int typeId = 0;
    private String funCode = "";

    private InputMethodManager manager;//输入法管理器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_list);

        funCode = getIntent().getStringExtra("funcode");
        title1 = getIntent().getStringExtra("title");
        ButterKnife.bind(GovernmentListActivity.this);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        search();
        initData();
        init_type();
        initRefreshs();
    }

    private void search() {
        et_titles.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(et_titles.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    shwo_serceh();
                }
                //记得返回false
                return false;
            }
        });
    }

    //下拉加载，上拉刷新
    private void initRefreshs() {
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(GovernmentListActivity.this
        ));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(GovernmentListActivity.this));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                if (typeId != 0) {
                    map.put("typeId", typeId + "");
                }
                ViseUtil.Get(GovernmentListActivity.this, NetUrl.AppGovernmentInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        GovernmentListBean bean = gson.fromJson(s, GovernmentListBean.class);
                        mList.clear();
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = 2;
                        refreshLayout.finishRefresh(500);
                    }
                });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", page + "");
                map.put("pageSize", "10");
                if (typeId != 0) {
                    map.put("typeId", typeId + "");
                }
                ViseUtil.Get(GovernmentListActivity.this, NetUrl.AppGovernmentInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        GovernmentListBean bean = gson.fromJson(s, GovernmentListBean.class);
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = page + 1;
                        refreshLayout.finishLoadMore(500);
                    }
                });
            }
        });
    }

    //初始化
    private void initData() {
        tvTitle.setText(title1);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        ViseUtil.Get(GovernmentListActivity.this, NetUrl.AppGovernmentInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                GovernmentListBean bean = gson.fromJson(s, GovernmentListBean.class);
                mList = bean.getData();
                if (mList.size() > 0) {
                    adapter = new GovernmentListAdapter(mList, title1, funCode);
                    LinearLayoutManager manager = new LinearLayoutManager(GovernmentListActivity.this) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    manager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    page = 2;
                    empty_order_bloacks.setVisibility(View.GONE);
                    smartRefreshLayout.setVisibility(View.VISIBLE);
                } else {
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    smartRefreshLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.iv_black, R.id.iv_type, R.id.iv_btn})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_black:
                finish();
                break;
            case R.id.iv_type:
                if (radio == 0) {
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.VISIBLE);
                    rl_type.setVisibility(View.VISIBLE);
                    radio = 1;
                } else {
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    rl_type.setVisibility(View.GONE);
                    radio = 0;
                }
                break;
            case R.id.iv_btn:
                shwo_serceh();
                break;
        }
    }

    //关键字搜索
    private void shwo_serceh() {
        String title = et_titles.getText().toString();//标题
//        if (TextUtils.isEmpty(title)) {
//            ToastUtil.showShort(GovernmentListActivity.this, "请填写要搜索的内容!");
//        } else {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        map.put("title", title);
        ViseUtil.Get(GovernmentListActivity.this, NetUrl.AppGovernmentInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                GovernmentListBean bean = gson.fromJson(s, GovernmentListBean.class);
                mList.clear();
                mList = bean.getData();
                Log.e("000000", mList.size() + "");
                if (mList.size() > 0) {
                    adapter = new GovernmentListAdapter(mList, title1, funCode);
                    LinearLayoutManager manager = new LinearLayoutManager(GovernmentListActivity.this) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    manager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    empty_order_bloacks.setVisibility(View.GONE);
                    smartRefreshLayout.setVisibility(View.VISIBLE);
                } else {
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    smartRefreshLayout.setVisibility(View.GONE);
                }
            }
        });
//        }

    }

    //根据类别筛选
    private void init_type() {
        ViseUtil.Get(context, NetUrl.AppGovernmentInfofindType, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                GovernmentServiceTypeBean bean = gson.fromJson(s, GovernmentServiceTypeBean.class);
                mList2 = bean.getData();
                mList2.add(0, new GovernmentServiceTypeBean.DataBean(0, "全部"));
                adapter2 = new GovernmentTypeAdapter(mList2, new GovernmentTypeAdapter.ClickListener() {
                    @Override
                    public void onClickType(int pos) {
                        if (pos == 0) {
                            initData();
                            view1.setVisibility(View.GONE);
                            view2.setVisibility(View.GONE);
                            rl_type.setVisibility(View.GONE);
                            radio = 0;
                        } else {
                            typeId = mList2.get(pos).getId();
                            Map<String, String> map = new LinkedHashMap<>();
                            map.put("pageNum", "1");
                            map.put("pageSize", "10");
                            map.put("typeId", mList2.get(pos).getId() + "");
                            ViseUtil.Get(GovernmentListActivity.this, NetUrl.AppGovernmentInfoqueryList, map, new ViseUtil.ViseListener() {
                                @Override
                                public void onReturn(String s) {
                                    Gson gson = new Gson();
                                    GovernmentListBean bean = gson.fromJson(s, GovernmentListBean.class);
                                    mList = bean.getData();
                                    if (mList.size() > 0) {
                                        adapter = new GovernmentListAdapter(mList, title1, funCode);
                                        LinearLayoutManager manager = new LinearLayoutManager(GovernmentListActivity.this) {
                                            @Override
                                            public boolean canScrollVertically() {
                                                return false;
                                            }
                                        };
                                        manager.setOrientation(LinearLayoutManager.VERTICAL);
                                        recyclerView.setLayoutManager(manager);
                                        recyclerView.setAdapter(adapter);
                                        page = 2;
                                        empty_order_bloacks.setVisibility(View.GONE);
                                        smartRefreshLayout.setVisibility(View.VISIBLE);
                                    } else {
                                        empty_order_bloacks.setVisibility(View.VISIBLE);
                                        smartRefreshLayout.setVisibility(View.GONE);
                                    }
                                    view1.setVisibility(View.GONE);
                                    view2.setVisibility(View.GONE);
                                    rl_type.setVisibility(View.GONE);
                                    radio = 0;
                                }
                            });
                        }

                    }
                });
                GridLayoutManager managers = new GridLayoutManager(context, 4);
                recycler_viewtype.setLayoutManager(managers);
                recycler_viewtype.setAdapter(adapter2);
            }
        });
       /* mList2 = new ArrayList<>();
        mList2.add("");
        mList2.add("");
        mList2.add("");
        adapter2 = new GovernmentTypeAdapter(mList2);
        LinearLayoutManager manager = new LinearLayoutManager(GovernmentListActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViews.setLayoutManager(manager);
        recyclerViews.setAdapter(adapter2);*/
    }
}
