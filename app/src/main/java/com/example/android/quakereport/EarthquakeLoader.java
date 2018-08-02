package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.AsyncTaskLoader;
import java.util.List;

/**
 * Created by vanessawanner on 31.07.18.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
                List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }
}