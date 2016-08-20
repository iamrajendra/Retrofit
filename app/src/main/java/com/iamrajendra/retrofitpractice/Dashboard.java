package com.iamrajendra.retrofitpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    Button mButton_json;
    Button mButton_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mButton_json = (Button) findViewById(R.id.json_b);
        mButton_xml = (Button) findViewById(R.id.xml_b);
        mButton_json.setOnClickListener(this);
        mButton_xml.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.json_b:
                callActivity(MainActivity.class);
                break;
            case R.id.xml_b:
                callActivity(XmlActivity.class);
                break;
        }
    }

    private void callActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
