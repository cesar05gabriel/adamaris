package edu.itesa.adamaris.android.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import edu.itesa.adamaris.android.GooglePlusSignIn.GooglePlusAuthentication;
import edu.itesa.adamaris.android.R;
import edu.itesa.adamaris.android.fragments.SignInFragment;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import android.view.View.OnClickListener;

public class SignInActivity extends ActionBarActivity implements ConnectionCallbacks,
        OnConnectionFailedListener, OnClickListener{

    GooglePlusAuthentication googlePlusAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new SignInFragment())
                    .commit();
        }

        googlePlusAuthentication =
                new GooglePlusAuthentication(this,
                this,
                this);

    }

    protected void onStart() {
        super.onStart();
        googlePlusAuthentication.connect();
    }

    protected void onStop() {
        super.onStop();
        googlePlusAuthentication.disconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                // Signin button clicked
                googlePlusAuthentication.logIn(this);
                break;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        googlePlusAuthentication.onConnected(bundle);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConnectionSuspended(int i) {
        googlePlusAuthentication.connect();
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        googlePlusAuthentication.onConnectionFailed(connectionResult, this);
    }
}
