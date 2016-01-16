package com.example.telematica.uiappexample.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.presenters.LibroPresenterImpl;
import com.example.telematica.uiappexample.views.LibrosView;

/**
 * Created by SG on 15-01-2016.
 */
public class ListLibrosFragment extends Fragment implements LibrosView {

    RecyclerView.LayoutManager mLayoutManager;
    LibroPresenterImpl mLibroPresenter;

    RecyclerView mRecyclerView;

    public static ListLibrosFragment newInstance(){
        ListLibrosFragment fragment = new ListLibrosFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.fragment_main, null);

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView = mLibroPresenter.setDatos();

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        return mainView;
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
