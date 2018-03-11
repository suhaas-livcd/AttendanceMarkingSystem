package com.example.MobileATS.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.MobileATS.R;

public class StudentActivity extends AppCompatActivity {

    private String LOG_TAG = StudentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentprofile_mainlayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(LOG_TAG, "----------> onCreateOptionsMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.studentprofile_display_timeslots_menuoptions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void studentProfile_OpenTitleMenuOption(View view) {
        Log.d(LOG_TAG, "----------> studentProfile_OpenTitleMenuOption");
        openOptionsMenu();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Log.d(LOG_TAG, "----------> studentProfile_onCreateContextMenu");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.create_new:
                // do stuff, like showing settings fragment
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
