package com.example.allascopertadibomarzo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;

import static android.app.ProgressDialog.show;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TicketFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestaurantFragment newInstance(String param1, String param2) {
        RestaurantFragment fragment = new RestaurantFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restaurant, container, false);

        ImageButton goToRestaurant1 = (ImageButton)   v.findViewById(R.id.restaurant1);
        goToRestaurant1.setOnClickListener(b -> {
            Intent intent = new Intent(v.getContext(), ActivityRestaurant1.class);
               startActivity(intent);
            });

        //go to restaurant2
        ImageButton goToRestaurant2 =  (ImageButton)  v.findViewById(R.id.restaurant2);
        goToRestaurant2.setOnClickListener(b -> {
            Intent intent2 = new Intent(v.getContext(), ActivityRestaurant2.class);
            startActivity(intent2);
        });

        //go to restaurant3
        ImageButton goToRestaurant3 =  (ImageButton)  v.findViewById(R.id.restaurant3);
        goToRestaurant3.setOnClickListener(b -> {
            Intent intent3 = new Intent(v.getContext(), ActivityRestaurant3.class);
            startActivity(intent3);
        });

        //go to restaurant4
        ImageButton goToRestaurant4 =  (ImageButton)  v.findViewById(R.id.restaurant4);
        goToRestaurant4.setOnClickListener(b -> {
            Intent intent4 = new Intent(v.getContext(), ActivityRestaurant4.class);
            startActivity(intent4);
        });

        //go to restaurant5
        ImageButton goToRestaurant5 =  (ImageButton)  v.findViewById(R.id.restaurant5);
        goToRestaurant5.setOnClickListener(b -> {
            Intent intent5 = new Intent(v.getContext(), ActivityRestaurant5.class);
            startActivity(intent5);
        });



        return v;
    }
}