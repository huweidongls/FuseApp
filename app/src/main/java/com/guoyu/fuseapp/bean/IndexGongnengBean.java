package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/11.
 */

public class IndexGongnengBean {

    /**
     * status : 200
     * data : [{"id":1,"funName":"便民通知","funCode":"BMTZ","logoPic":"/upload/icon/convenience_notice.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":2,"funName":"城市风采","funCode":"CHFC","logoPic":"/upload/icon/city_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":3,"funName":"政务指南","funCode":"ZWZN","logoPic":"/upload/icon/government_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.GovernmentListActivity"},{"id":4,"funName":"医疗保健","funCode":"YLBJ","logoPic":"/upload/icon/medical_care.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":5,"funName":"学科资源","funCode":"XKZY","logoPic":"/upload/icon/education_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":6,"funName":"门票服务","funCode":"MPFW","logoPic":"/upload/icon/entrance_ticket_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":7,"funName":"招聘服务","funCode":"ZPFW","logoPic":"/upload/icon/recruit_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":8,"funName":"文体活动","funCode":"WTHD","logoPic":"/upload/icon/style_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":9,"funName":"养老服务","funCode":"YLFW","logoPic":"/upload/icon/oldman_service_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":10,"funName":"安全服务","funCode":"AQFU","logoPic":"/upload/icon/save_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"},{"id":11,"funName":"社区服务","funCode":"SQFW","logoPic":"/upload/icon/community_service_info.png","url":"webUrl","unregSee":1,"androidUrl":"androidUrl","iosUrl":"iosUrl"}]
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
         * id : 1
         * funName : 便民通知
         * funCode : BMTZ
         * logoPic : /upload/icon/convenience_notice.png
         * url : webUrl
         * unregSee : 1
         * androidUrl : androidUrl
         * iosUrl : iosUrl
         */

        private int id;
        private String funName;
        private String funCode;
        private String logoPic;
        private String url;
        private int unregSee;
        private String androidUrl;
        private String iosUrl;
        private int urlType;

        public int getUrlType() {
            return urlType;
        }

        public void setUrlType(int urlType) {
            this.urlType = urlType;
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

        public String getLogoPic() {
            return logoPic;
        }

        public void setLogoPic(String logoPic) {
            this.logoPic = logoPic;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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
    }
}
