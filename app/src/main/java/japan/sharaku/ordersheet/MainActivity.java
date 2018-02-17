/*
 * Copyright (C) 2018 Sharaku Japan Inc.
 * Create Date: 2018/1/21
 * Author: Ryohei Suzuki
 */
package japan.sharaku.ordersheet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
        {

    private static AppSettings settingsApp;
    private static FoodIconSettings settingsFood;
    private boolean showHelp = true;

    private FoodIconList foodIconList;

    public static AppSettings getAppSettings() {
        return settingsApp;
    }

    public static FoodIconSettings getFoodSettings() {
        return settingsFood;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        settingsApp = AppSettings.getSettingsApp(this);
        settingsFood = FoodIconSettings.getFoodIconSettings(this);
        foodIconList = new FoodIconList();

        if (showHelp) {
            if (settingsApp.isHelpDialog()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.help_title));
                builder.setMessage(getResources().getString(R.string.help_message));
                builder.setPositiveButton(getResources().getString(R.string.help_not_show), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        settingsApp.setHelpDialog(false);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
            showHelp = false;
        }

        int category_flg = 0;
        Fragment fragment = null;
        AppCompatActivity acactivity = null;

        try {
            if (checkConfig()) {
                category_flg = 1;
                fragment = FoodIconGrid.class.newInstance();
            } else {
                category_flg = 2;
                acactivity = FoodOrdering.class.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        switch (category_flg){
            case 0:
                break;
            case 1:
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;
            case 2:
                break;
        }
    }

            private boolean checkConfig() {
                if (foodIconList.getFoodRestrictionList(true).size() <= 0) {
                    Toast.makeText(
                            getApplicationContext(),
                            getResources()
                                    .getString(R.string.no_config_msg),
                            Toast.LENGTH_LONG).show();
                    return false;
                }
                return true;
            }

            @Override
            public void onBackPressed() {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    super.onBackPressed();
                }
            }

            @SuppressWarnings("StatementWithEmptyBody")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                int appFlg = 0;
                Fragment fragment = null;
                Class fragmentClass = null;

                switch (id) {
                    case R.id.nav_menu_reader:
                        /*
                         * Delete Suzuki
                        if (checkConfig()) {
                            fragmentClass = FoodIconGrid.class;
                        } else {
                            fragmentClass = FoodIconConfig.class;
                        }
                        break;
                          */

                    case R.id.nav_food_menu:
                        appFlg = 1;
                        fragmentClass = FoodOrdering.class;
                        break;
                        /*
                         * Delete Suzuki
                        if (checkConfig()) {
                            fragmentClass = FoodMessages.class;
                        } else {
                            fragmentClass = FoodIconConfig.class;
                        }
                        break;
                          */

                    case R.id.nav_order_sheet:
                        fragmentClass = MessageLanguageSelector.class;
                        break;

                    case R.id.nav_payment:
                        fragmentClass = MessageLanguageSelector.class;
                        break;

                    case R.id.nav_app_settings:
                        fragmentClass = AppConfig.class;
                        break;

                    case R.id.nav_about_us:
                        fragmentClass = AboutUs.class;
                        break;
                }

                if (fragmentClass != null && appFlg == 0) {
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                } else {
                    startActivity(new Intent(MainActivity.this, FoodOrdering.class));
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
