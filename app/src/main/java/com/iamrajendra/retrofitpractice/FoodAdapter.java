package com.iamrajendra.retrofitpractice;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iamrajendra.retrofitpractice.model.Food;

import java.util.List;

/**
 * Created by rajendraverma on 20-08-2016.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> mList_food;
    private Activity mActivity;

    public FoodAdapter(List<Food> mList_food, Activity mActivity) {
        this.mList_food = mList_food;
        this.mActivity = mActivity;
    }

    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mActivity);
        View view = layoutInflater.inflate(R.layout.food_adapter, null);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, int position) {
holder.mTextView_name.setText(mList_food.get(position).getName());
        holder.mTextView_des.setText(mList_food.get(position).getDescription());
        holder.mTextView_cal.setText(mList_food.get(position).getCalories());
        holder.mTextView_price.setText(mList_food.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return mList_food.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView_name;
        TextView mTextView_price;
        TextView mTextView_des;
        TextView mTextView_cal;
        public FoodViewHolder(View itemView) {
            super(itemView);
            mTextView_name = (TextView) itemView.findViewById(R.id.food_adapter_name_tv);
            mTextView_price = (TextView) itemView.findViewById(R.id.food_adapter_price_tv);
            mTextView_des = (TextView) itemView.findViewById(R.id.food_adapter_des_tv);
            mTextView_cal= (TextView) itemView.findViewById(R.id.food_adapter_cal_tv);
        }
    }
}
