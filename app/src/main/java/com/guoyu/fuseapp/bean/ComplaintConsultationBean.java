package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 */

public class ComplaintConsultationBean {
    /**
     * status : 200
     * data : [{"id":19,"subName":"其他","subCode":"QT"},{"id":21,"subName":"建言议事","subCode":"JYYS"},{"id":20,"subName":"消费投诉","subCode":"XFTS"},{"id":4,"subName":"咨询求助","subCode":"ZX"},{"id":5,"subName":"投诉举报","subCode":"TS"}]
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
         * id : 19
         * subName : 其他
         * subCode : QT
         */

        private int id;
        private String subName;
        private String subCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public String getSubCode() {
            return subCode;
        }

        public void setSubCode(String subCode) {
            this.subCode = subCode;
        }
    }
}
