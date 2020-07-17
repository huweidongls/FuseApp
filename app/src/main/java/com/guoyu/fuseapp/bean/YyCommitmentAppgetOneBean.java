package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2020/7/17.
 */

public class YyCommitmentAppgetOneBean {

    /**
     * status : 200
     * data : {"id":1,"commitment":"为疫情防控，本人同意以上信息依法提交所在辖区防疫部门统筹管理。","commitmentSize":10}
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
         * commitment : 为疫情防控，本人同意以上信息依法提交所在辖区防疫部门统筹管理。
         * commitmentSize : 10
         */

        private int id;
        private String commitment;
        private int commitmentSize;

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
    }
}
