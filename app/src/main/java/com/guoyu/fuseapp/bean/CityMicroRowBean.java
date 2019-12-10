package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/21.
 */

public class CityMicroRowBean {

    /**
     * status : 200
     * data : {"id":1,"title":"红谷滩","contentTop":"ing你牛","content":"好在真去我婆婆无图如图","contentPic":"/upload/appHeadPhoto/ac1c10bf79754bb9987fcd29f1b563ef.jpg,/upload/appHeadPhoto/443e17ce6127430289e34c98b0459559.jpg"}
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
         * id : 1
         * title : 红谷滩
         * contentTop : ing你牛
         * content : 好在真去我婆婆无图如图
         * contentPic : /upload/appHeadPhoto/ac1c10bf79754bb9987fcd29f1b563ef.jpg,/upload/appHeadPhoto/443e17ce6127430289e34c98b0459559.jpg
         */

        private int id;
        private String title;
        private String contentTop;
        private String content;
        private String contentPic;

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

        public String getContentPic() {
            return contentPic;
        }

        public void setContentPic(String contentPic) {
            this.contentPic = contentPic;
        }
    }
}
