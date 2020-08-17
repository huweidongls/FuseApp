package com.guoyu.fuseapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2020/8/17.
 */

public class FragmentChengguanList extends BaseFragment {

    private String id = "";

    public static FragmentChengguanList newInstance(String id) {
        FragmentChengguanList newFragment = new FragmentChengguanList();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chengguan_list, null);

        ButterKnife.bind(this, view);
        Bundle args = getArguments();
        if (args != null) {
            id = args.getString("id");
        }
        initData();

        return view;
    }

    private void initData() {

        if(id.equals("0")){

            ViseHttp.GET("szcg/wxmp/wxmp/public/getAll.ht")
                    .baseUrl(NetUrl.CG_URL)
                    .request(new ACallback<String>() {
                        @Override
                        public void onSuccess(String data) {
                            Logger.e("chengguan", data);
                        }

                        @Override
                        public void onFail(int errCode, String errMsg) {
                            Logger.e("chengguan", errMsg);
                        }
                    });

        }else {

        }

    }

}
