package com.giyp.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

/**
 * Created by brunogabriel on 24/10/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void setupToolbar(Toolbar toolbar, String title, boolean isDisplayHomeAsUpEnabled) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isDisplayHomeAsUpEnabled);
            applyTypefaceOnTitle(toolbar, title);
        }
    }

    private void applyTypefaceOnTitle(Toolbar toolbar, String title) {
        try {
            for (int i = 0; i < toolbar.getChildCount(); ++i) {
                View child = toolbar.getChildAt(i);
                if (child instanceof TextView) {
                    Typeface mTypeface = TypefaceUtils.load(getAssets(), "fonts/Roboto/Roboto-Bold.ttf");
                    if (((TextView) child).getText().toString().equalsIgnoreCase(title)) {
                        CalligraphyUtils.applyFontToTextView((TextView)child, mTypeface);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Log.e("BaseActivity", "Fail to apply typeface on toolbar");
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
