package com.example.user.cw1.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by user on 09.08.2017.
 */
abstract public class BaseActivity extends Activity {
    protected BaseViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.init();

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}
