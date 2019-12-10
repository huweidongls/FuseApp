package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/11.
 */

public class UserGetOneBean {

    /**
     * status : 200
     * data : {"id":501,"userPic":"/upload/appHeadPhoto/ec017de9b5646ad8f833ca7f34fd04d.jpg","username":"18686817319","psd":"0b3ce46259443805ebd3707e9c892125","isDelete":1,"phone":"18686817319","realName":"恐龙个","status":2,"apprOpp":"我龙哥说通过就通过","apprUser":61,"appuserPics":"/upload/appHeadPhoto/d71ccfda8450446bb10d9d48a64b5872.jpg,/upload/appHeadPhoto/d5de3a05153f4129b5e794b21ecc4412.jpg,","appuserId":"6465695956464","community":10000,"waterNo":"36","eleNo":"56","ssNo":"123","foundNo":"123","carNo":"123","autonymName":0,"nameSex":"男","communityInfo":10000,"adminRealName":"东哥好几把大","commName":"损塞小区2"}
     * errorMsg : 获取用户个人信息
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
         * id : 501
         * userPic : /upload/appHeadPhoto/ec017de9b5646ad8f833ca7f34fd04d.jpg
         * username : 18686817319
         * psd : 0b3ce46259443805ebd3707e9c892125
         * isDelete : 1
         * phone : 18686817319
         * realName : 恐龙个
         * status : 2
         * apprOpp : 我龙哥说通过就通过
         * apprUser : 61
         * appuserPics : /upload/appHeadPhoto/d71ccfda8450446bb10d9d48a64b5872.jpg,/upload/appHeadPhoto/d5de3a05153f4129b5e794b21ecc4412.jpg,
         * appuserId : 6465695956464
         * community : 10000
         * waterNo : 36
         * eleNo : 56
         * ssNo : 123
         * foundNo : 123
         * carNo : 123
         * autonymName : 0
         * nameSex : 男
         * communityInfo : 10000
         * adminRealName : 东哥好几把大
         * commName : 损塞小区2
         */

        private int id;
        private String userPic;
        private String username;
        private String psd;
        private int isDelete;
        private String phone;
        private String realName;
        private int status;
        private String apprOpp;
        private int apprUser;
        private String appuserPics;
        private String appuserId;
        private int community;//社区id
        private String waterNo;
        private String eleNo;
        private String ssNo;
        private String foundNo;
        private String carNo;
        private int autonymName;
        private String nameSex;
        private int communityInfo;
        private String adminRealName;
        private String commName;
        private String nick;
        private String address;//家庭住址
        private String communityName;//社区名称

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
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

        public String getApprOpp() {
            return apprOpp;
        }

        public void setApprOpp(String apprOpp) {
            this.apprOpp = apprOpp;
        }

        public int getApprUser() {
            return apprUser;
        }

        public void setApprUser(int apprUser) {
            this.apprUser = apprUser;
        }

        public String getAppuserPics() {
            return appuserPics;
        }

        public void setAppuserPics(String appuserPics) {
            this.appuserPics = appuserPics;
        }

        public String getAppuserId() {
            return appuserId;
        }

        public void setAppuserId(String appuserId) {
            this.appuserId = appuserId;
        }

        public int getCommunity() {
            return community;
        }

        public void setCommunity(int community) {
            this.community = community;
        }

        public String getWaterNo() {
            return waterNo;
        }

        public void setWaterNo(String waterNo) {
            this.waterNo = waterNo;
        }

        public String getEleNo() {
            return eleNo;
        }

        public void setEleNo(String eleNo) {
            this.eleNo = eleNo;
        }

        public String getSsNo() {
            return ssNo;
        }

        public void setSsNo(String ssNo) {
            this.ssNo = ssNo;
        }

        public String getFoundNo() {
            return foundNo;
        }

        public void setFoundNo(String foundNo) {
            this.foundNo = foundNo;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public int getAutonymName() {
            return autonymName;
        }

        public void setAutonymName(int autonymName) {
            this.autonymName = autonymName;
        }

        public String getNameSex() {
            return nameSex;
        }

        public void setNameSex(String nameSex) {
            this.nameSex = nameSex;
        }

        public int getCommunityInfo() {
            return communityInfo;
        }

        public void setCommunityInfo(int communityInfo) {
            this.communityInfo = communityInfo;
        }

        public String getAdminRealName() {
            return adminRealName;
        }

        public void setAdminRealName(String adminRealName) {
            this.adminRealName = adminRealName;
        }

        public String getCommName() {
            return commName;
        }

        public void setCommName(String commName) {
            this.commName = commName;
        }
    }
}
