package edu.itesa.adamaris.android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {

    private static final String LOG_TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1000);
            finish();
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Unexpected "+ e.toString() + "Error : ");
            Log.e(LOG_TAG, e.getMessage());
        }

    }

}
