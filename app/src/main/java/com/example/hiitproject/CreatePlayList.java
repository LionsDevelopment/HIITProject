package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreatePlayList extends AppCompatActivity {

    public void hideTopAction(){
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
    }
    public void adaptArrayIntoSpinner(Spinner spin, int arrloc){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrloc, R.layout.spinner_custom);
        adapter.setDropDownViewResource(R.layout.spinner_custom);
        spin.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_play_list);
        //Variables
        Intent createin = getIntent();
        EditText plltitle = findViewById(R.id.plltitle);
        Spinner spintime = findViewById(R.id.timespin);
        Spinner spinday = findViewById(R.id.dayspin);
        Button backtohome = findViewById(R.id.backbutton);

        //Actions
        hideTopAction();
        adaptArrayIntoSpinner(spintime, R.array.timeofday);
        adaptArrayIntoSpinner(spinday, R.array.dayofweek);
        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhomein = new Intent(CreatePlayList.this, HomePage.class);
                startActivity(backhomein);
            }
        });

    }
}