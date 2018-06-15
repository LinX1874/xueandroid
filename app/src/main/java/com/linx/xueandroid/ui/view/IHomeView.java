package com.linx.xueandroid.ui.view;

import com.linx.xueandroid.bean.HomeBean;

import java.util.List;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 18:39
 */
public interface IHomeView extends IBaseView {
    void fillData(List<HomeBean.DataBean.DatasBean> datasBeanList);


}
