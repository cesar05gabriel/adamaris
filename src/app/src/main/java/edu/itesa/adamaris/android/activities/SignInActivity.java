package edu.itesa.adamaris.android.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import edu.itesa.adamaris.android.R;
import edu.itesa.adamaris.android.fragments.SignInFragment;

public class SignInActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new SignInFragment())
                    .commit();
        }
    }


}
