package com.example.yyy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SHOWorder extends AppCompatActivity {
    databaseClass databaseClass;

    RecyclerView recyclerView;
    ArrayList<ordermodal> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_h_o_worder);
        recyclerView = findViewById(R.id.recyclerShoworder);

        databaseClass=new databaseClass(this);
        list= databaseClass.orders();
        showadapter adapter= new showadapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


    }
}