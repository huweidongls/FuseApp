package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/11.
 */

public class GovernmentListBean {

    /**
     * status : 200
     * data : [{"id":65535,"title":"标题","govTypeName":"卫生保健"},{"id":65536,"title":"标题","govTypeName":"卫生保健"}]
     * totalPage : 1
     * totalCount : 2
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
         * id : 65535
         * title : 标题
         * govTypeName : 卫生保健
         */

        private int id;
        private String title;
        private String govTypeName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGovTypeName() {
            return govTypeName;
        }

        public void setGovTypeName(String govTypeName) {
            this.govTypeName = govTypeName;
        }
    }
}
