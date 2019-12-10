package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 */

public class GovernmentServiceTypeBean {
    /**
     * status : 200
     * data : [{"id":1,"subName":"卫生保健"},{"id":2,"subName":"文化"},{"id":3,"subName":"教育"}]
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
         * id : 1
         * subName : 卫生保健
         */

        private int id;
        private String subName;

        public DataBean(int id, String subName) {
            this.id = id;
            this.subName = subName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }
    }
}
