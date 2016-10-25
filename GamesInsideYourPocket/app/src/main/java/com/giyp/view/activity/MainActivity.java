package com.giyp.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.giyp.R;
import com.giyp.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by brunogabriel on 24/10/16.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar(toolbar, "Home", false);
    }
}
