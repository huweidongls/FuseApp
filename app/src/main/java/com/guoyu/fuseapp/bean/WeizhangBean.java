package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/8/19.
 */

public class WeizhangBean implements Serializable {

    /**
     * code : 200
     * data : [{"carNumber":"黑A5HW68","timeOne":"2020-04-01 12:03:57.0","number":"85713","address":"永盛路全路段","cause":"不按规定停车","maney":"","timeTwo":"","state":"未处理","member":""},{"carNumber":"黑A5HW68","timeOne":"2020-03-29 11:32:27.0","number":"60045","address":"大同街（一转盘至步行街、工商银行门前）","cause":"不按规定停车","maney":"","timeTwo":"","state":"未处理","member":""},{"carNumber":"黑A5HW68","timeOne":"2019-04-22 19:20:00.0","number":"82519","address":"工农大街全路段","cause":"不按规定停车","maney":"100","timeTwo":"2019-05-07 10:40:54.0","state":"已处理","member":"董蒂薇"},{"carNumber":"黑A5HW68","timeOne":"2019-05-04 07:43:00.0","number":"82519","address":"工农大街全路段","cause":"不按规定停车","maney":"","timeTwo":"","state":"未处理","member":""},{"carNumber":"黑A5HW68","timeOne":"2019-06-01 17:18:07.0","number":"82519","address":"工农大街全路段","cause":"不按规定停车","maney":"","timeTwo":"","state":"未处理","member":""},{"carNumber":"黑A5HW68","timeOne":"2019-08-29 09:35:00.0","number":"99999","address":"哈尔滨市南岗区马家街","cause":"不按规定停车","maney":"","timeTwo":"","state":"未处理","member":""}]
     * message : 请求数据成功!
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * carNumber : 黑A5HW68
         * timeOne : 2020-04-01 12:03:57.0
         * number : 85713
         * address : 永盛路全路段
         * cause : 不按规定停车
         * maney :
         * timeTwo :
         * state : 未处理
         * member :
         */

        private String carNumber;
        private String timeOne;
        private String number;
        private String address;
        private String cause;
        private String maney;
        private String timeTwo;
        private String state;
        private String member;

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        public String getTimeOne() {
            return timeOne;
        }

        public void setTimeOne(String timeOne) {
            this.timeOne = timeOne;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCause() {
            return cause;
        }

        public void setCause(String cause) {
            this.cause = cause;
        }

        public String getManey() {
            return maney;
        }

        public void setManey(String maney) {
            this.maney = maney;
        }

        public String getTimeTwo() {
            return timeTwo;
        }

        public void setTimeTwo(String timeTwo) {
            this.timeTwo = timeTwo;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMember() {
            return member;
        }

        public void setMember(String member) {
            this.member = member;
        }
    }
}
