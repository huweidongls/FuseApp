package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/11.
 */

public class ConsultationTypeBean {

    /**
     * status : 200
     * data : [{"id":4,"title":"已反馈1","contentTop":"已反馈副标题1","consType":4,"content":"500呢","statusid":3,"createUser":651,"feeMemo":"500呢","feeUser":651,"feeStatus":1}]
     * totalPage : 1
     * totalCount : 2
     */

    private String status;
    private int totalPage;
    private int totalCount;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * title : 已反馈1
         * contentTop : 已反馈副标题1
         * consType : 4
         * content : 500呢
         * statusid : 3
         * createUser : 651
         * feeMemo : 500呢
         * feeUser : 651
         * feeStatus : 1
         */

        private int id;
        private String title;
        private String contentTop;
        private int consType;
        private String content;
        private int statusid;
        private int createUser;
        private String feeMemo;
        private int feeUser;
        private int feeStatus;

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

        public String getContentTop() {
            return contentTop;
        }

        public void setContentTop(String contentTop) {
            this.contentTop = contentTop;
        }

        public int getConsType() {
            return consType;
        }

        public void setConsType(int consType) {
            this.consType = consType;
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

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public String getFeeMemo() {
            return feeMemo;
        }

        public void setFeeMemo(String feeMemo) {
            this.feeMemo = feeMemo;
        }

        public int getFeeUser() {
            return feeUser;
        }

        public void setFeeUser(int feeUser) {
            this.feeUser = feeUser;
        }

        public int getFeeStatus() {
            return feeStatus;
        }

        public void setFeeStatus(int feeStatus) {
            this.feeStatus = feeStatus;
        }
    }
}
