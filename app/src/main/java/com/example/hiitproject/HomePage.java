package com.example.hiitproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Hashtable;
import static android.graphics.Typeface.BOLD;

//Main Class for Homepage.java
public class HomePage extends AppCompatActivity {
    boolean clicked = false;
    boolean newplaylistboo = true;
    DaDataClass daObject = (DaDataClass) MainActivity.getObjService();
    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();


    //Hides the standard android studio header
    public void hideTopAction() {
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
            System.out.println("Top bar has been hidden.");
        }
    }

    //Transfers integers into pixel measurements for xml
    public int intToPixels(int i) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
    }

    //Personal boolean to string method
    public String toString(boolean boo) {
        String s = "";
        s += boo;
        return s;
    }

    public static Typeface createFont(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }

    //Main loop for activity_home_page.xml
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hideTopAction();
        final SearchView searchView = (SearchView) findViewById(R.id.searchwork);
        Button createbutton = findViewById(R.id.creatplaybt);
        Button createcusworkbt = findViewById(R.id.custcreate);
        Button favpage = findViewById(R.id.favourites);
        Button playopenbt = new Button(this);
        Typeface volkhovTypeface = createFont("font/volkhov.ttf", playopenbt.getContext());
        LinearLayout playlists = findViewById(R.id.playlists);
        Intent homin = getIntent();
        Bundle bun = homin.getExtras();
        //Playlist Information
        String cplayname = "";
        final ArrayList<String> info = homin.getStringArrayListExtra("playinfo");
        try {
            newplaylistboo = daObject.isArrayListEmpty();
        } catch (NullPointerException e) {
            System.out.println("Empty");
        }
        try {
            cplayname = (String) daObject.playinfo.get(0).get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Empty");
        }
        //Creates playlist when newplaylistboo is true
        if (newplaylistboo == false) {
            playopenbt.setLayoutParams(new LinearLayout.LayoutParams(1350, 400));
            LinearLayout.LayoutParams playbt = (LinearLayout.LayoutParams) playopenbt.getLayoutParams();
            playbt.gravity = Gravity.CENTER;
            playopenbt.setLayoutParams(playbt);
            playopenbt.setBackground(getDrawable(R.drawable.plledit));
            playopenbt.setTypeface(volkhovTypeface, BOLD);
            playopenbt.setText(cplayname);
            playopenbt.setTextSize(25f);
            playopenbt.setTextColor(ContextCompat.getColor(playopenbt.getContext(), R.color.darklime));
            playlists.addView(playopenbt);
        } else {
            System.out.println("No playlist");
        }
        //Search View on activity_home_page.xml
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
        //Create playlist button in acitivity_home_page.xml
        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent createin = new Intent(HomePage.this, CreatePlayList.class);
                startActivity(createin);
            }
        });
        //Create custom playlist button in activity_home_page.xml
        createcusworkbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cusin = new Intent(HomePage.this, CreateCustWork.class);
                startActivity(cusin);
            }
        });
        //Playlistbutton that is created after information is put in
        playopenbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //HomePage.this.mService.printPlayListGiven();
                Toast.makeText(HomePage.this, "" + daObject.playinfo.get(0), Toast.LENGTH_LONG).show();


            }
        });
        //Opens favourite list button
        favpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotofav = new Intent(HomePage.this, FavouritePage.class);
                startActivity(gotofav);
            }
        });

    }

}

