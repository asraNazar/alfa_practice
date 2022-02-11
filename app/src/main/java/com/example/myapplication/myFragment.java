package com.example.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class myFragment extends Fragment {

    private ArrayList<AccountModelClass> list = new ArrayList<>();
    private EditText ed_calender;
    private DatePickerDialog datapicker;
    EditText txtSim;
    private EditText cnic;

    public myFragment() {
        // Required empty public constructor
    }


    public static myFragment newInstance() {
        myFragment fragment = new myFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my, container, false);

        initDatePicker();
        ed_calender = v.findViewById(R.id.calender_view);
        ed_calender.setText(getTodaysDate());
        cnic = v.findViewById(R.id.cnic_EditText);
        cnic.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        cnic.addTextChangedListener(new TextWatcher() {
            int len=0;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String str = cnic.getText().toString();
                len = str.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String str = cnic.getText().toString();

                if((str.length() == 5 && len <str.length()) || (str.length() == 13 && len <str.length())){

                    cnic.append("-");
                }





            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        ed_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDataPicker(view);
            }
        });

        txtSim = v.findViewById(R.id.ed_Carrier);

        String[] m_data = {"Telenor", "Ufone","Warid","Zong","SCOM","Jazz"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setCancelable(true);
        builder.setTitle("Select an MNP");

        txtSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                createDialogBox();
                builder.setItems(m_data, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtSim.setText(m_data[i]);
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        return v;
    }





    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDataString(day, month, year);

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                month = month + 1;
                String date = makeDataString(day, month, year);
                ed_calender.setText(date);

            }
        };


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;
        datapicker = new DatePickerDialog(this.getContext(), style, dateSetListener, year, month, day);

    }

    private String makeDataString(int day, int month, int year) {
        return getMonthFormat(month) + "" + day + "" + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APRIL";
        if (month == 1)
            return "MAY";
        if (month == 1)
            return "JUNE";
        if (month == 1)
            return "JULY";
        if (month == 1)
            return "AUG";
        if (month == 1)
            return "SEP";
        if (month == 1)
            return "OCT";
        if (month == 1)
            return "NOV";
        if (month == 1)
            return "DEC";
        return "";
    }

    public void openDataPicker(View v) {
        datapicker.show();
    }

//
}