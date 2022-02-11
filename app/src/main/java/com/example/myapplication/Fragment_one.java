package com.example.myapplication;

import static android.content.Context.CLIPBOARD_SERVICE;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_one#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_one extends Fragment {


    private EditText ed_debitCard;
    private EditText ed_debitCard2;
    private EditText ed_debitCard3;
    private EditText ed_debitCard4;
    private EditText cnic;
    private ArrayList<AccountModelClass> list = new ArrayList<>();
    private EditText ed_calender;
    private DatePickerDialog datapicker;
    EditText txtSim;



    public Fragment_one() {
        // Required empty public constructor
    }


    public static Fragment_one newInstance() {
        Fragment_one fragment = new Fragment_one();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_one, container, false);
//        myClipboard = view.getSys
        initDatePicker();

        ed_calender = view.findViewById(R.id.calender_view);
        ed_calender.setText(getTodaysDate());


        ed_debitCard = view.findViewById(R.id.db_1);
        ed_debitCard2 = view.findViewById(R.id.db_2);
        ed_debitCard3 = view.findViewById(R.id.db_3);
        ed_debitCard4 = view.findViewById(R.id.db_4);
        cnic = view.findViewById(R.id.cnic_EditText);


        ed_debitCard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_debitCard.getText().toString().length() == 4) {
                    ed_debitCard2.requestFocus();

                }
//
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ed_debitCard2.addTextChangedListener(new TextWatcher() {
                                                         @Override
                                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                                                         }

                                                         @Override
                                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                             if (ed_debitCard2.getText().toString().length() == 4) {
                                                                 ed_debitCard3.requestFocus();

                                                             }
//
                                                         }

                                                         @Override
                                                         public void afterTextChanged(Editable editable) {

                                                         }
                                                     });
        ed_debitCard3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_debitCard3.getText().toString().length() == 4) {
                    ed_debitCard4.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

        txtSim = view.findViewById(R.id.ed_Carrier);

        String[] m_data = {"Telenor", "Ufone", "Warid", "Zong", "SCOM", "Jazz"};
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
        return view;
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


}