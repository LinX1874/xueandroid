package com.linx.xueandroid.presenter;

import android.app.Activity;
import android.app.ProgressDialog;

import com.linx.xueandroid.bean.HomeBean;
import com.linx.xueandroid.ui.view.IHomeView;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;


/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 14:40
 */
public class HomePresenter extends BasePresenter<IHomeView> {

    Activity mActivity;

    IHomeView homeView;

    public HomePresenter(Activity activity, IHomeView iHomeView) {
        this.mActivity = activity;
        this.homeView = iHomeView;
    }



    public void getArticle(int page) {

        EasyHttp.get("article/list/" + page + "/json").execute(new SimpleCallBack<String>() {
            @Override
            public void onError(ApiException e) {

            }

            @Override
            public void onSuccess(String obj) {
                HomeBean homeBean = gson.fromJson(obj, HomeBean.class);
                homeView.fillData(homeBean.getData().getDatas());

            }
        });
    }

}
