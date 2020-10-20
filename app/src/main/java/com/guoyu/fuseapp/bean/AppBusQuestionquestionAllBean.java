package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/10/20.
 */

public class AppBusQuestionquestionAllBean {

    /**
     * status : 200
     * data : [{"id":1,"questionClassify":"国庆问卷","beginTime":"2020-10-19 13:18:12","endTime":"2020-10-21 13:18:19","isPub":1,"createTime":"2020-10-19 14:08:22","isShow":"0"},{"id":101,"questionClassify":"清明问卷","beginTime":"2020-10-19 14:24:52","endTime":"2021-10-22 00:00:00","isPub":1,"createTime":"2020-10-19 14:25:08","isShow":"0"}]
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
         * questionClassify : 国庆问卷
         * beginTime : 2020-10-19 13:18:12
         * endTime : 2020-10-21 13:18:19
         * isPub : 1
         * createTime : 2020-10-19 14:08:22
         * isShow : 0
         */

        private int id;
        private String questionClassify;
        private String beginTime;
        private String endTime;
        private int isPub;
        private String createTime;
        private String isShow;
        private int isHide;

        public int getIsHide() {
            return isHide;
        }

        public void setIsHide(int isHide) {
            this.isHide = isHide;
        }

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

        public String getIsShow() {
            return isShow;
        }

        public void setIsShow(String isShow) {
            this.isShow = isShow;
        }
    }
}
