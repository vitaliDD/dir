package com.example.ya.testapp.model.net;

import com.example.ya.testapp.model.entity.JsonNYT;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by user on 16.08.2017.
 */
public interface RestApi {

    @GET("automobiles.json?api-key=624c8eef24f04b3e95d7a87b85b0471e")
    Observable<JsonNYT> getJsonNYT();
}
