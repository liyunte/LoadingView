package com.lyt.loading;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lyt.loading.library.LoadView;
import com.lyt.loading.library.Loading;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "liyunte";
    private TextView tv_test;
    private LoadView loadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_test = findViewById(R.id.tv_test);
        loadView = Loading.get().wrap(tv_test);
    }


    public void loading(View view) {
        loadView.showLoading();
    }

    public void empty(View view) {
        loadView.showEmpty();
    }

    public void errory(View view) {
        loadView.showError();
    }

    public void success(View view) {
        loadView.showSuccess();
    }
}
