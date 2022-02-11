package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RegistrationExistingUserActivity extends AppCompatActivity {


//    private String s;
//    private int images;
    RecyclerView recyclerView;
    private List<AccountModelClass> mList = new ArrayList<>();
    private ImageView img_backArrow;
    myAdapter_rec adapter_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_existing_user);

        img_backArrow = findViewById(R.id.back_arrow_forgot);
        img_backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationExistingUserActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recycler_view);
        addList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter_rec = new myAdapter_rec(this, mList, new myAdapter_rec.OnOptionSelectedListener() {
            @Override
            public void onOptionSelected(AccountModelClass md, int position) {
                navigate(position);

            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter_rec);

        Fragment fr = myFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fr,"main_frag");
        ft.commit();

    }

    private void navigate(int position) {
        adapter_rec.setSelectedPosition(position);
        switch (position) {
            case 0:

                Fragment fr = myFragment.newInstance();
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.fragment_container, fr).addToBackStack(null).commit();
                break;

            case 1:

                Fragment fragment_one = Fragment_one.newInstance();
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.fragment_container, fragment_one)
                        .addToBackStack(null).commit();
                break;

            case 2:
                //holder.m1.setBackgroundColor(Color.parseColor("#FF0000"));
                Fragment fragment_two = Fragment_two.newInstance();
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.fragment_container, fragment_two)
                        .commit();
                break;

            case 3:
                //holder.m1.setBackgroundColor(Color.parseColor("#FF0000"));
                Fragment fragment_three = Fragment_three.newInstance();
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.fragment_container, fragment_three)
                        .commit();

                break;

            case 4:
                // holder.m1.setBackgroundColor(Color.parseColor("#FF0000"));
                Fragment fragment_four = Fragment_four.newInstance();
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.fragment_container, fragment_four)
                        .commit();
                break;
        }
    }

    void addList() {
        AccountModelClass amc = new AccountModelClass("Account Holder", R.drawable.ic_baseline_person_outline_24);
        mList.add(amc);
        amc = new AccountModelClass("Debit Card", R.drawable.ic_baseline_credit_card_24);
        mList.add(amc);
        amc = new AccountModelClass("Credit Card\"", R.drawable.ic_baseline_credit_card_24);
        mList.add(amc);

        mList.add(amc);
        amc = new AccountModelClass("Existing Wallet", R.drawable.ic_baseline_account_balance_wallet_24);
        mList.add(amc);


    }

}