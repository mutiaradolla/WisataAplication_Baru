package com.example.wisataaplication_baru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rec_Makanan;
    private ArrayList <Kuliner> listMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec_Makanan = findViewById(R.id.rec_Makanan);
        initData();

        // memanggil class KulinerAdapter agar menu muncul
        rec_Makanan.setAdapter(new KulinerAdapter(listMakanan));
        rec_Makanan.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        this.listMakanan = new ArrayList<>();
        listMakanan.add(new Kuliner("Hidden Valley Hills",
                "Purwakarta",
                "vila, resor, dan sky pool yang instagramable",
                R.drawable.hiddenvalley));

        listMakanan.add(new Kuliner("Green Valley",
                "Purwakarta",
                "Water Park yang seru dan instagramable",
                R.drawable.greenvalleywater));

        listMakanan.add(new Kuliner("Tebing Bayor",
                "Purwakarta",
                "Susunan tebing dan pemandangan yang instagramable",
                R.drawable.tebingboyer));
        listMakanan.add(new Kuliner("Urban Farming",
                "Purwakarta",
                "kebun bunga yang instagramable",
                R.drawable.urbanfarming));
        listMakanan.add(new Kuliner("Waduk Jatiluhur",
                "Purwakarta",
                "Bendungan eksotis dengan keindahan panoramannya",
                R.drawable.wadukjatiluhur));
        listMakanan.add(new Kuliner("Bukit Panenjoan",
                "Purwakarta",
                "pemandangan alam yang instagramable",
                R.drawable.bukitpanenjoan));
    }


    public void tambahdata(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}