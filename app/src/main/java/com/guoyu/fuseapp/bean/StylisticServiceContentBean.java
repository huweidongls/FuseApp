package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/22.
 */

public class StylisticServiceContentBean {
    /**
     * status : 200
     * data : {"id":1,"title":"标题1","content":"内容","topPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png","publishDate":"2019-10-10 14:07:27","intro":"简介","activityTime":"晚六点","activityPlace":"中央大街"}
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
         * title : 标题1
         * content : 内容
         * topPic : upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png
         * publishDate : 2019-10-10 14:07:27
         * intro : 简介
         * activityTime : 晚六点
         * activityPlace : 中央大街
         */

        private int id;
        private String title;
        private String content;
        private String topPic;
        private String publishDate;
        private String intro;
        private String activityTime;
        private String activityPlace;

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

        public String getTopPic() {
            return topPic;
        }

        public void setTopPic(String topPic) {
            this.topPic = topPic;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getActivityTime() {
            return activityTime;
        }

        public void setActivityTime(String activityTime) {
            this.activityTime = activityTime;
        }

        public String getActivityPlace() {
            return activityPlace;
        }

        public void setActivityPlace(String activityPlace) {
            this.activityPlace = activityPlace;
        }
    }
}
