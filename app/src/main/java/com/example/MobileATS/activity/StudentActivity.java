package com.example.MobileATS.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.MobileATS.R;

import java.util.Calendar;

public class StudentActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private String LOG_TAG = StudentActivity.class.getSimpleName();
    private Dialog mdialogContact;

    /**
     * Calling oncreate when the activity launches
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentprofile_mainlayout);

    }

    /**
     * Inflating th popup menu and registering the listener
     *
     * @param v
     */
    public void studentProfile_OpenStudentBodyMenuOption(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.studentprofile_display_timeslots_menuoptions, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    /**
     * When the user clicks the pop menu
     *
     * @param menuItem
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.create_new:
                Log.d(LOG_TAG, "---------> Create New clicked");
                return true;
            case R.id.Reminder:
                Log.d(LOG_TAG, "---------> Create New Reminder");
                /*Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://com.android.calendar/time"));
                startActivity(i);*/
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");

                Calendar cal = Calendar.getInstance();
                long startTime = cal.getTimeInMillis();
                long endTime = cal.getTimeInMillis() + 60 * 60 * 1000;

                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                intent.putExtra(CalendarContract.Events.TITLE, "Subject 14FSP001");
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Complete assignment 001");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Something put yyar");
                intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");

                startActivity(intent);
                return true;

            /**
             * Logout Menthod from student activiyt
             * Better to use braodcast ! to be changed just for testing purpose
             */
            case R.id.logout_StudentProfile:
                Intent intentToStartLoginActivity = new Intent(this, LoginActivity.class);
                startActivity(intentToStartLoginActivity);
                finish();
                return true;

            case R.id.contactSubjectStaff:
                mdialogContact = new Dialog(this);
                mdialogContact.setContentView(R.layout.studentprofile_contactlayout);
                mdialogContact.setTitle("Contact");


                mdialogContact.show();

//                Button dialogContactButtonOK = (Button) findViewById(R.id.ContactButtonOK);
//                dialogContactButtonOK.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mdialogContact.dismiss();
//                    }
//                });

                return true;

            case R.id.contactMentor:

                return true;

            default:
                return false;
        }
    }

    public void studentProfile_OpenMentorContactMenuOption(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.studentprofile_display_mentorcontact_menuoptions, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    public void studentProfile_OpenTitleBarMenuOption(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.studentprofile_titlebar_menuoptions, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }
}
