package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/8/13.
 */

public class CreditList2Bean implements Serializable {

    /**
     * total : 1
     * rows : [{"RESOURCE_ID":"DIR-20180902-164730-458","CF_XDR_GSZC":null,"CF_JDRQ":"2019-10-10","CF_WSH":"市场【2019】1号","CF_XDR_SWDJ":null,"CF_SJLYDM":"11230500001755309F","CF_SY":"违反相关产品准入市场规定","CF_SJLY":"双鸭山市公安局","BZ":null,"CF_XDR_SHZZ":null,"ID":"86d5f278038611eaa714fa8d4ae32600","CHECK_FLAG":"1","CF_XDR_ZZJG":null,"CF_XDR_ZJLX":null,"CF_FR_ZJHM":null,"CF_YXQ":"2019-10-17","CF_XDR_SHXYM":"91230500MA1B3N1N2M","CF_XDR_LB":"法人及非法人组织","CF_NR":"罚款2000元","CF_WFXW":"违反相关产品准入市场规定","CF_NR_ZKDX":null,"CF_CFJG":"双鸭山市公安局","COMP_NAME":"双鸭山智慧城市运营有限公司","CF_NR_FK":0.2,"CREATE_DEPT_NAME":"市公安局","CF_FRDB":"王杨","PERSON_ID":"24c1b8fad39911e999b9fa8d4ae32600","CF_FR_ZJLX":null,"CF_GSJZQ":"2020-10-17","CF_CFJGDM":"11230500001755309F","CF_CFLB":"罚款","CF_NR_WFFF":null,"CF_XDR_ZJHM":null,"CF_YJ":"依据《行业准入规定》","CF_XDR_SYDW":null}]
     */

