package com.linx.xueandroid.ui.view;

import android.view.View;

import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/15 13:31
 */
public class HeaderView implements IHeaderView {
    @Override
    public View getView() {
        return null;
    }

    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish(OnAnimEndListener animEndListener) {

    }

    @Override
    public void reset() {

    }
}
