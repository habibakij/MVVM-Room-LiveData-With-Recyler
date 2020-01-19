package com.example.shareapp3.ViewModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shareapp3.Model.LoginDao;
import com.example.shareapp3.Model.LoginEntity;


@Database(entities = {LoginEntity.class}, version = 1)
public abstract class LoginDatabase extends RoomDatabase {

    public abstract LoginDao loginDao();
    private static volatile LoginDatabase databseInstance;

    static LoginDatabase getDatabase(Context mContext){
        if (databseInstance == null){
            synchronized (LoginDatabase.class){
                if (databseInstance == null){
                    databseInstance= Room.databaseBuilder(mContext.getApplicationContext(),
                            LoginDatabase.class, "loginDatabase").build();
                }
            }
        }
        return databseInstance;
    }


}
