package com.chuck.android.meetupfoodiedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chuck.android.meetupfoodiedroid.adapters.FoodListAdapter;
import com.chuck.android.meetupfoodiedroid.models.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFoodList;
    private FoodListAdapter adapter;
    LinearLayoutManager foodLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FoodItem testItem;
        final List<FoodItem> foodItemList = new ArrayList<FoodItem>();
        testItem = new FoodItem("Pizza",0,60.00, 55.00);
        rvFoodList = findViewById(R.id.rv_food_items);
        initRecyclerView();
        //Add a new food item
        //Set on click listener to open AddFoodItemActivity
        Button addFoodItem = findViewById(R.id.bt_add_new_food);
        addFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodItemList.add(testItem);
                adapter.setFoodList(foodItemList);

            }
        });


        //Recycerview Showing all food items
        //On click open DetailActivity
    }
    private void initRecyclerView() {
        foodLayoutManager = new LinearLayoutManager(this);
        rvFoodList.setLayoutManager(foodLayoutManager);
        adapter = new FoodListAdapter();
        rvFoodList.setAdapter(adapter);
    }
}
