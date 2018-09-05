package com.chuck.android.meetupfoodiedroid.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chuck.android.meetupfoodiedroid.R;
import com.chuck.android.meetupfoodiedroid.models.FoodItem;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodItemViewHolder>{

    private List<FoodItem> foodList;

    public class FoodItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout foodLayout;

        FoodItemViewHolder(View v) {
            super(v);
            //Desgine Viewholder Text objects
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            //do something
        }
    }


    @NonNull
    @Override
    public FoodListAdapter.FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_list_item,parent,false);
        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodItemViewHolder holder, int position) {
        if (foodList != null)
        {
            //What do we populate textview with
        }
    }

    public void setFoodList(List<FoodItem> currentFoodList) {
        this.foodList = currentFoodList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (foodList != null)
            return foodList.size();
        else
            return 0;
    }
}
