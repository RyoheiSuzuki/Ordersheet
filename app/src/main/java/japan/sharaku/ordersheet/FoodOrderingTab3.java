/*
 * Copyright (C) 2018 Sharaku Japan Inc.
 * Create Date: 2018/1/21
 * Author: Ryohei Suzuki
 */

package japan.sharaku.ordersheet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;


public class FoodOrderingTab3 extends Fragment implements View.OnClickListener {
    /*
     ****************************
     * Declare Variables
     ****************************
     */
    private int min_value = 0;
    private int max_value = 10;
    private NumberPicker Gyoza5_NumberPicker;
    private NumberPicker Karaage5_NumberPicker;
    private NumberPicker YasaiItame_NumberPicker;
    private NumberPicker Charhan_NumberPicker;
    private NumberPicker CharhanMini_NumberPicker;
    private NumberPicker CharSiuDon_NumberPicker;
    private NumberPicker MentaiDon_NumberPicker;
    private NumberPicker ShiroGohan_NumberPicker;
    private Button Gyoza5_Button;
    private Button Karaage5_Button;
    private Button YasaiItame_Button;
    private Button Charhan_Button;
    private Button CharhanMini_Button;
    private Button CharSiuDon_Button;
    private Button MentaiDon_Button;
    private Button ShiroGohan_Button;

    /*
     ****************************
     * Declare Classes
     ****************************
     */
    private FoodIconSettings foodSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_food_ordering_tab3,
                container, false);

        /*
         * Set NumberPicker
         */
        Gyoza5_NumberPicker = (NumberPicker) v.findViewById(R.id.Gyoza5_NumberPicker);
        Gyoza5_NumberPicker.setMinValue(min_value);
        Gyoza5_NumberPicker.setMaxValue(max_value);
        Karaage5_NumberPicker = (NumberPicker) v.findViewById(R.id.Karaage5_NumberPicker);
        Karaage5_NumberPicker.setMinValue(min_value);
        Karaage5_NumberPicker.setMaxValue(max_value);
        YasaiItame_NumberPicker = (NumberPicker) v.findViewById(R.id.YasaiItame_NumberPicker);
        YasaiItame_NumberPicker.setMinValue(min_value);
        YasaiItame_NumberPicker.setMaxValue(max_value);
        Charhan_NumberPicker = (NumberPicker) v.findViewById(R.id.Charhan_NumberPicker);
        Charhan_NumberPicker.setMinValue(min_value);
        Charhan_NumberPicker.setMaxValue(max_value);
        CharhanMini_NumberPicker = (NumberPicker) v.findViewById(R.id.CharhanMini_NumberPicker);
        CharhanMini_NumberPicker.setMinValue(min_value);
        CharhanMini_NumberPicker.setMaxValue(max_value);
        CharSiuDon_NumberPicker = (NumberPicker) v.findViewById(R.id.CharSiuDon_NumberPicker);
        CharSiuDon_NumberPicker.setMinValue(min_value);
        CharSiuDon_NumberPicker.setMaxValue(max_value);
        MentaiDon_NumberPicker = (NumberPicker) v.findViewById(R.id.MentaiDon_NumberPicker);
        MentaiDon_NumberPicker.setMinValue(min_value);
        MentaiDon_NumberPicker.setMaxValue(max_value);
        ShiroGohan_NumberPicker = (NumberPicker) v.findViewById(R.id.ShiroGohan_NumberPicker);
        ShiroGohan_NumberPicker.setMinValue(min_value);
        ShiroGohan_NumberPicker.setMaxValue(max_value);

        /*
         * Set Button
         */
        Gyoza5_Button = (Button) v.findViewById(R.id.btGyoza5);
        Karaage5_Button = (Button) v.findViewById(R.id.btKaraage5);
        YasaiItame_Button = (Button) v.findViewById(R.id.btYasaiItame);
        Charhan_Button = (Button) v.findViewById(R.id.btCharhan);
        CharhanMini_Button = (Button) v.findViewById(R.id.btCharhanMini);
        CharSiuDon_Button = (Button) v.findViewById(R.id.btCharSiuDon);
        MentaiDon_Button = (Button) v.findViewById(R.id.btMentaiDon);
        ShiroGohan_Button = (Button) v.findViewById(R.id.btShiroGohan);

        /*
         * Call MainActivity
         */
        foodSettings = MainActivity.getFoodSettings();
        if (foodSettings != null) {

        }
        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        }
    }

}
