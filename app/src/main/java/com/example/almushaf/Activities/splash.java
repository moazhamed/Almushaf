package com.example.almushaf.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.almushaf.Base.BaseActivity;
import com.example.almushaf.R;

public class splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(activity , HomeActivity.class));
                        finish();
                    }
                },3000);

    }
}
