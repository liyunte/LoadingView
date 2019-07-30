package com.lyt.loading.library;

import android.view.View;
import android.view.ViewGroup;

import com.lyt.loading.library.bean.LoadBean;
import com.lyt.loading.library.interfaces.ILoading;
import com.lyt.loading.library.interfaces.OnRetryListener;

import java.util.HashMap;
import java.util.Map;

public class LoadView {
    private Map<LoadState, View> views = new HashMap<>();
    private ILoading iLoading;
    private ViewGroup parent;
    private View currentView;
    private LoadBean loadBean  = new LoadBean();
    private LoadState state = LoadState.DEFAULT;

    public LoadView(ILoading iLoading, ViewGroup parent) {
        this.iLoading = iLoading;
        this.parent = parent;
    }

    public void showError() {
        showForState(LoadState.ERROR);
    }

    public void showEmpty() {
        showForState(LoadState.EMPTY);
    }

    public void showLoading() {
        showForState(LoadState.LOADING);
    }

    public void showSuccess() {
        showForState(LoadState.SUCCESS);
    }

    /**
     * 设置重试事件
     * @param listener
     */
    public void setOnRetryListener(OnRetryListener listener){
        loadBean.setOnRetryListener(listener);
    }

    /**
     * 设置数据
     * @param data
     */
    public void setData(Object data){
        loadBean.setData(data);
    }

    /**
     * 释放
     */
    public void release() {
        showSuccess();
        loadBean.setOnRetryListener(null);
        loadBean.setData(null);
        loadBean = null;
        views.clear();
        views = null;
        currentView = null;
        state = null;
    }

    private boolean isEmpty() {
        return iLoading == null || parent == null;
    }

    private void showForState(LoadState state) {
        if (this.state == state || isEmpty()) {
            return;
        }
        if (currentView != null) {
            if (state == LoadState.SUCCESS) {
                parent.removeView(currentView);
                currentView = null;
                this.state = state;
                return;
            }
            if (state != this.state) {
                parent.removeView(currentView);
            }
        }
        View stateView = views.get(state);
        if (stateView == null) {
            stateView = iLoading.createView(parent, state,loadBean);
            if (stateView == null) {
                throw new NullPointerException("the stateView is Null");
            }
            views.put(state, stateView);
        }
        parent.addView(stateView);
        this.state = state;
        this.currentView = stateView;
    }


}
