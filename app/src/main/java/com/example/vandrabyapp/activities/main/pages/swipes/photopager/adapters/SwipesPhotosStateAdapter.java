package com.example.vandrabyapp.activities.main.pages.swipes.photopager.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SwipesPhotosStateAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {

    private final List<String> mPhotoUrls;

    public SwipesPhotosStateAdapter(Fragment fragment, List<String> photoUrls) {
        super(fragment);
        mPhotoUrls = photoUrls;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ObjectPhotoFragment.newInstance(mPhotoUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotoUrls.size();
    }

    static public class ObjectPhotoFragment extends Fragment {
        private static final String ARGUMENT_PHOTO_URL = "arg_photo_url";
        private String photoUrl;

        public static ObjectPhotoFragment newInstance(String photoUrl) {
            Bundle arguments = new Bundle();
            arguments.putString(ARGUMENT_PHOTO_URL, photoUrl);
            ObjectPhotoFragment objectPhotoFragment = new ObjectPhotoFragment();
            objectPhotoFragment.setArguments(arguments);
            return objectPhotoFragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            assert getArguments() != null;
            photoUrl = getArguments().getString(ARGUMENT_PHOTO_URL);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_main_swipes_photo_item, null);

            ImageView imageView = view.findViewById(R.id.sight_picture);
            Picasso.with(view.getContext()).load(photoUrl).fit().centerCrop().into(imageView);

            return view;
        }
    }
}