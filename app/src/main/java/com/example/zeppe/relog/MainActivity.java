package com.example.zeppe.relog;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements MainFragment.FragmentActions, FragmentManager.OnBackStackChangedListener {
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new ViewPageFragment());
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
       calendar.clear();
        //calendar.set(2018,11,24,10,1,16);
        calendar.set(Calendar.YEAR,2018);
        calendar.set(Calendar.MONTH,11);
        calendar.set(Calendar.DAY_OF_MONTH,27);
        calendar.set(Calendar.HOUR_OF_DAY,1);
        calendar.set(Calendar.MINUTE,47);
        calendar.set(Calendar.SECOND,20);
        AlarmManager alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        alarmMgr.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+3000,pendingIntent);
    }

    @Override
    public void onBackStackChanged() {
       if (null!=getActualFrgament()){
           getActualFrgament().onResume();
       }
    }

    public Fragment getActualFrgament(){
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.config:
                addFragment(new ConfigFragment());
                return true;
            case R.id.acerca:
                addFragment(new AboutFragment());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void changeTitle(String title) {
        if (null != getSupportActionBar()){
            getSupportActionBar().setTitle(title);
        }

    }

    @Override
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment,fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,fragment,fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();

    }

}
