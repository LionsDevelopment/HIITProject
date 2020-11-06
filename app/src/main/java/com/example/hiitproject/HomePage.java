package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    boolean clicked = false;
    public void hideTopAction(){
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hideTopAction();
        Intent homin= getIntent();
        Button createbutton = findViewById(R.id.creatplaybt);
        final SearchView searchView = (SearchView)findViewById(R.id.searchwork);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked) {
                    searchView.setVisibility(View.GONE);
                    clicked = false;
                }
                else{
                    searchView.setVisibility(View.VISIBLE);
                    clicked = true;
                }
            }
        });


        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent createin = new Intent(HomePage.this, CreatePlayList.class);
                startActivity(createin);
            }
        });
    }


}