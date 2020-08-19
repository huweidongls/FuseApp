package com.guoyu.fuseapp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/19.
 */

public class WeizhangBean implements Serializable {

    private List<ArrayList<String>> data;

    public List<ArrayList<String>> getData() {
        return data;
    }

    public void setData(List<ArrayList<String>> data) {
        this.data = data;
    }
}
