package com.iamrajendra.retrofitpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.iamrajendra.retrofitpractice.model.BreakFastMenu;
import com.iamrajendra.retrofitpractice.model.Food;
import com.iamrajendra.retrofitpractice.rest.ApiClientXml;
import com.iamrajendra.retrofitpractice.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XmlActivity extends AppCompatActivity {
    private static final String TAG ="XmlActivity" ;
    RecyclerView mRecyclerView_foodList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView_foodList = (RecyclerView) findViewById(R.id.xml_foodlist_rv);
        mRecyclerView_foodList.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiInterface = ApiClientXml.getClient().create(ApiInterface.class);
        Call<BreakFastMenu> breakFastMenuCall = apiInterface.getXml();
        breakFastMenuCall.enqueue(new Callback<BreakFastMenu>() {
            @Override
            public void onResponse(Call<BreakFastMenu> call, Response<BreakFastMenu> response) {
                BreakFastMenu breakFastMenu = response.body();
                mRecyclerView_foodList.setAdapter(new FoodAdapter(breakFastMenu.getFoodList(),XmlActivity.this));
            }

            @Override
            public void onFailure(Call<BreakFastMenu> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

}
