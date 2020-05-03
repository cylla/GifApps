package com.example.gifapps.view.viewmodel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gifapps.model.gif.GifDiscoverResponse;
import com.example.gifapps.model.gif.GifDiscoverResultsItem;
import com.example.gifapps.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GifViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<GifDiscoverResultsItem>> listDiscoverGif = new MutableLiveData<>();

    public void setGifDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiGif().getGifDiscover().enqueue(new Callback<GifDiscoverResponse>() {
            @Override
            public void onResponse(Call<GifDiscoverResponse> call, Response<GifDiscoverResponse> response) {
                GifDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getResults() != null){
                    ArrayList<GifDiscoverResultsItem> gifDiscoverItems = responseDiscover.getResults();
                    listDiscoverGif.postValue(gifDiscoverItems);

                }
            }

            @Override
            public void onFailure(Call<GifDiscoverResponse> call, Throwable t) {

            }
        });

    }
    public LiveData<ArrayList<GifDiscoverResultsItem>> getGifsDiscover(){
        return listDiscoverGif;
    }
}
