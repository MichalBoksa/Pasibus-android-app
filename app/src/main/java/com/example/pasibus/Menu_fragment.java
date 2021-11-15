package com.example.pasibus;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class Menu_fragment extends Fragment {
    public Integer [] burgers = new Integer[18];
    public String [] descriptions = new String[18];
    boolean isPopped = false;
    PopupWindow popupWindow;
    TextView tv;
    ViewGroup.LayoutParams linearparams1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        writeDesc();
        View view = inflater.inflate(R.layout.fragment_menu_fragment, container, false);
        for (int i = 0; i < burgers.length; i++) {
            burgers[i] = getResources().getIdentifier
                    ("burger" + i , "drawable", getActivity().getPackageName());
        }
        GridView gridView = (GridView) view.findViewById((R.id.gridView));

        gridView.setAdapter(new ImageAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (isPopped == false) {

                    popupWindow = new PopupWindow(getActivity());
                    tv = new TextView(getActivity());
                    linearparams1 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    tv.setLayoutParams(linearparams1);
                    tv.setTextColor(Color.parseColor("#FFFFFF"));
                    tv.setText(descriptions[position]);
                    popupWindow.setContentView(tv);
                    popupWindow.setWidth(400);
                    popupWindow.setHeight(100);
                   popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                    popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 25, 25);
                    //  popupWindow.update();
                    popupWindow.setBackgroundDrawable(new ColorDrawable());

                    int location[] = new int[2];

                    // Get the View's(the one that was clicked in the Fragment) location
                    view.getLocationOnScreen(location);

                    // Using location, the PopupWindow will be displayed right under anchorView
                    popupWindow.showAtLocation(view, Gravity.NO_GRAVITY,
                            location[0], location[1] + view.getHeight());

                    isPopped = true;
                }

                else{
                    popupWindow.dismiss();
                    isPopped = false;
                }



            }
        });

        return view;
    }

    public class ImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return burgers.length;
        }

        @Override
        public Object getItem(int position) {
            return burgers[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(getActivity().getBaseContext());
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(180, 180));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(2, 2, 2, 2);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(burgers[position]);
            return imageView;
        }
    }

    public void writeDesc(){
        descriptions[0] = "100% wołowiny, sałata lodowa, majonez szczypiorkowy, jajo sadzone, pieprz, młoda kapusta podsmażana na maśle, pomidor malinowy";
        descriptions[1] = "100% wołowiny, sos różowy, rukola, autorski sos mango-chilli, ogórek kompresowany, czerwona cebula";
        descriptions[2] = "Autorski kotlet warzywny, wegański majonez, sałata lodowa, wegański ser cheddar, pomidor, ogórek kiszony, cebula";
        descriptions[3] = "100% wołowiny, sos biały, sałata lodowa, ser cheddar, ogórek kiszony, pomidor, cebula";
        descriptions[4] = "100% wołowiny, sos biały, sałata lodowa, jajo sadzone, grillowany boczek, pomidor, ogórek kiszony, cebula";
        descriptions[5] = "100% wołowiny, sos różowy, sałata lodowa, autorski sos BBQ, ser cheddar, grillowany boczek, cebula";
        descriptions[6] = "100% wołowiny, sos biały, rukola, ser grana padano, sos pomidorowo-bazyliowy, grillowany boczek";
        descriptions[7] = "100% wołowiny, sos różowy, rukola, pasta red curry, ser cheddar, jalapeño, nachosy";
        descriptions[8] = "100% wołowiny, sos jalapeño-majo, sałata lodowa, sos red hot z pepperoncino, świeże chilli";
        descriptions[9] = "100% wołowiny, sałata lodowa, majonez szczypiorkowy, jajo sadzone, pieprz, młoda kapusta podsmażana na maśle, pomidor malinowy";
        descriptions[10] = "100% wołowiny, sos różowy, rukola, pasta z suszonych pomidorów i żurawiny, ser cheddar, grillowane chorizo, grillowana pieczarka";
        descriptions[11] = "100% wołowiny, sos różowy, roszponka, ser cheddar, sos musztardowo-miodowy z orzechami, autorskie guacamole, grillowany boczek";
        descriptions[12] = "100% wołowiny, majonez, sałata lodowa, kiszony ogórek, cebula";
        descriptions[13] = "100% wołowiny, majonez, sałata lodowa, ser cheddar, sos pomidorowo-bazyliowy";
        descriptions[14] = "100% wołowiny, sos jalapeño majo, sałata lodowa, jalapeño, cebula";
        descriptions[15] = "100% wołowiny, majonez, sałata lodowa, ser cheddar, ogórek kiszony, autorski sos BBQ";
        descriptions[16] = "100% wołowiny, majonez, duszona cebula, ser cheddar, autorski sos BBQ";
        descriptions[17] = "100% wołowiny, sałata lodowa, majonez szczypiorkowy, jajo sadzone, pieprz, młoda kapusta podsmażana na maśle, pomidor malinowy";
       
    }
}