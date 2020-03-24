package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2020/3/24.
 */

public class AppointmentNoticeAppgetOneBean {

    /**
     * status : 200
     * data : {"id":1,"title":"测试标题","content":"测试内容123","createDate":"2020-03-23 10:06:46","status":0}
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
         * id : 1
         * title : 测试标题
         * content : 测试内容123
         * createDate : 2020-03-23 10:06:46
         * status : 0
         */

        private int id;
        private String title;
        private String content;
        private String createDate;
        private int status;

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

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
