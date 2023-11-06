package com.example.allascopertadibomarzo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class specificmapmeglio extends AppCompatActivity implements OnMapReadyCallback{

    TextView info;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentspecific_maps);
        info = (TextView)findViewById(R.id.pisello_txt);
        int idmappa = getIntent().getIntExtra("idmappa", 0);
        info.setText(""+idmappa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        String Posto;
        int id = getIntent().getIntExtra("idmappa", 0);
        switch (id) {

            case 1: LatLng Parco_Mostri = new LatLng(42.49177854680352, 12.24757183992639);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Parco_Mostri, 18));
                googleMap.addMarker(new MarkerOptions().position(Parco_Mostri));
                Posto = "Indirizzo: Località Giardino, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 2: LatLng Duomo_Bomarzo = new LatLng(42.49129271286973, 12.251456097847672);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Duomo_Bomarzo, 18));
                googleMap.addMarker(new MarkerOptions().position(Duomo_Bomarzo));
                Posto = "Indirizzo: SP20, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 3: LatLng Piramide = new LatLng(42.48130585419684, 12.264270026683267);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Piramide, 18));
                googleMap.addMarker(new MarkerOptions().position(Piramide));
                Posto = "Indirizzo: 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 4: LatLng Piccolo = new LatLng(42.47842017917922, 12.247646297847226);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Piccolo, 18));
                googleMap.addMarker(new MarkerOptions().position(Piccolo).icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                Posto = "Indirizzo: Via Madonna del Piano, 27, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 5: LatLng Cantina_Borgo = new LatLng(42.489900002037174, 12.251239450112678);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Cantina_Borgo, 18));
                googleMap.addMarker(new MarkerOptions().position(Cantina_Borgo).icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                Posto = "Indirizzo: Via Guglielmo Marconi, 71, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 6: LatLng Quadrifoglio = new LatLng(42.47973159206462, 12.252760376691242);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Quadrifoglio, 18));
                googleMap.addMarker(new MarkerOptions().position(Quadrifoglio).icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                Posto = "Indirizzo: Via Giovanni Verga, 191, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 7: LatLng Sapori = new LatLng(42.48676557917853, 12.25072189784751);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sapori, 18));
                googleMap.addMarker(new MarkerOptions().position(Sapori).icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                Posto = "Indirizzo: Via Mentana, 2, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 8: LatLng Magna = new LatLng(42.48611293987782, 12.250786289042825);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Magna, 18));
                googleMap.addMarker(new MarkerOptions().position(Magna).icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                Posto = "Via Cavour, 01020 Bomarzo VT";
                info.setText(Posto);
                break;

            case 9: LatLng Orsini = new LatLng(42.49138907892989, 12.251587340252284);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Orsini, 18));
                googleMap.addMarker(new MarkerOptions().position(Orsini));
                Posto = "Piazza Duomo, 11, 01020 Bomarzo VT";
                info.setText(Posto);
                break;
        }
    }



}