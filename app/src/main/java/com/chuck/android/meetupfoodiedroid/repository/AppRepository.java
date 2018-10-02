package com.chuck.android.meetupfoodiedroid.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.chuck.android.meetupfoodiedroid.MainActivity;
import com.chuck.android.meetupfoodiedroid.database.AppDatabase;
import com.chuck.android.meetupfoodiedroid.models.FoodItem;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static AppRepository instance;

    //Used for async tasks
    private Executor executor = Executors.newSingleThreadExecutor();
    //List retrieved from DB
    public LiveData<List<FoodItem>> foodItems;

    private AppDatabase foodDB;

    public static AppRepository getInstance(Context context) {
        //Only one Repository allowed
        if (instance == null) {
            instance = new AppRepository(context);
        }
        return instance;
    }

    private AppRepository(Context context) {
        //init Repo and assign db content to livedata
        foodDB = AppDatabase.getInstance(context);
        foodItems = getAllFoodItems();
    }

    public LiveData<List<FoodItem>> getAllFoodItems() {
        return foodDB.foodItemDao().getAll();
    }

    public FoodItem getFoodbyId(int FoodId) {
        return foodDB.foodItemDao().getFoodByID(FoodId);
    }

    public void insertFoodItem(final FoodItem foodItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    foodDB.foodItemDao().insertFood(foodItem);
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
            }

        });
    }
    public void deleteFoodItem(final FoodItem foodItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foodDB.foodItemDao().deleteFood(foodItem);
                }catch (Exception e){
                    Log.e(TAG, e.toString());
                }
            }
        });
    }
    public void deleteAll(){foodDB.foodItemDao().deleteAll();}
}
