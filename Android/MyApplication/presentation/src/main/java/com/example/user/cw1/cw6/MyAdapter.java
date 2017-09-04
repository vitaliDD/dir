package com.example.user.cw1.cw6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.cw1.R;

import java.util.ArrayList;

/**
 * Created by user on 04.08.2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private ArrayList<String> items;

    public MyAdapter(ArrayList<String> items) {
        this.items=items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("AAA","onCreateViewolder");
        View root= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_recycle_view, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("AAA","onBindViewHolder() position = "+position);
        String item=items.get(position);
        //holder.imageView - заполнить дома
        holder.textView111.setText(item);



    }

    @Override
    public int getItemCount() {
        return items==null?0:items.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView111;


        public Holder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.cw6ImageView);
            textView111=(TextView) itemView.findViewById(R.id.cw6TextView);
        }
    }
}
