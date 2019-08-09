package com.example.c0754254_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    RecyclerView recyclerView;
    JSONObject obj;
    List<DataModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            obj = new JSONObject(loadJSONFromAsset());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Should read json values and store it in the list.

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());






        } catch (JSONException e) {
            e.printStackTrace();
        }
        //end of reading


        DataAdapter adapter = new DataAdapter(HomeScreen.this, dataList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


    }


    //Reading Json file from the assets folder
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

