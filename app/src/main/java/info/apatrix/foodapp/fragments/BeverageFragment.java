package info.apatrix.foodapp.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.apatrix.foodapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeverageFragment extends Fragment {


    public BeverageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beverage, container, false);
    }

}
