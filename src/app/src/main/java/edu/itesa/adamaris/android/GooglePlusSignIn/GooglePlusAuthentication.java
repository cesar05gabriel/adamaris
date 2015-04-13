package edu.itesa.adamaris.android.GooglePlusSignIn;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

/**
 * Created by Kelfi on 4/9/2015.
 */
public class GooglePlusAuthentication implements ConnectionCallbacks,
        OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 0;
    // Logcat tag
    private static final String TAG = "MainActivity";
    private GoogleApiClient mGoogleApiClient;
    private boolean mIntentInProgress;
    private boolean mSignInClicked;
    private ConnectionResult mConnectionResult;

    public GooglePlusAuthentication (Context context, ConnectionCallbacks connectionCallbacks,
                                    OnConnectionFailedListener onConnectionFailedListener)
    {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(connectionCallbacks)
                .addOnConnectionFailedListener(onConnectionFailedListener).addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN).build();
    }

    public void logIn (Activity activity)
    {
        if (!mGoogleApiClient.isConnecting()) {
            mSignInClicked = true;
            resolveSignInError(activity);
        }
    }
    public void logOff ()
    {
        if (mGoogleApiClient.isConnected()) {
            Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
            mGoogleApiClient.disconnect();
            mGoogleApiClient.connect();
        }
    }

    public void connect ()
    {
        if(!mGoogleApiClient.isConnected())
        {
            mGoogleApiClient.connect();
        }
    }

    public void disconnect()
    {
        if(mGoogleApiClient.isConnected())
        {
            mGoogleApiClient.disconnect();
        }
    }

    private void resolveSignInError(Activity activity) {
        if (mConnectionResult.hasResolution()) {
            try {
                mIntentInProgress = true;
                mConnectionResult.startResolutionForResult(activity, RC_SIGN_IN);
            } catch (SendIntentException e) {
                mIntentInProgress = false;
                mGoogleApiClient.connect();
            }
        }
    }

    public void onConnected(Bundle bundle) {
        mSignInClicked = false;
    }

    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void onConnectionFailed(ConnectionResult connectionResult, Activity activity) {
        if (!connectionResult.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(connectionResult.getErrorCode(),
                    activity,
                    0)
                    .show();
            return;
        }

        if (!mIntentInProgress) {
            // Store the ConnectionResult for later usage
            mConnectionResult = connectionResult;

            if (mSignInClicked) {
                // The user has already clicked 'sign-in' so we attempt to
                // resolve all
                // errors until the user is signed in, or they cancel.
                resolveSignInError(activity);
            }
        }
    }

}
