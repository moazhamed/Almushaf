package com.example.almushaf.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.almushaf.Adapters.VersesAdapter;
import com.example.almushaf.Base.BaseActivity;
import com.example.almushaf.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SurrahActivity extends BaseActivity {

    TextView suraatxt;
    int K = 0;
    ///String str ;
    ArrayList<String> data = new ArrayList<>();
    RecyclerView recyclerView;
    VersesAdapter adapter;
    LinearLayoutManager manager;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surrah);
        //Toolbar toolbar = findViewById(R.id.toolbar);
    //    setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.surah_recycler_view);
        String sura_name = getIntent().getStringExtra("sura_name");
        String fileName = getIntent().getStringExtra("pos");
        TextView sura = findViewById(R.id.esm_elsora);
        sura.setText(sura_name);
        ArrayList adapter_list = generateAyaatElsora(fileName);
        adapter = new VersesAdapter(adapter_list);
        manager = new LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);


    }

    public  ArrayList<String> generateAyaatElsora(String filename ) {


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(SurrahActivity.this.getAssets().open(filename), "UTF-8"));
            String mLine;
            count = 1;
            String fff = "(";
            String DDD = ")";
            do {


                //              str ="";
                mLine = reader.readLine();
                // do something with the line
                if (mLine == null) break;
                data.add(mLine + fff + count + DDD);

                count++;
            } while (mLine != null);




        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
  return data;

    }


}
