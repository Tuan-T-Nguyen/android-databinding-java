package com.example.nguyenthanhtuan.mvvmpost.di.module;

import com.example.nguyenthanhtuan.mvvmpost.network.PostApi;
import com.example.nguyenthanhtuan.mvvmpost.utils.Constants;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Reusable
    PostApi providePostApi(Retrofit retrofit) {
        return retrofit.create(PostApi.class);
    }

    @Provides
    @Reusable
    Retrofit provideRetrofitInterface() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

    }
}
