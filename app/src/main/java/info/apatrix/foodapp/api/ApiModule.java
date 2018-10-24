package info.apatrix.foodapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 22-Oct-18.
 */

public class ApiModule {
    private static Retrofit getRetrofitInstance()
    {
        return new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static APIService getAPIService()
    {
        return getRetrofitInstance().create(APIService.class);
    }

}
