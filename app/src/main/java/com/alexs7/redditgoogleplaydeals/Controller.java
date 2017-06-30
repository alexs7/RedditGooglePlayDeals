package com.alexs7.redditgoogleplaydeals;

/**
 * Created by alex on 21/06/2017.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<RedditResponse> {

    static final String BASE_URL = "https://www.reddit.com/r/";

    public void start(){
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
        Call<RedditResponse> call = redditAPI.getDeals();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
        if(response.isSuccessful()){
            System.out.println("-------------->");
            RedditResponse redditResponse = response.body();
            System.out.println(redditResponse.getData().toString());
        }else{
            System.out.println("<---------------");
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<RedditResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
