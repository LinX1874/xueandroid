package com.linx.xueandroid.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.linx.xueandroid.R;
import com.linx.xueandroid.adapter.HomeAdapter;
import com.linx.xueandroid.base.RxLazyFragment;
import com.linx.xueandroid.bean.BannerBean;
import com.linx.xueandroid.bean.HomeBean;

import com.linx.xueandroid.presenter.HomePresenter;
import com.linx.xueandroid.ui.view.IHomeView;
import com.linx.xueandroid.utils.GlideImageLoader;
import com.linx.xueandroid.utils.LogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;


import java.util.ArrayList;
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

    @BindView(R.id.banner)
    Banner banner;

    HomePresenter homePresenter;
    int page = 0;

    @Override
    public void finishCreateView(Bundle state) {

        refreshLayout.setFloatRefresh(true);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                homePresenter.getArticle(page);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                page++;
                homePresenter.getArticle(page);
            }
        });

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homePresenter = new HomePresenter(this.getActivity(), this);

        homePresenter.getArticle(page);


    }

    @Override
    public void fillData(List<HomeBean.DataBean.DatasBean> datasBeanList) {
        if (homeAdapter == null) {
            homeAdapter = new HomeAdapter(getActivity(), datasBeanList, R.layout.item_home);
            mRecyclerView.setAdapter(homeAdapter);
        } else {
            homeAdapter.insertAll(datasBeanList);
        }


        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void fillBanner(List<BannerBean.DataBean> datasBeanList) {

        List<String> titles = new ArrayList<>();
        List<String> images = new ArrayList<>();

        for (int i = 0; i < datasBeanList.size(); i++) {
            titles.add(datasBeanList.get(i).getTitle());
            images.add(datasBeanList.get(i).getImagePath());
        }

        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用


        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ShowToast(datasBeanList.get(position).getUrl());
            }
        });
    }

    @Override
    public void ShowToast(String t) {

    }

    @Override
    public void showProgressDialog() {
        refreshLayout.startRefresh();
    }

    @Override
    public void dimissProgressDialog() {
        refreshLayout.finishRefreshing();
        refreshLayout.finishLoadmore();
    }


}
