package com.example.fmbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class AddAddresActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_addres)
        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val lima = LatLng(-12.1153894,-76.9916113)
        val casa = LatLng(-12.1635021,-76.9762704)
        val casaA = LatLng(-12.125310001446795, -77.00197857666993)
        val trbA = LatLng(-12.1116405,-77.0016057)

        map.addMarker(MarkerOptions().title("Trabajo F").position(lima))
        map.addMarker(MarkerOptions().title("Casa F").position(casa))
        map.addMarker(MarkerOptions().title("Casa A").position(casaA))
        map.addMarker(MarkerOptions().title("Trabajo A").position(trbA))

        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(lima,16F))

        val bounds = LatLngBounds.builder()
        bounds.include(lima)
        bounds.include(casa)
        bounds.include(casaA)
        bounds.include(trbA)

        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(),150))

    }
}