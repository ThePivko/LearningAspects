package com.example.learningaspects.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.learningaspects.Czasownik;
import com.example.learningaspects.CzasownikAdapter;
import com.example.learningaspects.R;

public class DashboardFragment extends Fragment {
    private ArrayList<Czasownik> mCzasownikList;
    private RecyclerView mRecyclerView;
    private CzasownikAdapter mAdapter;  /* pozwala na załadowanie tylko tyle co trzeba a nie wszystkich*/
    private RecyclerView.LayoutManager mLayoutManager;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mRecyclerView = root.findViewById(R.id.recyclerView);

        createCzasownikList();
        buildRecyclerView();

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());

        return root;
    }

    public void changeImage(int position, int image) {
        mCzasownikList.get(position).changeImage(image);
        mAdapter.notifyItemChanged(position);
    }

    public void createCzasownikList() {
        mCzasownikList = new ArrayList<>();
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_black_24dp, "pić", "wypić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "pić", "wypić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "pić", "wypić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "pić", "wypić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "pić", "wypić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "pić", "wypić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "robić", "zrobić"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "oglądać", "obejrzeć"));
        mCzasownikList.add(new Czasownik(R.drawable.ic_star_border_black_24dp, "pić", "wypić"));
    }

    public void buildRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CzasownikAdapter(mCzasownikList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CzasownikAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (mCzasownikList.get(position).getImageResource() == R.drawable.ic_star_border_black_24dp) {
                    changeImage(position, R.drawable.ic_star_black_24dp);
                } else if (mCzasownikList.get(position).getImageResource() == R.drawable.ic_star_black_24dp) {
                    changeImage(position, R.drawable.ic_star_border_black_24dp);
                } else changeImage(position, R.drawable.ic_practice_black_24dp);
            }
        });
    }
}