package info.apatrix.foodapp.api;

import info.apatrix.foodapp.model.ResultSignUp;
import info.apatrix.foodapp.model.ResultSubCategory;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("categories/list_by_id/{input}")
    Call<ResultSubCategory> getSubCategoryList(
           @Path("input") String input
    );
    @FormUrlEncoded
    @POST("customers/register")
    Call<ResultSignUp> register(
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("password") String password

    );
}
