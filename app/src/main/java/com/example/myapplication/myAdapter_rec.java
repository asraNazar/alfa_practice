package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class myAdapter_rec extends RecyclerView.Adapter<myAdapter_rec.myViewHolder_rec> {

    Context context;
    private List<AccountModelClass> mList;
    int row_index = -1;
    RecyclerView rec;

    OnOptionSelectedListener onOptionSelectedListener;

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    private int selectedPosition = 0;



    public myAdapter_rec(Context ct, List<AccountModelClass> mList, OnOptionSelectedListener onOptionSelectedListener) {
        this.context = ct;
        this.mList = mList;
        this.onOptionSelectedListener = onOptionSelectedListener;
    }

    @NonNull
    @Override
    public myViewHolder_rec onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view, parent, false);


        return new myViewHolder_rec(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder_rec holder, @SuppressLint("RecyclerView") int position) {

        AccountModelClass md = mList.get(position);
        holder.t1.setText(md.getText());
        //String str = md.arr[position];
        holder.m1.setImageResource(md.getImage());

        if(position == selectedPosition){
            holder.cardView.setCardBackgroundColor(Color.RED);
            holder.m1.setColorFilter(Color.WHITE);
            holder.t1.setTextColor(Color.RED);
        }else {
            holder.cardView.setCardBackgroundColor(Color.WHITE);
            holder.m1.setColorFilter(Color.RED);
            holder.t1.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onOptionSelectedListener != null){
                    onOptionSelectedListener.onOptionSelected(md, position);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class myViewHolder_rec extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView m1;
        RelativeLayout rec;
        CardView cardView;

        public myViewHolder_rec(@NonNull View itemView) {

            super(itemView);
            t1 = itemView.findViewById(R.id.textViewA);
            m1 = itemView.findViewById(R.id.imageViewI);
           rec = itemView.findViewById(R.id.buttons_recycler_view);
            cardView = itemView.findViewById(R.id.card);
        }
    }



    interface OnOptionSelectedListener{
        void onOptionSelected(AccountModelClass md, int position);
    }

}
