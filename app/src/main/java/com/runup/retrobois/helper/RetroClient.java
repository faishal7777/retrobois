package com.runup.retrobois.helper;



import com.runup.retrobois.Login;
import com.runup.retrobois.ModelSuccess;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetroClient {
    /*@GET("jadwal")
    Call<List<Jadwal>> pickJadwal();
    @GET("form")
    Call<Form> pickForm();*/

    @POST("login")
    Call<ModelSuccess> loginA(@Body Login login);

    @POST("login")
    Call<ModelSuccess> login(@Query("user_id") String user_id, @Query("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<ModelSuccess> masuk(@Field("id_user") String userId, @Field("password") String password);


}
