package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class IndexBean {

    /**
     * status : 200
     * data : [{"urlType":3,"publishDate":"2019-10-09","id":22,"androidModularUrl":"com.guoyu.fuseapp.page.GobernmentContentActivity","title":"政务指南之樊哥今天必吃鸡政务指南之樊哥今天必吃鸡政务指南之樊哥今天必吃鸡","content":"具体提了了 了图鸡腿提提"},{"urlType":3,"publishDate":"2019-10-09","id":21,"androidModularUrl":"com.guoyu.fuseapp.page.GobernmentContentActivity","title":"政务指南之东哥吃不到鸡,哈哈哈","content":"盒子鱼闺秀是嘻嘻嘻嘻个差不多他我去洗澡了的 个个了 可以了快中冷做最空给我看一下了了 可以一直做快聚聚咯不补课邋遢啦咯提团团卤猪脚具体。"},{"urlType":3,"publishDate":"2019-10-09","id":65535,"androidModularUrl":"com.guoyu.fuseapp.page.GobernmentContentActivity","title":"政务指南之于哥孩子下楼跑","content":"内容"},{"urlType":3,"publishDate":"2019-10-09","id":65536,"androidModularUrl":"com.guoyu.fuseapp.page.GobernmentContentActivity","title":"政务指南之社会润泽带条哈士奇","content":"内容"}]
     */

    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * urlType : 3
         * publishDate : 2019-10-09
         * id : 22
         * androidModularUrl : com.guoyu.fuseapp.page.GobernmentContentActivity
         * title : 政务指南之樊哥今天必吃鸡政务指南之樊哥今天必吃鸡政务指南之樊哥今天必吃鸡
         * content : 具体提了了 了图鸡腿提提
         */

        private int urlType;
        private String publishDate;
        private int id;
        private String androidModularUrl;
        private String title;
        private String content;
        private String modularUrl;
        private int unregSee;
        private String funName;
        private String funCode;

        public String getFunCode() {
            return funCode;
        }

        public void setFunCode(String funCode) {
            this.funCode = funCode;
        }

        public String getFunName() {
            return funName;
        }

        public void setFunName(String funName) {
            this.funName = funName;
        }

        public int getUnregSee() {
            return unregSee;
        }

        public void setUnregSee(int unregSee) {
            this.unregSee = unregSee;
        }

        public String getModularUrl() {
            return modularUrl;
        }

        public void setModularUrl(String modularUrl) {
            this.modularUrl = modularUrl;
        }

        public int getUrlType() {
            return urlType;
        }

        public void setUrlType(int urlType) {
            this.urlType = urlType;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAndroidModularUrl() {
            return androidModularUrl;
        }

        public void setAndroidModularUrl(String androidModularUrl) {
            this.androidModularUrl = androidModularUrl;
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
    }
}
