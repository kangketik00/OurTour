package com.makmurjaya.ourtour.view.destination;
// Tanggal Pengerjaan: 25-07-2022
// Ilham Zaki - 10119006 - IF1
// Muhammad Ikhlas Naufalsyah Ranau - 10119022 - IF1

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.bumptech.glide.Glide;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.makmurjaya.ourtour.MainActivity;
import com.makmurjaya.ourtour.R;

public class TourDetailActivity extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mMap;

    private String imgurl, title, rating, location, description, latitude, longitude;
    private TextView
            tour_detail_title,
            tour_detail_rating,
            tour_detail_location,
            tour_detail_description;
    private ImageView tour_detail_image;
    private ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);
        initView();
        setData();

    }

    public void initView() {
        tour_detail_image = findViewById(R.id.tour_detail_image);
        tour_detail_title = findViewById(R.id.tour_detail_title);
        tour_detail_rating = findViewById(R.id.tour_detail_rating);
        tour_detail_location = findViewById(R.id.tour_detail_location);
        tour_detail_description = findViewById(R.id.tour_detail_description);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ab = getSupportActionBar();
    }

    public void setData() {
        Intent intn = getIntent();
        imgurl = intn.getStringExtra("imgurl");
        title = intn.getStringExtra("title");
        rating = intn.getStringExtra("rating");
        location = intn.getStringExtra("location");
        description = intn.getStringExtra("description");
        latitude = intn.getStringExtra("latitude");
        longitude = intn.getStringExtra("longitude");

        if (ab != null)  ab.setTitle(title);

        Glide.with(getApplicationContext())
                .load(imgurl)
                .into(tour_detail_image);

        tour_detail_title.setText(title);
        tour_detail_rating.setText("Rating: " + rating);
        tour_detail_location.setText("Alamat: " + location);
        tour_detail_description.setText(description);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.tour_map_location);
        mapFragment.getMapAsync(this);


    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location_tour = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        mMap.addMarker(new MarkerOptions()
                .position(location_tour)
                .title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location_tour, 15));
    }


}