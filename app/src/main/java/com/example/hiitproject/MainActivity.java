package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    public void hideTopAction(){
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){System.out.println("TOPBARHIDDEN");}
    }
}