package edu.itesa.adamaris.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.SignInButton;

import edu.itesa.adamaris.android.R;


public class SignInFragment extends Fragment {

    public SignInFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        SignInButton button = (SignInButton) rootView.findViewById(R.id.sign_in_button);
        button.setSize(SignInButton.SIZE_WIDE);

        return rootView;
    }
}