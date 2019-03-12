package com.example.almushaf.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.almushaf.API.Model.RadiosItem;
import com.example.almushaf.API.Model.RadiosResponse;
import com.example.almushaf.R;

import java.util.List;

public class RadiosAdapter extends RecyclerView.Adapter<RadiosAdapter.ViewHolder> {

    List<RadiosItem> channels;
    onItemClickListener onPlayClickListener;
    onItemClickListener onStopClickListener;

    public void setOnPlayClickListener(onItemClickListener onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public void setOnStopClickListener(onItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    public RadiosAdapter(List<RadiosItem> responseData) {
        this.channels = responseData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.radio_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int pos) {
        final RadiosItem channel = channels.get(pos);
        viewHolder.text.setText(channel.getName());
        if(onPlayClickListener!=null){
            viewHolder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayClickListener.onItemClick(pos , channel);
                }
            });

        }
        if(onStopClickListener!=null){
            viewHolder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStopClickListener.onItemClick(pos , channel);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        if(channels==null)return 0 ;
        return channels.size();
    }

    public void changeData(List<RadiosItem> list){
        this.channels=list;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView play;
        ImageView stop;

        public ViewHolder(View view) {
            super(view);
            text =  view.findViewById(R.id.radio_item_textView);
            play= view.findViewById(R.id.play);
            stop = view.findViewById(R.id.stop);
        }

    }


    public interface onItemClickListener {
        public  void onItemClick(int pos , RadiosItem item);
    }


}
