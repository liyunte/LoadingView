package com.lyt.loading.library.interfaces;


import android.view.View;
import android.view.ViewGroup;

import com.lyt.loading.library.LoadState;
import com.lyt.loading.library.LoadView;
import com.lyt.loading.library.bean.LoadBean;

public interface ILoading {

    View createView(ViewGroup parent, LoadState state, LoadBean bean);

}
