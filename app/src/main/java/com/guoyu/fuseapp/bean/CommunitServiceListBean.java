package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class CommunitServiceListBean {
    /**
     * status : 200
     * data : [{"id":10000,"pcommName":"死鬼社区"},{"id":10001,"pcommName":"损色社区"}]
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

    public static class DataBean {
        /**
         * id : 10000
         * pcommName : 死鬼社区
         */

        private int id;
        private String pcommName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPcommName() {
            return pcommName;
        }

        public void setPcommName(String pcommName) {
            this.pcommName = pcommName;
        }
    }
}
