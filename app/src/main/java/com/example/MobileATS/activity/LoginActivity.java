package com.example.MobileATS.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.MobileATS.Beans.ListUserProfiles;
import com.example.MobileATS.Beans.UserProfile;
import com.example.MobileATS.R;
import com.example.MobileATS.rest.APIService;
import com.example.MobileATS.rest.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private View teacherView;
    private View studentView;
    private static final String mIsTeacher = "teacher";
    private static final String mIsStudent = "student";
    private static final String INVALID_CREDENTIALS = "Invalid Credentials";
    private static final String GUEST_LOGIN = "Logging in as guest";
    private static final String INVALID_INPUT = "Invalid input";
    private String mLoginTypeIs = mIsStudent;  //DEFAULT Login is student
    private String mUsername = null, mUserpass = null;
    private String mLOG_TAG = LoginActivity.class.getSimpleName();
    private String mPopMessage;

    //RetroAPI
    private String mRetroResponse;
    private APIService mAPIService;
    private static final String mIsSuccess = "success";
    private static final String mIsError = "error";
    private Intent mIntent;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        teacherView = findViewById(R.id.login_teacher);
        studentView = findViewById(R.id.login_student);
        //Progress
        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Processing...");
        mProgress.setMessage("Please wait...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);
        mProgress.setCanceledOnTouchOutside(true);
        mProgress.setCancelable(true);

        //Retro
        mAPIService = ApiUtils.getAPIService();

    }

    /**
     * To swap the images of the teacher and the student.
     *
     * @param view
     */
    public void onLoginTypeChecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
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
     *
     * @param view
     */
    public void onLoginClicked(View view) {
        Log.d(mLOG_TAG, "----------> Logging in as a " + mLoginTypeIs);
        if (mLoginTypeIs != null) {
            EditText mtextViewUserName = (EditText) findViewById(R.id.username);
            EditText mtextViewUserPass = (EditText) findViewById(R.id.password);
            mUsername = mtextViewUserName.getText().toString();
            mUserpass = mtextViewUserPass.getText().toString();
            if (mUsername != null && mUserpass != null) {
                if (!(mUsername.isEmpty() || mUserpass.isEmpty())) {
                    mProgress.show();
                    sendPost(mUsername, mUserpass, mLoginTypeIs);
                } else {
                    mPopMessage = INVALID_INPUT;
                    Toast.makeText(getApplicationContext(), mPopMessage, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    /**
     * @param mUsername
     * @param mUserpass
     * @param mLoginTypeIs
     */
    public void sendPost(String mUsername, String mUserpass, final String mLoginTypeIs) {
        mAPIService.authenticateUser(mUsername, mUserpass, mLoginTypeIs).enqueue(new Callback<ListUserProfiles>() {
            @Override
            public void onResponse(Call<ListUserProfiles> call, Response<ListUserProfiles> response) {
                mProgress.dismiss();
                if (response.isSuccessful()) {
                    List<UserProfile> muserProfiles = response.body().getUserProfileInfo();
                    String mLoginResponseIs = response.body().getLoginResponse();
                    if (mLoginResponseIs.equals(mIsSuccess)) {
                        switch (mLoginTypeIs) {
                            case mIsStudent:
                                mIntent = new Intent(getApplicationContext(), StudentActivity.class);
                                //send response data via intent
                                startActivity(mIntent);
                                break;
                            case mIsTeacher:
                                mIntent = new Intent(getApplicationContext(), StaffActivity.class);
                                startActivity(mIntent);
                                break;
                            default:
                                mPopMessage = GUEST_LOGIN;
                                Toast.makeText(getApplicationContext(), mPopMessage, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        mPopMessage = INVALID_CREDENTIALS;
                        Toast.makeText(getApplicationContext(), mPopMessage, Toast.LENGTH_SHORT).show();
                    }
//                    if (muserProfiles.size() > 0) {
//                        showResponse(muserProfiles.get(0).toString());
//                        Log.i(mLOG_TAG, "post submitted to API." + muserProfiles.get(0).toString() + muserProfiles.get(0).getName());
//                    } else {
//                        Log.i(mLOG_TAG, "post submitted to API." + muserProfiles.get(0).toString());
//                    }
                }
            }


            @Override
            public void onFailure(Call<ListUserProfiles> call, Throwable t) {
                Log.e(mLOG_TAG, "Unable to submit post to API.");
            }
        });
    }


    public void showResponse(String response) {
        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
    }

    /**
     * When the orientation is changed!!!
     * Note : Hey, the screen rotation is locked !
     * To unlock, remove "android:screenOrientation="portrait"
     * and add "android:configChanges="orientation|screenSize"" to the activity element tag
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Toast.makeText(getApplicationContext(), "Orientation changed", Toast.LENGTH_SHORT).show();
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (teacherView.getVisibility() == View.VISIBLE) {
                ViewGroup.LayoutParams layoutParams = teacherView.getLayoutParams();
                layoutParams.width = 100;
                layoutParams.height = 100;
                teacherView.setLayoutParams(layoutParams);
                teacherView.setVisibility(View.VISIBLE);
            } else {
                ViewGroup.LayoutParams layoutParams = studentView.getLayoutParams();
                layoutParams.width = 100;
                layoutParams.height = 100;
                studentView.setLayoutParams(layoutParams);
                studentView.setVisibility(View.VISIBLE);
            }
        } else {
            if (teacherView.getVisibility() == View.VISIBLE) {
                ViewGroup.LayoutParams layoutParams = teacherView.getLayoutParams();
                layoutParams.width = 300;
                layoutParams.height = 300;
                teacherView.setLayoutParams(layoutParams);
                teacherView.setVisibility(View.VISIBLE);
            } else {
                ViewGroup.LayoutParams layoutParams = studentView.getLayoutParams();
                layoutParams.width = 300;
                layoutParams.height = 300;
                studentView.setLayoutParams(layoutParams);
                studentView.setVisibility(View.VISIBLE);
            }
        }
    }

//    public void onBackPressed() {
//        mPopMessage = "Back button disabled";
//        Toast.makeText(getApplicationContext(), mPopMessage, Toast.LENGTH_SHORT).show();
//    }
}
