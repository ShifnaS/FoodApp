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

public class ForgetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.btn_signin)
    ImageButton bt_signIn;

    @BindView(R.id.forget_pas)
    TextView tv_forget_pas;
    @BindView(R.id.enter_reg_email)
    TextView tv_enter_reg_email;

    @BindView(R.id.back_to_login)
    TextView tv_back_to_login;

    @BindView(R.id.input_email)
    EditText et_input_email;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Typeface bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Bold.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Regular.ttf");
        Typeface semi_bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-SemiBold.ttf");
        Typeface medium = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Medium.ttf");

        tv_forget_pas.setTypeface(bold);
        tv_enter_reg_email.setTypeface(regular);
        tv_back_to_login.setTypeface(medium);
        et_input_email.setTypeface(regular);
    }
    @OnClick(R.id.back_to_login)
    public void onButtonClick(View view) {
        Intent i=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
        finish();
    }
    @OnClick(R.id.btn_signin)
    public void onButtonSignClick(View view) {
        Intent i=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
        finish();
    }
}
