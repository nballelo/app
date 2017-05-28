package edu.upc.eetac.dsa.android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Ignacio on 24/05/2017.
 */

public interface Service {
    String URL="http://10.0.2.2:8080/myapp/";

    @GET("json/Log/Nacho")
    Call<User> calUser();

    @POST("json/LogIn")
    Call<User> login(@Body User user);

    @POST("json/SingIn")
    Call<User> sinin(@Body User user);

    @GET("json/{name}/getEetakemons")
    Call<List<String>> eetakemons(@Path("name")String name);

    @POST("json/{name}/setEetakemon")
    Call<String> setEetakemon(@Path("name")String name,@Body Eetackemon eetackemon);
}
