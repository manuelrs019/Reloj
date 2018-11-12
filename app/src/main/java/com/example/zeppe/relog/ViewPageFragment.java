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
    private int[] tabIcons={
            R.drawable.ic_access_alarm_black_24dp,
            R.drawable.ic_access_time_black_24dp,
            R.drawable.ic_hourglass_empty_black_24dp,
            R.drawable.ic_timer_black_24dp
    };

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_viewpage, container, false);
        initUI();
        setTabicons();
        return rootView;
    }

    private void setTabicons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);

    }
    private void initUI(){
        viewPager = rootView.findViewById(R.id.viewpager);
        ViewPageAdapter adapter = new ViewPageAdapter(getChildFragmentManager());
        adapter.addFragment(new AlarmFragment(),"Alarma");
        adapter.addFragment(new RelogFragment(),"Reloj");
        adapter.addFragment(new TimerFragment(),"Temporizador");
        adapter.addFragment(new CronometroFragment(),"Cronometro");
        viewPager.setAdapter(adapter);
        tabLayout = rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        
    }

    @Override
    public void onResume() {
        super.onResume();
        fragmentActions.changeTitle(getString(R.string.app_name));
    }
}
