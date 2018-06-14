package com.linx.xueandroid.model;

import android.app.Activity;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.linx.xueandroid.BR;
import com.linx.xueandroid.R;
import com.linx.xueandroid.adapter.HomeAdapter;
import com.linx.xueandroid.base.BaseViewModel;
import com.linx.xueandroid.bean.HomeBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;


/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 14:40
 */
public class HomeViewModel extends BaseViewModel {

    Activity mActivity;
    RecyclerView mRecyclerView;



    public HomeViewModel(Activity activity, RecyclerView recyclerView) {
        this.mActivity = activity;
        this.mRecyclerView = recyclerView;
    }

    HomeBean mhomeBean = new HomeBean();

    HomeAdapter homeAdapter;

    public void getArticle(int page) {

        EasyHttp.get("article/list/" + page + "/json").execute(new SimpleCallBack<String>() {
            @Override
            public void onError(ApiException e) {

            }

            @Override
            public void onSuccess(String obj) {

                Gson gson = new Gson();
                HomeBean homeBean = gson.fromJson(obj, HomeBean.class);

                if (page == 0) {
                    mhomeBean = new HomeBean();
                }
                mhomeBean.getData().setDatas(homeBean.getData().getDatas());

                if (homeAdapter == null)
                    homeAdapter = new HomeAdapter(mActivity);
                homeAdapter.getItems().addAll(mhomeBean.getData().getDatas());
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                mRecyclerView.setAdapter(homeAdapter);
                homeAdapter.notifyDataSetChanged();
            }
        });
    }

}
