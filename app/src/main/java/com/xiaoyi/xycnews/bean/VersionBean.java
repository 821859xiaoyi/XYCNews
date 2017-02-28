package com.xiaoyi.xycnews.bean;


/**
 * 创建者：  徐宜程
 * 创建日期： 2017/2/28
 */
// https://github.com/8212859xiaoyi/XYCNews/raw/master/XYCNews.apk
public class VersionBean {

    @Override
    public String toString() {
        return "VersionBean{" +
                "versionName='" + versionName + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }

    private String versionName;//你好
    private String downloadUrl;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
