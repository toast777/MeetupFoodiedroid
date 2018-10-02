package com.chuck.android.meetupfoodiedroid;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.chuck.android.meetupfoodiedroid.adapters.FirebaseFoodAdapter;
import com.chuck.android.meetupfoodiedroid.adapters.FoodListAdapter;
import com.chuck.android.meetupfoodiedroid.models.FirebaseFoodItem;
import com.chuck.android.meetupfoodiedroid.models.FoodItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity" ;
    List<FirebaseFoodItem> mFoodItems = new ArrayList<>();
    private FirebaseAuth mAuth;
    private RecyclerView rvFoodList;
    private FirebaseFoodAdapter adapter;
    LinearLayoutManager foodLayoutManager;
    private String UserID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Kansas City").child("Papa Johns");


        rvFoodList = findViewById(R.id.rv_food_items_firebase);
        initRecyclerView();

        // Read from the database
        myRef.child("food items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    FirebaseFoodItem food = snapshot.getValue(FirebaseFoodItem.class);
                    mFoodItems.add(food);
                    Log.i(TAG, "food loaded");
                }
                adapter.setFoodList(mFoodItems);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        });
    }
    private void initRecyclerView() {
        foodLayoutManager = new LinearLayoutManager(this);
        rvFoodList.setLayoutManager(foodLayoutManager);
        adapter = new FirebaseFoodAdapter();
        rvFoodList.setAdapter(adapter);
    }
}
