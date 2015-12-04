package com.example.telematica.uiappexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.telematica.uiappexample.connection.HttpConection;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String[] myStringArray = new String[]{"HOLA","MUNDO","SOY", "UNA", "LISTA"};

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String myUrl = "http://www.mocky.io/v2/5661be1a100000c5348d91ee";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new UIAdapter(myStringArray);
        mRecyclerView.setAdapter(mAdapter);

        AsyncTask<Void, Void, String> connectionTask = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    return new HttpConection().getContentFromUrl(myUrl, 10000, 15000, "GET");
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    System.out.println(result);
                }
            }
        };
        connectionTask.execute();
    }
}
