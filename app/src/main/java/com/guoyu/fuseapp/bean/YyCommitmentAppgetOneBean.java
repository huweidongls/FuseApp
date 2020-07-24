package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2020/7/17.
 */

public class YyCommitmentAppgetOneBean {

    /**
     * status : 200
     * data : {"id":1,"commitment":"本人郑重承诺信息123123","commitmentSize":6,"title":"免责声明标题123","content":"<p>免责声明富文本1234123<\/p>","imgurl":"upload/null/2020-07-24/223646fa46d242539f93fa8f451ca1b7.jpg"}
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
         * commitment : 本人郑重承诺信息123123
         * commitmentSize : 6
         * title : 免责声明标题123
         * content : <p>免责声明富文本1234123</p>
         * imgurl : upload/null/2020-07-24/223646fa46d242539f93fa8f451ca1b7.jpg
         */

        private int id;
        private String commitment;
        private int commitmentSize;
        private String title;
        private String content;
        private String imgurl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCommitment() {
            return commitment;
        }

        public void setCommitment(String commitment) {
            this.commitment = commitment;
        }

        public int getCommitmentSize() {
            return commitmentSize;
        }

        public void setCommitmentSize(int commitmentSize) {
            this.commitmentSize = commitmentSize;
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

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }
    }
}
