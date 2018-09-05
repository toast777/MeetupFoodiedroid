package com.chuck.android.meetupfoodiedroid.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.chuck.android.meetupfoodiedroid.models.FoodItem;
import com.chuck.android.meetupfoodiedroid.repository.AppRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<FoodItem>> foodList;
    private AppRepository mRepository;

    public MainViewModel (@NonNull Application application){
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
        foodList = mRepository.getAllFoodItems();
    }

    public LiveData<List<FoodItem>> getFoodList() {return foodList;}

}
