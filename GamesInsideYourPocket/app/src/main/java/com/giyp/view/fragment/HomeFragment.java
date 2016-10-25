package com.giyp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giyp.R;

/**
 * Created by brunogabriel on 25/10/16.
 */

public class HomeFragment extends Fragment {

    protected View mRootView;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, null, false);
        return mRootView;
    }
}
