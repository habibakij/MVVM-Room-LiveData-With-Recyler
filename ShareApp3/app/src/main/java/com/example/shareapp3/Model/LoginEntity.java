package com.example.shareapp3.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loginTable")
public class LoginEntity {

    public LoginEntity(String id, String userEmail) {
        this.id = id;
        this.userEmail = userEmail;
    }

    @PrimaryKey()
    @NonNull
    private String id;

    @ColumnInfo(name = "userEmail")
    private String userEmail;

    public String getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
