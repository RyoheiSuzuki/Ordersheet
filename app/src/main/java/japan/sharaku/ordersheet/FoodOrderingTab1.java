/*
 * Copyright (C) 2018 Sharaku Japan Inc.
 * Create Date: 2018/1/21
 * Author: Ryohei Suzuki
 */

package japan.sharaku.ordersheet;

import android.content.Context;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


public class FoodOrderingTab1 extends Fragment implements View.OnClickListener {
    /*
     ****************************
     * Declare Variables
     ****************************
     */
    private TextView Label_SeatNumber;
    private TextView txtSeatNumber;
    private TextView Label_CustomerName;
    private TextView txtCustomerName;

    private TextView HeaderText_Ramen;
    private TextView HakataRamen_Name;
    private TextView HakataRamen_;
    private TextView ShioRamen_Name;
    private TextView ShioRamen_Description;
    private TextView KuroRamen_Name;
    private TextView KuroRamen_Description;
    private TextView AkaRamen_Name;
    private TextView AkaRamen_Description;
    private CheckBox cbHakataRamen;
    private CheckBox cbShioRamen;
    private CheckBox cbKuroRamen;
    private CheckBox cbAkaRamen;
    private CheckBox cbTokumoriRamen;
    private Button btHakataRamen;
    private Button btShioRamen;
    private Button btKuroRamen;
    private Button btAkaRamen;
    private Button btTokumoriRamen;

    /*
     ****************************
     * Declare Classes
     ****************************
     */
    private FoodIconSettings foodSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_food_ordering_tab1,
                container, false);

        // Popup Buttons
        btHakataRamen = (Button)v.findViewById(R.id.btHakataRamen);
        btHakataRamen.setOnClickListener(this);
        btShioRamen = (Button)v.findViewById(R.id.btShioRamen);
        btShioRamen.setOnClickListener(this);
        btKuroRamen = (Button)v.findViewById(R.id.btKuroRamen);
        btKuroRamen.setOnClickListener(this);
        btAkaRamen = (Button)v.findViewById(R.id.btAkaRamen);
        btAkaRamen.setOnClickListener(this);
        btTokumoriRamen = (Button)v.findViewById(R.id.btTokumoriRamen);
        btTokumoriRamen.setOnClickListener(this);

        // Image and CheckBox
        foodSettings = MainActivity.getFoodSettings();
        if (foodSettings != null) {

            // Set Fields Properties
            cbHakataRamen = (CheckBox) v.findViewById(R.id.cbHakataRamen);
            cbHakataRamen.setOnClickListener(this);
            cbShioRamen = (CheckBox) v.findViewById(R.id.cbShioRamen);
            cbShioRamen.setOnClickListener(this);
            cbKuroRamen = (CheckBox) v.findViewById(R.id.cbKuroRamen);
            cbKuroRamen.setOnClickListener(this);
            cbAkaRamen = (CheckBox) v.findViewById(R.id.cbAkaRamen);
            cbAkaRamen.setOnClickListener(this);
            cbTokumoriRamen = (CheckBox) v.findViewById(R.id.cbTokumoriRamen);
            cbTokumoriRamen.setOnClickListener(this);

            // Set ClickListeners
            cbHakataRamen.setChecked(foodSettings.isHakataRamen());
            cbHakataRamen.setOnClickListener(this);
            cbShioRamen.setChecked(foodSettings.isShioRamen());
            cbShioRamen.setOnClickListener(this);
            cbKuroRamen.setChecked(foodSettings.isKuroRamen());
            cbKuroRamen.setOnClickListener(this);
            cbAkaRamen.setChecked(foodSettings.isAkaRamen());
            cbAkaRamen.setOnClickListener(this);
            cbTokumoriRamen.setChecked(foodSettings.isTokumoriRamen());
            cbTokumoriRamen.setOnClickListener(this);

            View.OnClickListener imageOnClickListener =
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = "";
                            switch(v.getId()) {
                                case R.id.ivHakataRamen:
                                    name = getResources().getString(R.string.hakata_ramen_name)
                                            + " / "
                                            + getResources().getString(R.string.hakata_ramen_description);
                                    break;
                                case R.id.ivShioRamen:
                                    name = getResources().getString(R.string.shio_ramen_name)
                                            + " / "
                                            + getResources().getString(R.string.shio_ramen_description);
                                    break;
                                case R.id.ivKuroRamen:
                                    name = getResources().getString(R.string.kuro_ramen_name)
                                            + " / "
                                            + getResources().getString(R.string.kuro_ramen_description);
                                    break;
                                case R.id.ivAkaRamen:
                                    name = getResources().getString(R.string.aka_ramen_name)
                                            + " / "
                                            + getResources().getString(R.string.aka_ramen_description);
                                    break;
                                case R.id.ivTokumoriRamen:
                                    name = getResources().getString(R.string.tokumori_ramen_name)
                                            + " / "
                                            + getResources().getString(R.string.tokumori_ramen_description);
                                default:
                                    break;
                            }

                            Snackbar.make(v, name, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    };

            ImageView ivHakataRamen = (ImageView) v.findViewById(R.id.ivHakataRamen);
            ImageView ivShioRamen = (ImageView) v.findViewById(R.id.ivShioRamen);
            ImageView ivKuroRamen = (ImageView) v.findViewById(R.id.ivKuroRamen);
            ImageView ivAkaRamen = (ImageView) v.findViewById(R.id.ivAkaRamen);
            ImageView ivTokumoriRamen = (ImageView) v.findViewById(R.id.ivTokumoriRamen);

            ivHakataRamen.setOnClickListener(imageOnClickListener);
            ivShioRamen.setOnClickListener(imageOnClickListener);
            ivKuroRamen.setOnClickListener(imageOnClickListener);
            ivAkaRamen.setOnClickListener(imageOnClickListener);
            ivTokumoriRamen.setOnClickListener(imageOnClickListener);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        boolean checked=false;
        //    checked = ((CheckBox) v).isChecked();

        switch(v.getId()) {
            case R.id.cbHakataRamen:
                //    cbHakataRamen.setChecked(checked);
                //    foodSettings.setHakataRamen(checked);
                //    if ((checked) && (cbHakataRamenMini.isChecked())) {
                //        cbHakataRamenMini.setChecked(false);
                //        foodSettings.setHakataRamenMini(false);
                //    }
                //    break;
                break;
            case R.id.btHakataRamen:
                break;
        }
    }

}
