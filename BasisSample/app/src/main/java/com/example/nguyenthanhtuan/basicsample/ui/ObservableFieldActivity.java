package com.example.nguyenthanhtuan.basicsample.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.databinding.ObservableInt;
import com.example.nguyenthanhtuan.basicsample.R;
import com.example.nguyenthanhtuan.basicsample.data.ObservableFieldProfile;
import com.example.nguyenthanhtuan.basicsample.databinding.ActivityObservableFieldBinding;

public class ObservableFieldActivity extends AppCompatActivity {
    private ObservableFieldProfile observableFieldProfile =
            new ObservableFieldProfile(
                    "Ada",
                    "Lovelace",
                    new ObservableInt(0)
            );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObservableFieldBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable_field);

        binding.setUser(observableFieldProfile);
    }

    public void onLike(View view) {
        observableFieldProfile.likes.set(observableFieldProfile.likes.get() + 1);
    }
}
