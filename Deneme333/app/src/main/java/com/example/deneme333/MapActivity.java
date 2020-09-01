package com.example.deneme333;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.location.LocationManagerCompat;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.services.android.navigation.ui.v5.NavigationView;

import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Feature;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;

/**
 * GameModeMap class, directs users to some buildings in map
 * @author Furkan Turunç, Murat Furkan Uğurlu, Recep Uysal
 * @version 1.0
 */
public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener {

    // proporties
    private MapView            mapView;
    private MapboxMap          mapboxMap;
    private LocationComponent  locationComponent;
    private PermissionsManager permissionsManager;
    private Intent             intent2, intent3, intent4;
    private Button             buttonGo2, locationButton;
    private String             buildingName;
    private NavigationView     navigationView;
    private static final int CHECK_FREQ = 3000;
    private Switch switch1;

    private DirectionsRoute currentRoute;
    private NavigationMapRoute navigationMapRoute;
    private static final String TAG = "DirectionsActivity";
    // methods
    /**
     * This method is the default method of android studio, which applies main process for widgets.
     * @param savedInstanceState , a Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_NoActionBar);

        // initialising map objects
        Mapbox.getInstance(this, getString(R.string.access_token));
        setContentView(R.layout.activity_map);


        // linking mapView
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        // linking buttons
        buttonGo2 = findViewById(R.id.buttonGo2);
        locationButton = findViewById(R.id.locationButton);

        switch1 = findViewById(R.id.switch1);

        // linking navigationview
        navigationView = findViewById(R.id.navigationView);

        // get the building name from GameModeMain class
        buildingName = getIntent().getStringExtra("answer");



        Handler handler = new Handler();

        /**
         * handler's post delayed method provides the location to be checked every three seconds
         */
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // get users last location
                Point newLocation = Point.fromLngLat(locationComponent.getLastKnownLocation().getLongitude(),locationComponent.getLastKnownLocation().getLatitude());


				if( buildingName.equals("ODEON")){
					if( mapTracker( newLocation, 32.752106, 39.875492, 32.7519, 32.7523, 39.8752, 39.8756)){
						return;
					}
				}
				
                if( buildingName.equals("A")){
                    if(mapTracker(newLocation, 32.749340, 39.868065, 32.7492, 32.7502, 39.8675, 39.8682)){
                        return;
                    }
                }


                if( buildingName.equals("B")) {
                    Point destPoint = Point.fromLngLat(32.7482, 39.8686);
                    getRoute(newLocation, destPoint);
                    if(newLocation.latitude() > 39.8685 && newLocation.latitude() < 39.8690 && newLocation.longitude() > 32.7475 && newLocation.longitude() < 32.7485) {
                        Toast.makeText(MapActivity.this, "You have arrived!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if( buildingName.equals("D")) {
                    if(mapTracker( newLocation, 32.764658, 39.870485, 32.7644, 32.7648, 39.8703, 39.8707)){
                        return;
                    }
                }


                if( buildingName.equals("EA")) {
                    if(mapTracker( newLocation, 32.75010, 39.871125, 32.7497, 32.7503, 39.8708, 39.8714)){
                        return;
                    }
                }


                if( buildingName.equals("EE")) {
                    Point destPoint = Point.fromLngLat(32.750600, 39.872060);
                    getRoute(newLocation, destPoint);
                    if(newLocation.latitude() > 39.8719 && newLocation.latitude() < 39.8722 && newLocation.longitude() > 32.7504 && newLocation.longitude() < 32.7510) {
                        Toast.makeText(MapActivity.this, "You have arrived!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }


                if( buildingName.equals("Fx")) {
                    Point destPoint = Point.fromLngLat(32.748890, 39.8658865);
                    getRoute(newLocation, destPoint);
                    if(newLocation.latitude() > 39.8655 && newLocation.latitude() < 39.8665 && newLocation.longitude() > 32.7485 && newLocation.longitude() < 32.7495) {
                        Toast.makeText(MapActivity.this, "You have arrived!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if( buildingName.equals("G")) {
                    Point destPoint = Point.fromLngLat(32.749600, 39.868700);
                    getRoute(newLocation, destPoint);
                    if(newLocation.latitude() > 39.8685 && newLocation.latitude() < 39.8689 && newLocation.longitude() > 32.7494 && newLocation.longitude() < 32.7508) {
                        Toast.makeText(MapActivity.this, "You have arrived!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if( buildingName.equals("MSSF")) {
                    if(mapTracker( newLocation, 32.755251, 39.869203, 32.7550, 32.7554, 39.8690, 39.8694)){
                        return;
                    }
                }

                if( buildingName.equals("N")) {
                    if(mapTracker( newLocation, 32.763130, 39.872817, 32.7629, 32.7633, 39.8726, 39.8730)){
                        return;
                    }
                }

                if( buildingName.equals("SASB")) {
                    Point destPoint = Point.fromLngLat(32.748395, 39.867700);
                    getRoute(newLocation, destPoint);
                    if(newLocation.latitude() > 39.8675 && newLocation.latitude() < 39.8680 && newLocation.longitude() > 32.7480 && newLocation.longitude() < 32.7485) {
                        Toast.makeText(MapActivity.this, "You have arrived!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if( buildingName.equals("V")) {
                    Point destPoint = Point.fromLngLat(32.750000, 39.867100);
                    getRoute(newLocation, destPoint);
                    if(newLocation.latitude() > 39.8668 && newLocation.latitude() < 39.8673 && newLocation.longitude() > 32.7496 && newLocation.longitude() < 32.7505) {
                        Toast.makeText(MapActivity.this, "You have arrived!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if( buildingName.equals("76")) {
                    if(mapTracker( newLocation, 32.747641, 39.864487, 32.7474, 32.7478, 39.8642, 39.8646)){
                        return;
                    }
                }

                if( buildingName.equals("77")) {
                    if(mapTracker( newLocation, 32.746615, 39.864322, 32.7464, 32.7468, 39.8641, 39.8645)){
                        return;
                    }
                }

                if( buildingName.equals("78")) {
                    if(mapTracker( newLocation, 32.746046, 39.865116, 32.7458, 32.7462, 39.8649, 39.8653)){
                        return;
                    }
                }

                if( buildingName.equals("9091")) {
                    if(mapTracker( newLocation, 32.763987, 39.868850, 32.7637, 32.7641, 39.8686, 39.8690)){
                        return;
                    }
                }

                if( buildingName.equals("YemekhaneMerkez")) {
                    if(mapTracker( newLocation, 32.750554, 39.870614, 32.7503, 32.7507, 39.8704, 39.8708)){
                        return;
                    }
                }

                if( buildingName.equals("YemekhaneDogu")) {
                    if(mapTracker( newLocation, 32.764091, 39.872209, 32.7638, 32.7642, 39.8720, 39.8724)){
                        return;
                    }
                }

                if( buildingName.equals("BilkaMerkez")) {
                    if(mapTracker( newLocation, 32.747849, 39.864567, 32.7476, 32.7480, 39.8643, 39.8647)){
                        return;
                    }
                }

                if( buildingName.equals("BilkaDogu")) {
                    if(mapTracker( newLocation, 32.763558, 39.868526, 32.7633, 32.7637, 39.8683, 39.8687)){
                        return;
                    }
                }

                if( buildingName.equals("CafeIn")) {
                    if(mapTracker( newLocation, 32.750614, 39.869934, 32.7504, 32.7058, 39.8697, 39.8701)){
                        return;
                    }
                }

                if( buildingName.equals("CBDogu")) {
                    if(mapTracker( newLocation, 32.761969, 39.874162, 32.7617, 32.7621, 39.8739, 39.8743)){
                        return;
                    }
                }

                if( buildingName.equals("CBMerkez")) {
                    if(mapTracker( newLocation, 32.749075, 39.868150, 32.7488, 32.7492, 39.8679, 39.8683)){
                        return;
                    }
                }

                if( buildingName.equals("CBKutuphaneAlt") || buildingName.equals("CBKutuphaneUst")) {
                    if(mapTracker( newLocation, 32.7495235, 39.8702107, 32.7491, 32.7500, 39.8698, 39.8707)){
                        return;
                    }
                }

                if( buildingName.equals("ExpressCafeG")) {
                    if(mapTracker( newLocation, 32.749600, 39.868700, 32.7494, 32.7498, 39.8685, 39.8689)){
                        return;
                    }
                }

                if( buildingName.equals("FameoEA")) {
                    if(mapTracker(newLocation, 32.75010, 39.871125, 32.7497, 32.7503, 39.8708, 39.8714)){
                        return;
                    }
                }

                if( buildingName.equals("FieroG")) {
                    if(mapTracker( newLocation, 32.7497813, 39.8682817, 32.7493, 32.7501, 39.8679, 39.8686)){
                        return;
                    }
                }

                if( buildingName.equals("KiracSpeed")) {
                    if(mapTracker( newLocation, 32.7477544, 39.8663107, 32.7473, 32.7481, 39.8659, 39.8667)){
                        return;
                    }
                }

                if( buildingName.equals("MozartB")) {
                    if(mapTracker( newLocation, 32.7481828, 39.8688857, 32.7477, 32.7485, 39.8683, 39.8692)){
                        return;
                    }
                }

                if( buildingName.equals("MozartD")) {
                    if(mapTracker( newLocation, 32.7644, 39.8706238, 32.7640, 32.7648, 39.8702, 39.8710)){
                        return;
                    }
                }

                if( buildingName.equals("MozartEE")) {
                    if(mapTracker( newLocation, 32.7509768, 39.8721588, 32.7505, 32.7513, 39.8717, 39.8725)){
                        return;
                    }
                }

                if( buildingName.equals("MozartN")) {
                    if(mapTracker( newLocation, 32.7629468, 39.872905, 32.7625, 32.7633, 39.8725, 39.8733)){
                        return;
                    }
                }

                if( buildingName.equals("Sofa")) {
                    if(mapTracker( newLocation, 32.7486883, 39.8643314, 32.7482, 32.7490, 39.8639, 39.8647)){
                        return;
                    }
                }

                if( buildingName.equals("StarbucksA")) {
                    if(mapTracker( newLocation, 32.749433, 39.867985, 32.7490, 32.7498, 39.8675, 39.8683)){
                        return;
                    }
                }

                if( buildingName.equals("StarbucksFC")) {
                    if(mapTracker( newLocation, 32.7485538, 39.865948, 32.7481, 32.7489, 39.8655, 39.8663)){
                        return;
                    }
                }

                if( buildingName.equals("Lab")) {
                    if(mapTracker( newLocation, 32.7482, 39.8686, 32.7477, 32.7483, 39.8685, 39.8690)){
                        return;
                    }
                }

                if( buildingName.equals("BilkentStore")) {
                    if(mapTracker( newLocation, 32.750425,39.870659 , 32.7502, 32.7507, 39.8703, 39.8708)){
                        return;
                    }
                }

                if( buildingName.equals("CBlokAmfi")) {
                    if(mapTracker(newLocation, 32.749340, 39.868065, 32.7492, 32.7502, 39.8675, 39.8682)){
                        return;
                    }
                }

                if( buildingName.equals("Kutuphane")) {
                    if(mapTracker( newLocation, 32.749942, 39.870240, 32.7497, 32.7502, 39.8700, 39.8704)){
                        return;
                    }
                }

                if( buildingName.equals("Mescid")) {
                    if(mapTracker( newLocation, 32.750761, 39.867515, 32.7505, 32.7510, 39.8674, 39.8677)){
                        return;
                    }
                }

                if( buildingName.equals("MeteksanKirtasiye")) {
                    if(mapTracker( newLocation,32.748554 , 39.866298, 32.7483, 32.7487, 39.8660, 39.8664)){
                        return;
                    }
                }
                if( buildingName.equals("MeteksanMarket")) {
                    if(mapTracker( newLocation,32.751408 , 39.872475, 32.7512, 32.7517, 39.8722, 39.8726)){
                        return;
                    }
                }

                if( buildingName.equals("MithatCoruhAmfi")) {
                    if(mapTracker( newLocation, 32.75010, 39.871125, 32.7497, 32.7503, 39.8708, 39.8714)){
                        return;
                    }
                }

                if( buildingName.equals("OgrenciIsleri")) {
                    if(mapTracker( newLocation,32.744727 , 39.864574, 32.7444, 32.7449, 39.8642, 39.8647)){
                        return;
                    }
                }

                if( buildingName.equals("Rektorluk")) {
                    if(mapTracker( newLocation, 32.75010, 39.871125, 32.7497, 32.7503, 39.8708, 39.8714)){
                        return;
                    }
                }

                if( buildingName.equals("SaglikMerkez")) {
                    if(mapTracker( newLocation,32.749041 , 39.868338, 32.7487, 32.7493, 39.8680, 39.8685)){
                        return;
                    }
                }

                if( buildingName.equals("SaglikDogu")) {
                    if(mapTracker( newLocation, 32.763901,39.871227 ,  32.7637, 32.7641, 39.8710, 39.8714)){
                        return;
                    }
                }

                if( buildingName.equals("SporDogu")) {
                    if(mapTracker( newLocation,32.764836 , 39.870038,  32.7646, 32.7650,39.8698, 39.8703)){
                        return;
                    }
                }

                if( buildingName.equals("SporMerkez")) {
                    if(mapTracker( newLocation,32.748584, 39.866535,  32.7482, 32.7488,39.8663, 39.8668)){
                        return;
                    }
                }

                if( buildingName.equals("SporYurtlar")) {
                    if(mapTracker( newLocation,32.745591, 39.863543,  32.7453, 32.7458,39.8633, 39.8638)){
                        return;
                    }
                }






                handler.postDelayed(this,CHECK_FREQ);
            }
        }, CHECK_FREQ);

        // When the button go was pressed, this method works
        buttonGo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating new intent to go to the GameModeDiscovery activity
                if(buildingName.equals("FameoEA") || buildingName.equals("MozartB") || buildingName.equals("MozartD") || buildingName.equals("MozartEE")
                        || buildingName.equals("MozartN") || buildingName.equals("StarbucksA") || buildingName.equals("StarbucksFC")
                        || buildingName.equals("CBlokAmfi") || buildingName.equals("Lab") || buildingName.equals("FieroG")){
                    intent2 = new Intent(MapActivity.this, UniversalSlideActivity2.class);

                    if(buildingName.equals("FameoEA")){ intent2.putExtra("building", "FameoEA"); }
                    if(buildingName.equals("MozartB")) { intent2.putExtra("building", "MozartB"); }
                    if(buildingName.equals("MozartD")) { intent2.putExtra("building", "MozartD"); }
                    if(buildingName.equals("MozartEE")) { intent2.putExtra("building", "MozartEE"); }
                    if(buildingName.equals("MozartN")) { intent2.putExtra("building", "MozartN"); }
                    if(buildingName.equals("StarbucksFC")) { intent2.putExtra("building", "StarbucksFC"); }
                    if(buildingName.equals("StarbucksA")) { intent2.putExtra("building", "StarbucksA"); }
                    if(buildingName.equals("FieroG")) { intent2.putExtra("building", "FieroG"); }
                    if(buildingName.equals("CBlokAmfi")) { intent2.putExtra("building", "CBlokAmfi"); }
                    if(buildingName.equals("Lab")) { intent2.putExtra("building", "Lab"); }
                    startActivity(intent2);
                }
                else if(buildingName.equals("MithatCoruhAmfi") || buildingName.equals("CBKutuphaneAlt") || buildingName.equals("CBKutuphaneUst") || buildingName.equals("ExpressCafeG")) {
                    intent3 = new Intent(MapActivity.this, UniversalSlideActivity3.class);

                    if (buildingName.equals("MithatCoruhAmfi")) { intent3.putExtra("building", "MithatCoruhAmfi"); }
                    if (buildingName.equals("CBKutuphaneAlt") || buildingName.equals("CBKutuphaneUst")) { intent3.putExtra("building", "CBKutuphane"); }
                    if (buildingName.equals("ExpressCafeG")) { intent3.putExtra("building", "ExpressCafeG"); }
                    startActivity(intent3);
                }
                else {
                    intent4 = new Intent(MapActivity.this, ArrivedActivity.class);

					if(buildingName.equals("A")){ intent4.putExtra("building", "A"); }
					if(buildingName.equals("B")){ intent4.putExtra("building", "B"); }
					if(buildingName.equals("D")){ intent4.putExtra("building", "D"); }
					if(buildingName.equals("EA")){ intent4.putExtra("building", "EA"); }
					if(buildingName.equals("EE")){ intent4.putExtra("building", "EE"); }
					if(buildingName.equals("Fx")){ intent4.putExtra("building", "Fx"); }
					if(buildingName.equals("G")){ intent4.putExtra("building", "G"); }
					if(buildingName.equals("MSSF")){ intent4.putExtra("building", "MSSF"); }
					if(buildingName.equals("N")){ intent4.putExtra("building", "N"); }
					if(buildingName.equals("SASB")){ intent4.putExtra("building", "SASB"); }
					if(buildingName.equals("V")){ intent4.putExtra("building", "V"); }
					if(buildingName.equals("76")){ intent4.putExtra("building", "76"); }
					if(buildingName.equals("77")){ intent4.putExtra("building", "77"); }
					if(buildingName.equals("78")){ intent4.putExtra("building", "78"); }
					if(buildingName.equals("9091")){ intent4.putExtra("building", "9091"); }
					if(buildingName.equals("YemekhaneMerkez")){ intent4.putExtra("building", "YemekhaneMerkez"); }
					if(buildingName.equals("YemekhaneDogu")){ intent4.putExtra("building", "YemekhaneDogu"); }
					if(buildingName.equals("BilkaMerkez")){ intent4.putExtra("building", "BilkaMerkez"); }
					if(buildingName.equals("BilkaDogu")){ intent4.putExtra("building", "BilkaDogu"); }
					if(buildingName.equals("CafeIn")){ intent4.putExtra("building", "CafeIn"); }
					if(buildingName.equals("CBMerkez")){ intent4.putExtra("building", "CBMerkez"); }
					if(buildingName.equals("CBDogu")){ intent4.putExtra("building", "CBDogu"); }
					if(buildingName.equals("KiracSpeed")){ intent4.putExtra("building", "KiracSpeed"); }
					if(buildingName.equals("Sofa")){ intent4.putExtra("building", "Sofa"); }
					if(buildingName.equals("BilkentStore")){ intent4.putExtra("building", "BilkentStore"); }
					if(buildingName.equals("Kutuphane")){ intent4.putExtra("building", "Kutuphane"); }
					if(buildingName.equals("Mescid")){ intent4.putExtra("building", "Mescid"); }
					if(buildingName.equals("MeteksanKirtasiye")){ intent4.putExtra("building", "MeteksanKirtasiye"); }
					if(buildingName.equals("MeteksanMarket")){ intent4.putExtra("building", "MeteksanMarket"); }
					if(buildingName.equals("SaglikMerkez")){ intent4.putExtra("building", "SaglikMerkez"); }
                    if(buildingName.equals("SaglikDogu")){ intent4.putExtra("building", "SaglikDogu"); }
                    if(buildingName.equals("SporMerkez")){ intent4.putExtra("building", "SporMerkez"); }
                    if(buildingName.equals("SporDogu")){ intent4.putExtra("building", "SporDogu"); }
                    if(buildingName.equals("SporYurtlar")){ intent4.putExtra("building", "SporYurtlar"); }
                    if(buildingName.equals("OgrenciIsleri")){ intent4.putExtra("building", "OgrenciIsleri"); }
					if(buildingName.equals("ODEON")){ intent4.putExtra("building", "ODEON");}

					startActivity(intent4);
                }

            }
        });
    }

    private void getRoute(Point origin, Point destination) {
        NavigationRoute.builder(this).accessToken(Mapbox.getAccessToken()).origin(origin).destination(destination)
                .profile(DirectionsCriteria.PROFILE_WALKING).build().getRoute(new Callback<DirectionsResponse>() {      // walking routes
            @Override
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {

                // if there are no routes, it returns anything so route cannot be gotten.
                if (response.body() == null) {
                    return;
                } else if (response.body().routes().size() < 1) {
                    return;
                }
                currentRoute = response.body().routes().get(0);

                // drawnig the route on map
                if (navigationMapRoute != null) {
                    navigationMapRoute.removeRoute();
                } else {
                    navigationMapRoute = new NavigationMapRoute(null, mapView, mapboxMap, R.style.NavigationMapRoute);
                }
                navigationMapRoute.addRoute(currentRoute);
            }

            // inner method for failure
            @Override
            public void onFailure(Call<DirectionsResponse> call, Throwable throwable) {
                Log.e(TAG, "Error: " + throwable.getMessage());
            }
        });
    }

    /**
     * isLocationEnabled method, returns true if location is enabled
     * @param context
     * @return  boolean
     */
    private boolean isLocationEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return LocationManagerCompat.isLocationEnabled(locationManager);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) { }

    /**
     * onPermissionResult method, checks the permission is granted or not
     * @param granted
     */
    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            enableLocationComponent(mapboxMap.getStyle());
        } else {
            // showing the toast message
            Toast.makeText(getApplicationContext(), "Permission not granted", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    /**
     * onMapReady method, checks the map is ready to be used
     * @param mapboxMap
     */
    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        // checking the GPS is enabled
        if( isLocationEnabled(this) == false){
            Toast.makeText(getApplicationContext(),  "You need to enable GPS before continue.", Toast.LENGTH_LONG).show();
            startActivity( new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS) );
            finish();
        }
        else {
            this.mapboxMap = mapboxMap;

            // setting the map zoom
            this.mapboxMap.setMinZoomPreference(0.1);

            // setting the map style

            mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(Style style) {
                    enableLocationComponent(style);
                    addDestinationIconLayer(style);
                }
            });
            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mapboxMap.setStyle(getString(R.string.mapbox_style_satellite), new Style.OnStyleLoaded() {
                            @Override
                            public void onStyleLoaded(Style style) {
                                enableLocationComponent(style);
                                addDestinationIconLayer(style);
                            }
                        });
                    } else{
                        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                            @Override
                            public void onStyleLoaded(Style style) {
                                enableLocationComponent(style);
                                addDestinationIconLayer(style);
                            }
                        });
                    }
                }
            });
        }
    }


    public boolean mapTracker ( Point newLocation, double longitude, double latitude, double smallLongitude, double bigLongitude, double smallLatitude, double bigLatitude )
    {
        Point destPoint = Point.fromLngLat( longitude, latitude);
        getRoute( newLocation, destPoint);
        if ( newLocation.latitude() > smallLatitude && newLocation.latitude() < bigLatitude && newLocation.longitude() > smallLongitude && newLocation.longitude() < bigLongitude )
        {
            Toast.makeText( MapActivity.this, "You have arrived!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }


    /**
     * enableLocationComponent method, checks the map is ready to be used
     * @param loadedMapStyle
     */
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(this, loadedMapStyle);
            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);

            locationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    locationComponent.setCameraMode(CameraMode.TRACKING);
                }
            });

        }
        else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }

    }

    /**
     * addDestinationIconLayer method, adds destination icon layer to the choosen building
     * @param style
     */
    private void addDestinationIconLayer(Style style) {
        // setting style
        style.addImage("destination-icon-id", BitmapFactory.decodeResource(this.getResources(),
                R.drawable.mapbox_marker_icon_default));
        GeoJsonSource source = new GeoJsonSource("destination-source-id");
        style.addSource(source);
        SymbolLayer destinationSymbolLayer = new SymbolLayer("destination-symbol-layer-id","destination-source-id");
        destinationSymbolLayer.withProperties(iconImage("destination-icon-id"), iconAllowOverlap(true),
                iconIgnorePlacement(true));
        style.addLayer(destinationSymbolLayer);

        // adding icon layers for choosen building
        if ( source != null ) {

            if(buildingName.equals("ODEON")){
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.752106, 39.875492)));
            }
            // For building A
            if (buildingName.equals("A")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749340, 39.868065)));
            }

            // For building B
            if (buildingName.equals("B")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7482, 39.8686)));
            }

            // For building EA
            if (buildingName.equals("EA")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.75010, 39.871125)));
            }

            // For building EE
            if (buildingName.equals("EE")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.750600, 39.872060)));
            }

            // For building FF
            if (buildingName.equals("FF")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.748890, 39.8658865)));
            }

            // For building G
            if (buildingName.equals("G")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749600, 39.868700)));
            }

            if (buildingName.equals("MSSF")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.755251, 39.869203)));
            }
            // For building SA
            if (buildingName.equals("SASB")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.748395, 39.867700)));
            }

            // For building V
            if (buildingName.equals("V")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.750000, 39.867100)));
            }
            if (buildingName.equals("76")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.747641, 39.864487)));
            }
            if (buildingName.equals("77")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat( 32.746615, 39.864322)));
            }
            if (buildingName.equals("78")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.746046, 39.865116)));
            }
            if (buildingName.equals("9091")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.763987, 39.868850)));
            }
            if (buildingName.equals("YemekhaneMerkez")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.750554, 39.870614)));
            }
            if (buildingName.equals("YemekhaneDogu")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.764091, 39.872209)));
            }
            if (buildingName.equals("BilkaMerkez")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.747849, 39.864567)));
            }
            if (buildingName.equals("BilkaDogu")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.763558, 39.868526)));
            }
            if (buildingName.equals("CafeIn")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.750614, 39.869934)));
            }
            if (buildingName.equals("CBDogu")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.761969, 39.874162)));
            }
            if (buildingName.equals("CBMerkez")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749075, 39.868150)));
            }
            if (buildingName.equals("CBKutuphaneAlt") || buildingName.equals("CBKutuphaneUst")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7495235, 39.8702107)));
            }
            if (buildingName.equals("ExpressCafeG")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749600, 39.868700)));
            }
            if (buildingName.equals("FameoEA")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.75010, 39.871125)));
            }
            if (buildingName.equals("FieroG")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7497813, 39.8682817)));
            }
            if (buildingName.equals("KiracSpeed")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7477544, 39.8663107)));
            }
            if (buildingName.equals("MozartB")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7481828, 39.8688857)));
            }
            if (buildingName.equals("MozartD")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7644, 39.8706238)));
            }
            if (buildingName.equals("MozartEE")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7509768, 39.8721588)));
            }
            if (buildingName.equals("MozartN")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7629468, 39.872905)));
            }
            if (buildingName.equals("Sofa")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7486883, 39.8643314)));
            }
            if (buildingName.equals("StarbucksA")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749433, 39.867985)));
            }
            if (buildingName.equals("StarbucksFC")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7485538, 39.865948)));
            }
            if (buildingName.equals("Lab")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.7482, 39.8686)));
            }
            if (buildingName.equals("BilkentStore")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.750425,39.870659)));
            }
            if (buildingName.equals("CBlokAmfi")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749340, 39.868065)));
            }
            if (buildingName.equals("Kutuphane")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749942, 39.870240)));
            }
            if (buildingName.equals("Mescid")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.750761, 39.867515)));
            }
            if (buildingName.equals("MeteksanKirtasiye")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.748554 , 39.866298)));
            }
            if (buildingName.equals("MeteksanMarket")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.751408 , 39.872475)));
            }
            if (buildingName.equals("MithatCoruhAmfi")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.75010, 39.871125)));
            }
            if (buildingName.equals("OgrenciIsleri")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.744727 , 39.864574)));
            }
            if (buildingName.equals("Rektorluk")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.75010, 39.871125)));
            }
            if (buildingName.equals("SaglikMerkez")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.749041 , 39.868338)));
            }
            if (buildingName.equals("SaglikDogu")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.763901,39.871227)));
            }
            if (buildingName.equals("SporDogu")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.764836 , 39.870038)));
            }
            if (buildingName.equals("SporMerkez")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.748584, 39.866535)));
            }
            if (buildingName.equals("SporYurtlar")) {
                source.setGeoJson(Feature.fromGeometry(Point.fromLngLat(32.745591, 39.863543)));
            }

        }
    }

    /**
     * onRequestPermissionsResult method, checks the permissions are granted or not
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    /**
     * onStart method, starts the activity and mapView
     */
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    /**
     * onResume method, resumes the activity and mapView
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();

    }

    /**
     * onPause method, pauses the activity and mapView
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * onStop method, stops the activity and mapView
     */
    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    /**
     * onBackPressed method, sets the function of back button
     */
    public void onBackPressed(){
        // creating and initialising new intent
        Intent intent = new Intent(MapActivity.this, MainActivity.class);
        // back to the main menu
        startActivity(intent);
    }

    /**
     * onSaveInstanceState method, saves the state of the activity and mapView
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * onDestroy method, finishes the activity and mapView
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    /**
     * onLowMemory method, kills the background process of the activity and mapView when the phone memory is low
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    /**
     * onRestoreInstanceState method, restores the state of the activity and navigationView
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        navigationView.onRestoreInstanceState(savedInstanceState);
    }
}
