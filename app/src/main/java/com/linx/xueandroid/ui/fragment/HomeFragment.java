package com.linx.xueandroid.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linx.xueandroid.R;
import com.linx.xueandroid.base.RxLazyFragment;
import com.linx.xueandroid.databinding.FragmentHomeBinding;
import com.linx.xueandroid.model.HomeViewModel;


public class HomeFragment extends RxLazyFragment {


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    FragmentHomeBinding binding;

    HomeViewModel homeViewModel;

    @Override
    public void finishCreateView(Bundle state) {

        homeViewModel.getArticle(1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        homeViewModel = new HomeViewModel(getActivity(), binding.recyclerView);
        return super.onCreateView(inflater, container, state);
    }
}
