package com.chuck.android.meetupfoodiedroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chuck.android.meetupfoodiedroid.adapters.FoodListAdapter;
import com.chuck.android.meetupfoodiedroid.models.FoodItem;
import com.chuck.android.meetupfoodiedroid.utils.FirebaseUtils;
import com.chuck.android.meetupfoodiedroid.viewmodels.MainViewModel;
import com.facebook.stetho.Stetho;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFoodList;
    private FoodListAdapter adapter;
    LinearLayoutManager foodLayoutManager;
    private MainViewModel mViewModel;

//Retrieve Region

    //Choose Resteraunt
    //Choose Address
    //Save 3 values to Shared Preferences
    //Use String Set to store all the regions
    //Seperate String for Region

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Stetho.initializeWithDefaults(this);

        //Check if user is logged in with util
        FirebaseUtils fLogin  = new FirebaseUtils();

        final FoodItem testItem;
        final List<FoodItem> foodItemList = new ArrayList<FoodItem>();
        //testItem = new FoodItem("Tacos",0,60.00, 55.00);
        rvFoodList = findViewById(R.id.rv_food_items);
        initRecyclerView();
        //Add a new food item
        //Set on click listener to open AddFoodItemActivity
        Button addFoodItem = findViewById(R.id.bt_add_new_food);
        initViewModel();
        addFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mViewModel.addFoodItem(testItem);
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
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
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
//    private void anonymousSignIn() {
//        mAuth.signInAnonymously()
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        final String TAG = "Main Activity" ;
//
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInAnonymously:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInAnonymously:failure", task.getException());
//                            Toast.makeText(getApplicationContext(), "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                        // ...
//                    }
//                });
//
//    }
}
