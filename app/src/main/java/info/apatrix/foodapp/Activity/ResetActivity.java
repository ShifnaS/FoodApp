package info.apatrix.foodapp.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.apatrix.foodapp.R;

public class ResetActivity extends AppCompatActivity {
    @BindView(R.id.cancel)
    Button bt_cancel;
    @BindView(R.id.ok)
    Button bt_ok;

    @BindView(R.id.reset_pass)
    TextView tv_reset_pass;

    @BindView(R.id.sign_continue)
    TextView tv_sign_continue;

    @BindView(R.id.back_to_login)
    TextView tv_back_to_login;

    @BindView(R.id.input_password)
    EditText et_input_password;

    @BindView(R.id.input_reset_password)
    EditText et_input_Confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        Typeface bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Bold.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Regular.ttf");
        Typeface semi_bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-SemiBold.ttf");
        Typeface medium = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Medium.ttf");
        ButterKnife.bind(this);

        tv_reset_pass.setTypeface(bold);
        tv_sign_continue.setTypeface(regular);
        tv_back_to_login.setTypeface(semi_bold);
        et_input_Confirm_password.setTypeface(regular);
        et_input_password.setTypeface(regular);
        bt_cancel.setTypeface(semi_bold);
        bt_ok.setTypeface(semi_bold);

    }
    @OnClick(R.id.ok)
    public void onButtonClick(View view) {
        Intent i=new Intent(getApplicationContext(),ResetSuccessActivity.class);
        startActivity(i);
        finish();
    }
}
