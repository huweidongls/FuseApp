package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class SearchBean implements Serializable {

    /**
     * status : 200
     * data : [{"title":"应用相关","content":[{"funNode":"ZJFW","logoPic":"/upload/icon/agent_service.png","unregSee":0,"androidUrl":"com.guoyu.fuseapp.page.ZhongjieListActivity","id":34,"funName":"中介服务"},{"funNode":"XKZY","logoPic":"/upload/icon/education_info.png","unregSee":1,"androidUrl":"androidUrl","id":5,"iosUrl":"iosUrl","url":"webUrl","funName":"教育服务"},{"funNode":"MPFW","logoPic":"/upload/icon/entrance_ticket_info.png","unregSee":1,"androidUrl":"androidUrl","id":6,"iosUrl":"iosUrl","url":"webUrl","funName":"旅游服务"},{"funNode":"ZPFW","logoPic":"/upload/icon/recruit_info.png","unregSee":1,"androidUrl":"androidUrl","id":7,"iosUrl":"iosUrl","url":"webUrl","funName":"招聘服务"},{"funNode":"YLFW","logoPic":"/upload/icon/oldman_service_info.png","unregSee":1,"androidUrl":"androidUrl","id":9,"iosUrl":"iosUrl","url":"webUrl","funName":"养老服务"},{"funNode":"AQFU","logoPic":"/upload/icon/save_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.SafeListActivity","id":10,"iosUrl":"iosUrl","funName":"安全服务"},{"funNode":"SQFW","logoPic":"/upload/icon/community_service_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.CommunityServiceActivity","id":11,"iosUrl":"iosUrl","funName":"社区服务"},{"funNode":"JZFW","logoPic":"/upload/icon/house_service_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.JiazhengListActivity","id":12,"iosUrl":"iosUrl","funName":"家政服务"},{"funNode":"HCCX","logoPic":"/upload/icon/huochechuxing.png","unregSee":0,"androidUrl":"androidUrl","id":22,"iosUrl":"iosUrl","url":"webUrl","funName":"交通服务"}]},{"title":"住宿餐饮","content":[{"modularUrl":"web","statusid":0,"unregSee":1,"id":21,"title":"测试美食服务","funCode":"MSFW","content":"测试美食服务","funId":13,"funName":"住宿餐饮"},{"modularUrl":"web","statusid":1,"unregSee":1,"id":41,"title":"测试美食服务","funCode":"MSFW","content":"测试美食服务","funId":13,"funName":"住宿餐饮"}]},{"title":"社区服务","content":[{"statusid":2,"unregSee":1,"publishUser":651,"publishDate":"2019-10-16","id":61,"androidModularUrl":"com.guoyu.fuseapp.page.CommunityBulletinContentActivity","title":"测试社区服务","funCode":"SQFW","content":"测试社区服务","funId":11,"funName":"社区服务"}]},{"title":"家政服务","content":[{"statusid":1,"unregSee":1,"id":21,"androidModularUrl":"com.guoyu.fuseapp.page.JiazhengDetailsActivity","title":"测试家政服务","funCode":"JZFW","content":"内容","funId":12,"funName":"家政服务"}]}]
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

    public static class DataBean implements Serializable {
        /**
         * title : 应用相关
         * content : [{"funNode":"ZJFW","logoPic":"/upload/icon/agent_service.png","unregSee":0,"androidUrl":"com.guoyu.fuseapp.page.ZhongjieListActivity","id":34,"funName":"中介服务"},{"funNode":"XKZY","logoPic":"/upload/icon/education_info.png","unregSee":1,"androidUrl":"androidUrl","id":5,"iosUrl":"iosUrl","url":"webUrl","funName":"教育服务"},{"funNode":"MPFW","logoPic":"/upload/icon/entrance_ticket_info.png","unregSee":1,"androidUrl":"androidUrl","id":6,"iosUrl":"iosUrl","url":"webUrl","funName":"旅游服务"},{"funNode":"ZPFW","logoPic":"/upload/icon/recruit_info.png","unregSee":1,"androidUrl":"androidUrl","id":7,"iosUrl":"iosUrl","url":"webUrl","funName":"招聘服务"},{"funNode":"YLFW","logoPic":"/upload/icon/oldman_service_info.png","unregSee":1,"androidUrl":"androidUrl","id":9,"iosUrl":"iosUrl","url":"webUrl","funName":"养老服务"},{"funNode":"AQFU","logoPic":"/upload/icon/save_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.SafeListActivity","id":10,"iosUrl":"iosUrl","funName":"安全服务"},{"funNode":"SQFW","logoPic":"/upload/icon/community_service_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.CommunityServiceActivity","id":11,"iosUrl":"iosUrl","funName":"社区服务"},{"funNode":"JZFW","logoPic":"/upload/icon/house_service_info.png","unregSee":1,"androidUrl":"com.guoyu.fuseapp.page.JiazhengListActivity","id":12,"iosUrl":"iosUrl","funName":"家政服务"},{"funNode":"HCCX","logoPic":"/upload/icon/huochechuxing.png","unregSee":0,"androidUrl":"androidUrl","id":22,"iosUrl":"iosUrl","url":"webUrl","funName":"交通服务"}]
         */

        private String title;
        private List<ContentBean> content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean implements Serializable {
            /**
             * funNode : ZJFW
             * logoPic : /upload/icon/agent_service.png
             * unregSee : 0
             * androidUrl : com.guoyu.fuseapp.page.ZhongjieListActivity
             * id : 34
             * funName : 中介服务
             * iosUrl : iosUrl
             * url : webUrl
             */

            private String funCode;
            private String logoPic;
            private int unregSee;
            private String androidUrl;
            private int id;
            private String funName;
            private String iosUrl;
            private String url;
            private String modularUrl;
            private String androidModularUrl;
            private String title;
            private String contentTop;
            private String publishDate;
            private int urlType;

            public int getUrlType() {
                return urlType;
            }

            public void setUrlType(int urlType) {
                this.urlType = urlType;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }

            public String getContent() {
                return contentTop;
            }

            public void setContent(String contentTop) {
                this.contentTop = contentTop;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAndroidModularUrl() {
                return androidModularUrl;
            }

            public void setAndroidModularUrl(String androidModularUrl) {
                this.androidModularUrl = androidModularUrl;
            }

            public String getModularUrl() {
                return modularUrl;
            }

            public void setModularUrl(String modularUrl) {
                this.modularUrl = modularUrl;
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

            public String getIosUrl() {
                return iosUrl;
            }

            public void setIosUrl(String iosUrl) {
                this.iosUrl = iosUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
