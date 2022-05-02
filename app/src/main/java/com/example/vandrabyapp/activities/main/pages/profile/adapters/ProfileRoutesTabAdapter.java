package com.example.vandrabyapp.activities.main.pages.profile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.model.entities.Route;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProfileRoutesTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Route> items;

    public ProfileRoutesTabAdapter(List<Route> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_profile_tab_routes_item, parent, false));
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

        private Route route;

        private final ImageView imageRoutePhoto;
        private final TextView textRouteName;

        PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            imageRoutePhoto = itemView.findViewById(R.id.image_route_photo);
            textRouteName = itemView.findViewById(R.id.text_route_name);

            itemView.setOnClickListener(this);
        }

        void fillItem(Route item) {
            route = item;

            // todo::use another route picture
            textRouteName.setText(item.getName());
            Picasso.with(imageRoutePhoto.getContext()).load(item.getPlaces().get(0).getPhotoUrls().get(0)).fit().into(imageRoutePhoto);
        }

        @Override
        public void onClick(View v) {
            //MainActivity mainActivity = (MainActivity) itemView.getContext();
            //mainActivity.onOpenPlaceDetailsPage(place, false);
        }
    }
}
