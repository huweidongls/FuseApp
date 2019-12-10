package com.guoyu.fuseapp.bean;

import java.util.List;

import me.zhouzhuo.zzletterssidebar.anotation.Letter;
import me.zhouzhuo.zzletterssidebar.entity.SortModel;

/**
 * Created by Administrator on 2019/10/22.
 */

public class XiaoquListBean extends SortModel {

    /**
     * status : 200
     * data : [{"id":10000,"commCode":"XIXIXI","commName":"损塞小区2","parentCommId":10000,"isDelete":1},{"id":21,"commCode":"CSXQ1","commName":"测试小区1","parentCommId":10001,"isDelete":1}]
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

    public static class DataBean extends SortModel {
        /**
         * id : 10000
         * commCode : XIXIXI
         * commName : 损塞小区2
         * parentCommId : 10000
         * isDelete : 1
         */

        private int id;
        private String commCode;
        @Letter(isSortField = true)
        private String commName;
        private int parentCommId;
        private int isDelete;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCommCode() {
            return commCode;
        }

        public void setCommCode(String commCode) {
            this.commCode = commCode;
        }

        public String getCommName() {
            return commName;
        }

        public void setCommName(String commName) {
            this.commName = commName;
        }

        public int getParentCommId() {
            return parentCommId;
        }

        public void setParentCommId(int parentCommId) {
            this.parentCommId = parentCommId;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }
    }
}
