package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class AppBookingBusinessqueryListHallBean {

    /**
     * status : 200
     * data : [{"id":601,"hallName":"尖山区政务服务中心","hallAdd":"双鸭山市尖山区工建路187号"},{"id":602,"hallName":"尖山区政务服务中心1","hallAdd":"双鸭山市尖山区工建路187号1"},{"id":603,"hallName":"尖山区政务服务中心2","hallAdd":"双鸭山市尖山区工建路187号2"}]
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
         * hallName : 尖山区政务服务中心
         * hallAdd : 双鸭山市尖山区工建路187号
         */

        private int id;
        private String hallName;
        private String hallAdd;

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

        public String getHallAdd() {
            return hallAdd;
        }

        public void setHallAdd(String hallAdd) {
            this.hallAdd = hallAdd;
        }
    }
}
