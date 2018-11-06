package com.example.zeppe.relog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainFragment.FragmentActions {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new ViewPageFragment());
    }

    @Override
    public void changeTitle(String title) {

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
                .commit();

    }
}
