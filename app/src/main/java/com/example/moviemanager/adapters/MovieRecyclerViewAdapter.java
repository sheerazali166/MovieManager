package com.example.moviemanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviemanager.R;
import com.example.moviemanager.activities.MovieDetailActivity;
import com.example.moviemanager.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sheeraz.
 */

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder> {

    List<Movie> movieList;
    Context context;

    public MovieRecyclerViewAdapter(Context _context, List<Movie> _movieList) {
        this.movieList = _movieList;
        this.context = _context;
    }

    private Context getContext() {
        return this.context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        Movie movie = movieList.get(position);
        myViewHolder.tvTitle.setText(movie.getTitle());
        myViewHolder.tvOverview.setText(movie.getOverview());

        Picasso.with(getContext())
                .load(movie.getPosterPath())
                .into(myViewHolder.ivMovieImage);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvOverView)
        TextView tvOverview;

        @BindView(R.id.cvMovie)
        CardView cvMovie;

        public MyViewHolder(@NonNull View view) {
            super(view);

            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Movie movie = movieList.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), MovieDetailActivity.class);
            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);

        }
    }

}
