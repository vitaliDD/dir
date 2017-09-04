package com.example.user.cw1.dz9;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.cw1.R;
import com.example.user.cw1.databinding.ActivityDz9Binding;
import com.example.user.cw1.databinding.Dz9ItemRecycleViewBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by user on 04.08.2017.
 */
public class Dz9Adapter extends RecyclerView.Adapter<Dz9Adapter.Holder> {
    private ArrayList<String> items;
    Context context;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Dz9Adapter(ArrayList<String> items, Context context) {
        this.items=items;
        this.context=context;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {// при создании используется
        Log.e("BBB","onCreateViewolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Dz9ItemRecycleViewBinding binding = Dz9ItemRecycleViewBinding.inflate(inflater, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {// при прокрутке тспользуется
        Log.e("BBB", "onBindViewHolder() position = " + position);
        final String item=items.get(position);

        Dz9ItemViewModel model= new Dz9ItemViewModel(item);
        holder.binding.setItemViewModel(model);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                    listener.OnItemClick(item);
            }
        });




    }

    @Override
    public int getItemCount() {
        return items==null?0:items.size();
    }//получаем количество элементов

    public static class Holder extends RecyclerView.ViewHolder{
        Dz9ItemRecycleViewBinding binding;


        public Holder(View itemView) {
            super(itemView);
           binding = DataBindingUtil.bind(itemView);

        }
    }

    interface OnItemClickListener{

        public void OnItemClick(String item);
    }

}

