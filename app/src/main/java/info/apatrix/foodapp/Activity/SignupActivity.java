package info.apatrix.foodapp.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.apatrix.foodapp.R;
import info.apatrix.foodapp.api.APIService;
import info.apatrix.foodapp.api.ApiModule;
import info.apatrix.foodapp.model.ResultSignUp;
import info.apatrix.foodapp.model.ResultSubCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    @BindView(R.id.btn_signup)
    ImageButton btn_signup;

    @BindView(R.id.enter_details)
    TextView tv_enter_details;
    @BindView(R.id.create_account)
    TextView tv_create_account;
    @BindView(R.id.have_account)
    TextView tv_have_account;
    @BindView(R.id.link_login)
    TextView tv_link_login;
    @BindView(R.id.input_email)

    EditText et_input_email;
    @BindView(R.id.input_phone)
    EditText et_input_phone;
    @BindView(R.id.input_password)
    EditText et_input_password;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Typeface bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Bold.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Regular.ttf");
        Typeface semi_bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-SemiBold.ttf");
        Typeface medium = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Medium.ttf");

        tv_enter_details.setTypeface(regular);
        tv_create_account.setTypeface(bold);
        tv_have_account.setTypeface(medium);
        tv_link_login.setTypeface(semi_bold);
        et_input_email.setTypeface(regular);
        et_input_phone.setTypeface(regular);
        et_input_password.setTypeface(regular);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @OnClick(R.id.btn_signup)
    public void onButtonClick(View view) {

        if (isEmailEmpty()){
            et_input_email.setError(getString(R.string.email_error));
        }
        else if (isPasswordEmpty()){
            et_input_password.setError(getString(R.string.password_error));

        }
        else if (isPhoneEmpty()){
            et_input_phone.setError(getString(R.string.phone_error));

        }
        else
        {
            String email=et_input_email.getText().toString().trim();
            String phone=et_input_phone.getText().toString().trim();
            String password=et_input_password.getText().toString().trim();
            signUpActivity(email,phone,password);
        }



    }
    @OnClick(R.id.link_login)
    public void onButtonLoginClick(View view) {
        Intent i=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void signUpActivity(String email, String phone, String password)
    {

        APIService service = ApiModule.getAPIService();
        Call<ResultSignUp> call = service.register(email,phone,password);
        call.enqueue(new Callback<ResultSignUp>() {
            @Override
            public void onResponse(Call<ResultSignUp> call, Response<ResultSignUp> response) {
                try
                {
                 //   Toast.makeText(getApplicationContext(), "success "+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    if(response.body().getMessage().equalsIgnoreCase("success"))
                    {
                        JSONObject jo =response.body().getResponse();
                        String value=jo.getString("value");
                        Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(getApplicationContext(),ExploreActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No data in this category", Toast.LENGTH_SHORT).show();
                    }

                  //  Log.e("item","my item33333333"+item.size());

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Log.e("Exception ",e.getMessage());


                }

            }

            @Override
            public void onFailure(Call<ResultSignUp> call, Throwable t) {
                Log.e("MyTag", "requestFailed", t);
                Log.e("Failure ",t.getMessage());

            }
        });
    }
    public boolean isPasswordEmpty() {
        return et_input_password.getText().toString().isEmpty();
    }
    public boolean isEmailEmpty() {
        return et_input_email.getText().toString().isEmpty();
    } public boolean isPhoneEmpty() {
        return et_input_phone.getText().toString().isEmpty();
    }

}
