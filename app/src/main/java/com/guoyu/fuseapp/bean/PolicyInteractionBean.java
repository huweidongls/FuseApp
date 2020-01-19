package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/19.
 */

public class PolicyInteractionBean {
    /**
     * status : 200
     * data : {"governEnterInteraction":{"interaction":[{"id":603,"title":"测试标题2","titlePic":"测试图标2","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"},{"id":602,"title":"测试标题","titlePic":"测试图标","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"},{"id":601,"title":"测试标题","titlePic":"标题图片","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"}],"typeName":"政策咨询"},"picture":"upload/null/2019-11-11/e0ba206a0a314e99a9ff2bf8ae503782.png"}
     * totalPage : 0
     * totalCount : 3
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
         * governEnterInteraction : {"interaction":[{"id":603,"title":"测试标题2","titlePic":"测试图标2","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"},{"id":602,"title":"测试标题","titlePic":"测试图标","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"},{"id":601,"title":"测试标题","titlePic":"标题图片","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"}],"typeName":"政策咨询"}
         * picture : upload/null/2019-11-11/e0ba206a0a314e99a9ff2bf8ae503782.png
         */

        private GovernEnterInteractionBean governEnterInteraction;
        private String picture;

        public GovernEnterInteractionBean getGovernEnterInteraction() {
            return governEnterInteraction;
        }

        public void setGovernEnterInteraction(GovernEnterInteractionBean governEnterInteraction) {
            this.governEnterInteraction = governEnterInteraction;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public static class GovernEnterInteractionBean {
            /**
             * interaction : [{"id":603,"title":"测试标题2","titlePic":"测试图标2","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"},{"id":602,"title":"测试标题","titlePic":"测试图标","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"},{"id":601,"title":"测试标题","titlePic":"标题图片","publishDate":"2020-01-19 03:01:44","publishDepartment":1,"departmentName":"双鸭山教育局"}]
             * typeName : 政策咨询
             */

            private String typeName;
            private List<InteractionBean> interaction;

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public List<InteractionBean> getInteraction() {
                return interaction;
            }

            public void setInteraction(List<InteractionBean> interaction) {
                this.interaction = interaction;
            }

            public static class InteractionBean {
                /**
                 * id : 603
                 * title : 测试标题2
                 * titlePic : 测试图标2
                 * publishDate : 2020-01-19 03:01:44
                 * publishDepartment : 1
                 * departmentName : 双鸭山教育局
                 */

                private int id;
                private String title;
                private String titlePic;
                private String publishDate;
                private int publishDepartment;
                private String departmentName;

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

                public String getTitlePic() {
                    return titlePic;
                }

                public void setTitlePic(String titlePic) {
                    this.titlePic = titlePic;
                }

                public String getPublishDate() {
                    return publishDate;
                }

                public void setPublishDate(String publishDate) {
                    this.publishDate = publishDate;
                }

                public int getPublishDepartment() {
                    return publishDepartment;
                }

                public void setPublishDepartment(int publishDepartment) {
                    this.publishDepartment = publishDepartment;
                }

                public String getDepartmentName() {
                    return departmentName;
                }

                public void setDepartmentName(String departmentName) {
                    this.departmentName = departmentName;
                }
            }
        }
    }
}
