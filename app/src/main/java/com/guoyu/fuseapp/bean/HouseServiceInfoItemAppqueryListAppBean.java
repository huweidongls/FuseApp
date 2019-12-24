package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/12/24.
 */

public class HouseServiceInfoItemAppqueryListAppBean {

    /**
     * status : 200
     * data : [{"id":53,"typeName":"打代码","createDate":"2019-12-24 11:14:22"},{"id":52,"typeName":"派派","createDate":"2019-12-24 11:14:06"},{"id":51,"typeName":"扫地","createDate":"2019-12-24 11:13:52"}]
     * totalPage : 0
     * totalCount : 3
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
         * id : 53
         * typeName : 打代码
         * createDate : 2019-12-24 11:14:22
         */

        private int id;
        private String typeName;
        private String createDate;

        public DataBean(String typeName) {
            this.typeName = typeName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }
    }
}
