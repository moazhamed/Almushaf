package com.example.almushaf.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.almushaf.R;

public class QuraanSuraahAdapter extends RecyclerView.Adapter<QuraanSuraahAdapter.ViewHolder> {
   String[] names ;
   onItemClickListener surahClickListener;

    public void setSuraahClickListener(onItemClickListener suraahClickListener) {
        this.surahClickListener = suraahClickListener;
    }

    public QuraanSuraahAdapter(String[] names) {
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.suraaah_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final String name = names[i];
        viewHolder.surahName.setText(name);
        if (surahClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surahClickListener.onItemClick(i, name );
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return  names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView surahName;
        public ViewHolder(View view) {
            super(view);
         surahName = view.findViewById(R.id.suraah_name);
        }

    }



    public interface  onItemClickListener{

        public void onItemClick(int i , String name);

    }


}
