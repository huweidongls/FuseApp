package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/22.
 */

public class StylisticServiceListBean {

    /**
     * status : 200
     * data : {"picture":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png","lists":[{"id":2,"title":"标题","topPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png","intro":"简介","activityTime":"晚六点","activityPlace":"索菲亚教堂"},{"id":1,"title":"标题1","topPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png","intro":"简介","activityTime":"晚六点","activityPlace":"中央大街"}]}
     * totalPage : 1
     * totalCount : 2
     */

    private String status;
    private DataBean data;
    private int totalPage;
    private int totalCount;

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

    public static class DataBean {
        /**
         * picture : upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png
         * lists : [{"id":2,"title":"标题","topPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png","intro":"简介","activityTime":"晚六点","activityPlace":"索菲亚教堂"},{"id":1,"title":"标题1","topPic":"upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png","intro":"简介","activityTime":"晚六点","activityPlace":"中央大街"}]
         */

        private String picture;
        private List<ListsBean> lists;

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public List<ListsBean> getLists() {
            return lists;
        }

        public void setLists(List<ListsBean> lists) {
            this.lists = lists;
        }

        public static class ListsBean {
            /**
             * id : 2
             * title : 标题
             * topPic : upload/banner/2019-10-11/507daa59551140bc8af4c5de68acb7b9.png
             * intro : 简介
             * activityTime : 晚六点
             * activityPlace : 索菲亚教堂
             */

            private int id;
            private String title;
            private String topPic;
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

            public String getTopPic() {
                return topPic;
            }

            public void setTopPic(String topPic) {
                this.topPic = topPic;
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
}
