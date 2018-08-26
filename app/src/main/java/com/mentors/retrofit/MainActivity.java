package com.mentors.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mentors.retrofit.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Inject
    ContactUsAPI contactUsAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getComponent().inject(this);

        Call<Contactus> call = contactUsAPI.getContacts();
        call.enqueue(new Callback<Contactus>() {
            @Override
            public void onResponse(Call<Contactus> call, Response<Contactus> response) {
                List<Datum> gameList = response.body().getData();

                for (Datum top : gameList){
                    System.out.println(top.getEmail());
                }
            }

            @Override
            public void onFailure(Call<Contactus> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}