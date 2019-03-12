package com.example.almushaf.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.almushaf.Base.BaseActivity;
import com.example.almushaf.Fragments.AhadethFragment;
import com.example.almushaf.Fragments.QuraanFragment;
import com.example.almushaf.Fragments.RadioFragment;
import com.example.almushaf.R;
import com.example.almushaf.Fragments.TasbeehFragment;

public class HomeActivity extends BaseActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
           switch (item.getItemId()){
               case R.id.navigation_ahadeth:
                   fragment = new AhadethFragment();
                   break;
               case R.id.navigation_quraan:
                   fragment = new QuraanFragment();
                   break;
               case R.id.navigation_tasbeeh:
                   fragment = new TasbeehFragment();
                   break;
               case R.id.navigation_radio:
                   fragment = new RadioFragment();
                   break;
           }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTextMessage =  findViewById(R.id.message);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_quraan);
    }

}
