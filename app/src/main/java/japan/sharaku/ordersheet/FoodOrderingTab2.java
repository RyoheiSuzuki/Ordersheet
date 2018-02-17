/*
 * Copyright (C) 2018 Sharaku Japan Inc.
 * Create Date: 2018/1/21
 * Author: Ryohei Suzuki
 */

package japan.sharaku.ordersheet;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;


public class FoodOrderingTab2 extends Fragment implements View.OnClickListener {
    /*
     ****************************
     * Declare Variables
     ****************************
     */
    private CheckBox cbCharSiu;
    private CheckBox cbAjitama;
    private CheckBox cbNori;
    private CheckBox cbAonegi;
    private CheckBox cbMoyashi;
    private CheckBox cbKikurage;
    private CheckBox cbMenma;
    private CheckBox cbKaedamaBefore;
    private CheckBox cbKaedamaAfter;
    private NumberPicker CharSiu_NumberPicker;
    private TextView CharSiu_Number_TexiView;

    /*
     ****************************
     * Declare Classes
     ****************************
     */
    private FoodIconSettings foodSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_food_ordering_tab2,
                container, false);

        CharSiu_NumberPicker = (NumberPicker) v.findViewById(R.id.CharSiu_NumberPicker);
        CharSiu_NumberPicker.setMinValue(0);
        CharSiu_NumberPicker.setMaxValue(100);
        //CharSiu_NumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
        //    @Override
        //    public void onValueChange(NumberPicker picker, int oldVal, int newVal){
        //        CharSiu_Number_TexiView.setText("Selected Value is: " + newVal);
        //    }
        //});

        foodSettings = MainActivity.getFoodSettings();
        if (foodSettings != null) {

        }
        return v;
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((CheckBox) v).isChecked();

        switch(v.getId()) {
        }
    }

}
