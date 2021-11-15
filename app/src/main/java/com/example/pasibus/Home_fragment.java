package com.example.pasibus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class Home_fragment extends Fragment {
    ImageSlider imageSlider;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> aboutUs = new ArrayList<>();
        aboutUs.add(new SlideModel(R.drawable.atmosfera,
                "Wywodzimy się ze street foodu i cenimy sobie niezobowiązującą atmosferę, luźny klimat i indywidualne podejście do klienta. U nas możesz zapomnieć o konwenansach i sztywnych zasadach",
                null));

        aboutUs.add(new SlideModel(R.drawable.idea,
                "Naszym głównym założeniem było stworzenie miejsca na mapie Wrocławia w ulicznym charakterze, o niezobowiązującej atmosferze, do którego ludzie z chęcią będą wracać. ",
                null));

        aboutUs.add(new SlideModel(R.drawable.zajednia,
                "Tu dzieje się magia. Zbudowaliśmy naszą własną produkcję - ZAJEZDNIĘ PASIBUS. Przygotowujemy tu wszystkie nasze wyroby - począwszy od mielenia mięsa, po własnoręcznie robione kulki serowe.",
                null));

        aboutUs.add(new SlideModel(R.drawable.jakosc,
                "Jakość stoi u nas na pierwszym miejscu. Dokładamy wszelkich starań, aby nasze produkty były najwyższej jakości. ",
                null));
        imageSlider.setImageList(aboutUs, ScaleTypes.CENTER_CROP);

        return view;
    }
}