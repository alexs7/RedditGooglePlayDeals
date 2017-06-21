package com.alexs7.redditgoogleplaydeals;

/**
 * Created by alex on 21/06/2017.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.moshi.Moshi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Controller implements Callback<List<Deal>> {

    static final String BASE_URL = "https://www.reddit.com/r/";

    public void start(){
        Moshi moshi = new Moshi.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
        Call<List<Deal>> call = redditAPI.getDeals(0);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Deal>> call, Response<List<Deal>> response) {
        if(response.isSuccessful()){
            List<Deal> deals = response.body();
            deals.forEach( deal -> System.out.println(deal.getUrl()));
        }else{
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Deal>> call, Throwable t) {
        t.printStackTrace();
    }
}
