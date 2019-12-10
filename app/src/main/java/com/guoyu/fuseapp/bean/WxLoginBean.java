package com.guoyu.fuseapp.bean;

/**
 * Created by Administrator on 2019/10/25.
 */

public class WxLoginBean {

    /**
     * access_token : 26_hEcicPEGcg4PmNW-Z13pnNcbxxdPip4dqO-8NXUTR3EW6ggI0itCxILbRzdiE6NveG96knUDm0YsSOZZ6Ji-YkduuEffst16hoDqgKTEQ7Q
     * expires_in : 7200
     * refresh_token : 26_DXkCKPYqUWdhLr61JJu_e5P1B4QxW5hUWSsZmqIfHaSXMBT1jYHFTAmIyGqGQTLoy5dDC-7vyB4haZbMp6SQFG5KGOggiatYMCpTDYeUfnk
     * openid : oESm8s2yaDpyrQH_bHtijJmFtkRQ
     * scope : snsapi_userinfo
     * unionid : oVcZV58S_QYU8jnWa1ocy-o6Hofk
     */

    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
