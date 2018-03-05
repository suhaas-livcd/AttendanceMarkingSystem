package com.example.poonam1.loginpage.activity;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.poonam1.loginpage.R;

public class LoginActivity extends AppCompatActivity {
    private View teacherView;
    private View studentView;
    private static final String mIsTeacher = "teacher";
    private static final String mIsStudent = "student";
    private static final String INVALID_CREDENTIALS ="Invalid Credentials";
    private static final String INVALID_INPUT ="Invalid input";
    private String mLoginTypeIs = null;
    private String mUsername = null,mUserpass=null;
    private String mLOG_TAG = LoginActivity.class.getSimpleName();
    private String mPopMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        teacherView = findViewById(R.id.login_teacher);
        studentView = findViewById(R.id.login_student);
    }


    /**
     * To swap the images of the teacher and the student.
     * @param view
     */
    public void onLoginTypeChecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioStudent:
                if (checked)
                    mLoginTypeIs = mIsStudent;
                    teacherView.setVisibility(View.GONE);
                    studentView.setVisibility(View.VISIBLE);
                    break;
            case R.id.radioTeacher:
                if (checked)
                    mLoginTypeIs = mIsTeacher;
                    studentView.setVisibility(View.GONE);
                    teacherView.setVisibility(View.VISIBLE);
                    break;
        }
    }

    /**
     * When the user presses the login button.
     * @param view
     */
    public void onLoginClicked(View view){
        Log.d(mLOG_TAG,"----------> Logging in as a "+ mLoginTypeIs);
        if(mLoginTypeIs !=null){
            EditText mtextViewUserName = (EditText) findViewById(R.id.username);
            EditText mtextViewUserPass = (EditText) findViewById(R.id.password);
            mUsername = mtextViewUserName.getText().toString();
            mUserpass = mtextViewUserPass.getText().toString();
            if (mUsername!=null && mUserpass!=null) {
                if(!(mUsername.isEmpty() || mUserpass.isEmpty())){
                    new AuthenticateCredentials(this).execute(mUsername,mUserpass,mLoginTypeIs);
                }
                else{
                    mPopMessage = INVALID_INPUT;
                    Toast.makeText(getApplicationContext(),mPopMessage,Toast.LENGTH_SHORT).show();
                }
            }
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

    /**
     * To establish connection and authenticate credentials
     */
    private static class AuthenticateCredentials extends AsyncTask<String,String,String>{
        private String mLOG_TAG = AuthenticateCredentials.class.getSimpleName();
        public AuthenticateCredentials(LoginActivity loginActivity) {

        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(mLOG_TAG,"---------> |AUTH|\tmUsername : "+strings[0]+"\tmUserpass : "
                    +strings[1]+"\tmLoginTypeIs : "+strings[2]);


            return null;
        }
    }
}
