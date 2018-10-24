package info.apatrix.foodapp.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.apatrix.foodapp.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_signin)
    ImageButton bt_signIn;

    @BindView(R.id.sign_continue)
    TextView tv_sign_continue;
    @BindView(R.id.welcome_back)
    TextView tv_welcome_back;
    @BindView(R.id.create_account)
    TextView tv_create_account;
    @BindView(R.id.link_signUp)
    TextView tv_link_signUp;
    @BindView(R.id.input_email)
    EditText et_input_email;
    @BindView(R.id.input_password)
    EditText et_input_password;
    @BindView(R.id.forget_password)
    TextView tv_forget_password;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Typeface bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Bold.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Regular.ttf");
        Typeface semi_bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-SemiBold.ttf");
        Typeface medium = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Medium.ttf");

        tv_sign_continue.setTypeface(regular);
        tv_welcome_back.setTypeface(bold);
        tv_create_account.setTypeface(medium);
        tv_link_signUp.setTypeface(semi_bold);
        et_input_email.setTypeface(regular);
        et_input_password.setTypeface(regular);
        tv_forget_password.setTypeface(medium);
    }
    @OnClick(R.id.forget_password)
    public void onButtonClick(View view) {
        Intent i=new Intent(getApplicationContext(),ForgetPasswordActivity.class);
        startActivity(i);
        finish();
    }
    @OnClick(R.id.link_signUp)
    public void onSignUpClick(View view) {
        Intent i=new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(i);
        finish();
    }
    @OnClick(R.id.btn_signin)
    public void onButtonLoginClick(View view) {
        Intent i=new Intent(getApplicationContext(),HomeMenuActivity.class);
        startActivity(i);
        finish();
    }
}
