package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/5/27.
 */

public class AppAppointmentgetByAppointmentAppBean {

    /**
     * status : 200
     * data : [{"id":2,"username":"垃圾东","phone":"13000000000","idCard":"211022200000000000","hallId":2,"timeId":1,"nyrTime":"2020-05-27","createTime":"2020-05-27 17:13:56","timeSlot":"8:30-9:30","areaName":"市市场监督管理局"}]
     * totalPage : 1
     * totalCount : 1
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
         * id : 2
         * username : 垃圾东
         * phone : 13000000000
         * idCard : 211022200000000000
         * hallId : 2
         * timeId : 1
         * nyrTime : 2020-05-27
         * createTime : 2020-05-27 17:13:56
         * timeSlot : 8:30-9:30
         * areaName : 市市场监督管理局
         */

        private int id;
        private String username;
        private String phone;
        private String idCard;
        private int hallId;
        private int timeId;
        private String nyrTime;
        private String createTime;
        private String timeSlot;
        private String areaName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getHallId() {
            return hallId;
        }

        public void setHallId(int hallId) {
            this.hallId = hallId;
        }

        public int getTimeId() {
            return timeId;
        }

        public void setTimeId(int timeId) {
            this.timeId = timeId;
        }

        public String getNyrTime() {
            return nyrTime;
        }

        public void setNyrTime(String nyrTime) {
            this.nyrTime = nyrTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTimeSlot() {
            return timeSlot;
        }

        public void setTimeSlot(String timeSlot) {
            this.timeSlot = timeSlot;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }
    }
}
