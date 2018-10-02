package com.chuck.android.meetupfoodiedroid.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.chuck.android.meetupfoodiedroid.models.FoodItem;

import java.util.List;

@Dao
public interface FoodItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(FoodItem foodItem);

    @Delete
    void deleteFood(FoodItem foodItem);

    @Query("SELECT * FROM foodItems WHERE fid = :id")
    FoodItem getFoodByID(int id);

    @Query("SELECT * FROM foodItems")
    LiveData<List<FoodItem>> getAll();

    @Query("DELETE FROM foodItems")
    void deleteAll();
}
