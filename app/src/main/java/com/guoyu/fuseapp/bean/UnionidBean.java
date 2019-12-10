package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/25.
 */

public class UnionidBean {

    /**
     * status : 200
     * data : {"status":"200","data":{"id":651,"userPic":"/upload/appHeadPhoto/90023db1315c4135b797fb2c7f0a127c.jpeg,","username":"15244615473","psd":"***","isDelete":1,"createDate":"2019-09-22 18:00:00","phone":"15244615473","realName":"未实名认证用户","status":1,"appuserId":"2110222200000000000","autonymName":0,"communityInfo":10018,"unionid":"oVcZV58S_QYU8jnWa1ocy-o6Hofk"},"appToken":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTI0NDYxNTQ3MyIsImNyZWF0ZWQiOjE1NzE5ODQzMzIzODksImlzcyI6NjUxLCJleHAiOjE1NzI1ODkxMzJ9.7ZLILgHvTfF7pnPd66quXIjlu8kOIaKfFLbTX9FedsKBx0hafBW87JLlv3mGwC2wCc9JpCQdvJ1c-Lj7yVklvg=app"}
     */

    private String status;
    private DataBeanX data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * status : 200
         * data : {"id":651,"userPic":"/upload/appHeadPhoto/90023db1315c4135b797fb2c7f0a127c.jpeg,","username":"15244615473","psd":"***","isDelete":1,"createDate":"2019-09-22 18:00:00","phone":"15244615473","realName":"未实名认证用户","status":1,"appuserId":"2110222200000000000","autonymName":0,"communityInfo":10018,"unionid":"oVcZV58S_QYU8jnWa1ocy-o6Hofk"}
         * appToken : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTI0NDYxNTQ3MyIsImNyZWF0ZWQiOjE1NzE5ODQzMzIzODksImlzcyI6NjUxLCJleHAiOjE1NzI1ODkxMzJ9.7ZLILgHvTfF7pnPd66quXIjlu8kOIaKfFLbTX9FedsKBx0hafBW87JLlv3mGwC2wCc9JpCQdvJ1c-Lj7yVklvg=app
         */

        private String status;
        private DataBean data;
        private String appToken;

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

        public String getAppToken() {
            return appToken;
        }

        public void setAppToken(String appToken) {
            this.appToken = appToken;
        }

        public static class DataBean {
            /**
             * id : 651
             * userPic : /upload/appHeadPhoto/90023db1315c4135b797fb2c7f0a127c.jpeg,
             * username : 15244615473
             * psd : ***
             * isDelete : 1
             * createDate : 2019-09-22 18:00:00
             * phone : 15244615473
             * realName : 未实名认证用户
             * status : 1
             * appuserId : 2110222200000000000
             * autonymName : 0
             * communityInfo : 10018
             * unionid : oVcZV58S_QYU8jnWa1ocy-o6Hofk
             */

            private int id;
            private String userPic;
            private String username;
            private String psd;
            private int isDelete;
            private String createDate;
            private String phone;
            private String realName;
            private int status;
            private String appuserId;
            private int autonymName;
            private int communityInfo;
            private String unionid;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
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

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getAppuserId() {
                return appuserId;
            }

            public void setAppuserId(String appuserId) {
                this.appuserId = appuserId;
            }

            public int getAutonymName() {
                return autonymName;
            }

            public void setAutonymName(int autonymName) {
                this.autonymName = autonymName;
            }

            public int getCommunityInfo() {
                return communityInfo;
            }

            public void setCommunityInfo(int communityInfo) {
                this.communityInfo = communityInfo;
            }

            public String getUnionid() {
                return unionid;
            }

            public void setUnionid(String unionid) {
                this.unionid = unionid;
            }
        }
    }
}
