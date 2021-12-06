package com.example.yyy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Orderadapter extends RecyclerView.Adapter<Orderadapter.ViewHolder> {
    ArrayList<Food> list;
    Context context;
    public Orderadapter(ArrayList<Food> list, Context context) {
        this.list = list;
        this.context = context;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ordersample,null,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Food model=  list.get(position) ;
        holder.orderImage.setImageResource(model.getImage());
        holder.foodname.setText(model.getFoodname());
        holder.ordernumber.setText(model.getNumber());
        holder.price.setText(model.getPrice());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("pricer",model.getPrice());
                intent.putExtra("quantity",model.getNumber());
                intent.putExtra("name",model.getFoodname());
                context.startActivity(intent);



            }
        });



    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView foodname,ordernumber,price,quantity;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderimage);
            foodname=itemView.findViewById(R.id.foodname);
            ordernumber=itemView.findViewById(R.id.ordernum);
            price=itemView.findViewById(R.id.pricess);
            layout=itemView.findViewById(R.id.layouts);
            quantity= itemView.findViewById(R.id.quantity);
        }
    }
}
