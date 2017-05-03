package cn.vacuumflask.gankapp.entity.bean;

import android.databinding.BaseObservable;

/**
 * Created by Administrator on 2017/5/2 0002.
 * Android 和 IOS 的Item显示类
 */

public class ItemShow extends BaseObservable {

    private String author;//作者
    private String createTime;//创建时间
    private String url;//地址
    private String desc;//描述

    public ItemShow() {
    }

    public ItemShow(String author, String createTime, String url, String desc) {
        this.author = author;
        this.createTime = createTime;
        this.url = url;
        this.desc = desc;
    }

    private ItemShow(Builder builder) {
        this.author = builder.author;
        this.createTime = builder.createTime;
        this.url = builder.url;
        this.desc = builder.desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ItemShow{" +
                "author='" + author + '\'' +
                ", createTime='" + createTime + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }


    public static class Builder {
        private String author;//作者
        private String createTime;//创建时间
        private String url;//地址
        private String desc;//描述

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public ItemShow build() {
            return new ItemShow(this);
        }


    }

}
