package com.upkarlidder.flicks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.upkarlidder.flicks.R;
import com.upkarlidder.flicks.models.Movie;

import java.util.List;

/**
 * Created by ulidder on 7/24/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item
        Movie movie = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        //get the image view and clean it out if convertview is being reused.
        ImageView ivMoveiImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivMoveiImage.setImageResource(0);

        TextView tvMovieTitle = (TextView) convertView.findViewById(R.id.tvMovieTitle);
        TextView tvMovieOverview = (TextView) convertView.findViewById(R.id.tvMovieOverview);


        //populate the data
        tvMovieTitle.setText(movie.getTitle());
        tvMovieOverview.setText(movie.getOverView());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivMoveiImage);

        return convertView;
    }
}
