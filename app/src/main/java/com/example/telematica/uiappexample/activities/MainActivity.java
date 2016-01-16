package com.example.telematica.uiappexample.activities;

import android.os.Bundle;

import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.fragments.ListLibrosFragment;

/**
 * Created by SG on 15-01-2016.
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentFrame(R.id.content_frame);

        switchContent(ListLibrosFragment.newInstance(), null);

    }
}
