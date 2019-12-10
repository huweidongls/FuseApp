package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/11.
 */

public class BannerBean {

    /**
     * status : 200
     * data : [{"bannerPic":"轮播图图片"},{"bannerPic":"轮播图图片"}]
     */

    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bannerPic : 轮播图图片
         */

        private String bannerPic;

        public String getBannerPic() {
            return bannerPic;
        }

        public void setBannerPic(String bannerPic) {
            this.bannerPic = bannerPic;
        }
    }
}
