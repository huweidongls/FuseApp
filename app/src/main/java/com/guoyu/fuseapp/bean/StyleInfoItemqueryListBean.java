package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/12/23.
 */

public class StyleInfoItemqueryListBean {

    /**
     * status : 200
     * data : [{"id":108,"siiType":"string3","createDate":"2019-12-23 16:47:28"},{"id":107,"siiType":"string2","createDate":"2019-12-23 16:47:22"},{"id":106,"siiType":"string1","createDate":"2019-12-23 16:47:11"},{"id":105,"siiType":"string","createDate":"2019-12-23 16:45:00"}]
     * totalPage : 0
     * totalCount : 4
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
         * id : 108
         * siiType : string3
         * createDate : 2019-12-23 16:47:28
         */

        private int id;
        private String siiType;
        private String createDate;

        public DataBean(String siiType) {
            this.siiType = siiType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSiiType() {
            return siiType;
        }

        public void setSiiType(String siiType) {
            this.siiType = siiType;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }
    }
}
