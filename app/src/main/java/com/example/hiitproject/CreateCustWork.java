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
import android.widget.Toast;

import java.util.ArrayList;

public class CreateCustWork extends AppCompatActivity {
    private boolean maxChar = true;
    DaDataClass daObject = (DaDataClass) MainActivity.getObjService();
    //Hides original top bar
    public void hideTopAction(){
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){System.out.println("TOPBARHIDDEN");}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideTopAction();
        final Intent bainhome = new Intent(CreateCustWork.this, HomePage.class);
        setContentView(R.layout.activity_create_cust_work);
        final EditText cuswtime = findViewById(R.id.timesecs);
        final EditText cuswname = findViewById(R.id.cuswtitle);
        final EditText cuswdescp = findViewById(R.id.description);
        final Button cusbackhome = findViewById(R.id.backbutton);
        final Button cuscancleback = findViewById(R.id.cancelcreate);
        final Button cusworkcreate = findViewById(R.id.confirmcreate);

        cuscancleback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(bainhome);
            }
        });
        cusbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(bainhome);
            }
        });

        cuswname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (cuswname.getText().length() < 30 && maxChar) maxChar = false;
                if (cuswname.getText().length() == 30 && !maxChar) {
                    Toast.makeText(CreateCustWork.this, "Reached Character Limit", Toast.LENGTH_LONG).show();
                    System.out.println("Max Charactered Reached");
                }
            }
        });
        cuswdescp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (cuswdescp.getText().length() < 200 && maxChar) maxChar = false;
                if (cuswdescp.getText().length() == 200 && !maxChar) {
                    Toast.makeText(CreateCustWork.this, "Reached Character Limit", Toast.LENGTH_LONG).show();
                    System.out.println("Max Characters Reached");
                }
            }
        });
        cusworkcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> workinfo = daObject.addInfoForWork(cuswname.getText().toString(), cuswdescp.getText().toString(), cuswtime.getText().toString());
                daObject.addWorkArraytoWorkinfo(workinfo);
                Toast.makeText(CreateCustWork.this, "" + workinfo, Toast.LENGTH_LONG).show();
                Intent favin = new Intent(CreateCustWork.this, FavouritePage.class);
                startActivity(favin);


            }
        });


    }
}