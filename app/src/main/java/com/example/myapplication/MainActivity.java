package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText EditText_username;
    private Button login_Btn;
    private EditText EditText_password;
    RecyclerView recyclerView;
    private Button register_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText_username = findViewById(R.id.user_name);
        EditText_password = findViewById(R.id.user_password);
         register_Btn=findViewById(R.id.reg_btn);

         register_Btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),RegistrationExistingUserActivity.class);
                 startActivity(intent);
             }
         });


        //recyclerView = findViewById(R.id.recycler_view);

        login_Btn = findViewById(R.id.login);
        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateUsername();
                validatePassword();
                if (!validateUsername() | !validatePassword()) {
                    return;
                }

            }
        });


    }

    private boolean validateUsername() {
        String val = EditText_username.getText().toString().trim();
        String checkspaces = "Aw{1,20}z";

        if (val.isEmpty()) {
            EditText_username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            EditText_username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            EditText_username.setError("No White spaces are allowed!");
            return false;
        } else {
            EditText_username.setError(null);
            //t1.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = EditText_password.getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            EditText_password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            EditText_password.setError("Password should contain 4 characters!");
            return false;
        } else {
            EditText_password.setError(null);
            //t2.setErrorEnabled(false);
            return true;
        }
    }
}