package com.movieapp.monica.whichtowatch;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
                    .inflate(R.layout.fragment_review, parent, false);
        }

        //TODO set data here
        TextView tvwName = (TextView) convertView.findViewById(R.id.namaReview);
        TextView tvwDesc = (TextView) convertView.findViewById(R.id.isiReview);
        tvwName.setText(obj.getDataAuthor());
        tvwDesc.setText(obj.getDataContent());

        return convertView;
    }

}