package com.example.almushaf.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.almushaf.Activities.SurrahActivity;
import com.example.almushaf.Adapters.QuraanSuraahAdapter;
import com.example.almushaf.Base.BaseFragment;
import com.example.almushaf.DataHolder;
import com.example.almushaf.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuraanFragment extends BaseFragment {

     RecyclerView recyclerView;
     QuraanSuraahAdapter adapter;
     RecyclerView.LayoutManager manager;



    public QuraanFragment() {
        // Required empty public constructor
    }

View view ;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view   = inflater.inflate(R.layout.fragment_quraan, container, false);
         recyclerView = view.findViewById(R.id.quraan_recycler_view);
         adapter = new QuraanSuraahAdapter(DataHolder.ArSuras);
         manager = new GridLayoutManager(getActivity() , 3 , LinearLayoutManager.HORIZONTAL , true );
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(manager);
         SnapHelper snap = new PagerSnapHelper();
         snap.attachToRecyclerView(recyclerView);

        adapter.setSuraahClickListener(new QuraanSuraahAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int pos , String name) {
                Intent intent = new Intent(getActivity() , SurrahActivity.class);
                intent.putExtra("sura_name" ,name);
                intent.putExtra("pos" , (pos+1)+".txt" );
                startActivity(intent);
            }
        });
        return view;
    }

}
