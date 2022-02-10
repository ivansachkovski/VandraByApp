package com.example.vandrabyapp.activities.main.pages.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.profile.adapters.ProfileTabsStateAdapter;
import com.example.vandrabyapp.model.database.DataModel;
import com.example.vandrabyapp.model.entities.User;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProfileFragment extends Fragment {

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_profile, null);

        DataModel dataModel = DataModel.getInstance();
        User user = dataModel.getUser();
        assert user != null;

        TextView textUserName = view.findViewById(R.id.text_user_name);
        textUserName.setText(user.getName());

        TextView textUserNickname = view.findViewById(R.id.text_user_nickname);
        textUserNickname.setText(user.getNickname());

        FragmentStateAdapter adapter = new ProfileTabsStateAdapter(this);

        ViewPager2 viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.layout_tabs);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Объекты");
                    break;
                case 1:
                    tab.setText("Маршруты");
                    break;
                case 2:
                    tab.setText("Статистика");
                    break;
            }
        }).attach();

        return view;
    }
}