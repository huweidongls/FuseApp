package com.guoyu.fuseapp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/8/18.
 */

public class TraceDataBean implements Serializable {

    /**
     * enterpriseVO : {"business_end_date":1567008000000,"business_scope":"热食类食品制售,冷食类食品制售","business_start_date":1565020800000,"city":"230500","county":"230502","emain":"458281042@163.com","ent_name":"高鑫有机蔬菜生产有限公司","enterprise_type":"1","established":1574352000000,"fr":null,"gmt_create":null,"gmt_modified":1596531773000,"id":"82262354","lat":"46.64954974793839","linkman":"李老师","lng":"131.15247525904597","main_type":"内资企业","mm":"tO9JCT/8Jg/7Yw2mAZxZRQ==","phone":null,"province":"230000","regist_fund":"600","shxydm":"856321478226235456","userid":null,"yhm":"测试生产企业","yxbz":"1","zcdz":"黑龙江省双鸭山市尖山区安全大厦","zcqy":"1"}
     * licenseImgs : null
     * msg : null
     * produceImgs : null
     * productBatchVO : {"batch_id":"7c3241e3a2274ba9b9dcaaeb75a51c71","enterprise_id":"82262354","enterprise_name":null,"pack_id":"","pack_ratio":"","pack_size":"每包10根","product_address":"黑龙江省双鸭山市尖山区5马路888号","product_batch":"200803","product_date":1596326400000,"product_date_str":"2020-08-02","product_id":"822623540401001","product_name":"优享美好火腿肠","product_number":10000,"product_valid":1614211200000,"product_valid_str":"2021-02-25","state":"1"}
     * productVO : {"bz":null,"data_source":null,"enterprise_id":"82262354","fzjg":"","fzrq":null,"gmt_modified":1596560438000,"lbbh":"0401","lbbhcode":"04010504；","lbmc":"热加工熟肉制品","pack_size":"每包10根","pack_unit":"包","product_code":"","product_id":"822623540401001","product_name":"优享美好火腿肠","product_seq":1,"pzmx":"熟肉干制品(其他)","sczt":"在产","state":"1","trace_type":"2","xkzbh":"","yxqz":null,"zcsb":"","zszt":"","zxbz":""}
     * productionLicenseVO : {"cplb":"2504","fddbr":"李开发","fzjg":"双鸭山食药监","fzrq":1592953113000,"fzrqStr":"2020-06-24","gmt_create":1592953113000,"gmt_modified":1592924312000,"id":"1b7907bca94d4d1d9edb21d8a7949662","jgdw":"双鸭山食药监","jgry":"李玉","qfr":"刘菏泽","qyfzr":"张离得","qyid":"82262354","qymc":"测试生产企业","xkzh":"SC10278392712362","xkzyxq":1592953113000,"xkzyxqStr":"2020-06-24","zcdz":"黑龙江省双鸭山市尖山区景阳路258号","zcdz_production_License":null}
     */

    private EnterpriseVOBean enterpriseVO;
    private Object licenseImgs;
    private String msg;
    private Object produceImgs;
    private ProductBatchVOBean productBatchVO;
    private ProductVOBean productVO;
    private ProductionLicenseVOBean productionLicenseVO;

    public EnterpriseVOBean getEnterpriseVO() {
        return enterpriseVO;
    }

    public void setEnterpriseVO(EnterpriseVOBean enterpriseVO) {
        this.enterpriseVO = enterpriseVO;
    }

    public Object getLicenseImgs() {
        return licenseImgs;
    }

    public void setLicenseImgs(Object licenseImgs) {
        this.licenseImgs = licenseImgs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getProduceImgs() {
        return produceImgs;
    }

    public void setProduceImgs(Object produceImgs) {
        this.produceImgs = produceImgs;
    }

    public ProductBatchVOBean getProductBatchVO() {
        return productBatchVO;
    }

    public void setProductBatchVO(ProductBatchVOBean productBatchVO) {
        this.productBatchVO = productBatchVO;
    }

    public ProductVOBean getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVOBean productVO) {
        this.productVO = productVO;
    }

