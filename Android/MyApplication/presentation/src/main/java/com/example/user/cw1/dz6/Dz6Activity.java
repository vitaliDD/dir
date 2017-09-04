package com.example.user.cw1.dz6;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.cw1.R;
import com.example.user.cw1.cw6.MyAdapter;

import java.util.ArrayList;

/**
 * Created by ya on 06.08.2017.
 */

public class Dz6Activity extends Activity {


    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz6);
        recyclerView = (RecyclerView) findViewById(R.id.dz6recyclerView);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/cartoons_026.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/indication_007.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/cinema_023.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/indication_024.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/erotic_049.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/cartoons_023.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/cartoons_101.jpg");
        stringArrayList.add("http://mobi.pro-z.net/images/pictures/auto_013.jpg");
        Dz6Adapter adapter=new Dz6Adapter(stringArrayList,Dz6Activity.this);
        adapter.setListener(new Dz6Adapter.OnItemClickListener() {
            @Override
            public void OnItemClick(String item) {
                Log.e("AAA", "OnItemClick item = " + item);
            }
        });

        recyclerView.setAdapter(adapter);




    }
}
