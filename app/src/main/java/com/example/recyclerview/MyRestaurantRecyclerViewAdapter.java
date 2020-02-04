package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.recyclerview.RestaurantFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurant> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestaurantRecyclerViewAdapter(List<Restaurant> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //we rescue the data of the elements that occupy the position
        holder.mItem = mValues.get(position);
        holder.textViewName.setText(holder.mItem.getName());
        holder.textViewAddress.setText(holder.mItem.getAddress());
        holder.ratingBar.setRating(holder.mItem.getValoration());
        Picasso.get()
                .load(holder.mItem.getUrlPhoto())
                .resize(400, 150)
                .centerCrop()
                .into(holder.imageViewPhoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewName;
        public final TextView textViewAddress;
        public final ImageView imageViewPhoto;
        public final RatingBar ratingBar;

        public Restaurant mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = view.findViewById(R.id.textViewName);
            textViewAddress = view.findViewById(R.id.textViewAddres);
            imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
            ratingBar = view.findViewById(R.id.ratingBarValoration);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }
}