    public ProductionLicenseVOBean getProductionLicenseVO() {
        return productionLicenseVO;
    }

    public void setProductionLicenseVO(ProductionLicenseVOBean productionLicenseVO) {
        this.productionLicenseVO = productionLicenseVO;
    }

    public static class EnterpriseVOBean implements Serializable {
        /**
         * business_end_date : 1567008000000
         * business_scope : 热食类食品制售,冷食类食品制售
         * business_start_date : 1565020800000
         * city : 230500
         * county : 230502
         * emain : 458281042@163.com
         * ent_name : 高鑫有机蔬菜生产有限公司
         * enterprise_type : 1
         * established : 1574352000000
         * fr : null
         * gmt_create : null
         * gmt_modified : 1596531773000
         * id : 82262354
         * lat : 46.64954974793839
         * linkman : 李老师
         * lng : 131.15247525904597
         * main_type : 内资企业
         * mm : tO9JCT/8Jg/7Yw2mAZxZRQ==
         * phone : null
         * province : 230000
         * regist_fund : 600
         * shxydm : 856321478226235456
         * userid : null
         * yhm : 测试生产企业
         * yxbz : 1
         * zcdz : 黑龙江省双鸭山市尖山区安全大厦
         * zcqy : 1
         */

        private long business_end_date;
        private String business_scope;
        private long business_start_date;
        private String city;
        private String county;
        private String emain;
        private String ent_name;
        private String enterprise_type;
        private long established;
        private String fr;
        private String gmt_create;
        private long gmt_modified;
        private String id;
        private String lat;
        private String linkman;
        private String lng;
        private String main_type;
        private String mm;
        private String phone;
        private String province;
        private String regist_fund;
        private String shxydm;
        private String userid;
        private String yhm;
        private String yxbz;
        private String zcdz;
        private String zcqy;

        public long getBusiness_end_date() {
            return business_end_date;
        }

        public void setBusiness_end_date(long business_end_date) {
            this.business_end_date = business_end_date;
        }

        public String getBusiness_scope() {
            return business_scope;
        }

        public void setBusiness_scope(String business_scope) {
            this.business_scope = business_scope;
        }

        public long getBusiness_start_date() {
            return business_start_date;
        }

