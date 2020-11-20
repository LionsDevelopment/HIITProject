package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreatePlayList extends AppCompatActivity {
    private boolean maxChar = false;
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
    public String getEditText(EditText edt){
        String edst;
        edst = edt.getText().toString();
        return edst;
    }
    public int toInt(String s){
        int newint;
        try{
            newint = Integer.parseInt(s);
        }catch(NumberFormatException e){
            newint = 0;
        }
        return newint;
    }
    public String toString(boolean boo){
        String s = "";
        s += boo;
        return s;
    }

    //Start App
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_play_list);
        //Variables
        Intent createin = getIntent();
        final EditText plltitle = findViewById(R.id.plltitle);
        final EditText plldesc = findViewById(R.id.description);
        final EditText timespinhr = findViewById(R.id.timespinhr);
        final EditText timespinmin = findViewById(R.id.timespinmin);
        Spinner spinday = findViewById(R.id.dayspin);
        Button backtohome = findViewById(R.id.backbutton);
        Button confirmcreate = findViewById(R.id.confirmcreate);
        Button cancelcreate = findViewById(R.id.cancelcreate);

        //Actions
        hideTopAction();
        adaptArrayIntoSpinner(spinday, R.array.dayofweek);
        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhomein = new Intent(CreatePlayList.this, HomePage.class);
                startActivity(backhomein);
            }
        });
        cancelcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelbackhome = new Intent(CreatePlayList.this, HomePage.class);
                Toast.makeText(CreatePlayList.this, "Cancelled Creation", Toast.LENGTH_LONG).show();
                startActivity(cancelbackhome);
            }
        });
        confirmcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final boolean newplayboo2 = true;
                final String playname = getEditText(plltitle);
                final String playdesc = getEditText(plldesc);
                final int timehr = toInt(getEditText(timespinhr));
                final int timemin = toInt(getEditText(timespinmin));
                Intent createbackhome = new Intent(CreatePlayList.this, HomePage.class);
                if(timehr > 23 || timemin > 59)
                    Toast.makeText(CreatePlayList.this, "Need Real Time", Toast.LENGTH_LONG).show();
                else if(playname.isEmpty() == true)
                    Toast.makeText(CreatePlayList.this, "Please Put Name",  Toast.LENGTH_LONG).show();
                else{
                    createbackhome.putExtra("playname", playname);
                    createbackhome.putExtra("playdesc", playdesc);
                    createbackhome.putExtra("timehr", timehr);
                    createbackhome.putExtra("timemin", timemin);
                    createbackhome.putExtra("newplayboo", newplayboo2);
                    Toast.makeText(CreatePlayList.this, "Created Playlist", Toast.LENGTH_LONG).show();
                    startActivity(createbackhome);
                }
            }

        });
        plldesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(plldesc.getText().length() == 300 && !maxChar){
                    Toast.makeText(CreatePlayList.this, "Max Characters Reached", Toast.LENGTH_LONG).show();
                }
                if(plldesc.getText().length() < 300 && maxChar) maxChar = false;
            }
        });
        plltitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(plltitle.getText().length() == 30 && !maxChar){
                    Toast.makeText(CreatePlayList.this, "Max Characters Reached", Toast.LENGTH_LONG).show();
                }
                if(plltitle.getText().length() < 30 && maxChar) maxChar = false;
            }
        });
    }
}