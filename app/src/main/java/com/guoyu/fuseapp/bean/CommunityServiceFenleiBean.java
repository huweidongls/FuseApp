package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class CommunityServiceFenleiBean {
    /**
     * status : 200
     * data : [{"id":16,"subName":"社区信息"},{"id":17,"subName":"房屋修改信息"},{"id":18,"subName":"楼道卫生"}]
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
         * id : 16
         * subName : 社区信息
         */

        private int id;
        private String subName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }
    }
}
