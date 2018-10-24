package info.apatrix.foodapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.apatrix.foodapp.R;
import info.apatrix.foodapp.adapter.HistoryAdapter;
import info.apatrix.foodapp.model.History;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingOrPastOrderFragment extends Fragment {

    private List<History> movieList = new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private HistoryAdapter mAdapter;

    public PendingOrPastOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_pending_or_past_order, container, false);
        ButterKnife.bind(this,root);
        mAdapter = new HistoryAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
       // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        prepareHistoryData();
        return root;
    }

    private void prepareHistoryData() {
        History movie = new History("17 jul", "#0041", "$20.15");
        movieList.add(movie);

        History movie1 = new History("18 jul", "#0048", "$20.15");
        movieList.add(movie1);

        History movie2 = new History("19 jul", "#0045", "$20.15");
        movieList.add(movie2);

        History movie3 = new History("20 jul", "#0045", "$20.15");
        movieList.add(movie3);

        History movie4 = new History("21 jul", "#0046", "$20.15");
        movieList.add(movie4);

        History movie5 = new History("30 jul", "#0047", "$20.15");
        movieList.add(movie5);
        History movie6 = new History("17 jul", "#0041", "$20.15");
        movieList.add(movie6);

        History movie7 = new History("18 jul", "#0048", "$20.15");
        movieList.add(movie7);

        History movie8 = new History("19 jul", "#0045", "$20.15");
        movieList.add(movie8);

        History movie9 = new History("20 jul", "#0045", "$20.15");
        movieList.add(movie9);

        History movie10 = new History("21 jul", "#0046", "$20.15");
        movieList.add(movie10);


        mAdapter.notifyDataSetChanged();


    }

}
