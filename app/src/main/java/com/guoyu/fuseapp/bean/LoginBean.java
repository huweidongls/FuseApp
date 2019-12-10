package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/10.
 */

public class LoginBean {

    /**
     * status : 200
     * errorMsg : 登录成功
     * data : {"id":401,"username":"44","psd":"***","phone":"44"}
     * appToken : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0NCIsImNyZWF0ZWQiOjE1NzA2Nzg0OTgzNTgsImlzcyI6NDAxLCJleHAiOjE1NzEyODMyOTh9.M9YmeH5bXdh32IXDaLDbBqg9nUp5OioA9mVcAT7xS2FvZ1grdMzJ_MvhNltxwWbSnHcIx6ELWH1ZIe3jNzakBA
     */

    private String status;
    private String errorMsg;
    private DataBean data;
    private String appToken;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public static class DataBean {
        /**
         * id : 401
         * username : 44
         * psd : ***
         * phone : 44
         */

        private int id;
        private String username;
        private String psd;
        private String phone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPsd() {
            return psd;
        }

        public void setPsd(String psd) {
            this.psd = psd;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
