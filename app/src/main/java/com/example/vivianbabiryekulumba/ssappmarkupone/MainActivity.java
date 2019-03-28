package com.example.vivianbabiryekulumba.ssappmarkupone;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.vivianbabiryekulumba.ssappmarkupone.fragments.GamesFrag;
import com.example.vivianbabiryekulumba.ssappmarkupone.fragments.MoreFrag;

public class MainActivity extends FragmentActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GamesFrag gamesFrag = new GamesFrag();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, gamesFrag);
        transaction.commit();

        bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = GamesFrag.newInstance();
                switch (item.getItemId()) {
                    case R.id.menu_games:
                        selectedFragment = GamesFrag.newInstance();
                        break;
                    case R.id.menu_more:
                        selectedFragment = MoreFrag.newInstance();
                        break;
                        default: GamesFrag.newInstance();
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.commit();
                return true;
            }
        });

    }
}
