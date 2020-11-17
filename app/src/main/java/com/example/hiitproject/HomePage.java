package com.example.hiitproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
    public int intToPixels(int i){
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
        return px;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hideTopAction();
        boolean newplatlistboo = false;
        Intent homin= getIntent();
        final SearchView searchView = (SearchView)findViewById(R.id.searchwork);
        Button createbutton = findViewById(R.id.creatplaybt);
        LinearLayout playlists = findViewById(R.id.playlists);
        Button playopenbt = new Button(this);
        final String cplayname = homin.getStringExtra("playname");
        final String cplaydesc = homin.getStringExtra("playdesc");
        final String ctimehr = homin.getStringExtra("timehr");
        final String ctimemin = homin.getStringExtra("timemin");
        if(newplatlistboo) {
            playopenbt.setBackground(getDrawable(R.drawable.plledit));
            playlists.addView(playopenbt);
            playopenbt.setWidth(intToPixels(165));
            playopenbt.setHeight(intToPixels(150));
            playopenbt.setTop(intToPixels(15));
        }
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