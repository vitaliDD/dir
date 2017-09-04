package com.example.user.cw1.dz9;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.example.user.cw1.base.BaseViewModel;
import com.squareup.picasso.Picasso;

/**
 * Created by ya on 20.08.2017.
 */

public class Dz9ItemViewModel implements BaseViewModel {

    private ObservableField<String> url;

    public ObservableField<String> getUrl() {
        return url;
    }

    public void setUrl(ObservableField<String> url) {
        this.url = url;
    }

    public Dz9ItemViewModel(String url) {
        this.url= new ObservableField<>(url);
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
