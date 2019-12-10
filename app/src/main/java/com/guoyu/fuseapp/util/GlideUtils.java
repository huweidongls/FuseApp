package com.guoyu.fuseapp.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.guoyu.fuseapp.R;

/**
 * Created by Administrator on 2019/10/24.
 */

public class GlideUtils {

    private static RequestOptions options = new RequestOptions().placeholder(R.mipmap.banner_default);

    public static void into(Context context, String url, ImageView imageView){

        Glide.with(context).load(url).apply(options).into(imageView);

    }

}
