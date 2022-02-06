package com.example.vandrabyapp.activities.main.pages.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.model.database.DataModel;
import com.example.vandrabyapp.model.entities.User;

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

        return view;
    }
}