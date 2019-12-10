package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/11/13.
 */

public class CreditBean {

    /**
     * total : 1
     * rows : [[{"fieldName":"姓名","fieldCode":"NAME","fieldValue":"张德硕","listShow":true},{"fieldName":"性别","fieldCode":"SEX","fieldValue":"男性","listShow":true},{"fieldName":"地址","fieldCode":"REG_ADDR","fieldValue":"黑龙江双鸭山","listShow":true},{"fieldName":"证件名称","fieldCode":"SFZJMC","fieldValue":"居民身份证","listShow":true},{"fieldName":"证件号码","fieldCode":"SFZJHM","fieldValue":"320322********8678","listShow":true},{"fieldName":"曾用名","fieldCode":"ONCE_NAME","fieldValue":"无","listShow":true},{"fieldName":"婚姻状况","fieldCode":"MARRIED","fieldValue":"20","listShow":true},{"fieldName":"户籍地派出所","fieldCode":"REG_ADDR_POLICE","fieldValue":"黑龙江双鸭山尖山区派出所","listShow":true},{"fieldName":"户籍地派出所编码","fieldCode":"REG_ADDR_POLICE_CODE","fieldValue":"221122","listShow":true},{"fieldName":"汉语拼音","fieldCode":"ALL_SPELLING","fieldValue":"shuangyasnhan","listShow":true},{"fieldName":"辖区编码","fieldCode":"DISTRICT_CODE","fieldValue":"320123","listShow":true},{"fieldName":"拼音字母","fieldCode":"FIRST_SPELLING","fieldValue":"shuangyanshan","listShow":true},{"fieldName":"与户主关系","fieldCode":"HOUSEHOLDER_RELATION","fieldValue":"户主","listShow":true},{"fieldName":"文化程度","fieldCode":"EDUCATION","fieldValue":"10","listShow":true},{"fieldName":"民族","fieldCode":"NATION","fieldValue":"1","listShow":true},{"fieldName":"国籍","fieldCode":"NATIONALITY","fieldValue":"中国","listShow":true},{"fieldName":"宗教信仰","fieldCode":"RELIGION","fieldValue":"无","listShow":true},{"fieldName":"生日","fieldCode":"BIRTHDAY","fieldValue":"1993-09-02 17:00:03","listShow":true},{"fieldName":"户口类型","fieldCode":"REG_TYPE","fieldValue":"2","listShow":true},{"fieldName":"门牌号","fieldCode":"REG_ADDR_NO","fieldValue":"196","listShow":true},{"fieldName":"户籍号码","fieldCode":"REG_CODE","fieldValue":"无","listShow":true},{"fieldName":"户籍标志","fieldCode":"HOUSEHOLDER_MARK","fieldValue":"无","listShow":true},{"fieldName":"常驻地址","fieldCode":"ADDR","fieldValue":"黑龙江双鸭山","listShow":true},{"fieldName":"人口类型","fieldCode":"PERSON_TYPE","fieldValue":"2","listShow":true},{"fieldName":"死亡标识","fieldCode":"DEAD_FLAG","fieldValue":"live","listShow":true},{"fieldName":"死亡日期","fieldCode":"DEAD_DATE","fieldValue":null,"listShow":true},{"fieldName":"政治面貌","fieldCode":"POLITICS_STATUS","fieldValue":"1","listShow":true},{"fieldName":"联系方式","fieldCode":"MOBILE","fieldValue":"18361390246","listShow":true},{"fieldName":"信息来源","fieldCode":"INFO_SOURCE","fieldValue":"双鸭山公安局","listShow":true},{"fieldName":"备注","fieldCode":"REMARK","fieldValue":"展示信息仅作参考","listShow":true}]]
     */

    private int total;
    private List<List<RowsBean>> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<List<RowsBean>> getRows() {
        return rows;
    }

    public void setRows(List<List<RowsBean>> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * fieldName : 姓名
         * fieldCode : NAME
         * fieldValue : 张德硕
         * listShow : true
         */

        private String fieldName;
        private String fieldCode;
        private String fieldValue;
        private boolean listShow;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldCode() {
            return fieldCode;
        }

        public void setFieldCode(String fieldCode) {
            this.fieldCode = fieldCode;
        }

        public String getFieldValue() {
            return fieldValue;
        }

        public void setFieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
        }

        public boolean isListShow() {
            return listShow;
        }

        public void setListShow(boolean listShow) {
            this.listShow = listShow;
        }
    }
}
