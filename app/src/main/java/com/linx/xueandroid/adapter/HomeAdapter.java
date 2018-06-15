package com.linx.xueandroid.adapter;

import android.content.Context;
import android.view.View;

import com.linx.xueandroid.R;
import com.linx.xueandroid.base.BaseAdapter;
import com.linx.xueandroid.base.BaseViewHolder;
import com.linx.xueandroid.bean.HomeBean;

import java.util.List;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 17:46
 */
public class HomeAdapter extends BaseAdapter<HomeBean.DataBean.DatasBean> {
    public HomeAdapter(Context context, List<HomeBean.DataBean.DatasBean> list, int itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, HomeBean.DataBean.DatasBean item, int position, boolean isScrolling) {
        holder.setText(R.id.txv_article_name, item.getTitle());

        holder.setText(R.id.txv_article_type, item.getSuperChapterName());

        holder.setText(R.id.txv_desc, item.getDesc());

        if (item.getDesc().length() <= 0) {
            holder.setVisibility(R.id.txv_desc, View.GONE);
        } else {
            holder.setVisibility(R.id.txv_desc, View.VISIBLE);
        }
        holder.setText(R.id.txv_auth_name, item.getAuthor());

        holder.setText(R.id.txv_time, item.getNiceDate());


    }


}
