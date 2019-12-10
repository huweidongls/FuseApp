package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/19.
 */

public class JaizhengListBean {

    /**
     * status : 200
     * data : [{"id":2,"title":"标题","topPic":"标题图片","contentTop":"简介","money":100},{"id":65536,"title":"标题","topPic":"标题图片","contentTop":"简介","money":50}]
     * totalPage : 0
     * totalCount : 2
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
         * id : 2
         * title : 标题
         * topPic : 标题图片
         * contentTop : 简介
         * money : 100
         */

        private int id;
        private String title;
        private String topPic;
        private String contentTop;
        private int money;

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

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }
}
