package com.example.telematica.uiappexample.presenters.contract;

import android.support.v7.widget.RecyclerView;

import com.example.telematica.uiappexample.models.Libro;

import java.util.List;

/**
 * Created by SG on 15-01-2016.
 */
public interface LibroPresenter {

    public List<Libro> getLista(String result);

    public RecyclerView setDatos();

}
