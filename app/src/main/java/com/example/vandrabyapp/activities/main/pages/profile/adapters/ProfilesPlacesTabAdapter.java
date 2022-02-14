package com.example.vandrabyapp.activities.main.pages.profile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.model.entities.Place;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProfilesPlacesTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Place> items;

    public ProfilesPlacesTabAdapter(List<Place> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_profile_tab_place, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PlaceViewHolder) holder).fillItem(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Place place;

        private final ImageView imagePlacePhoto;
        private final TextView textPlaceName;
        private final TextView textPlaceLocation;

        PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePlacePhoto = itemView.findViewById(R.id.image_place_photo);
            textPlaceName = itemView.findViewById(R.id.text_place_name);
            textPlaceLocation = itemView.findViewById(R.id.text_place_location);

            itemView.setOnClickListener(this);
        }

        void fillItem(Place item) {
            place = item;

            textPlaceName.setText(item.getName());
            textPlaceLocation.setText(item.getFormattedLocation());
            Picasso.with(imagePlacePhoto.getContext()).load(item.getPhotoUrls().get(0)).fit().into(imagePlacePhoto);
        }

        @Override
        public void onClick(View v) {
            //mPlaceDetailsPageListener.onOpenPlaceDetailsPage(mPlace);
        }
    }
}
