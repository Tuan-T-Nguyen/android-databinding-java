package com.example.nguyenthanhtuan.mvvmpost.di.component;

import com.example.nguyenthanhtuan.mvvmpost.di.module.NetworkModule;
import com.example.nguyenthanhtuan.mvvmpost.ui.post.PostListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    public void inject(PostListViewModel postListViewModel);

    @Component.Builder
    interface Builder {
        public ViewModelInjector build();

        public Builder networkModle(NetworkModule networkModule);
    }
}
