package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/12.
 */

public class Fragment3Bean {
    /**
     * status : 200
     * data : [{"id":4,"title":"标题","content":"内容","contentPics":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png"},{"id":2,"title":"测试标题","content":"内容","contentPics":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png"},{"id":1,"title":"标题","content":"内容","contentPics":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png"},{"id":3,"title":"标题","content":"内容","contentPics":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png"}]
     * totalPage : 1
     * totalCount : 4
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
         * id : 4
         * title : 标题
         * content : 内容
         * contentPics : upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png
         */

        private int id;
        private String title;
        private String content;
        private String contentPics;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContentPics() {
            return contentPics;
        }

        public void setContentPics(String contentPics) {
            this.contentPics = contentPics;
        }
    }
}
