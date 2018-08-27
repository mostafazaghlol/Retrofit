package com.mentors.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface  ContactUsAPI {
    @GET("contactus_api")
    Call<Contactus> getContacts();

    @GET("contactus_api")
    rx.Observable<Contactus> getTopContacts();


}
