package com.example.hiitproject;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;
import java.util.ArrayList;

public class DaDataClass extends Service {
    ArrayList<ArrayList> daplaylists = new ArrayList<>();
    static final String ACTION_START = "com.idkwahattoputhere.yummy.ACTION_START";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        String action = intent.getAction();
        System.out.println("ACTION: " + action);
        switch (action) {
            case ACTION_START:
                String plname = intent.getStringExtra("plname");
                break;
        }
        return START_STICKY;
    }

    public ArrayList addInfoForPlay(String name, String desc, String timehr, String timemin) {
        ArrayList<String> playinfo = new ArrayList<>();
        playinfo.add(name);
        playinfo.add(desc);
        playinfo.add(timehr);
        playinfo.add(timemin);
        return playinfo;
    }


}

