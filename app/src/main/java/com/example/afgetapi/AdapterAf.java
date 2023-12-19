package com.example.afgetapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterAf extends RecyclerView.Adapter<AdapterAf.ViewHolder> {

    List<Afmodel> afmodel;
    Context context;


    public AdapterAf(Context context, List<Afmodel> afmodel) {
        this.afmodel = afmodel;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.aflayoutrecycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Afmodel mode = afmodel.get(position);
        holder.t1.setText(mode.getBrandKey());
        holder.t2.setText(mode.getProductName());
        holder.t3.setText(mode.getVendorSku());
        Glide.with(context).load(mode.getProductImage()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Productdata.class);
intent.putExtra("product_id" ,mode.getProductid());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return afmodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3;
        ImageView imageView;
        CardView cardView;
        String ProductId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            t3 = itemView.findViewById(R.id.text3);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }


}
