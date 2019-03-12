package com.example.almushaf.Adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.almushaf.R;

import java.util.ArrayList;



public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder> {
    // List<String> list;
    ArrayList<String> data ;


    public VersesAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.verse_item , viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)  {
        viewHolder.suraahContent.setText(data.get(i));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView suraahContent;
        public  ViewHolder(View view){
            super(view);
            suraahContent = view.findViewById(R.id.suraah_content);
        }

    }





}
