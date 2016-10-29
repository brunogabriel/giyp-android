package com.giyp.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.giyp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

/**
 * Created by brunogabriel on 24/10/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BASE_ACTIVITY";

    public void setupToolbar(Toolbar toolbar, String title, boolean isDisplayHomeAsUpEnabled) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isDisplayHomeAsUpEnabled);
            applyTypefaceOnTitle(toolbar, title);
        }
    }

    public void applyColorOnStatusBar(int colorCode) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(colorCode));
            } catch (Exception ex) {
                Log.e(TAG, "Fail to apply status bar color: " + ex.getMessage());
            }

        }
    }

    public void applyToolbarColors(Toolbar toolbar, int toolbarColor, int statusBarColor) {

        try {
            applyColorOnStatusBar(statusBarColor);
        } catch (Exception ex) {
            Log.e(TAG, "Fail to apply toolbar colors");
        }
        if (toolbar != null) {
            toolbar.setBackgroundColor(getResources().getColor(toolbarColor));
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
