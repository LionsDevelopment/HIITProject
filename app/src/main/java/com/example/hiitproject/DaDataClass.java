package com.example.hiitproject;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;
import java.util.ArrayList;

public class DaDataClass extends IntentService {
    ArrayList<ArrayList> daplaylists = new ArrayList<>();

    public DaDataClass() {
        super("DaDataClass");
    }

    public ArrayList addInfoForPlay(String name, String desc, String timehr, String timemin) {
        ArrayList<String> playinfo = new ArrayList<>();
        playinfo.add(name);
        playinfo.add(desc);
        playinfo.add(timehr);
        playinfo.add(timemin);
        return playinfo;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent datain = new Intent(this, CreatePlayList.class);
        Bundle b = datain.getExtras();
        //Playlist Information
        final String cplayname = datain.getStringExtra("playname");
        final String cplaydesc = datain.getStringExtra("playdesc");
        final String ctimehr = datain.getStringExtra("timehr");
        final String ctimemin = datain.getStringExtra("timemin");
        if (cplaydesc == null)
            System.out.println("empty");
        else
            System.out.println("Not empty");
        ArrayList<String> newplayadd = addInfoForPlay(cplayname, cplaydesc, ctimehr, ctimemin);
        daplaylists.add(newplayadd);
        System.out.println(daplaylists);
        Intent broadcastIntent = new Intent();
        String arrayplayna = "";
        broadcastIntent.putStringArrayListExtra(arrayplayna, newplayadd);
    }

}


//class DaPlaylists extends DaDataClass {
//}
//
//class DaCusWorks extends DaDataClass {
//}
