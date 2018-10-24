package info.apatrix.foodapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import info.apatrix.foodapp.fragments.ProductsFragment;
import info.apatrix.foodapp.model.SubCategoryList;

/**
 * Created by pc on 21-Oct-18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<SubCategoryList> item;
    SubCategoryList obj;
    public ViewPagerAdapter(FragmentManager manager, ArrayList<SubCategoryList> item) {
        super(manager);
        this.item=item;
    }

    @Override
    public Fragment getItem(int position) {
        obj=item.get(position);
        return ProductsFragment.newInstance(obj.getSubcat_id());

    }
    @Override
    public CharSequence getPageTitle(int position) {
        obj=item.get(position);
        return obj.getSubcatname();
    }
    @Override
    public int getCount() {
        return item.size();
    }


}

