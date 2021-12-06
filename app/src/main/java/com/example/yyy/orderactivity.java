package com.example.yyy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class orderactivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderactivity);
        recyclerView=findViewById(R.id.recyclerorder);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
                ArrayList<Food> List = new ArrayList<Food>();
                List.add(new Food(R.drawable.food1,"bdwa","5","1"));
                List.add(new Food(R.drawable.food2,"Burger","5","2"));
                List.add(new Food(R.drawable.food3,"Hollolo","8","3"));
                List.add(new Food(R.drawable.food4,"lord of dish","9","4"));
                List.add(new Food(R.drawable.food1,"madamey","78","5"));
                List.add(new Food(R.drawable.food11,"moby dick","5","6"));
                List.add(new Food(R.drawable.food3,"ps ily","8","7"));
                List.add(new Food(R.drawable.food10,"Sweet peace","5","8"));
                List.add(new Food(R.drawable.food4,"Chilli","6","9"));
                List.add(new Food(R.drawable.food9,"Fried potatoes","11","10"));
                List.add(new Food(R.drawable.food10,"Pragya Tea","9","11"));
                List.add(new Food(R.drawable.food11,"Fire potatoes","8","12"));
                Orderadapter adapter= new Orderadapter(List,this);
                recyclerView.setAdapter(adapter);
                LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);

            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem showorder=menu.findItem(R.id.showodermenu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.showodermenu){
            Intent intent = new Intent(getApplicationContext(),SHOWorder.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
        }



