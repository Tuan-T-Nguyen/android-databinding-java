package com.example.nguyenthanhtuan.basicsample.data;

import android.databinding.ObservableInt;

public class ObservableFieldProfile {
    private String name;
    private String lastName;
    public final ObservableInt likes;

    public ObservableFieldProfile(String name, String lastName, ObservableInt likes) {
        this.name = name;
        this.lastName = lastName;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
