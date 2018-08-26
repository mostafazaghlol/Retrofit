package com.mentors.retrofit.root;

import com.mentors.retrofit.ApiModule;
import com.mentors.retrofit.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class , ApiModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
