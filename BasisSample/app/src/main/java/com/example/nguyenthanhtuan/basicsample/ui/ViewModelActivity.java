package com.example.nguyenthanhtuan.basicsample.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyenthanhtuan.basicsample.R;
import com.example.nguyenthanhtuan.basicsample.data.ProfileObservableViewModel;
import com.example.nguyenthanhtuan.basicsample.databinding.ActivityViewModelBinding;

public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain ViewModel from ViewModelProvider
        ProfileObservableViewModel viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel.class);
        // Obtain binding
        ActivityViewModelBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);

        // Bind layout with ViewModel
        binding.setViewmodel(viewModel);
    }
}
