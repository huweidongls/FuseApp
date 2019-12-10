package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class AppCitizenIndexfindConvenienceNoticeBean {

    /**
     * status : 200
     * data : [{"id":9,"funName":"养老服务","funCode":"YLFW","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl","showPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png"},{"id":13,"funName":"美食服务","funCode":"MSFW","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl","showPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png"}]
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
         * id : 9
         * funName : 养老服务
         * funCode : YLFW
         * unregSee : 1
         * androidUrl : androidUrl
         * iosUrl : iosUrl
         * showPic : upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png
         */

        private int id;
        private String funName;
        private String funCode;
        private int unregSee;
        private String androidUrl;
        private String iosUrl;
        private String showPic;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFunName() {
            return funName;
        }

        public void setFunName(String funName) {
            this.funName = funName;
        }

        public String getFunCode() {
            return funCode;
        }

        public void setFunCode(String funCode) {
            this.funCode = funCode;
        }

        public int getUnregSee() {
            return unregSee;
        }

        public void setUnregSee(int unregSee) {
            this.unregSee = unregSee;
        }

        public String getAndroidUrl() {
            return androidUrl;
        }

        public void setAndroidUrl(String androidUrl) {
            this.androidUrl = androidUrl;
        }

        public String getIosUrl() {
            return iosUrl;
        }

        public void setIosUrl(String iosUrl) {
            this.iosUrl = iosUrl;
        }

        public String getShowPic() {
            return showPic;
        }

        public void setShowPic(String showPic) {
            this.showPic = showPic;
        }
    }
}
