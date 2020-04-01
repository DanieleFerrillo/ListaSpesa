package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ProductItem> productList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();
        productList.add(new ProductItem(R.drawable.ic_product_a, "Line 1", "Line 2"));
        productList.add(new ProductItem(R.drawable.ic_product_b, "Line 3", "Line 4"));
        productList.add(new ProductItem(R.drawable.ic_product_c, "Line 5", "Line 6"));
        productList.add(new ProductItem(R.drawable.ic_product_a, "Line 7", "Line 8"));
        productList.add(new ProductItem(R.drawable.ic_product_b, "Line 9", "Line 10"));
        productList.add(new ProductItem(R.drawable.ic_product_c, "Line 11", "Line 12"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ProductAdapter(productList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}