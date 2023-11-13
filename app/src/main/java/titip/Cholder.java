/*
package com.example.tc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Cholder extends RecyclerView.ViewHolder implements View.OnClickListener {

    static ImageView ImgView;
    static TextView Title;
    ItemClickListener itemClickListener;


    Cholder(@NonNull View itemView) {
        super(itemView);

        this.ImgView = itemView.findViewById(R.id.card_image);
        this.Title = itemView.findViewById(R.id.title);

        itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        this.itemClickListener.onItemClickListener(v, getLayoutPosition());


    }

    public static void setItemClickListener(ItemClickListener itemClickListener) {

    }
    }

*/
