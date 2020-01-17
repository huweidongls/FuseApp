package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class AppBookingBusinessqueryListDepBean {

    /**
     * status : 200
     * data : [{"id":602,"depName":"尖山区人社局"},{"id":603,"depName":"尖山区城管局"},{"id":604,"depName":"尖山区交通局"}]
     * totalPage : 0
     * totalCount : 3
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
         * id : 602
         * depName : 尖山区人社局
         */

        private int id;
        private String depName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }
    }
}
