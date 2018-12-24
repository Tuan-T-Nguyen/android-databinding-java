package com.example.nguyenthanhtuan.mvvmpost.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Post {
    public int userId;
    @PrimaryKey
    public int id;
    public String title;
    public String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
