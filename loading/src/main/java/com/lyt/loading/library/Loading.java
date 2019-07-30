package com.lyt.loading.library;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lyt.loading.library.interfaces.ILoading;

public class Loading {

    private ILoading loading;

    private Loading() {
    }

    public static Loading get() {
        return SingleTon.LOADING;
    }

    private static final class SingleTon {
        private static Loading LOADING = new Loading();
    }


    public static void initILoading(ILoading loading) {
        if (loading == null) {
            throw new NullPointerException("the parms loading is Null");
        }
        get().loading = loading;
    }

    /**
     * @param view
     * @return
     */
    public LoadView wrap(View view) {
        return wrap(view, loading);
    }


    /**
     *
     */
    public LoadView wrap(View view, ILoading loading) {
        checkNull(view,"the wraps view is Null");
        checkNull(loading,"the parms loading is Null");
        FrameLayout wrapper = new FrameLayout(view.getContext());
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp != null) {
            wrapper.setLayoutParams(lp);
        }
        if (view.getParent() != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            int index = parent.indexOfChild(view);
            parent.removeView(view);
            parent.addView(wrapper, index);
        }
        FrameLayout.LayoutParams newLp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        wrapper.addView(view, newLp);
        return new LoadView(loading, wrapper);
    }

    private void checkNull(Object o,String exception){
        if (o==null){
            throw new NullPointerException(exception);
        }
    }

}
