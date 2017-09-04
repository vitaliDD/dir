package com.example.user.cw1.dz6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.cw1.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by user on 04.08.2017.
 */
public class Dz6Adapter extends RecyclerView.Adapter<Dz6Adapter.Holder> {
    private ArrayList<String> items;
    Context context;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Dz6Adapter(ArrayList<String> items, Context context) {
        this.items=items;
        this.context=context;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {// при создании используется
        Log.e("AAA","onCreateViewolder");
        View root= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.dz6_item_recycle_view, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {// при прокрутке тспользуется
        Log.e("AAA", "onBindViewHolder() position = " + position);
        final String item=items.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                    listener.OnItemClick(item);
            }
        });
        //String item=items.get(position);
        //holder.imageView - заполнить дома
        Picasso.with(context).load(items.get(position).toString())
                .into(holder.imageView);
//        Picasso.with(context).load("http://mobi.pro-z.net/images/pictures/indication_007.jpg")
//                .into(holder.imageView);
       // holder.imageView.setImageResource(R.drawable.sova_anmation_1);



    }

    @Override
    public int getItemCount() {
        return items==null?0:items.size();
    }//получаем количество элементов

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        //TextView textView111;


        public Holder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.dz6ImageView);

        }
    }

    interface OnItemClickListener{

        public void OnItemClick(String item);
    }

}