        public void setBusiness_start_date(long business_start_date) {
            this.business_start_date = business_start_date;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getEmain() {
            return emain;
        }

        public void setEmain(String emain) {
            this.emain = emain;
        }

        public String getEnt_name() {
            return ent_name;
        }

        public void setEnt_name(String ent_name) {
            this.ent_name = ent_name;
        }

        public String getEnterprise_type() {
            return enterprise_type;
        }

        public void setEnterprise_type(String enterprise_type) {
            this.enterprise_type = enterprise_type;
        }

        public long getEstablished() {
            return established;
        }

        public void setEstablished(long established) {
            this.established = established;
        }

        public String getFr() {
            return fr;
        }

        public void setFr(String fr) {
            this.fr = fr;
        }

        public String getGmt_create() {
            return gmt_create;
        }

        public void setGmt_create(String gmt_create) {
            this.gmt_create = gmt_create;
        }

        public long getGmt_modified() {
            return gmt_modified;
        }

        public void setGmt_modified(long gmt_modified) {
            this.gmt_modified = gmt_modified;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLinkman() {
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getMain_type() {
            return main_type;
        }

        public void setMain_type(String main_type) {
            this.main_type = main_type;
        }

        public String getMm() {
            return mm;
        }

        public void setMm(String mm) {
            this.mm = mm;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRegist_fund() {
            return regist_fund;
        }

        public void setRegist_fund(String regist_fund) {
            this.regist_fund = regist_fund;
        }

        public String getShxydm() {
            return shxydm;
        }

        public void setShxydm(String shxydm) {
            this.shxydm = shxydm;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getYhm() {
            return yhm;
        }

        public void setYhm(String yhm) {
            this.yhm = yhm;
        }

        public String getYxbz() {
            return yxbz;
        }

        public void setYxbz(String yxbz) {
            this.yxbz = yxbz;
        }

        public String getZcdz() {
            return zcdz;
        }

        public void setZcdz(String zcdz) {
            this.zcdz = zcdz;
        }

        public String getZcqy() {
            return zcqy;
        }

        public void setZcqy(String zcqy) {
            this.zcqy = zcqy;
        }
    }

    public static class ProductBatchVOBean implements Serializable {
        /**
         * batch_id : 7c3241e3a2274ba9b9dcaaeb75a51c71
         * enterprise_id : 82262354
         * enterprise_name : null
         * pack_id :
         * pack_ratio :
         * pack_size : 每包10根
         * product_address : 黑龙江省双鸭山市尖山区5马路888号
         * product_batch : 200803
         * product_date : 1596326400000
         * product_date_str : 2020-08-02
         * product_id : 822623540401001
         * product_name : 优享美好火腿肠
         * product_number : 10000
         * product_valid : 1614211200000
         * product_valid_str : 2021-02-25
         * state : 1
         */

        private String batch_id;
        private String enterprise_id;
        private String enterprise_name;
        private String pack_id;
        private String pack_ratio;
        private String pack_size;
        private String product_address;
        private String product_batch;
        private long product_date;
        private String product_date_str;
        private String product_id;
        private String product_name;
        private int product_number;
        private long product_valid;
        private String product_valid_str;
        private String state;

        public String getBatch_id() {
            return batch_id;
        }

        public void setBatch_id(String batch_id) {
            this.batch_id = batch_id;
        }

        public String getEnterprise_id() {
            return enterprise_id;
        }

        public void setEnterprise_id(String enterprise_id) {
            this.enterprise_id = enterprise_id;
        }

        public String getEnterprise_name() {
            return enterprise_name;
        }

        public void setEnterprise_name(String enterprise_name) {
            this.enterprise_name = enterprise_name;
        }

        public String getPack_id() {
            return pack_id;
        }

        public void setPack_id(String pack_id) {
            this.pack_id = pack_id;
        }

        public String getPack_ratio() {
            return pack_ratio;
        }

        public void setPack_ratio(String pack_ratio) {
            this.pack_ratio = pack_ratio;
        }

        public String getPack_size() {
            return pack_size;
        }

        public void setPack_size(String pack_size) {
            this.pack_size = pack_size;
        }

        public String getProduct_address() {
            return product_address;
        }

        public void setProduct_address(String product_address) {
            this.product_address = product_address;
        }

        public String getProduct_batch() {
            return product_batch;
        }

        public void setProduct_batch(String product_batch) {
            this.product_batch = product_batch;
        }

        public long getProduct_date() {
            return product_date;
        }

        public void setProduct_date(long product_date) {
            this.product_date = product_date;
        }

        public String getProduct_date_str() {
            return product_date_str;
        }

        public void setProduct_date_str(String product_date_str) {
            this.product_date_str = product_date_str;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public int getProduct_number() {
            return product_number;
        }

        public void setProduct_number(int product_number) {
            this.product_number = product_number;
        }

        public long getProduct_valid() {
            return product_valid;
        }

        public void setProduct_valid(long product_valid) {
            this.product_valid = product_valid;
        }

        public String getProduct_valid_str() {
            return product_valid_str;
        }

        public void setProduct_valid_str(String product_valid_str) {
            this.product_valid_str = product_valid_str;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    public static class ProductVOBean implements Serializable {
        /**
         * bz : null
         * data_source : null
         * enterprise_id : 82262354
         * fzjg :
         * fzrq : null
         * gmt_modified : 1596560438000
         * lbbh : 0401
         * lbbhcode : 04010504；
         * lbmc : 热加工熟肉制品
         * pack_size : 每包10根
         * pack_unit : 包
         * product_code :
         * product_id : 822623540401001
         * product_name : 优享美好火腿肠
         * product_seq : 1
         * pzmx : 熟肉干制品(其他)
         * sczt : 在产
         * state : 1
         * trace_type : 2
         * xkzbh :
         * yxqz : null
         * zcsb :
         * zszt :
         * zxbz :
         */

        private String bz;
        private String data_source;
        private String enterprise_id;
        private String fzjg;
        private String fzrq;
        private long gmt_modified;
        private String lbbh;
        private String lbbhcode;
        private String lbmc;
        private String pack_size;
        private String pack_unit;
        private String product_code;
        private String product_id;
        private String product_name;
        private int product_seq;
        private String pzmx;
        private String sczt;
        private String state;
        private String trace_type;
        private String xkzbh;
        private String yxqz;
        private String zcsb;
        private String zszt;
        private String zxbz;

        public String getBz() {
            return bz;
        }

        public void setBz(String bz) {
            this.bz = bz;
        }

        public String getData_source() {
            return data_source;
        }

        public void setData_source(String data_source) {
            this.data_source = data_source;
        }

        public String getEnterprise_id() {
            return enterprise_id;
        }

        public void setEnterprise_id(String enterprise_id) {
            this.enterprise_id = enterprise_id;
        }

        public String getFzjg() {
            return fzjg;
        }

        public void setFzjg(String fzjg) {
            this.fzjg = fzjg;
        }

        public String getFzrq() {
            return fzrq;
        }

        public void setFzrq(String fzrq) {
            this.fzrq = fzrq;
        }

        public long getGmt_modified() {
            return gmt_modified;
        }

        public void setGmt_modified(long gmt_modified) {
            this.gmt_modified = gmt_modified;
        }

        public String getLbbh() {
            return lbbh;
        }

        public void setLbbh(String lbbh) {
            this.lbbh = lbbh;
        }

        public String getLbbhcode() {
            return lbbhcode;
        }

        public void setLbbhcode(String lbbhcode) {
            this.lbbhcode = lbbhcode;
        }

        public String getLbmc() {
            return lbmc;
        }

        public void setLbmc(String lbmc) {
            this.lbmc = lbmc;
        }

        public String getPack_size() {
            return pack_size;
        }

        public void setPack_size(String pack_size) {
            this.pack_size = pack_size;
        }

        public String getPack_unit() {
            return pack_unit;
        }

        public void setPack_unit(String pack_unit) {
            this.pack_unit = pack_unit;
        }

        public String getProduct_code() {
            return product_code;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public int getProduct_seq() {
            return product_seq;
        }

        public void setProduct_seq(int product_seq) {
            this.product_seq = product_seq;
        }

        public String getPzmx() {
            return pzmx;
        }

        public void setPzmx(String pzmx) {
            this.pzmx = pzmx;
        }

        public String getSczt() {
            return sczt;
        }

        public void setSczt(String sczt) {
            this.sczt = sczt;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTrace_type() {
            return trace_type;
        }

        public void setTrace_type(String trace_type) {
            this.trace_type = trace_type;
        }

        public String getXkzbh() {
            return xkzbh;
        }

        public void setXkzbh(String xkzbh) {
            this.xkzbh = xkzbh;
        }

        public String getYxqz() {
            return yxqz;
        }

        public void setYxqz(String yxqz) {
            this.yxqz = yxqz;
        }

        public String getZcsb() {
            return zcsb;
        }

        public void setZcsb(String zcsb) {
            this.zcsb = zcsb;
        }

        public String getZszt() {
            return zszt;
        }

        public void setZszt(String zszt) {
            this.zszt = zszt;
        }

        public String getZxbz() {
            return zxbz;
        }

        public void setZxbz(String zxbz) {
            this.zxbz = zxbz;
        }
    }

    public static class ProductionLicenseVOBean implements Serializable {
        /**
         * cplb : 2504
         * fddbr : 李开发
         * fzjg : 双鸭山食药监
         * fzrq : 1592953113000
         * fzrqStr : 2020-06-24
         * gmt_create : 1592953113000
         * gmt_modified : 1592924312000
         * id : 1b7907bca94d4d1d9edb21d8a7949662
         * jgdw : 双鸭山食药监
         * jgry : 李玉
         * qfr : 刘菏泽
         * qyfzr : 张离得
         * qyid : 82262354
         * qymc : 测试生产企业
         * xkzh : SC10278392712362
         * xkzyxq : 1592953113000
         * xkzyxqStr : 2020-06-24
         * zcdz : 黑龙江省双鸭山市尖山区景阳路258号
         * zcdz_production_License : null
         */

        private String cplb;
        private String fddbr;
        private String fzjg;
        private long fzrq;
        private String fzrqStr;
        private long gmt_create;
        private long gmt_modified;
        private String id;
        private String jgdw;
        private String jgry;
        private String qfr;
        private String qyfzr;
        private String qyid;
        private String qymc;
        private String xkzh;
        private long xkzyxq;
        private String xkzyxqStr;
        private String zcdz;
        private String zcdz_production_License;

        public String getCplb() {
            return cplb;
        }

        public void setCplb(String cplb) {
            this.cplb = cplb;
        }

        public String getFddbr() {
            return fddbr;
        }

        public void setFddbr(String fddbr) {
            this.fddbr = fddbr;
        }

        public String getFzjg() {
            return fzjg;
        }

        public void setFzjg(String fzjg) {
            this.fzjg = fzjg;
        }

        public long getFzrq() {
            return fzrq;
        }

        public void setFzrq(long fzrq) {
            this.fzrq = fzrq;
        }

        public String getFzrqStr() {
            return fzrqStr;
        }

        public void setFzrqStr(String fzrqStr) {
            this.fzrqStr = fzrqStr;
        }

        public long getGmt_create() {
            return gmt_create;
        }

        public void setGmt_create(long gmt_create) {
            this.gmt_create = gmt_create;
        }

        public long getGmt_modified() {
            return gmt_modified;
        }

        public void setGmt_modified(long gmt_modified) {
            this.gmt_modified = gmt_modified;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJgdw() {
            return jgdw;
        }

        public void setJgdw(String jgdw) {
            this.jgdw = jgdw;
        }

        public String getJgry() {
            return jgry;
        }

        public void setJgry(String jgry) {
            this.jgry = jgry;
        }

        public String getQfr() {
            return qfr;
        }

        public void setQfr(String qfr) {
            this.qfr = qfr;
        }

        public String getQyfzr() {
            return qyfzr;
        }

        public void setQyfzr(String qyfzr) {
            this.qyfzr = qyfzr;
        }

        public String getQyid() {
            return qyid;
        }

        public void setQyid(String qyid) {
            this.qyid = qyid;
        }

        public String getQymc() {
            return qymc;
        }

        public void setQymc(String qymc) {
            this.qymc = qymc;
        }

        public String getXkzh() {
            return xkzh;
        }

        public void setXkzh(String xkzh) {
            this.xkzh = xkzh;
        }

        public long getXkzyxq() {
            return xkzyxq;
        }

        public void setXkzyxq(long xkzyxq) {
            this.xkzyxq = xkzyxq;
        }

        public String getXkzyxqStr() {
            return xkzyxqStr;
        }

        public void setXkzyxqStr(String xkzyxqStr) {
            this.xkzyxqStr = xkzyxqStr;
        }

        public String getZcdz() {
            return zcdz;
        }

        public void setZcdz(String zcdz) {
            this.zcdz = zcdz;
        }

        public String getZcdz_production_License() {
            return zcdz_production_License;
        }

        public void setZcdz_production_License(String zcdz_production_License) {
            this.zcdz_production_License = zcdz_production_License;
        }
    }
}
