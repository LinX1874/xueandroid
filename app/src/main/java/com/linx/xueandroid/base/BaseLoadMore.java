package com.linx.xueandroid.base;

import android.support.annotation.LayoutRes;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 17:42
 */
public abstract class BaseLoadMore {
    //loadMOre的不同状态
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_LOADING = 2;
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_END = 4;
    public static final int STATUS_NO_MORE = 5;

    private int mLoadMoreStatus = STATUS_DEFAULT;

    public void setLoadMoreStatus(int loadMoreStatus) {
        this.mLoadMoreStatus = loadMoreStatus;
    }

    public int getLoadMoreStatus() {
        return mLoadMoreStatus;
    }

    // 加载loadMore试图
    public abstract @LayoutRes
    int getLayoutId();

    // 数据转化
    public abstract void convert(BaseViewHolder holder, int loadMoreStatus);
}
