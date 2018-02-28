package com.example.poonam1.loginpage;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private View teacherView;
    private View studentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        teacherView = findViewById(R.id.login_teacher);
        studentView = findViewById(R.id.login_student);
    }


    public void onLoginTypeChecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioStudent:
                if (checked)
                    teacherView.setVisibility(View.GONE);
                    studentView.setVisibility(View.VISIBLE);
                    break;
            case R.id.radioTeacher:
                if (checked)
                    studentView.setVisibility(View.GONE);
                    teacherView.setVisibility(View.VISIBLE);
                    break;
        }
    }

    /**
     *
     * When the orientation is changed!!!
     * Note : Hey, the screen rotation is locked !
     * To unlock, remove "android:screenOrientation="portrait"
     * and add "android:configChanges="orientation|screenSize"" to the activity element tag
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Toast.makeText(getApplicationContext(),"Orientation changed",Toast.LENGTH_SHORT).show();
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            if(teacherView.getVisibility() == View.VISIBLE){
                ViewGroup.LayoutParams layoutParams = teacherView.getLayoutParams();
                layoutParams.width=100;
                layoutParams.height=100;
                teacherView.setLayoutParams(layoutParams);
                teacherView.setVisibility(View.VISIBLE);
            }
            else{
                ViewGroup.LayoutParams layoutParams = studentView.getLayoutParams();
                layoutParams.width=100;
                layoutParams.height=100;
                studentView.setLayoutParams(layoutParams);
                studentView.setVisibility(View.VISIBLE);
            }
        }
        else{
            if(teacherView.getVisibility() == View.VISIBLE){
                ViewGroup.LayoutParams layoutParams = teacherView.getLayoutParams();
                layoutParams.width=300;
                layoutParams.height=300;
                teacherView.setLayoutParams(layoutParams);
                teacherView.setVisibility(View.VISIBLE);
            }
            else{
                ViewGroup.LayoutParams layoutParams = studentView.getLayoutParams();
                layoutParams.width=300;
                layoutParams.height=300;
                studentView.setLayoutParams(layoutParams);
                studentView.setVisibility(View.VISIBLE);
            }
        }
    }
}
