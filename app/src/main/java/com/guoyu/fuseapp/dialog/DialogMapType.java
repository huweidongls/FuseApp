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
 * Created by Administrator on 2019/12/27.
 */

public class DialogMapType extends Dialog {

    private Context context;
    private TextView tvGaode;
    private TextView tvBaidu;
    private ClickListener listener;

    public DialogMapType(@NonNull Context context, ClickListener listener) {
        super(context, R.style.RoundCornerDialog);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_map_type, null);
        setContentView(view);

        tvGaode = view.findViewById(R.id.tv_gaode);
        tvBaidu = view.findViewById(R.id.tv_baidu);

        tvGaode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onGaode();
                dismiss();
            }
        });

        tvBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBaidu();
                dismiss();
            }
        });

    }

    public interface ClickListener{
        void onGaode();
        void onBaidu();
    }

}
