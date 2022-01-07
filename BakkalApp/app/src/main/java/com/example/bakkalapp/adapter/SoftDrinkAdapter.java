package com.example.bakkalapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakkalapp.R;
import com.example.bakkalapp.details.DetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SoftDrinkAdapter extends RecyclerView.Adapter<SoftDrinkAdapter.MyHolder> {
    ArrayList<String> imageList;
    ArrayList<String> productList;
    ArrayList<String> katIdList;
    ArrayList<String> idList;
    Context context;

    public SoftDrinkAdapter(ArrayList<String> imageList, ArrayList<String> productList, ArrayList<String> katIdList, ArrayList<String> idList, Context context) {
        this.imageList = imageList;
        this.productList = productList;
        this.katIdList = katIdList;
        this.idList = idList;
        this.context = context;
    }

    @NonNull
    @Override
    public SoftDrinkAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_recycler,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoftDrinkAdapter.MyHolder holder, int position) {

        holder.textProductName.setText(productList.get(position));
        Picasso.with(holder.imageProduct.getContext()).load(imageList.get(position)).into(holder.imageProduct);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageProduct;
        TextView textProductName;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageProduct = itemView.findViewById(R.id.imageProduct);
            textProductName = itemView.findViewById(R.id.textProductName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("urunId",idList.get(position));
            intent.putExtra("urunKatId",katIdList.get(position));
            context.startActivity(intent);
        }
    }
}
