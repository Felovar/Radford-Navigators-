package com.example.digitalstorm.radfordnavigatorv2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker For all the Halls At Radford University
        LatLng Peters = new LatLng(37.135759, -80.550431);
        LatLng FitnessCenter = new LatLng(37.137302,-80.547684 );

        //Moffet Quad Dorms
        LatLng Moffett = new LatLng(37.134875, -80.551544);
        LatLng Draper = new LatLng(37.135397,-80.552204);
        LatLng Ingles = new LatLng(37.136372, -80.552408);
        LatLng Bolling = new LatLng(37.135397,-80.550965);
        LatLng Pocahontas = new LatLng(37.136365,-80.551010);

        //Governor's Quad
        LatLng DaltonHall = new LatLng(37.136873,-80.549434);
        LatLng TheBonnie = new LatLng(37.136754, -80.548136);
        LatLng Perry = new LatLng(37.136967,-80.548882);
        LatLng Floyd = new LatLng(37.137369, -80.549654);


        /*LatLng = new LatLng(, );
        LatLng = new LatLng(, );
        LatLng = new LatLng(, );
        LatLng = new LatLng(, );
        LatLng = new LatLng(, );
        LatLng = new LatLng(, );
        LatLng = new LatLng(, );
        */



        mMap.addMarker(new MarkerOptions().position(Peters).title("Peters Hall"));
        mMap.addMarker(new MarkerOptions().position(Draper).title("Draper Hall"));
        mMap.addMarker(new MarkerOptions().position(Ingles).title("Ingles Hall"));
        mMap.addMarker(new MarkerOptions().position(Bolling).title("Bolling Hall"));
        mMap.addMarker(new MarkerOptions().position(Pocahontas).title("Pocahontas Hall"));
        mMap.addMarker(new MarkerOptions().position(FitnessCenter).title("FitnessCenter Hall"));
        mMap.addMarker(new MarkerOptions().position(DaltonHall).title("DaltonHall Hall"));
        mMap.addMarker(new MarkerOptions().position(TheBonnie).title("The Bonnie"));
        mMap.addMarker(new MarkerOptions().position(Floyd).title("Floyd Hall"));
        mMap.addMarker(new MarkerOptions().position(Perry).title("Perry Hall"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(Peters));

    }
}
