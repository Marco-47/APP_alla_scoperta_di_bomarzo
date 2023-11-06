package com.example.allascopertadibomarzo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;


public class MapsFragment extends Fragment {
    private final OnMapReadyCallback callback = new OnMapReadyCallback() {
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng Bomarzo = new LatLng(42.48458331181688, 12.249909074336397);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bomarzo, 14));

            LatLng Parco_Mostri = new LatLng(42.49177854680352, 12.24757183992639);
            googleMap.addMarker(new MarkerOptions().position(Parco_Mostri).title("Parco dei mostri").snippet("Località Giardino, 01020 Bomarzo VT"));

            LatLng Duomo_Bomarzo = new LatLng(42.49129271286973, 12.251456097847672);
            googleMap.addMarker(new MarkerOptions().position(Duomo_Bomarzo).title("Duomo di Bomarzo").snippet("SP20, 01020 Bomarzo VT"));

            LatLng Piramide = new LatLng(42.48130585419684, 12.264270026683267);
            googleMap.addMarker(new MarkerOptions().position(Piramide).title("Piramide di Bomarzo").snippet("01020 Bomarzo VT"));


            LatLng Piccolo = new LatLng(42.47844323840352, 12.247677476598108);
            googleMap.addMarker(new MarkerOptions().position(Piccolo).title("Ristorante Piccolo Mondo").snippet("Via Madonna del Piano, 27, 01020 Bomarzo VT").icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

            LatLng Cantina_Borgo = new LatLng(42.489900002037174, 12.251239450112678);
            googleMap.addMarker(new MarkerOptions().position(Cantina_Borgo).title("La Cantina del Borgo").snippet("Via Guglielmo Marconi, 71, 01020 Bomarzo VT").icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

            LatLng Quadrifoglio = new LatLng(42.47973159206462, 12.252760376691242);
            googleMap.addMarker(new MarkerOptions().position(Quadrifoglio).title("Il Quadrifoglio").snippet("Via Giovanni Verga, 191, 01020 Bomarzo VT").icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

            LatLng Sapori = new LatLng(42.48676557917853, 12.25072189784751);
            googleMap.addMarker(new MarkerOptions().position(Sapori).title("La Fraschetta degli Antichi Sapori").snippet("Via Mentana, 2, 01020 Bomarzo VT").icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}