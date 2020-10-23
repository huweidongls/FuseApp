package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.YuyueHorTimeAdapter;
import com.guoyu.fuseapp.adapter.YuyueTimeAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppAppointmentgetOneByTimeBean;
import com.guoyu.fuseapp.dialog.DialogYuyueTishi;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuyueTimeActivity extends BaseActivity {

    private Context context = YuyueTimeActivity.this;

    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.tv_week1)
    TextView tvWeek1;
    @BindView(R.id.tv_day1)
    TextView tvDay1;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.tv_week2)
    TextView tvWeek2;
    @BindView(R.id.tv_day2)
    TextView tvDay2;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.tv_week3)
    TextView tvWeek3;
    @BindView(R.id.tv_day3)
    TextView tvDay3;
    @BindView(R.id.rl4)
    RelativeLayout rl4;
    @BindView(R.id.tv_week4)
    TextView tvWeek4;
    @BindView(R.id.tv_day4)
    TextView tvDay4;
    @BindView(R.id.rl5)
    RelativeLayout rl5;
    @BindView(R.id.tv_week5)
    TextView tvWeek5;
    @BindView(R.id.tv_day5)
    TextView tvDay5;
    @BindView(R.id.tv_select_time)
    TextView tvSelectTime;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.hor_rv)
    RecyclerView HorRv;

    private Calendar c;

    private String id = "";

    private YuyueTimeAdapter adapter;
    private List<AppAppointmentgetOneByTimeBean.DataBean.ListBean> mList;

    private Dialog dialog;

    private boolean isFirst = true;

    private YuyueHorTimeAdapter horTimeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_time);

        id = getIntent().getStringExtra("id");
        c = Calendar.getInstance();
        ButterKnife.bind(YuyueTimeActivity.this);
        initData();

    }

    @Override
    protected void onStart() {
        super.onStart();
        onSelect(rl1);
        String time = StringUtils.getOldDate(1);
        int week = StringUtils.getOldWeek(1);
        tvSelectTime.setText(time+"("+getWeek(week)+")");
        setData(time);
    }

    private void initData() {

        horTimeAdapter = new YuyueHorTimeAdapter(new YuyueHorTimeAdapter.ClickListener() {
            @Override
            public void onItemClick(int pos) {
                String time = StringUtils.getOldDate(pos+1);
                int week = StringUtils.getOldWeek(pos+1);
                if(week == 1||week == 7){

                }else {
                    tvSelectTime.setText(time+"("+getWeek(week)+")");
//                    onSelect(rl1);
                    setData(time);
                }
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        HorRv.setLayoutManager(manager);
        HorRv.setAdapter(horTimeAdapter);

//        String time = StringUtils.getOldDate(1);
//        tvSelectTime.setText(time+"("+getWeek(week1)+")");
//        setData(time);

        int day1 = StringUtils.getOldDay(1);
        int week1 = StringUtils.getOldWeek(1);
//        if(week1 == 1||week1 == 7){
//            rl1.setBackgroundResource(R.color.line);
//        }
        tvWeek1.setText(getWeek(week1));
        tvDay1.setText(formatTimeUnit(day1));
        int day2 = StringUtils.getOldDay(2);
        int week2 = StringUtils.getOldWeek(2);
//        if(week2 == 1||week2 == 7){
//            rl2.setBackgroundResource(R.color.line);
//        }
        tvWeek2.setText(getWeek(week2));
        tvDay2.setText(formatTimeUnit(day2));
        int day3 = StringUtils.getOldDay(3);
        int week3 = StringUtils.getOldWeek(3);
//        if(week3 == 1||week3 == 7){
//            rl3.setBackgroundResource(R.color.line);
//        }
        tvWeek3.setText(getWeek(week3));
        tvDay3.setText(formatTimeUnit(day3));
        int day4 = StringUtils.getOldDay(4);
        int week4 = StringUtils.getOldWeek(4);
//        if(week4 == 1||week4 == 7){
//            rl4.setBackgroundResource(R.color.line);
//        }
        tvWeek4.setText(getWeek(week4));
        tvDay4.setText(formatTimeUnit(day4));
        int day5 = StringUtils.getOldDay(5);
        int week5 = StringUtils.getOldWeek(5);
//        if(week5 == 1||week5 == 7){
//            rl5.setBackgroundResource(R.color.line);
//        }
        tvWeek5.setText(getWeek(week5));
        tvDay5.setText(formatTimeUnit(day5));

    }

    private void setData(String time){
        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("nyrTime", time);
        map.put("id", id);
        ViseUtil.Get(context, NetUrl.AppAppointmentgetOneByTime, map, dialog, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppAppointmentgetOneByTimeBean bean = gson.fromJson(s, AppAppointmentgetOneByTimeBean.class);

                if(isFirst){
                    isFirst = false;
                    DialogYuyueTishi dialogYuyueTishi = new DialogYuyueTishi(context, bean.getData().getAppointmentHall().getAreaTitle(),
                            bean.getData().getAppointmentHall().getAreaContent());
                    dialogYuyueTishi.show();
                }

                mList = bean.getData().getList();
                adapter = new YuyueTimeAdapter(mList, bean.getData().getAppointmentHall().getOverContent());
                LinearLayoutManager manager = new LinearLayoutManager(context){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }
        });
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("yearMonth", time);
//        map.put("detailsId", id);
//        ViseUtil.Get(context, NetUrl.AppBookingBusinessqueryListManage, map, dialog, new ViseUtil.ViseListener() {
//            @Override
//            public void onReturn(String s) {
//                Gson gson = new Gson();
//                AppBookingBusinessqueryListManageBean bean = gson.fromJson(s, AppBookingBusinessqueryListManageBean.class);
//                mList = bean.getData();
//                adapter = new YuyueTimeAdapter(mList);
//                LinearLayoutManager manager = new LinearLayoutManager(context){
//                    @Override
//                    public boolean canScrollVertically() {
//                        return false;
//                    }
//                };
//                manager.setOrientation(LinearLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(manager);
//                recyclerView.setAdapter(adapter);
//            }
//        });
    }

    private String getWeek(int week){
        String w = "";
        switch (week){
            case 1:
                w = "周日";
                break;
            case 2:
                w = "周一";
                break;
            case 3:
                w = "周二";
                break;
            case 4:
                w = "周三";
                break;
            case 5:
                w = "周四";
                break;
            case 6:
                w = "周五";
                break;
            case 7:
                w = "周六";
                break;
        }
        return w;
    }

    /**
     * 将“0-9”转换为“00-09”
     */
    private String formatTimeUnit(int unit) {
        return unit < 10 ? "0" + String.valueOf(unit) : String.valueOf(unit);
    }

    @OnClick({R.id.rl_back, R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl4, R.id.rl5})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl1:
                String time = StringUtils.getOldDate(1);
                int week = StringUtils.getOldWeek(1);
                if(week == 1||week == 7){

                }else {
                    tvSelectTime.setText(time+"("+getWeek(week)+")");
                    onSelect(rl1);
                    setData(time);
                }
                break;
            case R.id.rl2:
                String time1 = StringUtils.getOldDate(2);
                int week1 = StringUtils.getOldWeek(2);
                if(week1 == 1||week1 == 7){

                }else {
                    tvSelectTime.setText(time1+"("+getWeek(week1)+")");
                    onSelect(rl2);
                    setData(time1);
                }
                break;
            case R.id.rl3:
                String time2 = StringUtils.getOldDate(3);
                int week2 = StringUtils.getOldWeek(3);
                if(week2 == 1||week2 == 7){

                }else {
                    tvSelectTime.setText(time2+"("+getWeek(week2)+")");
                    onSelect(rl3);
                    setData(time2);
                }
                break;
            case R.id.rl4:
                String time3 = StringUtils.getOldDate(4);
                int week3 = StringUtils.getOldWeek(4);
                if(week3 == 1||week3 == 7){

                }else {
                    tvSelectTime.setText(time3+"("+getWeek(week3)+")");
                    onSelect(rl4);
                    setData(time3);
                }
                break;
            case R.id.rl5:
                String time4 = StringUtils.getOldDate(5);
                int week4 = StringUtils.getOldWeek(5);
                if(week4 == 1||week4 == 7){

                }else {
                    tvSelectTime.setText(time4+"("+getWeek(week4)+")");
                    onSelect(rl5);
                    setData(time4);
                }
                break;
        }
    }

    private void onSelect(View view){
        int week1 = StringUtils.getOldWeek(1);
        int week2 = StringUtils.getOldWeek(2);
        int week3 = StringUtils.getOldWeek(3);
        int week4 = StringUtils.getOldWeek(4);
        int week5 = StringUtils.getOldWeek(5);
        if(week1 == 1||week1 == 7){
            rl1.setBackgroundResource(R.color.line);
        }else {
            rl1.setBackgroundResource(R.color.white_ffffff);
        }
        if(week2 == 1||week2 == 7){
            rl2.setBackgroundResource(R.color.line);
        }else {
            rl2.setBackgroundResource(R.color.white_ffffff);
        }
        if(week3 == 1||week3 == 7){
            rl3.setBackgroundResource(R.color.line);
        }else {
            rl3.setBackgroundResource(R.color.white_ffffff);
        }
        if(week4 == 1||week4 == 7){
            rl4.setBackgroundResource(R.color.line);
        }else {
            rl4.setBackgroundResource(R.color.white_ffffff);
        }
        if(week5 == 1||week5 == 7){
            rl5.setBackgroundResource(R.color.line);
        }else {
            rl5.setBackgroundResource(R.color.white_ffffff);
        }
        tvWeek1.setTextColor(Color.parseColor("#5F5F5F"));
        tvWeek2.setTextColor(Color.parseColor("#5F5F5F"));
        tvWeek3.setTextColor(Color.parseColor("#5F5F5F"));
        tvWeek4.setTextColor(Color.parseColor("#5F5F5F"));
        tvWeek5.setTextColor(Color.parseColor("#5F5F5F"));
        tvDay1.setTextColor(Color.parseColor("#5F5F5F"));
        tvDay2.setTextColor(Color.parseColor("#5F5F5F"));
        tvDay3.setTextColor(Color.parseColor("#5F5F5F"));
        tvDay4.setTextColor(Color.parseColor("#5F5F5F"));
        tvDay5.setTextColor(Color.parseColor("#5F5F5F"));
        switch (view.getId()){
            case R.id.rl1:
                rl1.setBackgroundResource(R.color.theme);
                tvWeek1.setTextColor(Color.parseColor("#FFFFFF"));
                tvDay1.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rl2:
                rl2.setBackgroundResource(R.color.theme);
                tvWeek2.setTextColor(Color.parseColor("#FFFFFF"));
                tvDay2.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rl3:
                rl3.setBackgroundResource(R.color.theme);
                tvWeek3.setTextColor(Color.parseColor("#FFFFFF"));
                tvDay3.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rl4:
                rl4.setBackgroundResource(R.color.theme);
                tvWeek4.setTextColor(Color.parseColor("#FFFFFF"));
                tvDay4.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rl5:
                rl5.setBackgroundResource(R.color.theme);
                tvWeek5.setTextColor(Color.parseColor("#FFFFFF"));
                tvDay5.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }

}
