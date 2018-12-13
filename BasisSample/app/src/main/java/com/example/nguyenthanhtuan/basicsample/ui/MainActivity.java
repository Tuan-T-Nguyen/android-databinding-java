package com.example.nguyenthanhtuan.basicsample.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nguyenthanhtuan.basicsample.R;
import com.example.nguyenthanhtuan.basicsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent_1 = new Intent(this, ObservableFieldActivity.class);
        final Intent intent_2 = new Intent(this, ViewModelActivity.class);

        // The layout for this activity is a Data Binding layout so it needs to be inflated using
        // DataBindingUtil.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // The returned binding has references to all the Views with an ID.
        binding.btnObservableFieldsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this, ObservableFieldActivity.class);
                startActivity(intent_1);
            }
        });
        binding.btnViewModelActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_2);
            }
        });
    }
}
