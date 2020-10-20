package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2020/10/20.
 */

public class AppBusQuestionquestionOneShowBean {

    /**
     * status : 200
     * data : {"id":2,"questionClassify":"市场问卷","beginTime":"2020-10-19 13:18:12","endTime":"2020-10-30 13:18:19","isPub":1,"createTime":"2020-10-19 14:08:22","isHide":1,"isShow":1}
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
         * questionClassify : 市场问卷
         * beginTime : 2020-10-19 13:18:12
         * endTime : 2020-10-30 13:18:19
         * isPub : 1
         * createTime : 2020-10-19 14:08:22
         * isHide : 1
         * isShow : 1
         */

        private int id;
        private String questionClassify;
        private String beginTime;
        private String endTime;
        private int isPub;
        private String createTime;
        private int isHide;
        private int isShow;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getQuestionClassify() {
            return questionClassify;
        }

        public void setQuestionClassify(String questionClassify) {
            this.questionClassify = questionClassify;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getIsPub() {
            return isPub;
        }

        public void setIsPub(int isPub) {
            this.isPub = isPub;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getIsHide() {
            return isHide;
        }

        public void setIsHide(int isHide) {
            this.isHide = isHide;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }
    }
}
