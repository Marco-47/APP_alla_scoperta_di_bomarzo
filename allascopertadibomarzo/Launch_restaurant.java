package com.example.allascopertadibomarzo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;



public class Launch_restaurant extends AppCompatActivity {
    private RestaurantFragment restaurantFragment;
    HomeFragment homeFragment;
    MapsFragment mapsFragment;
    TicketFragment ticketFragment;
    FrameLayout frameLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        frameLayout = findViewById(R.id.frameLayout);
        setContentView(R.layout.activity_launch_restaurant);
        homeFragment = new HomeFragment();
        mapsFragment = new MapsFragment();
        ticketFragment = new TicketFragment();
        restaurantFragment = new RestaurantFragment();
        initializeFragment(restaurantFragment);

    }

    private void initializeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}