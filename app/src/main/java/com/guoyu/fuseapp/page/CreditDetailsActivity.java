package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.CreditDetailsAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.CreditBean;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditDetailsActivity extends BaseActivity {

    private Context context = CreditDetailsActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout elEmpty;

    private String id = "";
    private String title = "";

    private CreditDetailsAdapter adapter;
    private List<CreditBean.RowsBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_details);

        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        ButterKnife.bind(CreditDetailsActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title+"详情");
//        String card = "320322199309028678";
        String card = id;
        String url = "/publicity/verbose_data_list.json?category=gsxx_xyfw_wdfw&infoCode=info_ZRRJBXX&conditions=%7B%22idCode%22:%22"+card+"%22%7D";
        ViseHttp.GET(url)
                .baseUrl("http://61.167.245.180:22280/")
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Gson gson = new Gson();
                        CreditBean bean = gson.fromJson(data, CreditBean.class);
                        if(bean.getRows().size()>0){
                            mList = bean.getRows().get(0);
                            for (int i = 0; i<mList.size(); i++){
                                if(!mList.get(i).isListShow()){
                                    mList.remove(i);
                                }
                            }
                            adapter = new CreditDetailsAdapter(mList);
                            LinearLayoutManager manager = new LinearLayoutManager(context);
                            manager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(manager);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
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
