package com.lyt.loading.library.bean;

import com.lyt.loading.library.interfaces.OnRetryListener;

public class LoadBean {
    private Object data;
    private OnRetryListener onRetryListener;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OnRetryListener getOnRetryListener() {
        return onRetryListener;
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.onRetryListener = onRetryListener;
    }
}
