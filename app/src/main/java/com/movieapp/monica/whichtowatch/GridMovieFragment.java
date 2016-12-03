package com.movieapp.monica.whichtowatch;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridMovieFragment extends Fragment {
    private static final String LOG_TAG = GridMovieFragment.class.getSimpleName();

    GridView grdMovieList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gridmovie, container, false);
        grdMovieList = (GridView) rootView.findViewById(R.id.grdMovieList);

        grdMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                MovieObject tes = (MovieObject) grdMovieList.getItemAtPosition(i);

                Toast
                        .makeText(getContext(),
                                        "Release date : " + tes.getMovieReleaseDate(),
                                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateList();
    }

    public boolean isOnline() {

        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);

        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }

    private void updateList() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String sortBy = prefs.getString(
            getString(R.string.pref_movie_sortby_key),
            getString(R.string.pref_movie_sortby_option_default_value)
        );

        MovieDataFetcher theFetcher = new MovieDataFetcher();
        MovieInterfaces theInterface = theFetcher.getFetcher().create(MovieInterfaces.class);
        Call<MovieData> callMovieData = theInterface
            .getMoviesBySort(sortBy, BuildConfig.MOVIE_DB_API_KEY_V3);
        
        callMovieData.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> resp) {
                assert resp != null;
                List<MovieObject> listMovies = resp.body().getDataResults();

                assert listMovies.size() != 0;
                //TODO Allocate the movie here !
                /*String[] arrString = new String[listMovies.size()];
                int index = 0;
                for(MovieObject obj : listMovies) {
                    arrString[index] = String.valueOf(obj.getMovieOriginalTitle());
                    index++;
                }*/

                //TODO ganti jadi ArrayAdapter of MovieObject
                MovieArrayAdapter adp = new MovieArrayAdapter (
                    getActivity(),
                    listMovies
                );
                grdMovieList.setAdapter(adp);
                //ENDOFTODO

                Log.d(LOG_TAG, "Total Film: " + listMovies.size());
                
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());
            }
        });
    }
}