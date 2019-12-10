package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.donkingliang.imageselector.utils.ImageSelector;
import com.donkingliang.imageselector.utils.ImageSelectorUtils;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.ComplaintInsertPicAdapter;
import com.guoyu.fuseapp.bean.CityMicroRowBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

public class CityMicroUpdateActivity extends AppCompatActivity {

    private Context context = CityMicroUpdateActivity.this;

    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_ftitle)
    EditText et_ftitle;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.rv_pic)
    RecyclerView recyclerView;

   /* @BindView(R.id.rv_pic)
    RecyclerView rv_pic;*/

    private List<String> mList = new ArrayList<String>();
    private int REQUEST_CODE = 102;
    private ComplaintInsertPicAdapter adapter;
    private List<String> list = new ArrayList<String>();
    private String id = "";
    private String pic_list = "";
    private Dialog weiboDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_micro_update);
        id = getIntent().getStringExtra("id");

        ButterKnife.bind(CityMicroUpdateActivity.this);
        initData();

    }

    private void initData() {//

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", id);
        ViseUtil.Get(context, NetUrl.AppMiniCityInfogetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                CityMicroRowBean bean = gson.fromJson(s, CityMicroRowBean.class);
                et_title.setText(bean.getData().getTitle());
                et_ftitle.setText(bean.getData().getContentTop());
                et_content.setText(bean.getData().getContent());
                pic_list = bean.getData().getContentPic();
                List<String> lists = Arrays.asList(bean.getData().getContentPic().split(","));
                for (String bea : lists) {
                    list.add(NetUrl.BASE_URL + bea);
                }
               /* StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < list.size(); i++) {
                    stringBuffer.append(list.get(i).toString().trim() + ",");
                }
                pic_list = stringBuffer.substring(0, stringBuffer.length() - 1).toString();*/
                adapter = new ComplaintInsertPicAdapter(list, 1);
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
                                .setMaxSelectCount(9 - list.size()) // 图片的最大选择数量，小于等于0时，不限数量。
                                .setViewImage(true) //是否点击放大图片查看,，默认为true
                                .start(CityMicroUpdateActivity.this, REQUEST_CODE); // 打开相册
                    }

                    @Override
                    public void delImg(int pos, int deltype) {
                        if (deltype == 0) {
                            list.remove(pos);
                            adapter.notifyDataSetChanged();
                        } else {
                            String s = list.get(pos);
                            String ss = "upload";
                            boolean ii = s.contains(ss);
                            if (ii == true) {
                                String userId = list.get(pos);//
                                String userIdJiequ = userId.substring(userId.indexOf("upload"));
                                String newStr = pic_list.replace("/" + userIdJiequ + ",", ""); //匹配路径
                                pic_list = newStr;//删除后的字符串
                                list.remove(pos);
                                adapter.notifyDataSetChanged();
                            } else if (ii == false) {
                                list.remove(pos);
                                adapter.notifyDataSetChanged();
                            }

                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            //获取选择器返回的数据
            final ArrayList<String> images = data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);
            list.addAll(images);
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

    private void onSave() {

        //Log.e("878974889489489",mList.size()+"");
        if (mList.size() == 0) {
            String title = et_title.getText().toString();//标题
            String ftitle = et_ftitle.getText().toString();//副标题
            String content = et_content.getText().toString();//内容
            Map<String, String> map = new LinkedHashMap<>();
            map.put("title", title);
            map.put("contentTop", ftitle);
            map.put("content", content);
            map.put("contentPic", pic_list);
            map.put("id", id);
            ViseUtil.Post(context, NetUrl.AppMiniCityInfotoUpdate, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        if (jsonObject.optString("status").equals("200")) {
                            ToastUtil.showShort(context, "更新成功!");
                            finish();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
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
                    ViseHttp.UPLOAD(NetUrl.AppMiniCityInfotoUpdate)
                            .addParam("title", title)
                            .addParam("contentTop", ftitle)
                            .addParam("content", content)
                            .addParam("contentPic", pic_list)
                            .addParam("id", id)
                            .addFiles(value)
                            .request(new ACallback<String>() {
                                @Override
                                public void onSuccess(String data) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(data);
                                        if (jsonObject.optString("status").equals("200")) {
                                            ToastUtil.showShort(context, "更新成功!");
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
    }

    @OnClick({R.id.iv_black, R.id.btn_submit})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_black:
                finish();
                break;
            case R.id.btn_submit:
                onSave();
                break;
        }
    }
}
