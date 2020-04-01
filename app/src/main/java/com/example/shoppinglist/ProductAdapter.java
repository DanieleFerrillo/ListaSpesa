package com.example.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<ProductItem> productList;
    private OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemListener){
        listener = itemListener;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;


        public ProductViewHolder(View itemView, final OnItemClickListener itemListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            itemListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ProductAdapter(ArrayList<ProductItem> productArrayList) {
        productList = productArrayList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ProductViewHolder  evh = new ProductViewHolder(v, listener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductItem currentItem = productList.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
