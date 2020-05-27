package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/5/27.
 */

public class AppAppointmentqueryListBean {

    /**
     * status : 200
     * data : [{"id":1,"areaName":"预约大厅","pid":0,"createTime":"2020-05-26 17:15:28","createName":"rexyu012","createId":141}]
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
         * id : 1
         * areaName : 预约大厅
         * pid : 0
         * createTime : 2020-05-26 17:15:28
         * createName : rexyu012
         * createId : 141
         */

        private int id;
        private String areaName;
        private int pid;
        private String createTime;
        private String createName;
        private int createId;
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

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
    }
}
