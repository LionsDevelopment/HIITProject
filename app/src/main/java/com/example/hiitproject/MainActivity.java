package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static DaDataClass dataObject = new DaDataClass();
    DaDataClass mService;
    boolean mBound = false;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            DaDataClass.LocalBinder binder = (DaDataClass.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
        }
    };

    public static DaDataClass getObjService() {
        return dataObject;
    }

    //Hiding android top bar
    public void hideTopAction() {
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
            System.out.println("TOPBARHIDDEN");
        }
    }

    //Running the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_page);
        hideTopAction();
        Button openbutton = findViewById(R.id.start_button);

        openbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent mainin = new Intent(MainActivity.this, HomePage.class);
                startActivity(mainin);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, DaDataClass.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

}