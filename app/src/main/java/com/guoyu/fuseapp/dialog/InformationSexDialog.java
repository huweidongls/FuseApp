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
 * Created by Administrator on 2019/2/27.
 */

public class InformationSexDialog extends Dialog {

    private Context context;

    private TextView tvNan;
    private TextView tvNv;

    private ClickListener listener;

    public InformationSexDialog(@NonNull Context context, ClickListener listener) {
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

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_information_sex, null);
        setContentView(view);

        tvNan = view.findViewById(R.id.tv_nan);
        tvNv = view.findViewById(R.id.tv_nv);

        tvNan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNan();
                dismiss();
            }
        });
        tvNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNv();
                dismiss();
            }
        });

    }

    public interface ClickListener{
        void onNan();
        void onNv();
    }

}
