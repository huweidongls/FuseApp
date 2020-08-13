package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/8/13.
 */

public class CreditList1Bean implements Serializable {

    /**
     * total : 1
     * rows : [{"XK_XDR_GSZC":null,"RESOURCE_ID":"DIR-20180903-101102-122","XK_XDR_LB":"法人及非法人组织","XK_XKBH":null,"XK_XDR_SWDJ":null,"XK_YXQZ":"2019-09-05","XK_LYDWDM":"00000000000000000X","XK_LYDW":"双鸭山市","XK_WSH":"双环许可2019","XK_XKWS":"双环许可证书2019","BZ":null,"XK_XKJGDM":"00000000000000000X","XK_XDR_SYDW":null,"ID":"7c0b9622d45711e999b9fa8d4ae32600","XK_FR_ZJLX":null,"CHECK_FLAG":"1","XK_XDR_SHXYM":"91230500MA1B3N1N2M","XK_XDR_MC":"双鸭山智慧城市运营有限公司","XK_XDR_ZJLX":null,"XK_XDR_ZZJG":null,"XK_NR":"许可开展智慧城市建设","XK_FRDB":"王杨","CREATE_DATE":1568180781000,"XK_YXQZI":"2020-09-22","CREATE_DEPT_NAME":"双鸭山市","XK_XKLB":"普通","PERSON_ID":"24c1b8fad39911e999b9fa8d4ae32600","XK_JDRQ":"2019-09-01","XK_XKZS":null,"XK_ZT":"1","XK_XDR_SHZZ":null,"XK_XKJG":"双鸭山市"}]
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
         * XK_XDR_GSZC : null
         * RESOURCE_ID : DIR-20180903-101102-122
         * XK_XDR_LB : 法人及非法人组织
         * XK_XKBH : null
         * XK_XDR_SWDJ : null
         * XK_YXQZ : 2019-09-05
         * XK_LYDWDM : 00000000000000000X
         * XK_LYDW : 双鸭山市
         * XK_WSH : 双环许可2019
         * XK_XKWS : 双环许可证书2019
         * BZ : null
         * XK_XKJGDM : 00000000000000000X
         * XK_XDR_SYDW : null
         * ID : 7c0b9622d45711e999b9fa8d4ae32600
         * XK_FR_ZJLX : null
         * CHECK_FLAG : 1
         * XK_XDR_SHXYM : 91230500MA1B3N1N2M
         * XK_XDR_MC : 双鸭山智慧城市运营有限公司
         * XK_XDR_ZJLX : null
         * XK_XDR_ZZJG : null
         * XK_NR : 许可开展智慧城市建设
         * XK_FRDB : 王杨
         * CREATE_DATE : 1568180781000
         * XK_YXQZI : 2020-09-22
         * CREATE_DEPT_NAME : 双鸭山市
         * XK_XKLB : 普通
         * PERSON_ID : 24c1b8fad39911e999b9fa8d4ae32600
         * XK_JDRQ : 2019-09-01
         * XK_XKZS : null
         * XK_ZT : 1
         * XK_XDR_SHZZ : null
         * XK_XKJG : 双鸭山市
         */

        private String XK_XDR_GSZC;
        private String RESOURCE_ID;
        private String XK_XDR_LB;
        private String XK_XKBH;
        private String XK_XDR_SWDJ;
        private String XK_YXQZ;
        private String XK_LYDWDM;
        private String XK_LYDW;
        private String XK_WSH;
        private String XK_XKWS;
        private String BZ;
        private String XK_XKJGDM;
        private String XK_XDR_SYDW;
        private String ID;
        private String XK_FR_ZJLX;
        private String CHECK_FLAG;
        private String XK_XDR_SHXYM;
        private String XK_XDR_MC;
        private String XK_XDR_ZJLX;
        private String XK_XDR_ZZJG;
        private String XK_NR;
        private String XK_FRDB;
        private String CREATE_DATE;
        private String XK_YXQZI;
        private String CREATE_DEPT_NAME;
        private String XK_XKLB;
        private String PERSON_ID;
        private String XK_JDRQ;
        private String XK_XKZS;
        private String XK_ZT;
        private String XK_XDR_SHZZ;
        private String XK_XKJG;

        public String getXK_XDR_GSZC() {
            return XK_XDR_GSZC;
        }

        public void setXK_XDR_GSZC(String XK_XDR_GSZC) {
            this.XK_XDR_GSZC = XK_XDR_GSZC;
        }

        public String getRESOURCE_ID() {
            return RESOURCE_ID;
        }

        public void setRESOURCE_ID(String RESOURCE_ID) {
            this.RESOURCE_ID = RESOURCE_ID;
        }

        public String getXK_XDR_LB() {
            return XK_XDR_LB;
        }

        public void setXK_XDR_LB(String XK_XDR_LB) {
            this.XK_XDR_LB = XK_XDR_LB;
        }

        public String getXK_XKBH() {
            return XK_XKBH;
        }

        public void setXK_XKBH(String XK_XKBH) {
            this.XK_XKBH = XK_XKBH;
        }

        public String getXK_XDR_SWDJ() {
            return XK_XDR_SWDJ;
        }

        public void setXK_XDR_SWDJ(String XK_XDR_SWDJ) {
            this.XK_XDR_SWDJ = XK_XDR_SWDJ;
        }

