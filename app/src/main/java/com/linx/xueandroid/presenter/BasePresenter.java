package com.linx.xueandroid.presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.linx.xueandroid.ui.view.IBaseView;

/**
 * Created by 皓然 on 2017/6/15.
 */

public abstract class BasePresenter<GV extends IBaseView> {


    protected Gson gson = new Gson();
    protected GV mView;
    protected Activity mContext;


    public BasePresenter(Activity context, GV view) {
        mContext = context;
        mView = view;
    }


    protected BasePresenter() {
    }

    public long getCurrentTime() {
        java.util.Date date = new java.util.Date();
        long datetime = date.getTime();
        return datetime;
    }


}
