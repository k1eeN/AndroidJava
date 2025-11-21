package com.example.androidjava.lesson_11_movies;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidjava.R;

import java.util.List;

import io.reactivex.rxjava3.schedulers.Schedulers;


public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = "MovieDetailActivityCheck";

    private MovieDetailViewModel viewModel;

    private static final String EXTRA_MOVIE = "movie";

    private ImageView imageViewPoster;
    private ImageView imageViewStar;
    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewDescription;
    private TextView textViewTrailerMissing;
    private RecyclerView recyclerViewTrailers;
    private RecyclerView recyclerViewReview;
    private TrailersAdapter trailersAdapter;
    private ReviewsAdapter reviewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie_detail);
        viewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);
        initView();

        trailersAdapter = new TrailersAdapter();
        reviewsAdapter = new ReviewsAdapter();
        recyclerViewTrailers.setAdapter(trailersAdapter);
        recyclerViewReview.setAdapter(reviewsAdapter);

        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);
        Poster poster = movie.getPoster();
        if (poster != null && poster.getUrl() != null && !poster.getUrl().isEmpty()) {
            Glide.with(this)
                    .load(movie.getPoster().getUrl())
                    .into(imageViewPoster);
        }
        textViewTitle.setText(movie.getName());
        textViewYear.setText(String.valueOf(movie.getYear()));
        textViewDescription.setText(movie.getDescription());

        viewModel.loadTrailers(movie.getId());
        viewModel.getTrailers().observe(this, new Observer<List<Trailer>>() {
            @Override
            public void onChanged(List<Trailer> trailers) {
                if (trailers != null) {
                    textViewTrailerMissing.setVisibility(View.GONE);
                    trailersAdapter.setTrailers(trailers);
                } else {
                    textViewTrailerMissing.setVisibility(View.VISIBLE);
                }
            }
        });

        trailersAdapter.setOnTrailerClickListener(new TrailersAdapter.OnTrailerClickListener() {
            @Override
            public void onTrailerClick(Trailer trailer) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(trailer.getUrl()));
                startActivity(intent);
            }
        });

        viewModel.getReviews().observe(this, new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviewList) {
                reviewsAdapter.setReviews(reviewList);
            }
        });
        viewModel.loadReviews(movie.getId());

        Drawable starOff = ContextCompat.getDrawable(
                MovieDetailActivity.this,
                android.R.drawable.btn_star_big_off
        );
        Drawable starOn = ContextCompat.getDrawable(
                MovieDetailActivity.this,
                android.R.drawable.btn_star_big_on
        );

        viewModel.getFavouriteMovie(movie.getId()).observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(Movie movieFromDb) {
                if (movieFromDb == null) {
                    imageViewStar.setImageDrawable(starOff);
                    imageViewStar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewModel.insertMovie(movie);
                        }
                    });
                } else {
                    imageViewStar.setImageDrawable(starOn);
                    imageViewStar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewModel.removeMovie(movie.getId());
                        }
                    });
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView() {
        imageViewPoster = findViewById(R.id.imageViewPoster);
        imageViewStar = findViewById(R.id.imageViewStar);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDescription = findViewById(R.id.textViewDescription);
        recyclerViewTrailers = findViewById(R.id.recyclerViewTrailers);
        recyclerViewReview = findViewById(R.id.recyclerViewReview);
        textViewTrailerMissing = findViewById(R.id.textViewTrailerMissing);
    }

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }
}