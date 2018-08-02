package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;


import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by vanessawanner on 19.07.18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter (Context context, ArrayList<Earthquake> earthquakes) {
        super(context,0, earthquakes);

    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);


        }


        Earthquake currentEarthquake = getItem(position);

        Double rawmagnitude = currentEarthquake.getMagnitude();
        String finalmagnitude = formatMagnitude(rawmagnitude);
        TextView MagTextView = (TextView) listItemView.findViewById(R.id.tvmagnitude);
        MagTextView.setText(finalmagnitude);


        String wholelocation = currentEarthquake.getLocation();

        if (wholelocation.contains(",")) {

            String[] parts = wholelocation.split("of ");
            String offset = parts[0] + "of";
            String main = parts[1];

            TextView LocTextView1 = (TextView) listItemView.findViewById(R.id.tvOffsetLocation);
            LocTextView1.setText(offset);

            TextView LocTextView2 = (TextView) listItemView.findViewById(R.id.tvPrLocation);
            LocTextView2.setText(main);

        }
        else {
            String offset = "Near of";
            String main = wholelocation;

            TextView LocTextView1 = (TextView) listItemView.findViewById(R.id.tvOffsetLocation);
            LocTextView1.setText(offset);

            TextView LocTextView2 = (TextView) listItemView.findViewById(R.id.tvPrLocation);
            LocTextView2.setText(main);
        }


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeinmilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.tvDate);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.tvtime);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        return listItemView;

    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

}
