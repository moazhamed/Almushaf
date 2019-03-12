package com.example.almushaf.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.almushaf.API.APIManager;
import com.example.almushaf.API.Model.RadiosItem;
import com.example.almushaf.API.Model.RadiosResponse;
import com.example.almushaf.Adapters.RadiosAdapter;
import com.example.almushaf.Base.BaseFragment;
import com.example.almushaf.R;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends BaseFragment {


    RecyclerView recyclerView;
    RadiosAdapter radiosAdapter;
    RecyclerView.LayoutManager layoutManager;


    public RadioFragment() {
        // Required empty public constructor
    }

    View view;
    // TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_radio, container, false);
        recyclerView = view.findViewById(R.id.radios_recycler_view);
        layoutManager = new LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL , false);
        recyclerView.setLayoutManager(layoutManager);
        radiosAdapter = new RadiosAdapter(null);
        recyclerView.setAdapter(radiosAdapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        radiosAdapter.setOnPlayClickListener(new RadiosAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem item) {
                playChannel(item.getURL());
            }
        });
        radiosAdapter.setOnStopClickListener(new RadiosAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem item) {
                stopPlay();
            }
        });

        getRadioChannels();


        return view;
    }


    MediaPlayer mediaPlayer;
    public void playChannel(String URL) {
        stopPlay();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(URL);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            showMessage(R.string.error,R.string.cannot_play_channel, R.string.ok);


        }


    }

    public void stopPlay() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

    }

    void getRadioChannels() {

        APIManager.getApis()
                .getAllRadioChannels()
                //here w have two functions excute(in UI,main thread) , enqueue(in background thread)
                .enqueue(new Callback<RadiosResponse>() {
                    @Override
                    public void onResponse(Call<RadiosResponse> call,
                                           final Response<RadiosResponse> response) {
                        // hideProgressBar();
                        if (response.isSuccessful()) {
                            radiosAdapter.changeData(response.body().getRadios());

                        }

                    }

                    @Override
                    public void onFailure(Call<RadiosResponse> call, Throwable t) {
                        // hideProgressBar();
                        showMessage("error", t.getLocalizedMessage(), "ok");

                    }
                });

    }
}
