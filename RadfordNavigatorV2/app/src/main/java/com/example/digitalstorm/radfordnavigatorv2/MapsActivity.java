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
        mMap.setMinZoomPreference(16.8f);
        //mMap.setMaxZoomPreference(14.0f);

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

        //Needs to be sorted by Quad

        LatLng Kyle= new LatLng(37.134040, -80.550307);
        LatLng Waldron = new LatLng(37.135301,-80.549456 );
        LatLng Cook = new LatLng(37.135647,-80.548890 );
        LatLng Washington = new LatLng(37.137144, -80.552565);
        LatLng Walker = new LatLng(37.137803, -80.552506 );
        LatLng Norwood= new LatLng(37.138367, -80.552645);
        LatLng Jefferson = new LatLng(37.138581,-80.551825);
        LatLng Madison = new LatLng(37.138012, -80.551905);
        LatLng Tyler = new LatLng(37.138816, -80.552555);
        LatLng Muse = new LatLng(37.140287, -80.553156);
        LatLng CHUBS = new LatLng(37.140116,-80.551616 );
        LatLng McConnell = new LatLng(37.139842, -80.551139);
        LatLng Reed = new LatLng(37.139350, -80.550544);
        LatLng Curie = new LatLng(37.139994, -80.550067);
        LatLng Preston = new LatLng(37.138950,-80.549514 );
        LatLng Young = new LatLng(37.138300,-80.549707 );
        LatLng Davis = new LatLng(37.138105,  -80.549248);
        LatLng McGruffy = new LatLng(37.137872,-80.548875);
        LatLng PorterField = new LatLng(37.138623, -80.548196);
        LatLng Covington= new LatLng(37.137926, -80.547000 );
        LatLng Buchanan = new LatLng(37.135377, -80.550512 );

        LatLng CenterFocus = new LatLng(37.137618, -80.550235 );


        //Will eventually test for the button press on the main Class to add a pin



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
        mMap.addMarker(new MarkerOptions().position(Kyle).title("Kyle Hall"));
        mMap.addMarker(new MarkerOptions().position(Waldron).title("Waldron Hall"));
        mMap.addMarker(new MarkerOptions().position(Cook).title("Cook Hall"));
        mMap.addMarker(new MarkerOptions().position(Washington).title("Washington Hall"));
        mMap.addMarker(new MarkerOptions().position(Walker).title("Walker Hall"));
        mMap.addMarker(new MarkerOptions().position(Norwood).title("Norwood Hall"));
        mMap.addMarker(new MarkerOptions().position(Jefferson).title("Jefferson Hall"));
        mMap.addMarker(new MarkerOptions().position(Madison).title("Madison Hall"));
        mMap.addMarker(new MarkerOptions().position(Tyler).title("Tyler Hall"));
        mMap.addMarker(new MarkerOptions().position(Muse).title("Muse Hall"));
        mMap.addMarker(new MarkerOptions().position(CHUBS).title("College of Humanities & Behavioral Sciences"));
        mMap.addMarker(new MarkerOptions().position(McConnell).title("McConnell Library"));
        mMap.addMarker(new MarkerOptions().position(Reed).title("Reed Hall"));
        mMap.addMarker(new MarkerOptions().position(Curie).title("Curie Hall"));
        mMap.addMarker(new MarkerOptions().position(Preston).title("Preston Hall"));
        mMap.addMarker(new MarkerOptions().position(Young).title("Young Hall"));
        mMap.addMarker(new MarkerOptions().position(Davis).title("Davis Hall"));
        mMap.addMarker(new MarkerOptions().position(McGruffy).title("McGruffy Hall"));
        mMap.addMarker(new MarkerOptions().position(PorterField).title("PorterField Hall"));
        mMap.addMarker(new MarkerOptions().position(Covington).title("Covington Hall"));
        mMap.addMarker(new MarkerOptions().position(Buchanan).title("Buchanan House"));
        mMap.addMarker(new MarkerOptions().position(Moffett).title("Moffett Hall"));






        mMap.moveCamera(CameraUpdateFactory.newLatLng(CenterFocus));



    }
}
