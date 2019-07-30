package com.lyt.loading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyt.loading.library.LoadState;
import com.lyt.loading.library.bean.LoadBean;
import com.lyt.loading.library.interfaces.ILoading;

class LoadViewAdapter implements ILoading {
    @Override
    public View createView(ViewGroup parent, LoadState state, LoadBean bean) {
        int resLayout = 0;
        switch (state){
            case ERROR:
                resLayout = R.layout.error;
                break;
            case LOADING:
                resLayout = R.layout.loading;
                break;
            case EMPTY:
                resLayout = R.layout.empty;
                break;
        }
        return LayoutInflater.from(parent.getContext()).inflate(resLayout,parent,false);
    }
}
