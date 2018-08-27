package com.mentors.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mentors.retrofit.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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

        //RX JAVA SAME CALL .
        contactUsAPI.getTopContacts().flatMap(new Func1<Contactus, Observable<Datum>>() {
            @Override
            public Observable<Datum> call(Contactus contactus) {
                return Observable.from(contactus.getData());
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Datum>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Datum datum) {
                        System.out.println("RX" + datum.getEmail());
                        System.out.println(datum.getFaceAccount());
                        System.out.println(datum.getFax());
                        System.out.println(datum.getGoogleplus());
                        System.out.println(datum.getPhone());
                    }
                });


    }
}