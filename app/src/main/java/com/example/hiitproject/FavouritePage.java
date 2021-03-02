package com.example.hiitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class FavouritePage extends AppCompatActivity {
    public void hideTopAction() {
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
            System.out.println("TOPBARHIDDEN");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_page);
        hideTopAction();
        Button backhome = findViewById(R.id.backbutton);
        Button createfav = findViewById(R.id.creatfavbt);
        ScrollView favlist = findViewById(R.id.favlist);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhome = new Intent(FavouritePage.this, HomePage.class);
                startActivity(backhome);
            }
        });
        createfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favourcreate = new Intent(FavouritePage.this, CreateCustWork.class);
                startActivity(favourcreate);
            }
        });

    }
}