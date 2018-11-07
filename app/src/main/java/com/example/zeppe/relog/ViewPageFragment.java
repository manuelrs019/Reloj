package com.example.zeppe.relog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPageFragment extends MainFragment {
    private View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_viewpage, container, false);
        initUI();
        return rootView;
    }

    private void initUI(){
        viewPager = rootView.findViewById(R.id.viewpager);
        ViewPageAdapter adapter = new ViewPageAdapter(getChildFragmentManager());
        adapter.addFragment(new AlarmFragment(),"Alarma");
        adapter.addFragment(new RelogFragment(),"Reloj");
        adapter.addFragment(new TimerFragment(),"Tempo");
        adapter.addFragment(new CronometroFragment(),"Cronometro");
        viewPager.setAdapter(adapter);

        tabLayout = rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


}
