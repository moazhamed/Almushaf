package com.example.almushaf.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.almushaf.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TasbeehFragment extends Fragment {
    private TextView counterText;
    private Spinner spinner;
    private Button plus;
    private Button reset;
    private Button sumition;


    private long counter;
    private View.OnClickListener clickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.plus :
                    plus_counter();
                    break;
                case R.id.reset:
                    reset_counter();
                    break;
                case R.id.sum:
                    sum_tsbehat();
                    break;
            }
        }

    };

    public TasbeehFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tasbeeh, container, false);
        spinner =view.findViewById(R.id.spinner);
        String[] items = new String[]{"الله اكبر", "سبحان الله", "الحمدالله"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        counterText = view.findViewById(R.id.counter);
        plus = view.findViewById(R.id.plus);
        reset = view.findViewById(R.id.reset);
        sumition = view.findViewById(R.id.sum);
        plus.setOnClickListener(clickListener);
        reset.setOnClickListener(clickListener);
        sumition.setOnClickListener(clickListener);

      return  view;

    }



    public void reset_counter(){
        counter=0;
        counterText.setText(counter + "");

    }
    public void plus_counter() {
        counter++;
        counterText.setText(counter + "");
    }
    public void sum_tsbehat(){
        int sum =0;
        sum= (int) (counter+sum)*2;
    }
}
