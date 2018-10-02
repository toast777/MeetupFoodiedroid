package com.chuck.android.meetupfoodiedroid.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.chuck.android.meetupfoodiedroid.models.FoodItem;
import com.chuck.android.meetupfoodiedroid.repository.AppRepository;

import java.util.List;
import java.util.Objects;

public class OrderStartViewModel extends AndroidViewModel {
    private LiveData<List<FoodItem>> foodList;
    private AppRepository mRepository;

    public OrderStartViewModel (@NonNull Application application){
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
        foodList = mRepository.getAllFoodItems();
    }

    public LiveData<List<FoodItem>> getFoodList() {return foodList;}

    public void addFoodItem(FoodItem item) {
        //creates a new favorite in DB
        mRepository.insertFoodItem(item);
    }
    public void deleteAll(){mRepository.deleteAll();}
}
