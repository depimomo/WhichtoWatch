package com.movieapp.monica.whichtowatch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import java.util.List;


public class ReviewArrayAdapter extends ArrayAdapter<MovieReviewObject> {
    public ReviewArrayAdapter(Activity context, List<MovieReviewObject> movieObjectList) {
        super(context, 0 , movieObjectList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MovieReviewObject obj = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.fragment_videos, parent, false);
        }

        return convertView;
    }

}