package com.guoyu.fuseapp.page;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.donkingliang.imageselector.utils.ImageSelectorUtils;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.app.MyApplication;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.VersionBean;
import com.guoyu.fuseapp.dialog.DialogVersion;
import com.guoyu.fuseapp.dialog.ProgressDialog;
import com.guoyu.fuseapp.fragment.Fragment1;
import com.guoyu.fuseapp.fragment.Fragment2;
import com.guoyu.fuseapp.fragment.Fragment3;
import com.guoyu.fuseapp.fragment.Fragment4;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.VersionUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;
import com.vise.xsnow.http.mode.DownProgress;
import com.vise.xsnow.permission.OnPermissionCallback;
import com.vise.xsnow.permission.PermissionManager;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private Context context = MainActivity.this;

//    @BindView(R.id.menu_1)
//    ImageButton ib1;
//    @BindView(R.id.menu_2)
//    ImageButton ib2;
//    @BindView(R.id.menu_3)
//    ImageButton ib3;
//    @BindView(R.id.menu_4)
//    ImageButton ib4;
//    @BindView(R.id.menu1)
//    RelativeLayout rl1;
//    @BindView(R.id.menu2)
//    RelativeLayout rl2;
//    @BindView(R.id.menu3)
//    RelativeLayout rl3;
//    @BindView(R.id.menu4)
//    RelativeLayout rl4;
//    @BindView(R.id.tv1)
//    TextView tv1;
//    @BindView(R.id.tv2)
//    TextView tv2;
//    @BindView(R.id.tv3)
//    TextView tv3;
//    @BindView(R.id.tv4)
//    TextView tv4;
    @BindView(R.id.mViewPager)
    ViewPager mViewPger;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaTabsIndicator;

    private long exitTime = 0;

    private List<Fragment> fragmentList = new ArrayList<>();
//    private MenuOnClickListener listener = new MenuOnClickListener();

