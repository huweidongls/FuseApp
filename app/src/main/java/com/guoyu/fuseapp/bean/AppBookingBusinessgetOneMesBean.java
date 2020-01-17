package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2020/1/17.
 */

public class AppBookingBusinessgetOneMesBean {

    /**
     * status : 200
     * data : {"id":601,"hallName":"测试","depName":"测试","busName":"测试","detailsName":"测试","businessUserName":"刘德华","businessUserIdnumber":"232306199601022012","businessUserPhone":"13796068265","businessDate":"2019-09-10 08:30-09:30"}
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
         * id : 601
         * hallName : 测试
         * depName : 测试
         * busName : 测试
         * detailsName : 测试
         * businessUserName : 刘德华
         * businessUserIdnumber : 232306199601022012
         * businessUserPhone : 13796068265
         * businessDate : 2019-09-10 08:30-09:30
         */

        private int id;
        private String hallName;
        private String depName;
        private String busName;
        private String detailsName;
        private String businessUserName;
        private String businessUserIdnumber;
        private String businessUserPhone;
        private String businessDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getBusName() {
            return busName;
        }

        public void setBusName(String busName) {
            this.busName = busName;
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

        public String getBusinessUserIdnumber() {
            return businessUserIdnumber;
        }

        public void setBusinessUserIdnumber(String businessUserIdnumber) {
            this.businessUserIdnumber = businessUserIdnumber;
        }

        public String getBusinessUserPhone() {
            return businessUserPhone;
        }

        public void setBusinessUserPhone(String businessUserPhone) {
            this.businessUserPhone = businessUserPhone;
        }

        public String getBusinessDate() {
            return businessDate;
        }

        public void setBusinessDate(String businessDate) {
            this.businessDate = businessDate;
        }
    }
}
