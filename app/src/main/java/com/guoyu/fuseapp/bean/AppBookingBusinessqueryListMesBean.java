package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class AppBookingBusinessqueryListMesBean {

    /**
     * status : 200
     * data : [{"id":601,"detailsName":"测试","businessUserName":"刘德华","businessDate":"2019-09-10 08:30-09:30"}]
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
         * id : 601
         * detailsName : 测试
         * businessUserName : 刘德华
         * businessDate : 2019-09-10 08:30-09:30
         */

        private int id;
        private String detailsName;
        private String businessUserName;
        private String businessDate;
        private int employ;

        public int getEmploy() {
            return employ;
        }

        public void setEmploy(int employ) {
            this.employ = employ;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDetailsName() {
            return detailsName;
        }

        public void setDetailsName(String detailsName) {
            this.detailsName = detailsName;
        }

        public String getBusinessUserName() {
            return businessUserName;
        }

        public void setBusinessUserName(String businessUserName) {
            this.businessUserName = businessUserName;
        }

        public String getBusinessDate() {
            return businessDate;
        }

        public void setBusinessDate(String businessDate) {
            this.businessDate = businessDate;
        }
    }
}
