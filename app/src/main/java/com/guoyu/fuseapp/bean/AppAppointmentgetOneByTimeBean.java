package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/5/27.
 */

public class AppAppointmentgetOneByTimeBean implements Serializable {

    /**
     * status : 200
     * data : {"appointmentHall":{"id":2,"areaName":"市市场监督管理局","pid":51,"createTime":"2020-05-26 17:21:24","createName":"admin","createId":100001,"areaTitle":"title","areaContent":"content","overContent":"chenggong"},"list":[{"id":1865,"hallId":2,"timeId":1,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"8:30-9:30"},{"id":1857,"hallId":2,"timeId":1,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"8:30-9:30"},{"id":1866,"hallId":2,"timeId":2,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"9:30-10:30"},{"id":1858,"hallId":2,"timeId":2,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"9:30-10:30"},{"id":1867,"hallId":2,"timeId":3,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"10:30-11:30"}]}
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

    public static class DataBean implements Serializable {
        /**
         * appointmentHall : {"id":2,"areaName":"市市场监督管理局","pid":51,"createTime":"2020-05-26 17:21:24","createName":"admin","createId":100001,"areaTitle":"title","areaContent":"content","overContent":"chenggong"}
         * list : [{"id":1865,"hallId":2,"timeId":1,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"8:30-9:30"},{"id":1857,"hallId":2,"timeId":1,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"8:30-9:30"},{"id":1866,"hallId":2,"timeId":2,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"9:30-10:30"},{"id":1858,"hallId":2,"timeId":2,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"9:30-10:30"},{"id":1867,"hallId":2,"timeId":3,"nyrTime":"2020-06-22","num":10,"createTime":"2020-06-17 16:30:00","timeSlot":"10:30-11:30"}]
         */

        private AppointmentHallBean appointmentHall;
        private List<ListBean> list;

        public AppointmentHallBean getAppointmentHall() {
            return appointmentHall;
        }

        public void setAppointmentHall(AppointmentHallBean appointmentHall) {
            this.appointmentHall = appointmentHall;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class AppointmentHallBean implements Serializable {
            /**
             * id : 2
             * areaName : 市市场监督管理局
             * pid : 51
             * createTime : 2020-05-26 17:21:24
             * createName : admin
             * createId : 100001
             * areaTitle : title
             * areaContent : content
             * overContent : chenggong
             */

            private int id;
            private String areaName;
            private int pid;
            private String createTime;
            private String createName;
            private int createId;
            private String areaTitle;
            private String areaContent;
            private String overContent;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public int getCreateId() {
                return createId;
            }

            public void setCreateId(int createId) {
                this.createId = createId;
            }

            public String getAreaTitle() {
                return areaTitle;
            }

            public void setAreaTitle(String areaTitle) {
                this.areaTitle = areaTitle;
            }

            public String getAreaContent() {
                return areaContent;
            }

            public void setAreaContent(String areaContent) {
                this.areaContent = areaContent;
            }

            public String getOverContent() {
                return overContent;
            }

            public void setOverContent(String overContent) {
                this.overContent = overContent;
            }
        }

        public static class ListBean implements Serializable {
            /**
             * id : 1865
             * hallId : 2
             * timeId : 1
             * nyrTime : 2020-06-22
             * num : 10
             * createTime : 2020-06-17 16:30:00
             * timeSlot : 8:30-9:30
             */

            private int id;
            private int hallId;
            private int timeId;
            private String nyrTime;
            private int num;
            private String createTime;
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

            public String getTimeSlot() {
                return timeSlot;
            }

            public void setTimeSlot(String timeSlot) {
                this.timeSlot = timeSlot;
            }
        }
    }
}
