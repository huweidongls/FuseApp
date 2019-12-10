package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/31.
 */

public class NoticegetOneBean {

    /**
     * status : 200
     * data : {"id":2,"title":"标题","content":"测试内容","statusid":2,"createDate":"2019-10-09 09:27:44","createUser":0,"contentPics":"测试图片","publishUser":1,"publishDate":"2019-10-09 09:26:36"}
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
         * id : 2
         * title : 标题
         * content : 测试内容
         * statusid : 2
         * createDate : 2019-10-09 09:27:44
         * createUser : 0
         * contentPics : 测试图片
         * publishUser : 1
         * publishDate : 2019-10-09 09:26:36
         */

        private int id;
        private String title;
        private String content;
        private int statusid;
        private String createDate;
        private int createUser;
        private String contentPics;
        private int publishUser;
        private String publishDate;
        private String contentPic;

        public String getContentPic() {
            return contentPic;
        }

        public void setContentPic(String contentPic) {
            this.contentPic = contentPic;
        }

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

        public String getContentPics() {
            return contentPics;
        }

        public void setContentPics(String contentPics) {
            this.contentPics = contentPics;
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
    }
}
