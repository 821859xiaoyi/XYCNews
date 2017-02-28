package com.xiaoyi.xycnews.bean;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class RobotMSGBean {

    public static final int MSG_RECEIVED = 0;
    public static final int MSG_SEND = 1;

    private String msg;
    private int type;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RobotMSGBean{" +
                "msg='" + msg + '\'' +
                ", type=" + type +
                '}';
    }
}