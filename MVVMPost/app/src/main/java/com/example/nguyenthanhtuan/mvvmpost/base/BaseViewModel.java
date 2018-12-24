package com.example.nguyenthanhtuan.mvvmpost.base;

import android.arch.lifecycle.ViewModel;

import com.example.nguyenthanhtuan.mvvmpost.di.component.DaggerViewModelInjector;
import com.example.nguyenthanhtuan.mvvmpost.di.component.ViewModelInjector;
import com.example.nguyenthanhtuan.mvvmpost.di.module.NetworkModule;
import com.example.nguyenthanhtuan.mvvmpost.ui.post.PostListViewModel;

public class BaseViewModel extends ViewModel {
    private ViewModelInjector injector() {
        return DaggerViewModelInjector.builder()
                .networkModle(new NetworkModule())
                .build();
    }

    public void init() {
        inject();
    }

    private void inject() {
        if (this.getClass() == PostListViewModel.class) {
            injector().inject(new PostListViewModel());
        }
    }
}
