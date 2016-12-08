package com.movieapp.monica.whichtowatch;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMovie extends AppCompatActivity {

    Toolbar toolbar;
    TextView judul_detail;
    TextView tahun_detail;
    TextView durasi_detail;
    TextView rating_detail;
    TextView summary;
    RatingBar bintang_detail;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView poster_detail;
    LinearLayout spaceVideo;
    LinearLayout spaceReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added to favorites", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        judul_detail = (TextView) findViewById(R.id.judul_detail);
        tahun_detail = (TextView) findViewById(R.id.tahun_detail);
        durasi_detail = (TextView) findViewById(R.id.durasi_detail);
        rating_detail = (TextView) findViewById(R.id.rating_detail);
        bintang_detail = (RatingBar) findViewById(R.id.bintang_detail);
        poster_detail = (ImageView) findViewById(R.id.poster_detail);
        summary = (TextView) findViewById(R.id.summary);
        spaceVideo = (LinearLayout) findViewById(R.id.spaceVideo);
        spaceReview = (LinearLayout) findViewById(R.id.spaceReview);

        Bundle b = getIntent().getExtras();

        int id_film = b.getInt("id_film");

        updateDetailMovie(id_film);
        updateDetailVideo(id_film);
        updateDetailReview(id_film);

        collapsingToolbar
                .setCollapsedTitleTextAppearance(R.style.TextAppearance_MyApp_Title_Collapsed);
        collapsingToolbar
                .setExpandedTitleTextAppearance(R.style.TextAppearance_MyApp_Title_Expanded);

        spaceVideo = (LinearLayout) findViewById(R.id.spaceVideo);
    }

    private void updateDetailMovie(int movieId) {
        MovieDataFetcher theFetcher = new MovieDataFetcher();
        MovieInterfaces theInterface = theFetcher.getFetcher().create(MovieInterfaces.class);

        Call<MovieObject> callMovieObject = theInterface
                .getMoviesById(movieId, BuildConfig.MOVIE_DB_API_KEY_V3);

        callMovieObject.enqueue(new Callback<MovieObject>() {
            @Override
            public void onResponse(Call<MovieObject> call, Response<MovieObject> resp) {

                toolbar.setTitle(resp.body().getMovieTitle());
                judul_detail.setText(resp.body().getMovieTitle());

                String release = resp.body().getMovieReleaseDate();
                String year = release.substring(0,4);

                tahun_detail.setText(year);
                durasi_detail.setText(String.format("%s%s", String.valueOf(resp.body().getRuntime())
                        , getString(R.string.minutes)));
                rating_detail
                        .setText(String.format("%s%s", String.valueOf(resp.body().getMovieVoteAverage())
                        , getString(R.string.per10)));

                Float rate = Float.valueOf(String.valueOf(resp.body().getMovieVoteAverage()))/2f;
                bintang_detail.setRating(rate);

                String imageUrl = "http://image.tmdb.org/t/p/w154/";
                Picasso.with(getBaseContext())
                        .load(imageUrl + resp.body().getMoviePosterPath()).into(poster_detail);

                summary.setText(resp.body().getMovieOverview());

            }

            @Override
            public void onFailure(Call<MovieObject> call, Throwable t) {
                Log.e("Gagal nih", t.toString());
            }
        });
    }

    private void updateDetailVideo(int movieId) {
        MovieDataFetcher theFetcher = new MovieDataFetcher();
        MovieInterfaces theInterface = theFetcher.getFetcher().create(MovieInterfaces.class);
        Call<MovieVideoData> callMovieVideoData = theInterface
                .getMovieVideo(movieId, BuildConfig.MOVIE_DB_API_KEY_V3);

        callMovieVideoData.enqueue(new Callback<MovieVideoData>() {
            @Override
            public void onResponse(Call<MovieVideoData> call, Response<MovieVideoData> resp) {

                Log.d("hasil get data result", String.valueOf(resp.body().getDataResult()));
                //assert resp != null;
                List<MovieVideoObject> listMoviesVideo = resp.body().getDataResult();

                assert listMoviesVideo.size() != 0;

                final VideoArrayAdapter adp = new VideoArrayAdapter(DetailMovie.this, listMoviesVideo);

                for (Integer i = 0; i < adp.getCount(); i++) {
                    View item = adp.getView(i, null, null);
                    spaceVideo.addView(item);
                }

            }

            @Override
            public void onFailure(Call<MovieVideoData> call, Throwable t) {
                Log.e("Gagal ambil video", t.toString());
            }
        });
    }

    private void updateDetailReview(int movieId) {
        MovieDataFetcher theFetcher = new MovieDataFetcher();
        MovieInterfaces theInterface = theFetcher.getFetcher().create(MovieInterfaces.class);
        Call<MovieReviewData> callMovieReviewData = theInterface
                .getMovieReview(movieId, BuildConfig.MOVIE_DB_API_KEY_V3);

        callMovieReviewData.enqueue(new Callback<MovieReviewData>() {
            @Override
            public void onResponse(Call<MovieReviewData> call, Response<MovieReviewData> resp) {
                assert resp != null;
                List<MovieReviewObject> listMoviesReview = resp.body().getDataResult();

                assert listMoviesReview.size() != 0;
                ReviewArrayAdapter adp = new ReviewArrayAdapter(DetailMovie.this, listMoviesReview);

                for (Integer i = 0; i < adp.getCount(); i++) {
                    View item = adp.getView(i, null, null);
                    spaceReview.addView(item);
                }
            }

            @Override
            public void onFailure(Call<MovieReviewData> call, Throwable t) {
                Log.e("Gagal ambil review", t.toString());
            }
        });
    }
}
