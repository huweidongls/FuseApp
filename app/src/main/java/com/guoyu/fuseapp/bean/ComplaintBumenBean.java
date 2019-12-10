package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/19.
 */

public class ComplaintBumenBean {
    /**
     * status : 200
     * data : [{"id":1,"depCode":"测试","depName":"精纳小垃圾部门","isDelete":1}]
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
         * depCode : 测试
         * depName : 精纳小垃圾部门
         * isDelete : 1
         */

        private int id;
        private String depCode;
        private String depName;
        private int isDelete;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDepCode() {
            return depCode;
        }

        public void setDepCode(String depCode) {
            this.depCode = depCode;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }
    }
}
