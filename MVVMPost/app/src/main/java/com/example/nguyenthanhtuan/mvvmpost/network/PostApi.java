package com.example.nguyenthanhtuan.mvvmpost.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostApi {
    @GET("/posts")
    Observable<List<PostApi>> getPosts();
}
