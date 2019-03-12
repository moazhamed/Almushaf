package com.example.almushaf.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.almushaf.AhadethNamesHolder;
import com.example.almushaf.R;


public class AhadeethAdapter extends  RecyclerView.Adapter<AhadeethAdapter.ViewHolder>{
    String[] names ;
    onItemClickListener onHadethClickListener;

    public void setOnHadethClickListener(onItemClickListener onHadethClickListener) {
        this.onHadethClickListener = onHadethClickListener;
    }

    public AhadeethAdapter(  String[] data) {
        this.names = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view =   LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hadeth_item ,viewGroup , false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int postion)  {
       String hadeth =  AhadethNamesHolder.ArِAhadeth[postion];
       viewHolder.hadethContent.setText(hadeth);
       if(onHadethClickListener!=null){
           viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onHadethClickListener.onItemClick(postion);


               }
           });

       }
    }

    @Override
    public int getItemCount() {
        return names.length;
    }







    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hadethContent;
        public ViewHolder(View view){
            super(view);
           hadethContent = view.findViewById(R.id.hadeeth_item_text_view);

        }
    }


    public interface onItemClickListener {
          void onItemClick(int pos);

    }


}
