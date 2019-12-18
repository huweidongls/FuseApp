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
 * Created by Administrator on 2019/12/18.
 */

public class DialogWxType extends Dialog {

    private Context context;
    private ClickListener listener;

    private TextView tv1;
    private TextView tv2;

    public DialogWxType(@NonNull Context context, ClickListener listener) {
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

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_wx_type, null);
        setContentView(view);

        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRegister();
                dismiss();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLogin();
                dismiss();
            }
        });

    }

    public interface ClickListener{
        void onRegister();
        void onLogin();
    }

}
