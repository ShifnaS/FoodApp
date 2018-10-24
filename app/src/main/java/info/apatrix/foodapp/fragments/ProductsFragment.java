package info.apatrix.foodapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.apatrix.foodapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;
    @BindView(R.id.txtTabItemNumber)
    TextView textView ;

    public ProductsFragment() {
        // Required empty public constructor
    }
    public static ProductsFragment newInstance(int sectionNumber) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_products, container, false);
        ButterKnife.bind(this,view);
        sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        textView.setText("TAB " + sectionNumber);
        return view;

    }

}
