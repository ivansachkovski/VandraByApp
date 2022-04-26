package com.example.vandrabyapp.activities.main.pages.profile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.MainActivity;
import com.example.vandrabyapp.model.entities.Place;
import com.example.vandrabyapp.model.entities.Trip;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProfileTripsTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Trip> items;

    public ProfileTripsTabAdapter(List<Trip> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_profile_tab_trips_item, parent, false));
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

        private Trip trip;

        private final ImageView imageTripPhoto;
        private final TextView textTripName;

        PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTripPhoto = itemView.findViewById(R.id.image_trip_photo);
            textTripName = itemView.findViewById(R.id.text_trip_name);

            itemView.setOnClickListener(this);
        }

        void fillItem(Trip item) {
            trip = item;

            // todo::use another trip picture
            textTripName.setText(item.getName());
            Picasso.with(imageTripPhoto.getContext()).load(item.getPlaces().get(0).getPhotoUrls().get(0)).fit().into(imageTripPhoto);
        }

        @Override
        public void onClick(View v) {
            //MainActivity mainActivity = (MainActivity) itemView.getContext();
            //mainActivity.onOpenPlaceDetailsPage(place, false);
        }
    }
}
