package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/11/7.
 */

public class ShequBean {

    /**
     * status : 200
     * data : {"parentCommId":"10000","parentCommName":"康乐社区"}
     * errorMsg : 修改成功
     */

    private String status;
    private DataBean data;
    private String errorMsg;

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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * parentCommId : 10000
         * parentCommName : 康乐社区
         */

        private String parentCommId;
        private String parentCommName;

        public String getParentCommId() {
            return parentCommId;
        }

        public void setParentCommId(String parentCommId) {
            this.parentCommId = parentCommId;
        }

        public String getParentCommName() {
            return parentCommName;
        }

        public void setParentCommName(String parentCommName) {
            this.parentCommName = parentCommName;
        }
    }
}
