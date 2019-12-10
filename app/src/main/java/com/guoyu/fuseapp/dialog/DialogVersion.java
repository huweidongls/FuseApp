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
 * Created by Administrator on 2019/10/24.
 */

public class DialogVersion extends Dialog {

    private Context context;

    private TextView tvVersionName;
    private TextView tvDesc;
    private TextView tvSure;
    private TextView tvCancel;
    private ClickListener listener;

    private String versionName;
    private String desc;

    public DialogVersion(@NonNull Context context, String versionName, String desc, ClickListener listener) {
        super(context, R.style.RoundCornerDialog);
        this.context = context;
        this.versionName = versionName;
        this.desc = desc;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

    }

    private void init() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_version, null);
        setContentView(view);

        tvVersionName = view.findViewById(R.id.tv_version_name);
        tvDesc = view.findViewById(R.id.tv_desc);
        tvSure = view.findViewById(R.id.tv_sure);
        tvCancel = view.findViewById(R.id.tv_cancel);

        tvVersionName.setText("最新版本："+versionName);
        tvDesc.setText("版本描述："+desc);

        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onSure();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onCancel();
            }
        });

    }

    public interface ClickListener{
        void onSure();
        void onCancel();
    }

}
