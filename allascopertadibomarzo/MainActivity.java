package com.example.allascopertadibomarzo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //bottom navigation view inizialize
    BottomNavigationView navigation;
    FrameLayout frameLayout ;

        //riferimenti agli oggetti Fragments
        private HomeFragment homeFragment;
        private RestaurantFragment restaurantFragment;
        private MapsFragment mapsFragment;
        private TicketFragment ticketFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //identify ID bottom  nav bar from xml file
        navigation = findViewById(R.id.BottomNaviglationView);
        frameLayout = findViewById(R.id.frameLayout);
        //Button gotocamera = (Button) findViewById(R.id.gotocamera);
        //Button gotoparco= (Button) findViewById(R.id.parco);
        //fragments initialization
        homeFragment = new HomeFragment();
        mapsFragment = new MapsFragment();
        restaurantFragment = new RestaurantFragment();
        ticketFragment = new TicketFragment();
        InitializeFragment(homeFragment);
        //gotocamera.setOnClickListener(x->{
            //Intent i = new Intent(this, scrivi_recensione.class);
            //startActivity(i);});
       // gotoparco.setOnClickListener(x->{
            //Intent i2 = new Intent(this, ParcoDeiMostri.class);
            //startActivity(i2);});
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Switch to select which case is chosen:
                switch(item.getItemId())
                {
                    case R.id.home:
                        //inizializzo il fregment home
                        InitializeFragment(homeFragment);
                        return true;
                    case R.id.restaurant:
                        InitializeFragment(restaurantFragment);
                        return true;
                    case R.id.maps:
                        InitializeFragment(mapsFragment);
                        return true;
                    case R.id.ticket:
                        InitializeFragment(ticketFragment);
                        return true;
                    default:
                        return false;

                }



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                switch (data.getIntExtra("id", 1)) {
                    case R.id.home:

                        InitializeFragment(homeFragment);
                        return;
                    case R.id.restaurant:
                        Intent intent = new Intent(getApplicationContext(), Launch_restaurant.class);
                        startActivity(intent);
                        return ;
                    case R.id.maps:
                        InitializeFragment(mapsFragment);
                        return ;
                    case R.id.ticket:
                        InitializeFragment(ticketFragment);
                        return ;
                    default:
                        return ;

                }
            }
        }
    }

    //private class
    private void InitializeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}