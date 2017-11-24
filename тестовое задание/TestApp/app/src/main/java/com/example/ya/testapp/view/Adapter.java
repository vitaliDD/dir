package com.example.ya.testapp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ya.testapp.R;
import com.example.ya.testapp.presenter.entity.MultimediumPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.08.2017.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<MultimediumPresenter> items = new ArrayList<>();
    private Context context;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Adapter(List<MultimediumPresenter> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {// при создании используется
        View root = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_recycle_view, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {// при прокрутке тспользуется
        final String imageItem = items.get(position).getUrl();
        final String copyrightItem = items.get(position).getCopyright();
        final String captionItem = items.get(position).getCaption();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.OnItemClick(captionItem);
            }
        });
        Glide.with(context).load(imageItem).into(holder.imageView);
        holder.textView.setText(copyrightItem);

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }//получаем количество элементов

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;


        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }

    interface OnItemClickListener {
        void OnItemClick(String item);
    }


}

