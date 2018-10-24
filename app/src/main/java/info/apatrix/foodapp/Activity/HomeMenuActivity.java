package info.apatrix.foodapp.Activity;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.apatrix.foodapp.Helper.BottomNavigationViewBehavior;
import info.apatrix.foodapp.Helper.BottomNavigationViewHelper;
import info.apatrix.foodapp.R;
import info.apatrix.foodapp.fragments.CartFragment;
import info.apatrix.foodapp.fragments.FoodFragment;
import info.apatrix.foodapp.fragments.HistoryFragment;

public class HomeMenuActivity extends AppCompatActivity {
    static final int NUM_ITEMS = 10;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
        ButterKnife.bind(this);
        Typeface bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Bold.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-Regular.ttf");
        Typeface semi_bold = Typeface.createFromAsset(getAssets(),  "fonts/Poppins-SemiBold.ttf");
        toolbar_title.setTypeface(semi_bold);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        Fragment fragment = new FoodFragment();
        Bundle bundle = new Bundle();
        bundle.putString("parent_id", "0");
        fragment.setArguments(bundle);
        loadFragment(fragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Bundle bundle;

            Fragment fragment;
            if (item.isChecked()) {
                item.setChecked(false);
            }
            switch (item.getItemId()) {
                case R.id.navigation_food:
                    item.setChecked(true);
                    fragment = new FoodFragment();
                    bundle = new Bundle();
                    bundle.putString("parent_id", "0");
                    fragment.setArguments(bundle);

                    loadFragment(fragment);
                    return true;
                case R.id.navigation_beverage:
                    item.setChecked(true);
                    fragment = new FoodFragment();
                    bundle = new Bundle();
                    bundle.putString("parent_id", "1");
                    fragment.setArguments(bundle);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    item.setChecked(true);
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_history:
                    item.setChecked(true);
                    fragment = new HistoryFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    /**/
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.change_pass:
                intent=new Intent(getApplicationContext(),ResetActivity.class);
                startActivity(intent);
                return true;
            case R.id.logout:
                 intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}