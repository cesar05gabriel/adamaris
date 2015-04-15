package edu.itesa.adamaris.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import edu.itesa.adamaris.android.MainActivity;
import edu.itesa.adamaris.android.R;

public class SplashActivity extends Activity {

    private static final String LOG_TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1000);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Unexpected "+ e.toString() + "Error : ");
            Log.e(LOG_TAG, e.getMessage());
        }

    }

}
