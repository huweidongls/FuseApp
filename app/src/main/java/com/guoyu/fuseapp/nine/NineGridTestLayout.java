package com.guoyu.fuseapp.nine;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.imagepreview.Consts;
import com.guoyu.fuseapp.imagepreview.ImagePreviewActivity;
import com.guoyu.fuseapp.util.GlideUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 * 作者：HMY
 * 时间：2016/5/12
 */
public class NineGridTestLayout extends NineGridLayout {

    protected static final int MAX_W_H_RATIO = 3;

    public NineGridTestLayout(Context context) {
        super(context);
    }

    public NineGridTestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean displayOneImage(final RatioImageView imageView, String url, final int parentWidth) {
        GlideUtils.into(mContext, url, imageView);
        return false;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
//        ImageLoaderUtil.getImageLoader(mContext).displayImage(url, imageView, ImageLoaderUtil.getPhotoImageOption());
//        Glide.with(mContext).load(url).into(imageView);
        GlideUtils.into(mContext, url, imageView);
    }

    @Override
    protected void onClickImage(int i, String url, List<String> urlList) {
//        Toast.makeText(mContext, "点击了图片" + url, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mContext, ImagePreviewActivity.class);
        intent.putExtra("imageList", (Serializable) urlList);
        intent.putExtra(Consts.START_ITEM_POSITION, i);
        intent.putExtra(Consts.START_IAMGE_POSITION, i);
        mContext.startActivity(intent);
//                ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(getActivity(), imageView, imageView.getTransitionName());
//                getActivity().overridePendingTransition(R.anim.photoview_open, 0);
    }
}
