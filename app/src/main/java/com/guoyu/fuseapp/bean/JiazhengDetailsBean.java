package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/19.
 */

public class JiazhengDetailsBean {

    /**
     * status : 200
     * data : {"id":2,"title":"标题","topPic":"标题图片","contentTop":"简介","content":"商家信息","telephone":"13365479875"}
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
         * id : 2
         * title : 标题
         * topPic : 标题图片
         * contentTop : 简介
         * content : 商家信息
         * telephone : 13365479875
         */

        private int id;
        private String title;
        private String topPic;
        private String contentTop;
        private String content;
        private String telephone;
        private String address;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopPic() {
            return topPic;
        }

        public void setTopPic(String topPic) {
            this.topPic = topPic;
        }

        public String getContentTop() {
            return contentTop;
        }

        public void setContentTop(String contentTop) {
            this.contentTop = contentTop;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
    }
}
