package com.example.user.data.net;

import com.example.user.data.entity.Profile;
import com.example.user.data.entity.cw12Profile;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 16.08.2017.
 */
public interface RestApi {

//    @GET("data/profile")
//    Observable<List<Profile>> getProfiles(); //ретровфит обратится к бзовой ссылке,склеит с этой ссылкой,
//    // там все распарсится и вернется объектом Profile
//
//    @POST("data/profile")
//    Observable<Void> saveProfile(@Body Profile profile);//body - в формате json положит наш объект и передаст на сервер


    @GET("data/myTables")
    Observable<List<Profile>> getProfiles1();

    @GET("data/myTables?pageSize=100")
   // @GET("data/myTables")
    Observable<List<cw12Profile>> getProfiles(); //ретровфит обратится к бзовой ссылке,склеит с этой ссылкой,
    // там все распарсится и вернется объектом Profile


    @GET("data/myTables/{id}")
    Observable<cw12Profile> getProfile(@Path("id")String id); //ретровфит обратится к бзовой ссылке,склеит с этой ссылкой,
    // там все распарсится и вернется объектом Profile

    @POST("data/myTables")
    Observable<Void> saveProfile(@Body cw12Profile profile);//body - в формате json положит наш объект и передаст на сервер

    @POST("data/myTables")
    Observable<Void> saveProfile1(@Body Profile profile);

    @PUT("data/myTables/{objectId}")
    Observable<Void> updateProfile(@Path("objectId")String id, @Body cw12Profile profile);//body - в формате json положит наш объект и передаст на сервер
}
