package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/5/27.
 */

public class AppAppointmentgetOneByTimeBean implements Serializable {

    /**
     * status : 200
     * data : [{"id":10000,"hallId":2,"timeId":1,"nyrTime":"2020-05-27","num":10,"createTime":"2020-05-27 16:42:10","updateName":"leng.mo","timeSlot":"8:30-9:30"},{"id":10001,"hallId":2,"timeId":2,"nyrTime":"2020-05-27","num":10,"createTime":"2020-05-27 16:42:10","updateName":"leng.mo","timeSlot":"9:30-10:30"},{"id":10002,"hallId":2,"timeId":3,"nyrTime":"2020-05-27","num":10,"createTime":"2020-05-27 16:42:10","updateName":"leng.mo","timeSlot":"10:30-11:30"},{"id":10003,"hallId":2,"timeId":4,"nyrTime":"2020-05-27","num":10,"createTime":"2020-05-27 16:42:10","updateName":"leng.mo","timeSlot":"13:30-14:30"},{"id":10004,"hallId":2,"timeId":5,"nyrTime":"2020-05-27","num":10,"createTime":"2020-05-27 16:42:10","updateName":"leng.mo","timeSlot":"14:30-15:30"},{"id":10005,"hallId":2,"timeId":6,"nyrTime":"2020-05-27","num":10,"createTime":"2020-05-27 16:42:10","updateName":"leng.mo","timeSlot":"15:30-16:30"}]
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
         * id : 10000
         * hallId : 2
         * timeId : 1
         * nyrTime : 2020-05-27
         * num : 10
         * createTime : 2020-05-27 16:42:10
         * updateName : leng.mo
         * timeSlot : 8:30-9:30
         */

        private int id;
        private int hallId;
        private int timeId;
        private String nyrTime;
        private int num;
        private String createTime;
        private String updateName;
        private String timeSlot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public String getTimeSlot() {
            return timeSlot;
        }

        public void setTimeSlot(String timeSlot) {
            this.timeSlot = timeSlot;
        }
    }
}
