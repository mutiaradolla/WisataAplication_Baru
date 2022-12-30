package com.example.wisataaplication_baru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    EditText edt_komen;
    Button bt_save;

    SharedPreferences pref;
    Gson gson;
    RecyclerView rec_komen;
    ArrayList<Komentar> listKomen;
    KomentarAdapter komentarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rec_komen = findViewById(R.id.rec_komen);
        rec_komen.setLayoutManager(new LinearLayoutManager(this));
        pref = this.getSharedPreferences(getString(R.string.SHARE_KEY), Context.MODE_PRIVATE);
        gson = new GsonBuilder().create();

        edt_komen = findViewById(R.id.edt_komen);
        bt_save = findViewById(R.id.bt_save);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recordList = pref.getString("RecordList", "[]");
                listKomen = gson.fromJson(recordList, new TypeToken<ArrayList<Komentar>>() {
                }.getType());
                if (listKomen == null) listKomen = new ArrayList<>();

                listKomen.add(new Komentar(edt_komen.getText().toString()));

                recordList = gson.toJson(listKomen);
                pref.edit().putString("RecordList", recordList).apply();

                komentarAdapter = new KomentarAdapter(listKomen);
                rec_komen.setAdapter(komentarAdapter);
            }
        });
    }

}