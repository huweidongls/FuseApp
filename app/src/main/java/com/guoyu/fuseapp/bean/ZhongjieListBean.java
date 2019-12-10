package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */

public class ZhongjieListBean {

    /**
     * status : 200
     * data : [{"id":751,"title":"测试中介服务","contentShort":"测试中介服务","content":"嘻嘻嘻嘻","deptId":1,"statusid":2,"createDate":"2019-10-21 19:09:49","createUser":651,"publishDate":"2019-10-21 19:09:49","publishUser":651},{"id":752,"title":"测试中介服务","contentShort":"测试中介服务","content":"嘻嘻嘻嘻","deptId":1,"statusid":2,"createDate":"2019-10-21 19:10:55","createUser":651,"publishDate":"2019-10-21 19:09:49","publishUser":651},{"id":753,"title":"测试中介服务1","contentShort":"测试中介服务1","content":"嘻嘻嘻嘻","deptId":1,"statusid":2,"createDate":"2019-10-21 19:15:08","createUser":651,"publishDate":"2019-10-21 19:09:49","publishUser":651}]
     * totalPage : 0
     * totalCount : 3
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
         * id : 751
         * title : 测试中介服务
         * contentShort : 测试中介服务
         * content : 嘻嘻嘻嘻
         * deptId : 1
         * statusid : 2
         * createDate : 2019-10-21 19:09:49
         * createUser : 651
         * publishDate : 2019-10-21 19:09:49
         * publishUser : 651
         */

        private int id;
        private String title;
        private String contentShort;
        private String content;
        private int deptId;
        private int statusid;
        private String createDate;
        private int createUser;
        private String publishDate;
        private int publishUser;
        private String depName;

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContentShort() {
            return contentShort;
        }

        public void setContentShort(String contentShort) {
            this.contentShort = contentShort;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public int getStatusid() {
            return statusid;
        }

        public void setStatusid(int statusid) {
            this.statusid = statusid;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public int getPublishUser() {
            return publishUser;
        }

        public void setPublishUser(int publishUser) {
            this.publishUser = publishUser;
        }
    }
}
