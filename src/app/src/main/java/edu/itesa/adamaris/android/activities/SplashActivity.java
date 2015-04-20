package edu.itesa.adamaris.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import edu.itesa.adamaris.android.GooglePlusSignIn.GooglePlusAuthentication;
import edu.itesa.adamaris.android.MainActivity;
import edu.itesa.adamaris.android.R;

public class SplashActivity extends Activity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{

    private static final String LOG_TAG = "SplashActivity";
    GooglePlusAuthentication googlePlusAuthentication;

    @Override
    protected void onStart()
    {
        super.onStart();
        googlePlusAuthentication.connect();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1000);
            googlePlusAuthentication = new GooglePlusAuthentication(this,
                    this,
                    this);
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Unexpected "+ e.toString() + "Error : ");
            Log.e(LOG_TAG, e.getMessage());
        }

    }

    private void startActivity(boolean bool)
    {
        if(bool)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            setContentView(R.layout.activity_main);
        }
        else
        {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        startActivity(true);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        startActivity(false);
    }
}