        public String getXK_YXQZ() {
            return XK_YXQZ;
        }

        public void setXK_YXQZ(String XK_YXQZ) {
            this.XK_YXQZ = XK_YXQZ;
        }

        public String getXK_LYDWDM() {
            return XK_LYDWDM;
        }

        public void setXK_LYDWDM(String XK_LYDWDM) {
            this.XK_LYDWDM = XK_LYDWDM;
        }

        public String getXK_LYDW() {
            return XK_LYDW;
        }

        public void setXK_LYDW(String XK_LYDW) {
            this.XK_LYDW = XK_LYDW;
        }

        public String getXK_WSH() {
            return XK_WSH;
        }

        public void setXK_WSH(String XK_WSH) {
            this.XK_WSH = XK_WSH;
        }

        public String getXK_XKWS() {
            return XK_XKWS;
        }

        public void setXK_XKWS(String XK_XKWS) {
            this.XK_XKWS = XK_XKWS;
        }

        public String getBZ() {
            return BZ;
        }

        public void setBZ(String BZ) {
            this.BZ = BZ;
        }

        public String getXK_XKJGDM() {
            return XK_XKJGDM;
        }

        public void setXK_XKJGDM(String XK_XKJGDM) {
            this.XK_XKJGDM = XK_XKJGDM;
        }

        public String getXK_XDR_SYDW() {
            return XK_XDR_SYDW;
        }

        public void setXK_XDR_SYDW(String XK_XDR_SYDW) {
            this.XK_XDR_SYDW = XK_XDR_SYDW;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getXK_FR_ZJLX() {
            return XK_FR_ZJLX;
        }

        public void setXK_FR_ZJLX(String XK_FR_ZJLX) {
            this.XK_FR_ZJLX = XK_FR_ZJLX;
        }

        public String getCHECK_FLAG() {
            return CHECK_FLAG;
        }

        public void setCHECK_FLAG(String CHECK_FLAG) {
            this.CHECK_FLAG = CHECK_FLAG;
        }

        public String getXK_XDR_SHXYM() {
            return XK_XDR_SHXYM;
        }

        public void setXK_XDR_SHXYM(String XK_XDR_SHXYM) {
            this.XK_XDR_SHXYM = XK_XDR_SHXYM;
        }

        public String getXK_XDR_MC() {
            return XK_XDR_MC;
        }

        public void setXK_XDR_MC(String XK_XDR_MC) {
            this.XK_XDR_MC = XK_XDR_MC;
        }

        public String getXK_XDR_ZJLX() {
            return XK_XDR_ZJLX;
        }

        public void setXK_XDR_ZJLX(String XK_XDR_ZJLX) {
            this.XK_XDR_ZJLX = XK_XDR_ZJLX;
        }

        public String getXK_XDR_ZZJG() {
            return XK_XDR_ZZJG;
        }

        public void setXK_XDR_ZZJG(String XK_XDR_ZZJG) {
            this.XK_XDR_ZZJG = XK_XDR_ZZJG;
        }

        public String getXK_NR() {
            return XK_NR;
        }

        public void setXK_NR(String XK_NR) {
            this.XK_NR = XK_NR;
        }

        public String getXK_FRDB() {
            return XK_FRDB;
        }

        public void setXK_FRDB(String XK_FRDB) {
            this.XK_FRDB = XK_FRDB;
        }

        public String getCREATE_DATE() {
            return CREATE_DATE;
        }

        public void setCREATE_DATE(String CREATE_DATE) {
            this.CREATE_DATE = CREATE_DATE;
        }

        public String getXK_YXQZI() {
            return XK_YXQZI;
        }

        public void setXK_YXQZI(String XK_YXQZI) {
            this.XK_YXQZI = XK_YXQZI;
        }

        public String getCREATE_DEPT_NAME() {
            return CREATE_DEPT_NAME;
        }

        public void setCREATE_DEPT_NAME(String CREATE_DEPT_NAME) {
            this.CREATE_DEPT_NAME = CREATE_DEPT_NAME;
        }

        public String getXK_XKLB() {
            return XK_XKLB;
        }

        public void setXK_XKLB(String XK_XKLB) {
            this.XK_XKLB = XK_XKLB;
        }

        public String getPERSON_ID() {
            return PERSON_ID;
        }

        public void setPERSON_ID(String PERSON_ID) {
            this.PERSON_ID = PERSON_ID;
        }

        public String getXK_JDRQ() {
            return XK_JDRQ;
        }

        public void setXK_JDRQ(String XK_JDRQ) {
            this.XK_JDRQ = XK_JDRQ;
        }

        public String getXK_XKZS() {
            return XK_XKZS;
        }

        public void setXK_XKZS(String XK_XKZS) {
            this.XK_XKZS = XK_XKZS;
        }

        public String getXK_ZT() {
            return XK_ZT;
        }

        public void setXK_ZT(String XK_ZT) {
            this.XK_ZT = XK_ZT;
        }

        public String getXK_XDR_SHZZ() {
            return XK_XDR_SHZZ;
        }

        public void setXK_XDR_SHZZ(String XK_XDR_SHZZ) {
            this.XK_XDR_SHZZ = XK_XDR_SHZZ;
        }

        public String getXK_XKJG() {
            return XK_XKJG;
        }

        public void setXK_XKJG(String XK_XKJG) {
            this.XK_XKJG = XK_XKJG;
        }
    }
}
