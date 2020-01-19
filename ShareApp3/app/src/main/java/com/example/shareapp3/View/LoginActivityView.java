package com.example.shareapp3.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shareapp3.R;

public class LoginActivityView extends AppCompatActivity {
    public static final String DATA_SAVED= "data_saved";
    Button signUp;
    EditText userEmail, userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        signUp= findViewById(R.id.login_button);
        userEmail= findViewById(R.id.login_email);
        userPassword= findViewById(R.id.login_password);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                if (userEmail.getText().toString().isEmpty()){
                    setResult(RESULT_CANCELED, intent);
                } else {
                    String login= userEmail.getText().toString();
                    intent.putExtra(DATA_SAVED,login);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
