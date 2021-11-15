package com.example.pasibus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Gallery_fragment extends Fragment {

    LinearLayout linearLayout;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery_fragment, container, false);

        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        imageView = (ImageView) view.findViewById(R.id.imageView4);

        for ( int i = 6; i < 16; i++){
            ImageView barView = new ImageView(getActivity());
            barView.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            barView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int imgID = getResources().getIdentifier("burger" + i, "drawable", getActivity().getPackageName());
            barView.setImageResource(imgID);

            barView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView localView = (ImageView) v;
                    imageView.setImageDrawable(localView.getDrawable());
                }
            });
            linearLayout.addView(barView);
        }

        return view;
    }
}