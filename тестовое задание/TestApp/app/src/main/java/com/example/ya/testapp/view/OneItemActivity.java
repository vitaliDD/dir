package com.example.ya.testapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.ya.testapp.R;
import com.example.ya.testapp.presenter.OneItemBasePresenter;
import com.example.ya.testapp.presenter.OneItemPresenter;

/**
 * Created by ya
 * on 23.11.2017.
 */

public class OneItemActivity extends Activity implements OneItemView{
    private TextView textView;
    private OneItemBasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_item);
        textView=findViewById(R.id.itemTextView);
        presenter=new OneItemPresenter();
        presenter.attachView(this);
        presenter.showText();
    }

    @Override
    public void setText() {
        textView.setText(getIntent().getExtras().getString("captation","Some text"));
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();

    }
}
