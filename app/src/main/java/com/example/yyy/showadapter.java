package com.example.yyy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class showadapter extends RecyclerView.Adapter<showadapter.ViewHolder> {
    ArrayList<ordermodal> list;
    Context context;
    public showadapter(ArrayList<ordermodal> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.showorder,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ordermodal ordermodal=  list.get(position) ;
         holder.orderImage.setImageResource(ordermodal.getOrderimage());
        holder.foodname.setText(ordermodal.getSoliditems());
        holder.ordernumber.setText(ordermodal.getOrdeernumber());
        holder.price.setText(ordermodal.getPriceorder());
        holder.dewletebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                databaseClass databaseClass=new databaseClass(context);
                int id =Integer.parseInt(ordermodal.getOrdeernumber());

                databaseClass.deleteitem(id);

            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView foodname,ordernumber,price;
        Button dewletebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.showimage);
            foodname=itemView.findViewById(R.id.showfoodname);
            ordernumber=itemView.findViewById(R.id.shownum);
            price=itemView.findViewById(R.id.showpricess);
            dewletebtn=itemView.findViewById(R.id.deletebtn);

        }
    }
}
