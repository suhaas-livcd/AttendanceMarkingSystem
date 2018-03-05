package com.example.poonam1.loginpage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.poonam1.loginpage.R;
import com.example.poonam1.loginpage.service.BackgroundWork;

public class MainActivity extends AppCompatActivity {
EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent  = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);

//        Username = (EditText)findViewById(R.id.username);
//        Password = (EditText)findViewById(R.id.password);
    }

    public void OnLogin(View view) {
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String type = "login";
        String type1="login_teacher.php";
        BackgroundWork backgroundWorker = new BackgroundWork(this);
        backgroundWorker.execute(type1, username, password);
    }

}

