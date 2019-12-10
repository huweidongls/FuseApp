package com.guoyu.fuseapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.guoyu.fuseapp.R;

/**
 * Created by Administrator on 2019/4/8.
 */

public class ProgressDialog extends Dialog {

    private Context context;
    private ProgressBar progressBar;
    private TextView tv1;
    private TextView tv2;

    public ProgressDialog(@NonNull Context context) {
        super(context, R.style.RoundCornerDialog);
        this.context = context;
        initView();
    }

    public void setInfo(String s1, String s2){
        tv1.setText(s1);
        tv2.setText(s2);
        s2 = s2.substring(0, s2.length()-1);
        double percent = Double.valueOf(s2);
        progressBar.setProgress((int) percent);
    }

    private void initView() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
        setContentView(view);

        progressBar = view.findViewById(R.id.progress);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);

    }

}
