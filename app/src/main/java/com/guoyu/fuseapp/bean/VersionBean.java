package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/21.
 */

public class VersionBean {

    /**
     * status : 200
     * data : {"id":702,"versionname":"1.0.2","versioncode":2,"downloadAdd":"下载地址1","verDesc":"版本描述1","isAutoupdate":0}
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
         * id : 702
         * versionname : 1.0.2
         * versioncode : 2
         * downloadAdd : 下载地址1
         * verDesc : 版本描述1
         * isAutoupdate : 0
         */

        private int id;
        private String versionname;
        private int versioncode;
        private String downloadAdd;
        private String verDesc;
        private int isAutoupdate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVersionname() {
            return versionname;
        }

        public void setVersionname(String versionname) {
            this.versionname = versionname;
        }

        public int getVersioncode() {
            return versioncode;
        }

        public void setVersioncode(int versioncode) {
            this.versioncode = versioncode;
        }

        public String getDownloadAdd() {
            return downloadAdd;
        }

        public void setDownloadAdd(String downloadAdd) {
            this.downloadAdd = downloadAdd;
        }

        public String getVerDesc() {
            return verDesc;
        }

        public void setVerDesc(String verDesc) {
            this.verDesc = verDesc;
        }

        public int getIsAutoupdate() {
            return isAutoupdate;
        }

        public void setIsAutoupdate(int isAutoupdate) {
            this.isAutoupdate = isAutoupdate;
        }
    }
}
