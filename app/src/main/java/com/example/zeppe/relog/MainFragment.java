package com.example.zeppe.relog;

import android.content.Context;
import android.support.v4.app.Fragment;

public class MainFragment extends Fragment {
    public FragmentActions fragmentActions;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentActions = ((FragmentActions)context);
        } catch (ClassCastException e){
           throw new RuntimeException("Debes implementar a FragmentActions");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentActions = null;
    }

    public interface FragmentActions{
        void changeTitle(String title);
        void replaceFragment(Fragment fragment);
        void addFragment(Fragment fragment);
    }
}
