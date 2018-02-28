package com.example.poonam1.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText Username,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
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

