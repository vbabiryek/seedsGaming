package com.example.vivianbabiryekulumba.ssappmarkupone.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.ssappmarkupone.LListGamesActivity;
import com.example.vivianbabiryekulumba.ssappmarkupone.R;

public class LogicalGamesSplash extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2050;
    TextView logicalGamesTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical_games_splash);

        logicalGamesTv = findViewById(R.id.logicalGamesTv);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(LogicalGamesSplash.this, LListGamesActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
