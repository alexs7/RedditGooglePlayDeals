package com.alexs7.redditgoogleplaydeals;

/**
 * Created by alex on 21/06/2017.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RedditAPI {

    @GET("googleplaydeals/.json") //.json?
    Call<RedditResponse> getDeals(); // getDeals(@Query("count") Integer count);

}
