package com.example.shareapp3.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shareapp3.Model.LoginDao;
import com.example.shareapp3.Model.LoginEntity;

import java.util.List;
import java.util.concurrent.locks.Condition;

public class LoginViewModel extends AndroidViewModel {
    private String TAG= this.getClass().getSimpleName();
    private LoginDao loginDao;
    private LoginDatabase loginDatabase;
    private LiveData<List<LoginEntity>> getAll;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginDatabase= LoginDatabase.getDatabase(application);
        loginDao= loginDatabase.loginDao();
        getAll= loginDao.getAllData();
    }
    public void insert(LoginEntity loginEntity){
        new InsertAsyntask(loginDao).execute(loginEntity);
    }

    public LiveData<List<LoginEntity>> getAllData(){
        return getAll;
    }

    private class InsertAsyntask extends AsyncTask<LoginEntity, Void, Void> {
        LoginDao loginDao;

        public InsertAsyntask(LoginDao loginDao) {
            this.loginDao = loginDao;
        }

        @Override
        protected Void doInBackground(LoginEntity... loginEntities) {
            loginDao.insert(loginEntities[0]);
            return null;
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"ViewModel Destroy");
    }
}
