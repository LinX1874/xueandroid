package com.linx.xueandroid.base;

/**
 * 描述：api 地址
 * 作者：LinX
 * 创建时间：2018/6/15 13:47
 */
public class BaseApi {

    public static String getArticle(int page) {
        return "article/list/" + page + "/json";
    }

    public static String getBanner() {
        return "banner/json";
    }

}
