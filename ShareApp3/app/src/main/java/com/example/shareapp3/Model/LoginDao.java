package com.example.shareapp3.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LoginDao {

    @Insert
    void insert(LoginEntity loginEntity);

    @Query("SELECT * FROM loginTable")
    LiveData<List<LoginEntity>> getAllData();
}
