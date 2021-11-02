package com.kiran.myapplication;


import com.kiran.myapplication.Response.Fetchuser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String REGIURL = "https://butch-towers.000webhostapp.com/matrimony/";
    @FormUrlEncoded
    @POST("https://butch-towers.000webhostapp.com/matrimony/simpleregister.php")
    Call<String> getUserRegi(
            @Field("fullname") String name,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );

    String LOGINURL = "https://butch-towers.000webhostapp.com/matrimony/";
    @FormUrlEncoded
    @POST("https://butch-towers.000webhostapp.com/matrimony/simplelogin.php")
    Call<String> getUserLogin(
            @Field("email") String email,
            @Field("password") String password
    );

//    String REQUEST = "https://butch-towers.000webhostapp.com/userno/";
//    @FormUrlEncoded
//    @POST("https://butch-towers.000webhostapp.com/userno/requestform.php")
//    Call<String> requestForm(
//            @Field("unit") String unit,
//            @Field("grp") String group,
//            @Field("contact") String contact,
//            @Field("fname") String fname,
//            @Field("lname") String lname,
//            @Field("cond") String condition
//    );

    @GET("https://butch-towers.000webhostapp.com/matrimony/display.php")
    Call<Fetchuser> fetchAllUsers();
}
