package com.example.zeppe.relog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AlarmFragment extends MainFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FloatingActionButton alarmButton;
    private EditText text;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<Header>  headers = new ArrayList<>();

    public AlarmFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmFragment newInstance(String param1, String param2) {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);
        alarmButton = view.findViewById(R.id.addAlarm);
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        myAdapter = new MyAdapter(headers);
        recyclerView.setAdapter(myAdapter);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAlarm(v);
            }
        });
        return view;
    }

    public void addAlarm(View view){
        final Calendar calendar = Calendar.getInstance();
        if(view == alarmButton){
            int hora = calendar.get(android.icu.util.Calendar.HOUR);
            int min= calendar.get(Calendar.MINUTE);
            TimePickerDialog pickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    SimpleDateFormat format = new SimpleDateFormat("hh:mm");
                    SimpleDateFormat format1 = new SimpleDateFormat("a");
                    SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yy");
                    /*String day = format2.format(calendar.getTime());
                    try {
                        calendar.setTime(format2.parse(day));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }*/
                    calendar.add(Calendar.DAY_OF_MONTH,1);
                    calendar.set(Calendar.MINUTE, minute);
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    headers.add(new Header(format.format(calendar.getTime()),format1.format(calendar.getTime()),format2.format(calendar.getTime())));
                    myAdapter = new MyAdapter(headers);
                    recyclerView.setAdapter(myAdapter);
                }
            },hora,min,false);
            pickerDialog.show();
        }
    }

}
