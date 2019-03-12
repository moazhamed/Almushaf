package com.example.almushaf.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.almushaf.R;

public class HadeethContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadeeth_content);
        TextView hadeeth = findViewById(R.id.hadeth_text_view);
        String hadeth = getIntent().getStringExtra("hadeeth content");
        hadeeth.setText(hadeth);
    }
}
