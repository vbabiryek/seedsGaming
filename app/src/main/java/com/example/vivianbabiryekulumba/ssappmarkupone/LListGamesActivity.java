package com.example.vivianbabiryekulumba.ssappmarkupone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vivianbabiryekulumba.gnomeswellgame.UnityPlayerActivity;

public class LListGamesActivity extends Activity {

    Button gameImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llist_games);

        gameImage = findViewById(R.id.firstGame);

        gameImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGame = new Intent(LListGamesActivity.this, UnityPlayerActivity.class);
                startActivity(toGame);
            }
        });
    }
}
