package com.example.myfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentView extends Fragment {

    private Model mMovie;

    public FragmentView() {
    }

    public static FragmentView newInstance(Model model) {
        FragmentView fragment = new FragmentView();
        Bundle args = new Bundle();
        args.putParcelable("movie", model);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovie = getArguments().getParcelable("movie");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView movieImageView = view.findViewById(R.id.image_movie);
        TextView movieTextTitle = view.findViewById(R.id.text_movie_title);

        Glide.with(this)
                .load(mMovie.getUrl())
                .into(movieImageView);

        movieTextTitle.setText(mMovie.getTitle());

            }
        }

    }
}
