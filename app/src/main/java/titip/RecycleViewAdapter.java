/*
 package com.example.tc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<Cholder> {

    Context context;
    ArrayList<Content> contents;

    public RecycleViewAdapter(Context context, ArrayList<Content> contents) {
        this.context = context;
        this.contents = contents;
    }

    @NonNull
    @Override
    public Cholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);
        return new Cholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cholder holder, final int i) {

        Cholder.Title.setText(contents.get(i).getTitle());
        Cholder.ImgView.setImageResource(contents.get(i).getImg());

        if (contents.get(i).getTitle().equals("Pendidikan Pancasila")){
        }

        Cholder.contentView.setItemClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityContentInklusi.class);
                intent.putExtra("title", contents.get(i));

            }
        };

            }

    @Override
    public int getItemCount() {
        return contents.size();
    }
}
*/
