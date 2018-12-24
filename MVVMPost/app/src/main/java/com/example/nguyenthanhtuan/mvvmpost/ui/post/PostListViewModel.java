package com.example.nguyenthanhtuan.mvvmpost.ui.post;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.example.nguyenthanhtuan.mvvmpost.base.BaseViewModel;
import com.example.nguyenthanhtuan.mvvmpost.network.PostApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PostListViewModel extends BaseViewModel {

    @Inject
    PostApi postApi;

    private MutableLiveData<Integer> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Integer> loadingVisibility = new MutableLiveData<>();

    private Disposable subcription;

    @Override
    public void init() {
        super.init();
        loadPosts();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        subcription.dispose();
    }

    private void loadPosts() {
       subcription = postApi.getPosts()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .doOnSubscribe(new Consumer<Disposable>() {
                   @Override
                   public void accept(Disposable disposable) throws Exception {
                       loadingVisibility.setValue(View.VISIBLE);
                   }
                   
               })
               .doOnTerminate(() -> {
                   loadingVisibility.setValue(View.GONE);
                   errorMessage.setValue(null);
               })
               .subscribe(
                       new Consumer<List<PostApi>>() {
                           @Override
                           public void accept(List<PostApi> postApis) throws Exception {

                           }
                       },
                       new Consumer<Throwable>() {
                           @Override
                           public void accept(Throwable throwable) throws Exception {

                           }
                       }
               );
    }

}
