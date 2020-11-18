package com.pascal.myapplication.network

import com.pascal.myapplication.model.login.ResponseLogin
import com.pascal.myapplication.model.visitors.ResponseAction
import com.pascal.myapplication.model.visitors.ResponseVisitors
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    //getData
    @GET("getData.php")
    fun getData(): Flowable<ResponseVisitors>

    //insert
    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(@Field("name") name: String,
                   @Field("address") address: String,
                   @Field("nohp") nohp: String,
                   @Field("profession") profession: String,
                   @Field("visitors") visitors: String) : Flowable<ResponseAction>

    //update
    @FormUrlEncoded
    @POST("update.php")
    fun updateData(@Field("id") id: String,
                   @Field("name") name: String,
                   @Field("address") address: String,
                   @Field("nohp") nohp: String,
                   @Field("profession") profession: String,
                   @Field("visitors") visitors: String) : Flowable<ResponseAction>

    //delete
    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData(@Field("id") id: String) : Flowable<ResponseAction>

    //login
    @FormUrlEncoded
    @POST("login.php")
    fun loginData (@Field("user_email") email: String,
                   @Field("user_password") password: String) : Flowable<ResponseLogin>

    //register
    @FormUrlEncoded
    @POST("register.php")
    fun registerData (@Field("user_email") email: String,
                        @Field("user_password") password: String) : Flowable<ResponseAction>
}