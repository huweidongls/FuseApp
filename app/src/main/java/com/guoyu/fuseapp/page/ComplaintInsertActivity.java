package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.donkingliang.imageselector.utils.ImageSelector;
import com.donkingliang.imageselector.utils.ImageSelectorUtils;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.ComplaintInsertPicAdapter;
import com.guoyu.fuseapp.bean.ComplaintBumenBean;
import com.guoyu.fuseapp.bean.ComplaintConsultationBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class ComplaintInsertActivity extends AppCompatActivity {
    private Context context = ComplaintInsertActivity.this;

    @BindView(R.id.rv_pic)
    RecyclerView recyclerView;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_ftitle)
    EditText et_ftitle;
    @BindView(R.id.et_content)
    EditText et_content;
    private String BumenID = "";
    private ComplaintInsertPicAdapter adapter;
    private List<String> mList;
    private ArrayAdapter<String> adapters;
    private ArrayAdapter<String> adapter2;
    private List<ComplaintBumenBean.DataBean> mLis2;
    private List<ComplaintConsultationBean.DataBean> mLis3;
    private String type = "0";
    private Dialog weiboDialog;
    private int REQUEST_CODE = 102;
    private List<String> list = new ArrayList<String>();
    private List<String> list2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_insert);
        ButterKnife.bind(ComplaintInsertActivity.this);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = mLis3.get(position).getId() + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BumenID = mLis2.get(position).getId() + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        adapter = new ComplaintInsertPicAdapter(mList, 0);
        GridLayoutManager manager = new GridLayoutManager(context, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setListener(new ComplaintInsertPicAdapter.ClickListener() {
            @Override
            public void addImg() {
                //限数量的多选(比喻最多9张)
                ImageSelector.builder()
                        .useCamera(true) // 设置是否使用拍照
                        .setSingle(false)  //设置是否单选
                        .setMaxSelectCount(9 - mList.size()) // 图片的最大选择数量，小于等于0时，不限数量。
                        .setViewImage(true) //是否点击放大图片查看,，默认为true
                        .start(ComplaintInsertActivity.this, REQUEST_CODE); // 打开相册
            }

            @Override
            public void delImg(int pos, int deltype) {
                if (deltype == 0) {
                    mList.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        ViseUtil.Get(ComplaintInsertActivity.this, NetUrl.AppConsultationInfofindDepartment, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                ComplaintBumenBean bean = gson.fromJson(s, ComplaintBumenBean.class);
                mLis2 = bean.getData();
                Log.e("7878778787878", s);
                for (ComplaintBumenBean.DataBean bean2 : bean.getData()) {
                    list.add(bean2.getDepName());
                }
                adapters = new ArrayAdapter<String>(ComplaintInsertActivity.this, android.R.layout.simple_spinner_item, list);
                //第三步：设置下拉列表下拉时的菜单样式
                adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //第四步：将适配器添加到下拉列表上
                spinner2.setAdapter(adapters);
            }
        });
        ViseUtil.Get(context, NetUrl.AppConsultationInfofindType, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                ComplaintConsultationBean bean = gson.fromJson(s, ComplaintConsultationBean.class);
                mLis3 = bean.getData();
                for (ComplaintConsultationBean.DataBean bean2 : bean.getData()) {
                    list2.add(bean2.getSubName());
                }
                adapter2 = new ArrayAdapter<String>(ComplaintInsertActivity.this, android.R.layout.simple_spinner_item, list2);
                //第三步：设置下拉列表下拉时的菜单样式
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //第四步：将适配器添加到下拉列表上
                spinner1.setAdapter(adapter2);
            }
        });
    }

    /**
     * 提交
     */
    private void onSave() {
        weiboDialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");

        Observable<Map<String, File>> observable = Observable.create(new ObservableOnSubscribe<Map<String, File>>() {
            @Override
            public void subscribe(final ObservableEmitter<Map<String, File>> e) throws Exception {
                final Map<String, File> fileMap = new LinkedHashMap<>();
                final List<File> fileList = new ArrayList<>();
                Luban.with(context)
                        .load(mList)
                        .ignoreBy(100)
                        .filter(new CompressionPredicate() {
                            @Override
                            public boolean apply(String path) {
                                return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                            }
                        })
                        .setCompressListener(new OnCompressListener() {
                            @Override
                            public void onStart() {
                                // TODO 压缩开始前调用，可以在方法内启动 loading UI
                            }

                            @Override
                            public void onSuccess(File file) {
                                // TODO 压缩成功后调用，返回压缩后的图片文件
                                fileList.add(file);
                                if (fileList.size() == mList.size()) {
                                    for (int i = 0; i < fileList.size(); i++) {
                                        fileMap.put("file" + i, fileList.get(i));//[" + i + "]
                                    }
                                    e.onNext(fileMap);
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                // TODO 当压缩过程出现问题时调用
                            }
                        }).launch();
            }
        });
        Observer<Map<String, File>> observer = new Observer<Map<String, File>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Map<String, File> value) {
                String title = et_title.getText().toString();//标题
                String ftitle = et_ftitle.getText().toString();//副标题
                String content = et_content.getText().toString();//内容
                ViseHttp.UPLOAD(NetUrl.AppConsultationInfotoUpdate)
                        .addParam("title", title)
                        .addParam("contentTop", ftitle)
                        .addParam("consType", type)
                        .addParam("content", content)
                        .addParam("deptId", BumenID + "")
                        .addFiles(value)
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                try {
                                    JSONObject jsonObject = new JSONObject(data);
                                    if (jsonObject.optString("status").equals("200")) {
                                        ToastUtil.showShort(context, "发布成功");
                                        finish();
                                    } else {
                                        ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                WeiboDialogUtils.closeDialog(weiboDialog);
                            }

                            @Override
                            public void onFail(int errCode, String errMsg) {
                                WeiboDialogUtils.closeDialog(weiboDialog);
                            }
                        });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    private void SaveToText() {
        weiboDialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        String title = et_title.getText().toString();//标题
        String ftitle = et_ftitle.getText().toString();//副标题
        String content = et_content.getText().toString();//内容
        Map<String, String> map = new LinkedHashMap<>();
        map.put("title", title);
        map.put("contentTop", ftitle);
        map.put("consType", type);
        map.put("content", content);
        map.put("deptId", BumenID + "");
        ViseUtil.Post(context, NetUrl.AppConsultationInfotoUpdate, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    if (jsonObject.optString("status").equals("200")) {
                        ToastUtil.showShort(context, "发布成功");
                        finish();
                    } else {
                        ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                WeiboDialogUtils.closeDialog(weiboDialog);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            //获取选择器返回的数据
            ArrayList<String> images = data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);

            recyclerView.setVisibility(View.VISIBLE);
            mList.addAll(images);
            adapter.notifyDataSetChanged();

            /**
             * 是否是来自于相机拍照的图片，
             * 只有本次调用相机拍出来的照片，返回时才为true。
             * 当为true时，图片返回的结果有且只有一张图片。
             */
            boolean isCameraImage = data.getBooleanExtra(ImageSelector.IS_CAMERA_IMAGE, false);
        }
    }

    @OnClick({R.id.iv_black, R.id.btn_submit})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_black:
                finish();
                break;
            case R.id.btn_submit:
                String titles = et_title.getText().toString();//标题
                String ftitles = et_ftitle.getText().toString();//副标题
                String contents = et_content.getText().toString();//内容
                if (StringUtils.isEmpty(titles) || StringUtils.isEmpty(ftitles) || StringUtils.isEmpty(contents) || BumenID.isEmpty()) {
                    ToastUtil.showShort(context, "请先填写信息后再提交!");
                } else {
                    if (mList.size() > 0) {
                        onSave();
                    } else {
                        SaveToText();
                    }

                }

                break;
        }
    }
}
