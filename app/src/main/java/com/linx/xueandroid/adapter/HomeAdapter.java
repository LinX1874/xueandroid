package com.linx.xueandroid.adapter;

import android.content.Context;

import com.linx.xueandroid.R;
import com.linx.xueandroid.base.BaseBindingAdapter;
import com.linx.xueandroid.bean.HomeBean;
import com.linx.xueandroid.databinding.HomeItemBinding;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 14:06
 */
public class HomeAdapter extends BaseBindingAdapter<HomeBean.DataBean.DatasBean, HomeItemBinding> {
    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_home;
    }

    @Override
    protected void onBindItem(HomeItemBinding binding, HomeBean.DataBean.DatasBean item) {
        binding.setItem(item);
    }
}
