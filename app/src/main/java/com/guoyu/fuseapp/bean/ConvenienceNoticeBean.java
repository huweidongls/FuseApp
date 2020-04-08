package com.guoyu.fuseapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/21.
 */

public class ConvenienceNoticeBean {

    /**
     * status : 200
     * data : [{"id":851,"title":"双鸭山市司法局关于向社会公开征集2020年立法项目建议的通告","createDate":"2019-12-31 10:07:33","appimg":"upload/null/2019-12-31/5c718888c16149ffa0908bfded48d9ef.png"},{"id":451,"title":"区委书记梁野深入双鸭山市建文小学校实地...","createDate":"2019-11-04 11:16:40","appimg":"upload/null/2019-10-19/fcc42dd17dc8477c8a62c6949c7d5156.png"},{"id":402,"title":"市科技局领导到南岗区调研高科技产业建设...","createDate":"2019-10-31 07:25:32","appimg":"upload/null/2019-10-19/fcc42dd17dc8477c8a62c6949c7d5156.png"},{"id":351,"title":"哈西街道办事处如期完成花园小学校区清理...","createDate":"2019-10-30 16:42:21","appimg":"upload/null/2019-10-19/fcc42dd17dc8477c8a62c6949c7d5156.png"},{"id":201,"title":"南岗区亲水文化节\u2014走近你最美河园随手拍...","createDate":"2019-10-19 14:15:44","appimg":"upload/null/2019-10-19/fcc42dd17dc8477c8a62c6949c7d5156.png"},{"id":151,"title":"2019年下半年这15项便民大事儿你必须知道！","createDate":"2019-10-10 00:00:00","appimg":"upload/null/2019-10-19/fcc42dd17dc8477c8a62c6949c7d5156.png"}]
     * totalPage : 0
     * totalCount : 6
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
         * id : 851
         * title : 双鸭山市司法局关于向社会公开征集2020年立法项目建议的通告
         * createDate : 2019-12-31 10:07:33
         * appimg : upload/null/2019-12-31/5c718888c16149ffa0908bfded48d9ef.png
         */

        private int id;
        private String title;
        private String createDate;
        private String appimg;

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

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getAppimg() {
            return appimg;
        }

        public void setAppimg(String appimg) {
            this.appimg = appimg;
        }
    }
}
