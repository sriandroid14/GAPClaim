package com.fortegra.gap.network;
import com.fortegra.gap.model.Claim;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GapClaimApi {
    @GET("top-headlines")
    Call<Claim> getNewsList(@Query("sources") String newsSource,
                            @Query("apiKey") String apiKey);
}
