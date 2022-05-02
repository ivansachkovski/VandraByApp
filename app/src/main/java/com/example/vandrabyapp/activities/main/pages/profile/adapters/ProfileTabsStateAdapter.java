package com.example.vandrabyapp.activities.main.pages.profile.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.model.database.DataModel;

public class ProfileTabsStateAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {

    private final static int NUMBER_OF_PAGES = 3;

    public ProfileTabsStateAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return LikedPlacesPage.newInstance();
            case 1:
                return RoutesPage.newInstance();
            case 2:
                return StatisticPage.newInstance();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return NUMBER_OF_PAGES;
    }

    // TODO::pass arguments
    public static class LikedPlacesPage extends Fragment {

        public static LikedPlacesPage newInstance() {
            return new LikedPlacesPage();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            RecyclerView view = (RecyclerView) inflater.inflate(R.layout.list_item_profile_tab_liked, null);
            view.setAdapter(new ProfilePlacesTabAdapter(DataModel.getInstance().getUserLikedPlaces()));
            return view;
        }
    }

    // TODO::pass arguments
    static public class RoutesPage extends Fragment {
        public static RoutesPage newInstance() {
            return new RoutesPage();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            RecyclerView view = (RecyclerView) inflater.inflate(R.layout.list_item_profile_tab_routes, null);
            view.setAdapter(new ProfileRoutesTabAdapter(DataModel.getInstance().getRoutes()));
            return view;
        }
    }

    // TODO::pass arguments
    static public class StatisticPage extends Fragment {
        public static StatisticPage newInstance() {
            return new StatisticPage();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            RecyclerView view = (RecyclerView) inflater.inflate(R.layout.list_item_profile_tab_liked, null);
            // TODO::implement
            return view;
        }
    }
}