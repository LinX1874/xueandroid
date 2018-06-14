package com.linx.xueandroid.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.linx.xueandroid.R;
import com.linx.xueandroid.adapter.HomeAdapter;
import com.linx.xueandroid.base.RxLazyFragment;
import com.linx.xueandroid.bean.HomeBean;
import com.linx.xueandroid.databinding.FragmentHomeBinding;
import com.linx.xueandroid.presenter.HomePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;


public class HomeFragment extends RxLazyFragment {

    HomeBean mhomeBean = new HomeBean();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

//    FragmentHomeBinding binding;

    //    HomePresenter homePresenter;
    HomeAdapter homeAdapter;

    RecyclerView mRecyclerView;

    @Override
    public void finishCreateView(Bundle state) {
        mRecyclerView = (RecyclerView) parentView.findViewById(R.id.recyclerView);
//        homePresenter.getArticle(1);
//        RefreshLayout refreshLayout = (RefreshLayout) parentView.findViewById(R.id.refreshLayout);
        int page = 0;


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
                    homeAdapter = new HomeAdapter(getActivity(), mhomeBean.getData().getDatas(), R.layout.item_home);
                else {
                    homeAdapter.insertAll(homeBean.getData().getDatas());
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerView.setAdapter(homeAdapter);
                homeAdapter.notifyDataSetChanged();
            }
        });
    }

}
