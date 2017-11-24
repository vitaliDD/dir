package com.example.ya.testapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.ya.testapp.R;
import com.example.ya.testapp.presenter.AlllItemBasePresenter;
import com.example.ya.testapp.presenter.AlllItemPresenter;
import com.example.ya.testapp.presenter.entity.MultimediumPresenter;

import java.util.List;

public class AllItemActivity extends Activity implements AllItemView {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AlllItemBasePresenter presenter;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_item);
        progressBar = findViewById(R.id.progressBar);
        presenter = new AlllItemPresenter();
        presenter.attachView(this);
        presenter.getList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    //прячем прогресс-бар
    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    //старт активити айтема
    @Override
    public void startNewActivity(String item) {
        Intent intent = new Intent(this, OneItemActivity.class);
        intent.putExtra("captation", item);
        startActivity(intent);

//тост об ошибке, если нет сети
    }

    @Override
    public void showError(int error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    //установка адаптера
    @Override
    public void setAdapter(List<MultimediumPresenter> multPresList) {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllItemActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(multPresList, AllItemActivity.this);
        adapter.setListener(new Adapter.OnItemClickListener() {
            @Override
            public void OnItemClick(String item) {
                presenter.onItemClick(item);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
