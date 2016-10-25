package com.giyp.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by brunogabriel on 24/10/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void setupToolbar(Toolbar toolbar, String title, boolean isDisplayHomeAsUpEnabled) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isDisplayHomeAsUpEnabled);
        }
    }
}
