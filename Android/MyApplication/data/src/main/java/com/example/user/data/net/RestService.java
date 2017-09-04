package com.example.user.data.net;

import android.util.Log;

import com.example.user.data.entity.Profile;
import com.example.user.data.entity.cw12Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 16.08.2017.
 */
public class RestService {

    private static final RestService instance = new RestService();
    private RestApi restApi;

    private RestService() {
        init();
    }

    public static RestService getInstance() {

        return instance;

    }


    private void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")
                .baseUrl("https://api.backendless.com/E306428C-F94F-B3D5-FF35-6F20F9600400/A9468BE4-FCBE-67F3-FF31-1F1482C47A00/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).build();

        restApi = retrofit.create(RestApi.class);


    }
    public Observable<List<Profile>> getProfiles1() {
        return restApi.getProfiles1();
    }

    public Observable<List< cw12Profile >> getProfiles() {
        return restApi.getProfiles();


    }
    public Observable<cw12Profile> getProfile(String id) {
        return restApi.getProfile(id);


    }

    public Observable<Void> saveProfile(cw12Profile profile) {

        return restApi.saveProfile(profile);
    }
    public Observable<Void> saveProfile1(Profile profile) {

        return restApi.saveProfile1(profile);
    }


    public Observable<Void> updateProfile(String id,cw12Profile profile) {
        Log.e("qqqq", "updateProfile " +id+" "+profile);

        return restApi.updateProfile(id, profile);
    }


}

