package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/11.
 */

public class ComplaintDetailBean {
    /**
     * status : 200
     * data : {"id":60005,"title":"已反馈1","contentTop":"已反馈副标题1","consType":4,"content":"500呢","statusid":3,"createUser":651,"feeMemo":"500呢","feeUser":651,"feeStatus":1,"feeDate":"2019-09-26","createDate":"2019-09-25","username":"未实名认证用户","userPic":"/upload/appHeadPhoto/ec017de9b5646ad8f833ca7f34fd04d.jpg","feeUserName":"未实名认证用户"}
     */

    private String status;
    private DataBean data;

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

    public static class DataBean {
        /**
         * id : 60005
         * title : 已反馈1
         * contentTop : 已反馈副标题1
         * consType : 4
         * content : 500呢
         * statusid : 3
         * createUser : 651
         * feeMemo : 500呢
         * feeUser : 651
         * feeStatus : 1
         * feeDate : 2019-09-26
         * createDate : 2019-09-25
         * username : 未实名认证用户
         * userPic : /upload/appHeadPhoto/ec017de9b5646ad8f833ca7f34fd04d.jpg
         * feeUserName : 未实名认证用户
         */

        private int id;
        private String title;
        private String contentTop;
        private int consType;
        private String content;
        private int statusid;
        private int createUser;
        private String feeMemo;
        private int feeUser;
        private int feeStatus;
        private String feeDate;
        private String createDate;
        private String username;
        private String userPic;
        private String feeUserName;
        private String deptName;
        private String consTypeName;
        private String contentPic;

        public String getContentPic(){
            return contentPic;
        }

        public void setContentPic(String contentPic){
            this.contentPic = contentPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getConsTypeName(){
            return consTypeName;
        }

        public void setConsTypeName(String consTypeName){
            this.consTypeName = consTypeName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContentTop() {
            return contentTop;
        }

        public void setContentTop(String contentTop) {
            this.contentTop = contentTop;
        }

        public int getConsType() {
            return consType;
        }

        public void setConsType(int consType) {
            this.consType = consType;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatusid() {
            return statusid;
        }

        public void setStatusid(int statusid) {
            this.statusid = statusid;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public String getFeeMemo() {
            return feeMemo;
        }

        public void setFeeMemo(String feeMemo) {
            this.feeMemo = feeMemo;
        }

        public int getFeeUser() {
            return feeUser;
        }

        public void setFeeUser(int feeUser) {
            this.feeUser = feeUser;
        }

        public int getFeeStatus() {
            return feeStatus;
        }

        public void setFeeStatus(int feeStatus) {
            this.feeStatus = feeStatus;
        }

        public String getFeeDate() {
            return feeDate;
        }

        public void setFeeDate(String feeDate) {
            this.feeDate = feeDate;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserPic() {
            return userPic;
        }

        public void setUserPic(String userPic) {
            this.userPic = userPic;
        }

        public String getFeeUserName() {
            return feeUserName;
        }

        public void setFeeUserName(String feeUserName) {
            this.feeUserName = feeUserName;
        }
        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }
    }
}
