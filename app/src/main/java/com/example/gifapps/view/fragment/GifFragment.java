package com.example.gifapps.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gifapps.R;
import com.example.gifapps.adapter.GifDiscoverAdapter;
import com.example.gifapps.model.gif.GifDiscoverResultsItem;
import com.example.gifapps.view.viewmodel.GifViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GifFragment extends Fragment {

    private GifDiscoverAdapter gifDiscoverAdapter;
    private RecyclerView rvGifDiscover;
    private GifViewModel gifViewModel;

    public GifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gif2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gifDiscoverAdapter = new GifDiscoverAdapter(getContext());
        gifDiscoverAdapter.notifyDataSetChanged();

        rvGifDiscover = view.findViewById(R.id.fragmentgif_rv);
        rvGifDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        gifViewModel = new ViewModelProvider(this).get(GifViewModel.class);
        gifViewModel.setGifDiscover();
        gifViewModel.getGifsDiscover().observe(this,getGifDiscover);

        rvGifDiscover.setAdapter(gifDiscoverAdapter);
    }
    private Observer<ArrayList<GifDiscoverResultsItem>> getGifDiscover = new Observer<ArrayList<GifDiscoverResultsItem>>() {
        @Override
        public void onChanged(ArrayList<GifDiscoverResultsItem> gifDiscoverResultsItems) {
            if (gifDiscoverResultsItems != null){
                gifDiscoverAdapter.setData(gifDiscoverResultsItems);
            }
        }
    };
}

