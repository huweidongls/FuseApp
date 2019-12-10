package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.app.MyApplication;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.VersionBean;
import com.guoyu.fuseapp.dialog.DialogCustom;
import com.guoyu.fuseapp.dialog.DialogVersion;
import com.guoyu.fuseapp.dialog.ProgressDialog;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.VersionUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;
import com.vise.xsnow.http.mode.DownProgress;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/10/9.
 */

public class MemberSetupActivity extends BaseActivity {

    private Context context = MemberSetupActivity.this;

    @BindView(R.id.tv_version)
    TextView tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_setup);

        ButterKnife.bind(MemberSetupActivity.this);
        initData();

    }

    private void initData() {

        tvVersion.setText("v "+VersionUtils.packageName(context));

    }

    @OnClick({R.id.rl_back, R.id.ll_banben, R.id.ll_about, R.id.btn_exit})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_banben:
                final int versionCode = VersionUtils.packageCode(context);
                ViseUtil.Get(context, NetUrl.AppVersionInfonewVersion, null, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        final VersionBean bean = gson.fromJson(s, VersionBean.class);
                        if(bean.getData().getVersioncode()>versionCode){
                            DialogVersion dialogVersion = new DialogVersion(context, bean.getData().getVersionname(), bean.getData().getVerDesc()
                                    , new DialogVersion.ClickListener() {
                                @Override
                                public void onSure() {
                                    final ProgressDialog progressDialog = new ProgressDialog(context);
                                    progressDialog.setCancelable(false);
                                    progressDialog.setCanceledOnTouchOutside(false);
                                    progressDialog.show();
                                    String downloadUrl = bean.getData().getDownloadAdd();
                                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                                    ViseHttp.DOWNLOAD(downloadUrl)
                                            .setRootName(path)
                                            .setDirName("fuse")
                                            .setFileName("Fuse.apk")
                                            .request(new ACallback<DownProgress>() {
                                                @Override
                                                public void onSuccess(DownProgress data) {
                                                    progressDialog.setInfo(data.getFormatStatusString(), data.getPercent());
                                                    if (data.isDownComplete()){
                                                        progressDialog.dismiss();
                                                        String appFile = Environment.getExternalStorageDirectory().getAbsolutePath()+"/fuse/"+"Fuse.apk";
                                                        openAPK(appFile);
                                                    }
                                                }

                                                @Override
                                                public void onFail(int errCode, String errMsg) {

                                                }
                                            });
                                }

                                @Override
                                public void onCancel() {
                                    if(bean.getData().getIsAutoupdate() == 1){
                                        MyApplication.getInstance().exit();
                                    }
                                }
                            });
                            dialogVersion.setCancelable(false);
                            dialogVersion.setCanceledOnTouchOutside(false);
                            dialogVersion.show();
                        }
                    }
                });
                break;
            case R.id.ll_about:
                intent.setClass(context, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_exit:
                DialogCustom dialogCustom = new DialogCustom(context, "是否退出登录", new DialogCustom.OnYesListener() {
                    @Override
                    public void onYes() {
                        SpUtils.clear(context);
                        Map<String, String> map = new LinkedHashMap<>();
                        map.put("jnkjToken", "");
                        ViseHttp.CONFIG().baseUrl(NetUrl.BASE_URL)
                                .globalHeaders(map);
                        finish();
                    }
                });
                dialogCustom.show();
                break;
        }
    }

    /**
     * 安装apk
     * @param fileSavePath
     */
    private void openAPK(String fileSavePath){
        File file=new File(Uri.parse(fileSavePath).getPath());
        String filePath = file.getAbsolutePath();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//判断版本大于等于7.0
            // 生成文件的uri，，
            // 注意 下面参数com.ausee.fileprovider 为apk的包名加上.fileprovider，
            data = FileProvider.getUriForFile(context, "com.guoyu.fuseapp.fileprovider", new File(filePath));
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);// 给目标应用一个临时授权
        } else {
            data = Uri.fromFile(file);
        }

        intent.setDataAndType(data, "application/vnd.android.package-archive");
        startActivity(intent);
    }

}
