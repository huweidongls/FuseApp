package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.util.StringUtils;

import java.util.Calendar;

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

    private Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_time);

        c = Calendar.getInstance();
        ButterKnife.bind(YuyueTimeActivity.this);
        initData();

    }

    private void initData() {

        int day1 = c.get(Calendar.DAY_OF_MONTH);
        int week1 = c.get(Calendar.DAY_OF_WEEK);
        String time = StringUtils.getOldDate(0);
        tvSelectTime.setText(time+"("+getWeek(week1)+")");

        tvWeek1.setText(getWeek(week1));
        tvDay1.setText(formatTimeUnit(day1));
        int day2 = StringUtils.getOldDay(1);
        int week2 = StringUtils.getOldWeek(1);
        tvWeek2.setText(getWeek(week2));
        tvDay2.setText(formatTimeUnit(day2));
        int day3 = StringUtils.getOldDay(2);
        int week3 = StringUtils.getOldWeek(2);
        tvWeek3.setText(getWeek(week3));
        tvDay3.setText(formatTimeUnit(day3));
        int day4 = StringUtils.getOldDay(3);
        int week4 = StringUtils.getOldWeek(3);
        tvWeek4.setText(getWeek(week4));
        tvDay4.setText(formatTimeUnit(day4));
        int day5 = StringUtils.getOldDay(4);
        int week5 = StringUtils.getOldWeek(4);
        tvWeek5.setText(getWeek(week5));
        tvDay5.setText(formatTimeUnit(day5));

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

    @OnClick({R.id.rl_back, R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl4, R.id.rl5, R.id.tv_yuyue1})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl1:
                onSelect(rl1);
                break;
            case R.id.rl2:
                onSelect(rl2);
                break;
            case R.id.rl3:
                onSelect(rl3);
                break;
            case R.id.rl4:
                onSelect(rl4);
                break;
            case R.id.rl5:
                onSelect(rl5);
                break;
            case R.id.tv_yuyue1:
                intent.setClass(context, YuyueSureActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void onSelect(View view){
        rl1.setBackgroundResource(R.color.white_ffffff);
        rl2.setBackgroundResource(R.color.white_ffffff);
        rl3.setBackgroundResource(R.color.white_ffffff);
        rl4.setBackgroundResource(R.color.white_ffffff);
        rl5.setBackgroundResource(R.color.white_ffffff);
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
