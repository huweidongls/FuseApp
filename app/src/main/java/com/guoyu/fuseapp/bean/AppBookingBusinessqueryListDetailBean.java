package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class AppBookingBusinessqueryListDetailBean {

    /**
     * status : 200
     * data : [{"id":601,"detailsName":"食品营业许可（变更法定达标人或者负责人）"},{"id":602,"detailsName":"食品营业许可（变更法定达标人或者负责人）1"},{"id":603,"detailsName":"食品营业许可（变更法定达标人或者负责人）2"}]
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
         * id : 601
         * detailsName : 食品营业许可（变更法定达标人或者负责人）
         */

        private int id;
        private String detailsName;

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
    }
}
