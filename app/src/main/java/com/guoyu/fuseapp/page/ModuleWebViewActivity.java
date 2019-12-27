package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.dialog.DialogCustom;
import com.guoyu.fuseapp.dialog.DialogMapType;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Gps;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.PositionUtil;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.wxapi.OnResponseListener;
import com.guoyu.fuseapp.wxapi.WXShare;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModuleWebViewActivity extends BaseActivity {

    private Context context = ModuleWebViewActivity.this;

    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.pro)
    ProgressBar progressBar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_loc)
    RelativeLayout rlLoc;

    private String url = "";
    private String id = "";
    private WXShare wxShare;
    private String funCode = "";
    //YLBJ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_web_view);

        funCode = getIntent().getStringExtra("funcode");
        id = getIntent().getStringExtra("id");
        url = getIntent().getStringExtra("url");
        ButterKnife.bind(ModuleWebViewActivity.this);
        initListener();
        initWebview();

    }

    /**
     * 微信分享回调
     */
    private void initListener() {

        wxShare = new WXShare(context);
        wxShare.setListener(new OnResponseListener() {
            @Override
            public void onSuccess() {
                ToastUtil.showShort(context, "分享成功");
            }

            @Override
            public void onCancel() {
                ToastUtil.showShort(context, "取消分享");
            }

            @Override
            public void onFail(String message) {
                ToastUtil.showShort(context, "分享失败");
            }
        });

    }

    private void initWebview() {

        if(!StringUtils.isEmpty(funCode)&&funCode.equals("YLBJ")){
            rlLoc.setVisibility(View.VISIBLE);
        }

        Logger.e("123123", url);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.getSettings().setTextZoom(100);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);// 屏幕自适应网页,如果没有这个，在低分辨率的手机上显示可能会异常
//        webview.getSettings().setSupportZoom(true);
//        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setCacheMode(
                webview.getSettings().LOAD_NO_CACHE); // 缓存设置
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //使用控件ProgressDialog来显示更新进度条示数
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tvTitle.setText(title);
            }
        });
        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                handler.proceed(); // 接受所有网站的证书
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                //加载错误时的回调
            }
        });

        webview.addJavascriptInterface(new JsInterface(), "android");
        if(!StringUtils.isEmpty(id)){
            url = url+"?id="+id;
        }
        if(!SpUtils.getUserId(context).equals("0")&&StringUtils.isEmpty(id)){
            url = url+"?userId="+SpUtils.getUserId(context);
        }else if(!SpUtils.getUserId(context).equals("0")&&!StringUtils.isEmpty(id)){
            url = url+"&userId="+SpUtils.getUserId(context);
        }
        webview.loadUrl(url);

    }

    @OnClick({R.id.rl_back, R.id.rl_loc})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_loc:
                String s = NetUrl.H5BASE_URL+"pages/yliao_map.html";
                webview.loadUrl(s);
                break;
        }
    }

    private boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    private void openGaode(String lat, String lng, String address){
        try {
            if (isInstallByread("com.autonavi.minimap")) {
                Gps gps = PositionUtil.bd09_To_Gcj02(Double.valueOf(lat), Double.valueOf(lng));
                Intent intent = new Intent(
                        "android.intent.action.VIEW",
                        android.net.Uri.parse(
                                "androidamap://route?sourceApplication=应用名称" + "&dlat="+ gps.getWgLat()//终点的经度
                                        + "&dlon="+ gps.getWgLon()//终点的纬度
                                        +"&dname="+address
                                        + "&dev=0" + "&t=1"));
                startActivity(intent);
            } else {
                ToastUtil.showShort(context, "没有安装高德地图客户端，请先下载该地图应用");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openBaidu(String lat, String lng, String address){
        try {
            if (isInstallByread("com.baidu.BaiduMap")) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("baidumap://map/marker?location=" + lat +
                        "," + lng + "&title=" + address +
                        "&content=" +
                        "&traffic=on&src=andr.baidu.openAPIdemo"));
                intent.setPackage("com.baidu.BaiduMap");
                startActivity(intent); // 启动调用
            } else {
                ToastUtil.showShort(context, "没有安装百度地图客户端，请先下载该地图应用");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class JsInterface {
        //JS中调用Android中的方法 和返回值处理的一种方法

        /****
         * Html中的点击事件 onclick
         * @param
         */
        @JavascriptInterface
        public void Map_go(final String lat, final String lng, final String address) {
            DialogMapType dialogMapType = new DialogMapType(context, new DialogMapType.ClickListener() {
                @Override
                public void onGaode() {
                    openGaode(lat, lng, address);
                }

                @Override
                public void onBaidu() {
                    openBaidu(lat, lng, address);
                }
            });
            dialogMapType.show();
        }

        /****
         * Html中的点击事件 onclick
         * @param
         */
        @JavascriptInterface
        public void share(final String url, final String title, final String subtitle, final String pic) {
            Logger.e("123123", url+title+subtitle+pic);
            DialogCustom dialogCustom = new DialogCustom(context, "打开微信", new DialogCustom.OnYesListener() {
                @Override
                public void onYes() {
                    wxShare.shareUrl(url, title, subtitle, "http://f.hiphotos.baidu.com/image/h%3D300/sign=d985fb87d81b0ef473e89e5eedc551a1/b151f8198618367aa7f3cc7424738bd4b31ce525.jpg");
                }
            });
            dialogCustom.show();

//            if(!StringUtils.isEmpty(phone)){
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                Uri data = Uri.parse("tel:" + phone);
//                intent.setData(data);
//                startActivity(intent);
//            }
        }

        /****
         * Html中的点击事件 onclick
         * @param
         */
        @JavascriptInterface
        public void call_up(String teltxt) {
            if(!teltxt.equals("0")){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + teltxt);
                intent.setData(data);
                startActivity(intent);
            }else {
                ToastUtil.showShort(context, "暂无联系方式");
            }
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
                webview.goBack();//后退
                //webview.goForward();//前进
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (webview != null) {
            //再次打开页面时，若界面没有消亡，会导致进度条不显示并且界面崩溃
            webview.stopLoading();
            webview.onPause();
            webview.clearCache(true);
            webview.clearHistory();
            //动态创建webview调用
            //ViewGroup parent = (ViewGroup) mWebView.getParent();
            //if (parent != null) {
            //  parent.removeView(mWebView);
            //}
            webview.removeAllViews();
            //先结束未结束线程，以免可能会导致空指针异常
            webview.destroy();
            webview = null;
            super.onDestroy();
        }
        wxShare.unregister();
    }

}
