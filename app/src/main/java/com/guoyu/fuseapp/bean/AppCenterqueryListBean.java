package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/19.
 */

public class AppCenterqueryListBean {

    /**
     * status : 200
     * data : [{"typeName":"政务中心","appCenters":[{"id":603,"createDate":"2020-01-17 16:27:04","typeId":601,"title":"标题2","titlePic":"图标2","skipPage":"跳转包名2","skipUrl":"跳转URL2","deviceType":0},{"id":602,"createDate":"2020-01-17 16:26:53","typeId":601,"title":"标题1","titlePic":"图标1","skipPage":"跳转包名1","skipUrl":"跳转URL1","deviceType":0},{"id":601,"createDate":"2020-01-17 16:26:45","typeId":601,"title":"标题","titlePic":"图标","skipPage":"跳转包名","skipUrl":"跳转URL","deviceType":0}]},{"typeName":"美食服务","appCenters":[{"id":606,"createDate":"2020-01-17 16:27:35","typeId":602,"title":"标题","titlePic":"图标","skipPage":"跳转包名","skipUrl":"跳转URL","deviceType":0},{"id":605,"createDate":"2020-01-17 16:27:17","typeId":602,"title":"标题1","titlePic":"图标1","skipPage":"跳转包名1","skipUrl":"跳转URL1","deviceType":0},{"id":604,"createDate":"2020-01-17 16:27:11","typeId":602,"title":"标题2","titlePic":"图标2","skipPage":"跳转包名2","skipUrl":"跳转URL2","deviceType":0}]},{"typeName":"城市风采","appCenters":[]}]
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
         * typeName : 政务中心
         * appCenters : [{"id":603,"createDate":"2020-01-17 16:27:04","typeId":601,"title":"标题2","titlePic":"图标2","skipPage":"跳转包名2","skipUrl":"跳转URL2","deviceType":0},{"id":602,"createDate":"2020-01-17 16:26:53","typeId":601,"title":"标题1","titlePic":"图标1","skipPage":"跳转包名1","skipUrl":"跳转URL1","deviceType":0},{"id":601,"createDate":"2020-01-17 16:26:45","typeId":601,"title":"标题","titlePic":"图标","skipPage":"跳转包名","skipUrl":"跳转URL","deviceType":0}]
         */

        private String typeName;
        private List<AppCentersBean> appCenters;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public List<AppCentersBean> getAppCenters() {
            return appCenters;
        }

        public void setAppCenters(List<AppCentersBean> appCenters) {
            this.appCenters = appCenters;
        }

        public static class AppCentersBean {
            /**
             * id : 603
             * createDate : 2020-01-17 16:27:04
             * typeId : 601
             * title : 标题2
             * titlePic : 图标2
             * skipPage : 跳转包名2
             * skipUrl : 跳转URL2
             * deviceType : 0
             */

            private int id;
            private String createDate;
            private int typeId;
            private String title;
            private String titlePic;
            private String skipPage;
            private String skipUrl;
            private int deviceType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitlePic() {
                return titlePic;
            }

            public void setTitlePic(String titlePic) {
                this.titlePic = titlePic;
            }

            public String getSkipPage() {
                return skipPage;
            }

            public void setSkipPage(String skipPage) {
                this.skipPage = skipPage;
            }

            public String getSkipUrl() {
                return skipUrl;
            }

            public void setSkipUrl(String skipUrl) {
                this.skipUrl = skipUrl;
            }

            public int getDeviceType() {
                return deviceType;
            }

            public void setDeviceType(int deviceType) {
                this.deviceType = deviceType;
            }
        }
    }
}
