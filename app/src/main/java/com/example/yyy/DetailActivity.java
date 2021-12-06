package com.example.yyy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class DetailActivity extends AppCompatActivity {
ImageView imagename;
TextView nameView, prices,quantityd;
EditText phone, nameedt;
Button insertbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final int image = getIntent().getIntExtra("image", 0);
        final int quantity1 =  Integer.parseInt(getIntent().getStringExtra("quantity"));


        final int  priced = Integer.parseInt(getIntent().getStringExtra("pricer"));


        final String name = getIntent().getStringExtra("name");
        imagename = findViewById(R.id.imagedetail);
        nameView = findViewById(R.id.foodnamedetail);
        prices = findViewById(R.id.foodprice);
        nameedt = findViewById(R.id.name);
        phone = findViewById(R.id.editTextPhone);
        insertbutton = findViewById(R.id.btnordernow);
        quantityd = findViewById(R.id.quantity);
        imagename.setImageResource(image);
        nameView.setText(name);
        prices.setText(String.format("%d", priced));


            quantityd.setText(String.format("%d", quantity1));




        insertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(nameedt.getText().toString())&&!TextUtils.isEmpty(phone.getText().toString())){
                    databaseClass db=new databaseClass(getApplicationContext());
                    db.addfood(nameedt.getText().toString(),phone.getText().toString(),priced,image,name,quantity1);
                }else{
                    Toast.makeText(DetailActivity.this, "Both Field Requireds", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}