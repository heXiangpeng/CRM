package huayuan.com.crm.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import huayuan.com.crm.R;
import huayuan.com.crm.calendar.cons.DPMode;
import huayuan.com.crm.calendar.views.MonthView;
import huayuan.com.crm.calendar.views.WeekView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link schedule1ragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class schedule1ragment extends Fragment implements MonthView.OnDateChangeListener, MonthView.OnDatePickedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private MonthView monthView;
    private WeekView weekView;

    private LinearLayout contentLayout;
    private TextView weekTxt;
    private Calendar now;

    public schedule1ragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment schedule1ragment.
     */
    // TODO: Rename and change types and number of parameters
    public static schedule1ragment newInstance(String param1, String param2) {
        schedule1ragment fragment = new schedule1ragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule1ragment, container, false);

        now = Calendar.getInstance();
        monthView = (MonthView) view.findViewById(R.id.month_calendar);
        weekView = (WeekView) view.findViewById(R.id.week_calendar);


        monthView.setDPMode(DPMode.SINGLE);
        monthView.setDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1);
        monthView.setFestivalDisplay(true);
        monthView.setTodayDisplay(true);
        monthView.setOnDateChangeListener(this);
        monthView.setOnDatePickedListener(this);

        weekView.setDPMode(DPMode.SINGLE);
        weekView.setDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1);
        weekView.setFestivalDisplay(true);
        weekView.setTodayDisplay(true);
        weekView.setOnDatePickedListener(this);



        return view;
    }

    @Override
    public void onDateChange(int year, int month) {

    }

    @Override
    public void onDatePicked(String date) {

    }
}
