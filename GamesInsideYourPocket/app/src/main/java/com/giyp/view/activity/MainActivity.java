package com.giyp.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.giyp.R;
import com.giyp.base.BaseActivity;
import com.giyp.view.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by brunogabriel on 24/10/16.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.drawer)
    protected DrawerLayout drawer;

    @BindView(R.id.navigation_view)
    protected NavigationView mNavigationView;

    protected ActionBarDrawerToggle mActionBarDrawerToggle;

    // Current Fragment
    protected Fragment mCurrentFragment;
    private int mLastClicked=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setupToolbar(toolbar, getString(R.string.navigation_item_home), false);
        setupNavigationDrawer();
    }

    private void setupNavigationDrawer() {
        mNavigationView.setNavigationItemSelectedListener(item -> {
            int mClickedId = item.getItemId();

            // Clicked to open the same
            if (mLastClicked == mClickedId) {
                drawer.closeDrawers();
                return true;
            }

            Fragment mNewFragment=null;
            switch (mClickedId) {
                case R.id.home:
                    mNewFragment = new HomeFragment();
                    applyToolbarColors(toolbar, R.color.colorMenuItem1, R.color.colorMenuItemDark1);
                    break;
                case R.id.consoles:
                    applyToolbarColors(toolbar, R.color.colorMenuItem2, R.color.colorMenuItemDark2);
                    mNewFragment = new HomeFragment();
                    break;
                case R.id.games:
                    applyToolbarColors(toolbar, R.color.colorMenuItem3, R.color.colorMenuItemDark3);
                    mNewFragment = new HomeFragment();
                    break;
                case R.id.favourites:
                    applyToolbarColors(toolbar, R.color.colorMenuItem4, R.color.colorMenuItemDark4);
                    mNewFragment = new HomeFragment();
                    break;
                case R.id.settings:
                    applyToolbarColors(toolbar, R.color.colorMenuItem5, R.color.colorMenuItemDark5);
                    mNewFragment = new HomeFragment();
                    break;
                default:
                    break;
            }

            if (mNewFragment != null) {
                mCurrentFragment = mNewFragment;
                mLastClicked = mClickedId;
                changeContentFragment(mNewFragment, item.getTitle().toString());
            }

            drawer.closeDrawers();
            return true;
        });

        // Disable colors on icons
        mNavigationView.setItemIconTintList(null);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };

        drawer.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        // Define first element
        mNavigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setTitle(mNavigationView.getMenu().getItem(0).getTitle());
        applyToolbarColors(toolbar, R.color.colorMenuItem1, R.color.colorMenuItemDark1);
    }

    private void changeContentFragment(Fragment mNextFragment, String mNextTitle) {
        if (mNextFragment!=null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_content, mNextFragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(mNextTitle);
        }
    }
}
