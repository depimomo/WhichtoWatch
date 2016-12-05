package com.movieapp.monica.whichtowatch;

        import android.app.Activity;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import java.util.List;
        import com.squareup.picasso.Picasso;


public class MovieArrayAdapter extends ArrayAdapter<MovieObject> {
    public MovieArrayAdapter(Activity context, List<MovieObject> movieObjectList) {
        super(context, 0 , movieObjectList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieObject obj = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.fragment_imageview, parent, false);
        }

        ImageView movieImage = (ImageView) convertView.findViewById(R.id.poster);

        //Log.d("aaaaa", obj.getMoviePosterPath());
        String imageUrl = "http://image.tmdb.org/t/p/w185/";
        Picasso.with(getContext()).load(imageUrl + obj.getMoviePosterPath()).into(movieImage);

        return convertView;
    }
}