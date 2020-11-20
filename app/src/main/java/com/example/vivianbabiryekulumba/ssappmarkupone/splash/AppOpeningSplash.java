package com.example.vivianbabiryekulumba.ssappmarkupone.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;
import com.example.vivianbabiryekulumba.ssappmarkupone.AuthActivity;
import com.example.vivianbabiryekulumba.ssappmarkupone.R;

public class AppOpeningSplash extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2050;
    TextView logoPhold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_opening_splash);

        logoPhold = findViewById(R.id.logoPhol_tv);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(AppOpeningSplash.this, AuthActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
