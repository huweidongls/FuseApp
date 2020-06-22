package com.guoyu.fuseapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;

/**
 * Created by Administrator on 2020/6/22.
 */

public class DialogYuyueTishi extends Dialog {

    private Context context;
    private String title;
    private String content;
    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvClose;

    public DialogYuyueTishi(@NonNull Context context, String title, String content) {
        super(context, R.style.RoundCornerDialog);
        this.context = context;
        this.title = title;
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_yuyue_tishi, null);
        setContentView(view);

        tvTitle = view.findViewById(R.id.tv_title);
        tvContent = view.findViewById(R.id.tv_content);
        tvClose = view.findViewById(R.id.tv_close);

        tvTitle.setText(title);
        tvContent.setText(content);
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

}
