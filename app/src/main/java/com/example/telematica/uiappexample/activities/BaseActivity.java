package com.example.telematica.uiappexample.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.telematica.uiappexample.fragments.ListLibrosFragment;

public class BaseActivity extends AppCompatActivity {

    private int contentFrame;

    protected void setContentFrame(int contentFrame){
        this.contentFrame = contentFrame;
    }

    public void switchContent(ListLibrosFragment fragment, String addBackStack) {
        switchContent(fragment, addBackStack, -1, -1);
    }

    public void switchContent(ListLibrosFragment fragment, String addBackStack, int animationIn, int animationOut) {
        try {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if (animationIn > 0 && animationOut > 0)
                fragmentTransaction.setCustomAnimations(animationIn, animationOut);

            if (addBackStack != null)
                fragmentTransaction.addToBackStack(addBackStack);
            fragmentTransaction.replace(contentFrame, fragment);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
