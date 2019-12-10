package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/31.
 */

public class FindNumBean {

    /**
     * status : 200
     * data : {"id":1,"businessId":1,"funCode":"XT","shareTimes":0,"listTimes":1,"praiseTimes":0}
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
         * businessId : 1
         * funCode : XT
         * shareTimes : 0
         * listTimes : 1
         * praiseTimes : 0
         */

        private int id;
        private int businessId;
        private String funCode;
        private int shareTimes;
        private int listTimes;
        private int praiseTimes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBusinessId() {
            return businessId;
        }

        public void setBusinessId(int businessId) {
            this.businessId = businessId;
        }

        public String getFunCode() {
            return funCode;
        }

        public void setFunCode(String funCode) {
            this.funCode = funCode;
        }

        public int getShareTimes() {
            return shareTimes;
        }

        public void setShareTimes(int shareTimes) {
            this.shareTimes = shareTimes;
        }

        public int getListTimes() {
            return listTimes;
        }

        public void setListTimes(int listTimes) {
            this.listTimes = listTimes;
        }

        public int getPraiseTimes() {
            return praiseTimes;
        }

        public void setPraiseTimes(int praiseTimes) {
            this.praiseTimes = praiseTimes;
        }
    }
}
