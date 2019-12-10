package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/12.
 */

public class IndexZwznBean {

    /**
     * status : 200
     * data : {"list1":[{"id":65536,"title":"标题"},{"id":65535,"title":"标题"}],"list2":[{"id":65536,"title":"标题"},{"id":65535,"title":"标题"}]}
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
        private List<List1Bean> list1;
        private List<List2Bean> list2;

        public List<List1Bean> getList1() {
            return list1;
        }

        public void setList1(List<List1Bean> list1) {
            this.list1 = list1;
        }

        public List<List2Bean> getList2() {
            return list2;
        }

        public void setList2(List<List2Bean> list2) {
            this.list2 = list2;
        }

        public static class List1Bean {
            /**
             * id : 65536
             * title : 标题
             */

            private int id;
            private String title;

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
        }

        public static class List2Bean {
            /**
             * id : 65536
             * title : 标题
             */

            private int id;
            private String title;

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
        }
    }
}
