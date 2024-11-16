package com.ruipereira.MySweetCall;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ruipereira.mysweetcall.R;
import com.ruipereira.mysweetcall.databinding.ActivityMapaBinding;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {
    Intent i; Bundle b; double lat, lng; String morada; LatLng endereco;
    private GoogleMap mMap;
    private ActivityMapaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        i = getIntent();
        b = i.getExtras();
        lat = b.getDouble("latitude");
        lng = b.getDouble("longitude");
        morada = b.getString("morada");
        // Add a marker in Sydney and move the camera
        endereco = new LatLng(lat, lng);
        mMap.addMarker( new MarkerOptions().position( endereco).title("Marcador em " + morada ));
        mMap.moveCamera( CameraUpdateFactory.newLatLng( endereco ));
    }
}