    private int total;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean implements Serializable {
        /**
         * RESOURCE_ID : DIR-20180902-164730-458
         * CF_XDR_GSZC : null
         * CF_JDRQ : 2019-10-10
         * CF_WSH : 市场【2019】1号
         * CF_XDR_SWDJ : null
         * CF_SJLYDM : 11230500001755309F
         * CF_SY : 违反相关产品准入市场规定
         * CF_SJLY : 双鸭山市公安局
         * BZ : null
         * CF_XDR_SHZZ : null
         * ID : 86d5f278038611eaa714fa8d4ae32600
         * CHECK_FLAG : 1
         * CF_XDR_ZZJG : null
         * CF_XDR_ZJLX : null
         * CF_FR_ZJHM : null
         * CF_YXQ : 2019-10-17
         * CF_XDR_SHXYM : 91230500MA1B3N1N2M
         * CF_XDR_LB : 法人及非法人组织
         * CF_NR : 罚款2000元
         * CF_WFXW : 违反相关产品准入市场规定
         * CF_NR_ZKDX : null
         * CF_CFJG : 双鸭山市公安局
         * COMP_NAME : 双鸭山智慧城市运营有限公司
         * CF_NR_FK : 0.2
         * CREATE_DEPT_NAME : 市公安局
         * CF_FRDB : 王杨
         * PERSON_ID : 24c1b8fad39911e999b9fa8d4ae32600
         * CF_FR_ZJLX : null
         * CF_GSJZQ : 2020-10-17
         * CF_CFJGDM : 11230500001755309F
         * CF_CFLB : 罚款
         * CF_NR_WFFF : null
         * CF_XDR_ZJHM : null
         * CF_YJ : 依据《行业准入规定》
         * CF_XDR_SYDW : null
         */

        private String RESOURCE_ID;
        private String CF_XDR_GSZC;
        private String CF_JDRQ;
        private String CF_WSH;
        private String CF_XDR_SWDJ;
        private String CF_SJLYDM;
        private String CF_SY;
        private String CF_SJLY;
        private String BZ;
        private String CF_XDR_SHZZ;
        private String ID;
        private String CHECK_FLAG;
        private String CF_XDR_ZZJG;
        private String CF_XDR_ZJLX;
        private String CF_FR_ZJHM;
        private String CF_YXQ;
        private String CF_XDR_SHXYM;
        private String CF_XDR_LB;
        private String CF_NR;
        private String CF_WFXW;
        private String CF_NR_ZKDX;
        private String CF_CFJG;
        private String COMP_NAME;
        private String CF_NR_FK;
        private String CREATE_DEPT_NAME;
        private String CF_FRDB;
        private String PERSON_ID;
        private String CF_FR_ZJLX;
        private String CF_GSJZQ;
        private String CF_CFJGDM;
        private String CF_CFLB;
        private String CF_NR_WFFF;
        private String CF_XDR_ZJHM;
        private String CF_YJ;
        private String CF_XDR_SYDW;

        public String getRESOURCE_ID() {
            return RESOURCE_ID;
        }

        public void setRESOURCE_ID(String RESOURCE_ID) {
            this.RESOURCE_ID = RESOURCE_ID;
        }

        public String getCF_XDR_GSZC() {
            return CF_XDR_GSZC;
        }

        public void setCF_XDR_GSZC(String CF_XDR_GSZC) {
            this.CF_XDR_GSZC = CF_XDR_GSZC;
        }

        public String getCF_JDRQ() {
            return CF_JDRQ;
        }

        public void setCF_JDRQ(String CF_JDRQ) {
            this.CF_JDRQ = CF_JDRQ;
        }

        public String getCF_WSH() {
            return CF_WSH;
        }

        public void setCF_WSH(String CF_WSH) {
            this.CF_WSH = CF_WSH;
        }

        public String getCF_XDR_SWDJ() {
            return CF_XDR_SWDJ;
        }

        public void setCF_XDR_SWDJ(String CF_XDR_SWDJ) {
            this.CF_XDR_SWDJ = CF_XDR_SWDJ;
        }

        public String getCF_SJLYDM() {
            return CF_SJLYDM;
        }

        public void setCF_SJLYDM(String CF_SJLYDM) {
            this.CF_SJLYDM = CF_SJLYDM;
        }

        public String getCF_SY() {
            return CF_SY;
        }

        public void setCF_SY(String CF_SY) {
            this.CF_SY = CF_SY;
        }

        public String getCF_SJLY() {
            return CF_SJLY;
        }

        public void setCF_SJLY(String CF_SJLY) {
            this.CF_SJLY = CF_SJLY;
        }

        public String getBZ() {
            return BZ;
        }

        public void setBZ(String BZ) {
            this.BZ = BZ;
        }

        public String getCF_XDR_SHZZ() {
            return CF_XDR_SHZZ;
        }

        public void setCF_XDR_SHZZ(String CF_XDR_SHZZ) {
            this.CF_XDR_SHZZ = CF_XDR_SHZZ;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getCHECK_FLAG() {
            return CHECK_FLAG;
        }

        public void setCHECK_FLAG(String CHECK_FLAG) {
            this.CHECK_FLAG = CHECK_FLAG;
        }

        public String getCF_XDR_ZZJG() {
            return CF_XDR_ZZJG;
        }

        public void setCF_XDR_ZZJG(String CF_XDR_ZZJG) {
            this.CF_XDR_ZZJG = CF_XDR_ZZJG;
        }

        public String getCF_XDR_ZJLX() {
            return CF_XDR_ZJLX;
        }

        public void setCF_XDR_ZJLX(String CF_XDR_ZJLX) {
            this.CF_XDR_ZJLX = CF_XDR_ZJLX;
        }

        public String getCF_FR_ZJHM() {
            return CF_FR_ZJHM;
        }

        public void setCF_FR_ZJHM(String CF_FR_ZJHM) {
            this.CF_FR_ZJHM = CF_FR_ZJHM;
        }

        public String getCF_YXQ() {
            return CF_YXQ;
        }

        public void setCF_YXQ(String CF_YXQ) {
            this.CF_YXQ = CF_YXQ;
        }

        public String getCF_XDR_SHXYM() {
            return CF_XDR_SHXYM;
        }

        public void setCF_XDR_SHXYM(String CF_XDR_SHXYM) {
            this.CF_XDR_SHXYM = CF_XDR_SHXYM;
        }

        public String getCF_XDR_LB() {
            return CF_XDR_LB;
        }

        public void setCF_XDR_LB(String CF_XDR_LB) {
            this.CF_XDR_LB = CF_XDR_LB;
        }

        public String getCF_NR() {
            return CF_NR;
        }

        public void setCF_NR(String CF_NR) {
            this.CF_NR = CF_NR;
        }

        public String getCF_WFXW() {
            return CF_WFXW;
        }

        public void setCF_WFXW(String CF_WFXW) {
            this.CF_WFXW = CF_WFXW;
        }

        public String getCF_NR_ZKDX() {
            return CF_NR_ZKDX;
        }

        public void setCF_NR_ZKDX(String CF_NR_ZKDX) {
            this.CF_NR_ZKDX = CF_NR_ZKDX;
        }

        public String getCF_CFJG() {
            return CF_CFJG;
        }

        public void setCF_CFJG(String CF_CFJG) {
            this.CF_CFJG = CF_CFJG;
        }

        public String getCOMP_NAME() {
            return COMP_NAME;
        }

        public void setCOMP_NAME(String COMP_NAME) {
            this.COMP_NAME = COMP_NAME;
        }

        public String getCF_NR_FK() {
            return CF_NR_FK;
        }

        public void setCF_NR_FK(String CF_NR_FK) {
            this.CF_NR_FK = CF_NR_FK;
        }

        public String getCREATE_DEPT_NAME() {
            return CREATE_DEPT_NAME;
        }

        public void setCREATE_DEPT_NAME(String CREATE_DEPT_NAME) {
            this.CREATE_DEPT_NAME = CREATE_DEPT_NAME;
        }

        public String getCF_FRDB() {
            return CF_FRDB;
        }

        public void setCF_FRDB(String CF_FRDB) {
            this.CF_FRDB = CF_FRDB;
        }

        public String getPERSON_ID() {
            return PERSON_ID;
        }

        public void setPERSON_ID(String PERSON_ID) {
            this.PERSON_ID = PERSON_ID;
        }

        public String getCF_FR_ZJLX() {
            return CF_FR_ZJLX;
        }

        public void setCF_FR_ZJLX(String CF_FR_ZJLX) {
            this.CF_FR_ZJLX = CF_FR_ZJLX;
        }

        public String getCF_GSJZQ() {
            return CF_GSJZQ;
        }

        public void setCF_GSJZQ(String CF_GSJZQ) {
            this.CF_GSJZQ = CF_GSJZQ;
        }

        public String getCF_CFJGDM() {
            return CF_CFJGDM;
        }

        public void setCF_CFJGDM(String CF_CFJGDM) {
            this.CF_CFJGDM = CF_CFJGDM;
        }

        public String getCF_CFLB() {
            return CF_CFLB;
        }

        public void setCF_CFLB(String CF_CFLB) {
            this.CF_CFLB = CF_CFLB;
        }

        public String getCF_NR_WFFF() {
            return CF_NR_WFFF;
        }

        public void setCF_NR_WFFF(String CF_NR_WFFF) {
            this.CF_NR_WFFF = CF_NR_WFFF;
        }

        public String getCF_XDR_ZJHM() {
            return CF_XDR_ZJHM;
        }

        public void setCF_XDR_ZJHM(String CF_XDR_ZJHM) {
            this.CF_XDR_ZJHM = CF_XDR_ZJHM;
        }

        public String getCF_YJ() {
            return CF_YJ;
        }

        public void setCF_YJ(String CF_YJ) {
            this.CF_YJ = CF_YJ;
        }

        public String getCF_XDR_SYDW() {
            return CF_XDR_SYDW;
        }

        public void setCF_XDR_SYDW(String CF_XDR_SYDW) {
            this.CF_XDR_SYDW = CF_XDR_SYDW;
        }
    }
}
