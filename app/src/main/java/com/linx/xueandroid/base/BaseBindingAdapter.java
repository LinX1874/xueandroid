package com.linx.xueandroid.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 描述：mvvm下的RecyclerView的Adapter
 * 作者：LinX
 * 创建时间：2018/6/13 17:57
 */
public abstract class BaseBindingAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected Context context;
    protected ObservableArrayList<M> items;


    public BaseBindingAdapter(Context context) {
        this.context = context;
        this.items = new ObservableArrayList<>();
    }

    public ObservableArrayList<M> getItems() {
        return items;
    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(this.context), this.getLayoutResId(viewType), parent, false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B binding = DataBindingUtil.getBinding(holder.itemView);
        this.onBindItem(binding, this.items.get(position));
    }

    @LayoutRes
    protected abstract int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, M item);


    public class BaseBindingViewHolder extends RecyclerView.ViewHolder {
        public BaseBindingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
