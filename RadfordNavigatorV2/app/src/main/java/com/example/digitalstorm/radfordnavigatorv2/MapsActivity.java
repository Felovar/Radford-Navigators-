package com.example.digitalstorm.radfordnavigatorv2;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    GoogleMap mMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        getSupportActionBar().setTitle("Radford Navigator Map");

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        // This closes the location updates when the MapActivity is no longer active.
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        // Interesting option for how the map looks.
        //mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMinZoomPreference(18f);

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                // If the application has already been granted permissions for location
                // the MapActivity can just go straight to getting the location.
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            } else {
                checkLocationPermission();
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

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

        LatLng Kyle = new LatLng(37.134040,-80.550307);
        LatLng Waldron = new LatLng(37.135301,-80.549456);
        LatLng Cook = new LatLng(37.135647,-80.548890);
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

//        LatLng CenterFocus = new LatLng(37.137618, -80.550235 );


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
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }
    // While location services are being used (in the map activity) this sets the interval that
    // the current location is requested. Can be adjusted to maintain battery life.
    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(1);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}

    @Override
    public void onLocationChanged(Location location)
    {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        // Place user's current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        // MarkerOptions markerOptions = new MarkerOptions();
        //markerOptions.position(latLng);
        //markerOptions.title("Current Position");
        //markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        // mCurrLocationMarker = mMap.addMarker(markerOptions);

        // move map camera
        // Need to add conditionals so that users can break the auto-focus and look around the map
        // The current implementation allows the user to move, but it re-centers on update.
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(latLng);
        mMap.animateCamera(cameraUpdate);
        //location.removeUpdates(this);

    }

//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//      TODO
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//      TODO
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//      TODO
//    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Give a reason why location services are required. Once the user acknowledges the
                // explanation, permission prompt should show
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Required")
                        .setMessage("Radford Navigator requires Location Services, please grant permission to use location functionality.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // The following should prompt the user for permissions after the explanation above
                                ActivityCompat.requestPermissions(MapsActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION );
                            }
                        })
                        .create()
                        .show();

            } else {
                // Request the permission on first-time startup and permissions have not yet been
                // allowed or denied.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // If permission was granted, the app will then load the activity with users location
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // If permission is denied, this displays to the user a confirmation.
                    // The app shows the map activity currently, but does not get the user's location.
                    Toast.makeText(this, "Location permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
                // Other permission requests can be added here. Such as permission to store locally
                // if we want to store saved locations.
        }
    }

}
