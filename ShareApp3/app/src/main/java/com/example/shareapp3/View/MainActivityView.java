package com.example.shareapp3.View;

import android.content.Intent;
import android.os.Bundle;

import com.example.shareapp3.Model.Adapter.LoginAdapter;
import com.example.shareapp3.Model.LoginEntity;
import com.example.shareapp3.R;
import com.example.shareapp3.ViewModel.LoginViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class MainActivityView extends AppCompatActivity {

    private static final int PICK_REQUEST_CODE = 1;
    LoginViewModel loginViewModel;
    RecyclerView recyclerView;
    LoginAdapter loginAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView= findViewById(R.id.recylerview);
        loginAdapter= new LoginAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityView.this, LoginActivityView.class);
                startActivityForResult(intent, PICK_REQUEST_CODE);
            }
        });
        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getAllData().observe(this, new Observer<List<LoginEntity>>() {
            @Override
            public void onChanged(List<LoginEntity> loginEntities) {
                loginAdapter.setUserData(loginEntities);
            }
        });
        recyclerView.setAdapter(loginAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_REQUEST_CODE && resultCode == RESULT_OK){
            final String id= UUID.randomUUID().toString();
            //final String receiveEmail= data.getStringExtra("data_saved");
            LoginEntity loginEntity= new LoginEntity(id, data.getStringExtra(LoginActivityView.DATA_SAVED));
            loginViewModel.insert(loginEntity);
            Toast.makeText(this, "successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "unsuccessfully", Toast.LENGTH_SHORT).show();
        }
    }
}






    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    */

