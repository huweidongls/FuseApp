package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/10/20.
 */

public class AppBusQuestionselectAllQuestionBean {

    /**
     * status : 200
     * data : [{"ID":"154","questionClassifyId":"1","questionClassify":"国庆问卷","questionName":"问题测试5","createTime":"2020-10-15 18:14:15","list":[{"id":65,"questionId":154,"questionOption":"选项1"},{"id":66,"questionId":154,"questionOption":"选项2","questionCount":1}]},{"ID":"153","questionClassifyId":"1","questionClassify":"国庆问卷","questionName":"问题测试4","createTime":"2020-10-15 18:14:13","list":[{"id":63,"questionId":153,"questionOption":"选项1"},{"id":64,"questionId":153,"questionOption":"选项2"}]},{"ID":"152","questionClassifyId":"1","questionClassify":"国庆问卷","questionName":"问题测试3","createTime":"2020-10-15 18:14:12","list":[{"id":61,"questionId":152,"questionOption":"选项1","questionCount":1},{"id":62,"questionId":152,"questionOption":"选项2"}]},{"ID":"151","questionClassifyId":"1","questionClassify":"国庆问卷","questionName":"问题测试2","createTime":"2020-10-15 18:14:08","list":[{"id":59,"questionId":151,"questionOption":"选项1"},{"id":60,"questionId":151,"questionOption":"选项2"}]},{"ID":"251","questionClassifyId":"1","questionClassify":"国庆问卷","questionName":"xxxx","createTime":"2020-10-19 16:28:38","list":[{"id":160,"questionId":251,"questionOption":"sdfjklsadjfkl"},{"id":161,"questionId":251,"questionOption":"asdfsaf"},{"id":162,"questionId":251,"questionOption":"asdf"},{"id":163,"questionId":251,"questionOption":"asdfs"}]},{"ID":"107","questionClassifyId":"1","questionClassify":"国庆问卷","questionName":"问题测试1","createTime":"2020-10-15 17:52:26","list":[{"id":57,"questionId":107,"questionOption":"选项11"},{"id":58,"questionId":107,"questionOption":"选项22"}]}]
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
         * ID : 154
         * questionClassifyId : 1
         * questionClassify : 国庆问卷
         * questionName : 问题测试5
         * createTime : 2020-10-15 18:14:15
         * list : [{"id":65,"questionId":154,"questionOption":"选项1"},{"id":66,"questionId":154,"questionOption":"选项2","questionCount":1}]
         */

        private String ID;
        private String questionClassifyId;
        private String questionClassify;
        private String questionName;
        private String createTime;
        private List<ListBean> list;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getQuestionClassifyId() {
            return questionClassifyId;
        }

        public void setQuestionClassifyId(String questionClassifyId) {
            this.questionClassifyId = questionClassifyId;
        }

        public String getQuestionClassify() {
            return questionClassify;
        }

        public void setQuestionClassify(String questionClassify) {
            this.questionClassify = questionClassify;
        }

        public String getQuestionName() {
            return questionName;
        }

        public void setQuestionName(String questionName) {
            this.questionName = questionName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 65
             * questionId : 154
             * questionOption : 选项1
             * questionCount : 1
             */

            private int id;
            private int questionId;
            private String questionOption;
            private int questionCount;
            private int isSelect = 0;

            public int getIsSelect() {
                return isSelect;
            }

            public void setIsSelect(int isSelect) {
                this.isSelect = isSelect;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getQuestionId() {
                return questionId;
            }

            public void setQuestionId(int questionId) {
                this.questionId = questionId;
            }

            public String getQuestionOption() {
                return questionOption;
            }

            public void setQuestionOption(String questionOption) {
                this.questionOption = questionOption;
            }

            public int getQuestionCount() {
                return questionCount;
            }

            public void setQuestionCount(int questionCount) {
                this.questionCount = questionCount;
            }
        }
    }
}
