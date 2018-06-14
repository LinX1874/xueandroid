package com.linx.xueandroid.adapter;

import android.content.Context;

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
        holder.setText(R.id.txv_article_name,item.getTitle());
//        holder.setText();
//        holder.setText();
//        holder.setText();

    }


}
