package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/19.
 */

public class PolicyInteractionDetailsBean {

    /**
     * status : 200
     * data : {"comments":[{"id":651,"createDate":"2020-01-19 17:09:21","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"评论内容","interId":601,"likeNum":0},{"id":603,"createDate":"2020-01-19 11:45:44","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"测试评论2","interId":601,"likeNum":0},{"id":602,"createDate":"2020-01-19 11:45:20","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"测试评论2","interId":601,"likeNum":0},{"id":601,"createDate":"2020-01-19 11:45:13","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"测试评论","interId":601,"likeNum":2}],"interaction":{"id":601,"title":"测试标题1","publishDate":"2020-01-19 03:01:44","content":"测试内容","departmentName":"双鸭山教育局"}}
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
         * comments : [{"id":651,"createDate":"2020-01-19 17:09:21","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"评论内容","interId":601,"likeNum":0},{"id":603,"createDate":"2020-01-19 11:45:44","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"测试评论2","interId":601,"likeNum":0},{"id":602,"createDate":"2020-01-19 11:45:20","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"测试评论2","interId":601,"likeNum":0},{"id":601,"createDate":"2020-01-19 11:45:13","commentUserId":501,"commentUserName":"呵呵","commentUserPic":"头像","commentContent":"测试评论","interId":601,"likeNum":2}]
         * interaction : {"id":601,"title":"测试标题1","publishDate":"2020-01-19 03:01:44","content":"测试内容","departmentName":"双鸭山教育局"}
         */

        private InteractionBean interaction;
        private List<CommentsBean> comments;

        public InteractionBean getInteraction() {
            return interaction;
        }

        public void setInteraction(InteractionBean interaction) {
            this.interaction = interaction;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class InteractionBean {
            /**
             * id : 601
             * title : 测试标题1
             * publishDate : 2020-01-19 03:01:44
             * content : 测试内容
             * departmentName : 双鸭山教育局
             */

            private int id;
            private String title;
            private String publishDate;
            private String content;
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

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }
        }

        public static class CommentsBean {
            /**
             * id : 651
             * createDate : 2020-01-19 17:09:21
             * commentUserId : 501
             * commentUserName : 呵呵
             * commentUserPic : 头像
             * commentContent : 评论内容
             * interId : 601
             * likeNum : 0
             */

            private int id;
            private String createDate;
            private int commentUserId;
            private String commentUserName;
            private String commentUserPic;
            private String commentContent;
            private int interId;
            private int likeNum;
            private int isZan = 0;

            public int getIsZan() {
                return isZan;
            }

            public void setIsZan(int isZan) {
                this.isZan = isZan;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getCommentUserId() {
                return commentUserId;
            }

            public void setCommentUserId(int commentUserId) {
                this.commentUserId = commentUserId;
            }

            public String getCommentUserName() {
                return commentUserName;
            }

            public void setCommentUserName(String commentUserName) {
                this.commentUserName = commentUserName;
            }

            public String getCommentUserPic() {
                return commentUserPic;
            }

            public void setCommentUserPic(String commentUserPic) {
                this.commentUserPic = commentUserPic;
            }

            public String getCommentContent() {
                return commentContent;
            }

            public void setCommentContent(String commentContent) {
                this.commentContent = commentContent;
            }

            public int getInterId() {
                return interId;
            }

            public void setInterId(int interId) {
                this.interId = interId;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
