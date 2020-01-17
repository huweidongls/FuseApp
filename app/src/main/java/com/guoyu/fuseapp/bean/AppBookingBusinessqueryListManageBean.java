package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class AppBookingBusinessqueryListManageBean implements Serializable {

    /**
     * status : 200
     * data : [{"id":1,"detailsId":601,"orderYearMonth":"2019-09-10","orderStartTime":"08:30","orderEndTime":"09:30","orderCount":2,"hallName":"尖山区政务服务中心","depName":"尖山区人社局","businessName":"参保业务","detailsName":"食品营业许可（变更法定达标人或者负责人）"}]
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
         * id : 1
         * detailsId : 601
         * orderYearMonth : 2019-09-10
         * orderStartTime : 08:30
         * orderEndTime : 09:30
         * orderCount : 2
         * hallName : 尖山区政务服务中心
         * depName : 尖山区人社局
         * businessName : 参保业务
         * detailsName : 食品营业许可（变更法定达标人或者负责人）
         */

        private int id;
        private int detailsId;
        private String orderYearMonth;
        private String orderStartTime;
        private String orderEndTime;
        private int orderCount;
        private String hallName;
        private String depName;
        private String businessName;
        private String detailsName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDetailsId() {
            return detailsId;
        }

        public void setDetailsId(int detailsId) {
            this.detailsId = detailsId;
        }

        public String getOrderYearMonth() {
            return orderYearMonth;
        }

        public void setOrderYearMonth(String orderYearMonth) {
            this.orderYearMonth = orderYearMonth;
        }

        public String getOrderStartTime() {
            return orderStartTime;
        }

        public void setOrderStartTime(String orderStartTime) {
            this.orderStartTime = orderStartTime;
        }

        public String getOrderEndTime() {
            return orderEndTime;
        }

        public void setOrderEndTime(String orderEndTime) {
            this.orderEndTime = orderEndTime;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getHallName() {
            return hallName;
        }

        public void setHallName(String hallName) {
            this.hallName = hallName;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getDetailsName() {
            return detailsName;
        }

        public void setDetailsName(String detailsName) {
            this.detailsName = detailsName;
        }
    }
}
