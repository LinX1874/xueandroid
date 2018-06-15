package com.linx.xueandroid.ui.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


//import com.cjj.MaterialRefreshLayout;
//import com.cjj.MaterialRefreshListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BallPulseView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.linx.xueandroid.R;
import com.linx.xueandroid.adapter.HomeAdapter;
import com.linx.xueandroid.base.RxLazyFragment;
import com.linx.xueandroid.bean.HomeBean;

import com.linx.xueandroid.presenter.HomePresenter;
import com.linx.xueandroid.ui.view.IHomeView;


import java.util.List;

import butterknife.BindView;


public class HomeFragment extends RxLazyFragment implements IHomeView {


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    HomeAdapter homeAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;


    HomePresenter homePresenter;
    int page = 0;

    @Override
    public void finishCreateView(Bundle state) {

        refreshLayout.setFloatRefresh(true);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadmore();
                    }
                }, 2000);
            }
        });




        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homePresenter = new HomePresenter(this.getActivity(), this);

        homePresenter.getArticle(page);


    }

    @Override
    public void fillData(List<HomeBean.DataBean.DatasBean> datasBeanList) {
        if (homeAdapter == null)
            homeAdapter = new HomeAdapter(getActivity(), datasBeanList, R.layout.item_home);
        else {
            homeAdapter.insertAll(datasBeanList);
        }


        mRecyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void ShowToast(String t) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dimissProgressDialog() {

    }


}
