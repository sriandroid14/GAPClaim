package com.fortegra.gap.network;
import com.fortegra.gap.model.Claim;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GapClaimRepository {

    private static GapClaimRepository gapClaimRepository;

    public static GapClaimRepository getInstance(){
        if (gapClaimRepository == null){
            gapClaimRepository = new GapClaimRepository();
        }
        return gapClaimRepository;
    }

    private GapClaimApi gapClaimApi;

    public GapClaimRepository(){
        gapClaimApi = RetrofitService.cteateService(GapClaimApi.class);
    }

    public MutableLiveData<Claim> getNews(String source, String key){
        final MutableLiveData<Claim> newsData = new MutableLiveData<>();
        gapClaimApi.getNewsList(source, key).enqueue(new Callback<Claim>() {
            @Override
            public void onResponse(Call<Claim> call,
                                   Response<Claim> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Claim> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
