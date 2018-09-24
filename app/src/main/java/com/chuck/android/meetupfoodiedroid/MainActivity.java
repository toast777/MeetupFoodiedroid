package com.chuck.android.meetupfoodiedroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
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
import com.chuck.android.meetupfoodiedroid.viewmodels.MainViewModel;
import com.facebook.stetho.Stetho;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFoodList;
    private FoodListAdapter adapter;
    LinearLayoutManager foodLayoutManager;
    private MainViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(getApplicationContext());
        Stetho.initializeWithDefaults(this);


        final FoodItem testItem;
        final List<FoodItem> foodItemList = new ArrayList<FoodItem>();
        testItem = new FoodItem("Tacos",0,60.00, 55.00);
        rvFoodList = findViewById(R.id.rv_food_items);
        initRecyclerView();
        //Add a new food item
        //Set on click listener to open AddFoodItemActivity
        Button addFoodItem = findViewById(R.id.bt_add_new_food);
        initViewModel();
        addFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addFoodItem(testItem);
            }
        });
        Button firebaseList = findViewById(R.id.firebase_list);
        firebaseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FirebaseActivity.class);
                startActivity(intent);
            }
        });
        Button startOrder = findViewById(R.id.btn_start_new_order);
        startOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddFoodItemActivity.class);
                startActivity(intent);
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
    private void initViewModel() {
        final Observer<List<FoodItem>> foodObserver =
                new Observer<List<FoodItem>>() {
                    @Override
                    public void onChanged(@Nullable List<FoodItem> foodList) {
                        adapter.setFoodList(foodList);
                    }
                };
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getFoodList().observe(this, foodObserver);
    }
}
