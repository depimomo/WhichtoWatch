package com.movieapp.monica.whichtowatch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


public class VideoArrayAdapter extends ArrayAdapter<MovieVideoObject> {
    public VideoArrayAdapter(Activity context, List<MovieVideoObject> movieObjectList) {
        super(context, 0 , movieObjectList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MovieVideoObject obj = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.fragment_videos, parent, false);
        }

        ImageButton buttonVid = (ImageButton) convertView.findViewById(R.id.videoButton);

        buttonVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String baseYoutube = "http://youtube.com/watch?v=" + String.valueOf(obj.getKey());
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(baseYoutube));
                getContext().startActivity(i);
            }
        });

        TextView trailerText = (TextView) convertView.findViewById(R.id.descVideo);
        assert obj != null;
        trailerText.setText(obj.getName());

        return convertView;
    }

}