package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateCustWork extends AppCompatActivity {
    private boolean maxChar = true;
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
        setContentView(R.layout.activity_create_cust_work);
        final EditText cuswtime = findViewById(R.id.timesecs);
        final EditText cuswname = findViewById(R.id.cuswtitle);
        final EditText cuswdescp = findViewById(R.id.description);

        cuswname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(cuswname.getText().length() < 30 && maxChar) maxChar = false;
                if(cuswname.getText().length() == 30 && !maxChar){
                    Toast.makeText(CreateCustWork.this, "Reached Character Limit", Toast.LENGTH_LONG).show();
                    System.out.println("Max Charactered Reached");
                }
            }
        });
        cuswdescp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(cuswdescp.getText().length() < 200 && maxChar) maxChar = false;
                if(cuswdescp.getText().length() == 200 && !maxChar){
                    Toast.makeText(CreateCustWork.this, "Reached Character Limit", Toast.LENGTH_LONG).show();
                    System.out.println("Max Characters Reached");
                }
            }
        });

    }
}