//    FragmentManager fragmentManager = getSupportFragmentManager();
//    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionManager.instance().request(this, new OnPermissionCallback() {
                    @Override
                    public void onRequestAllow(String permissionName) {
//                DialogUtil.showTips(mContext, getString(R.string.permission_control),
//                        getString(R.string.permission_allow) + "\n" + permissionName);
                    }

                    @Override
                    public void onRequestRefuse(String permissionName) {
//                DialogUtil.showTips(mContext, getString(R.string.permission_control),
//                        getString(R.string.permission_refuse) + "\n" + permissionName);
                    }

                    @Override
                    public void onRequestNoAsk(String permissionName) {
//                DialogUtil.showTips(mContext, getString(R.string.permission_control),
//                        getString(R.string.permission_noAsk) + "\n" + permissionName);
                    }
                }, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE);
        MyApplication.getInstance().addActivity(MainActivity.this);
        ButterKnife.bind(MainActivity.this);
        init();
        initVersion();

    }

    /**
     * 版本
     */
    private void initVersion() {

        final int versionCode = VersionUtils.packageCode(context);
        ViseUtil.Get(context, NetUrl.AppVersionInfonewVersion, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Log.e("123123", s);
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

    /**
     * 初始化各个组件
     */
    private void init() {

//        ib1.setOnClickListener(listener);
//        ib2.setOnClickListener(listener);
//        ib3.setOnClickListener(listener);
//        ib4.setOnClickListener(listener);
//
//        rl1.setOnClickListener(listener);
//        rl2.setOnClickListener(listener);
//        rl3.setOnClickListener(listener);
//        rl4.setOnClickListener(listener);
//        Fragment fragment1 = new Fragment1();
//        Fragment fragment2 = new Fragment2();
//        Fragment fragment3 = new Fragment3();
//        Fragment fragment4 = new Fragment4();
//
//        fragmentList.add(fragment1);
//        fragmentList.add(fragment2);
//        fragmentList.add(fragment3);
//        fragmentList.add(fragment4);

//        fragmentTransaction.add(R.id.fl_container, fragment1);
//        fragmentTransaction.add(R.id.fl_container, fragment2);
//        fragmentTransaction.add(R.id.fl_container, fragment3);
//        fragmentTransaction.add(R.id.fl_container, fragment4);
//
//        fragmentTransaction.show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4);
//        fragmentTransaction.commit();
//
//        selectButton(ib1);
//        selectText(tv1);

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setOffscreenPageLimit(4);
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator.setViewPager(mViewPger);

//        alphaTabsIndicator.getTabView(0).showNumber(6);
//        alphaTabsIndicator.getTabView(1).showNumber(888);
//        alphaTabsIndicator.getTabView(2).showNumber(88);
//        alphaTabsIndicator.getTabView(3).showPoint();

    }

    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();
        Fragment fragment1 = new Fragment1();
        Fragment fragment2 = new Fragment2();
        Fragment fragment3 = new Fragment3();
        Fragment fragment4 = new Fragment4();

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(fragment1);
            fragments.add(fragment2);
            fragments.add(fragment3);
            fragments.add(fragment4);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
//            if (0 == position) {
//                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
//            } else if (2 == position) {
//                alphaTabsIndicator.getCurrentItemView().removeShow();
//            } else if (3 == position) {
//                alphaTabsIndicator.removeAllBadge();
//            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

//    public void selectFragment(int i){
//        switch (i){
//            case 0:
//                selectButton(ib1);
//                switchFragment(0);
//                break;
//            case 1:
//                selectButton(ib2);
//                switchFragment(1);
//                break;
//            case 2:
//                selectButton(ib3);
//                switchFragment(2);
//                break;
//            case 3:
//                selectButton(ib4);
//                switchFragment(3);
//                break;
//        }
//    }

//    private class MenuOnClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.menu_1:
//                    selectButton(ib1);
//                    selectText(tv1);
//                    switchFragment(0);
//                    break;
//                case R.id.menu_2:
//                    selectButton(ib2);
//                    selectText(tv2);
//                    switchFragment(1);
//                    break;
//                case R.id.menu_3:
//                    selectButton(ib3);
//                    selectText(tv3);
//                    switchFragment(2);
//                    break;
//                case R.id.menu_4:
//                    selectButton(ib4);
//                    selectText(tv4);
//                    switchFragment(3);
//                    break;
//                case R.id.menu1:
//                    selectText(tv1);
//                    selectButton(ib1);
//                    switchFragment(0);
//                    break;
//                case R.id.menu2:
//                    selectButton(ib2);
//                    selectText(tv2);
//                    switchFragment(1);
//                    break;
//                case R.id.menu3:
//                    selectButton(ib3);
//                    selectText(tv3);
//                    switchFragment(2);
//                    break;
//                case R.id.menu4:
//                    selectButton(ib4);
//                    selectText(tv4);
//                    switchFragment(3);
//                    break;
//            }
//
//        }
//    }

//    /**
//     * 选择隐藏与显示的Fragment
//     *
//     * @param index 显示的Frgament的角标
//     */
//    public void switchFragment(int index) {
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        for (int i = 0; i < fragmentList.size(); i++) {
//            if (index == i) {
//                fragmentTransaction.show(fragmentList.get(index));
//            } else {
//                fragmentTransaction.hide(fragmentList.get(i));
//            }
//        }
//        fragmentTransaction.commitAllowingStateLoss();
//    }
//
//    public void selectText(View v) {
//        tv1.setSelected(false);
//        tv2.setSelected(false);
//        tv3.setSelected(false);
//        tv4.setSelected(false);
//        v.setSelected(true);
//    }
//
//    /**
//     * 控制底部菜单按钮的选中
//     *
//     * @param v
//     */
//    public void selectButton(View v) {
//        ib1.setSelected(false);
//        ib2.setSelected(false);
//        ib3.setSelected(false);
//        ib4.setSelected(false);
//        v.setSelected(true);
//    }

    @Override
    public void onBackPressed() {
        backtrack();
    }

    /**
     * 退出销毁所有activity
     */
    private void backtrack() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtil.showShort(context, "再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            MyApplication.getInstance().exit();
            exitTime = 0;
        }
    }

}
