package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/24.
 */

public class communitybulletincontentBean {
    /**
     * status : 200
     * data : {"id":61,"title":"测试社区服务","content":"测试社区服务","statusid":2,"createDate":"2019-10-21 15:03:20","createUser":651,"publishUser":651,"publishDate":"2019-10-16 10:55:29","seviceType":17,"areaId":10000,"areaName":"死鬼社区"}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 61
         * title : 测试社区服务
         * content : 测试社区服务
         * statusid : 2
         * createDate : 2019-10-21 15:03:20
         * createUser : 651
         * publishUser : 651
         * publishDate : 2019-10-16 10:55:29
         * seviceType : 17
         * areaId : 10000
         * areaName : 死鬼社区
         */

        private int id;
        private String title;
        private String content;
        private int statusid;
        private String createDate;
        private int createUser;
        private int publishUser;
        private String publishDate;
        private int seviceType;
        private int areaId;
        private String areaName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatusid() {
            return statusid;
        }

        public void setStatusid(int statusid) {
            this.statusid = statusid;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public int getPublishUser() {
            return publishUser;
        }

        public void setPublishUser(int publishUser) {
            this.publishUser = publishUser;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public int getSeviceType() {
            return seviceType;
        }

        public void setSeviceType(int seviceType) {
            this.seviceType = seviceType;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }
    }
}
