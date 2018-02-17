/*
 * Copyright (C) 2018 Sharaku Japan Inc.
 * Create Date: 2018/1/21
 * Author: Ryohei Suzuki
 */

package japan.sharaku.ordersheet;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class FoodIconSettings {

    private static FoodIconSettings settings;
    private SharedPreferences.Editor edit = null;

    private final String FOOD_SETTINGS_HAKATA_RAMEN = "br.mochiladepano.settings.food.ramen.hakata_ramen";
    private final String FOOD_SETTINGS_SHIO_RAMEN = "br.mochiladepano.settings.food.shio_ramen";
    private final String FOOD_SETTINGS_KURO_RAMEN = "br.mochiladepano.settings.food.kuro_ramen";
    private final String FOOD_SETTINGS_AKA_RAMEN = "br.mochiladepano.settings.food.aka_ramen";
    private final String FOOD_SETTINGS_TOKUMORI_RAMEN = "br.mochiladepano.settings.food.tokumori_ramen";
    private final String FOOD_SETTINGS_CHARSIU = "br.mochiladepano.settings.food.topping.char_siu";
    private final String FOOD_SETTINGS_AJITAMA = "br.mochiladepano.settings.food.topping.ajitama";
    private boolean hakataRamen;
    private boolean shioRamen;
    private boolean kuroRamen;
    private boolean akaRamen;
    private boolean tokumoriRamen;
    private boolean charSiu;
    private boolean ajitama;

    private final String FOOD_SETTINGS_DONTEAT_COW = "br.mochiladepano.settings.food.donteat.cow";
    private final String FOOD_SETTINGS_ALLERGIC_COW = "br.mochiladepano.settings.food.allergic.cow";
    private boolean dontEatCow;
    private boolean allergicCow;

    private FoodIconSettings(Context ctx) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);

        if (sharedPref != null) {
            this.hakataRamen = sharedPref.getBoolean(FOOD_SETTINGS_HAKATA_RAMEN, false);
            this.shioRamen = sharedPref.getBoolean(FOOD_SETTINGS_SHIO_RAMEN, false);
            this.kuroRamen = sharedPref.getBoolean(FOOD_SETTINGS_KURO_RAMEN, false);
            this.akaRamen = sharedPref.getBoolean(FOOD_SETTINGS_AKA_RAMEN, false);
            this.tokumoriRamen = sharedPref.getBoolean(FOOD_SETTINGS_TOKUMORI_RAMEN, false);
            this.charSiu = sharedPref.getBoolean(FOOD_SETTINGS_CHARSIU, false);
            this.ajitama = sharedPref.getBoolean(FOOD_SETTINGS_AJITAMA, false);
        }

        if (sharedPref != null) {
            edit = sharedPref.edit();
            if (edit != null) {
                edit.apply();
            }
        }
    }

    public static FoodIconSettings getFoodIconSettings(Context ctx) {
        if (settings == null) {
            settings = new FoodIconSettings(ctx);
        }
        return settings;
    }

    public boolean isHakataRamen() {return hakataRamen;}
    public void setHakataRamen(boolean hakataRamen){
        edit.putBoolean(FOOD_SETTINGS_HAKATA_RAMEN, hakataRamen);
        edit.commit();
        this.hakataRamen = hakataRamen;
    }

    public boolean isShioRamen() {return shioRamen;}
    public void setShioRamen(boolean shioRamen){
        edit.putBoolean(FOOD_SETTINGS_SHIO_RAMEN, shioRamen);
        edit.commit();
        this.shioRamen = shioRamen;
    }

    public boolean isKuroRamen() {return kuroRamen;}
    public void setKuroRamen(boolean kuroRamen){
        edit.putBoolean(FOOD_SETTINGS_KURO_RAMEN, kuroRamen);
        edit.commit();
        this.kuroRamen = kuroRamen;
    }

    public boolean isAkaRamen() {return akaRamen;}
    public void setAkaRamen(boolean akaRamen){
        edit.putBoolean(FOOD_SETTINGS_AKA_RAMEN, akaRamen);
        edit.commit();
        this.akaRamen = akaRamen;
    }

    public boolean isTokumoriRamen() {return tokumoriRamen;}
    public void setTokumoriRamen(boolean tokumoriRamen){
        edit.putBoolean(FOOD_SETTINGS_TOKUMORI_RAMEN, tokumoriRamen);
        edit.commit();
        this.tokumoriRamen = tokumoriRamen;
    }

    public boolean isCharSiu() {return charSiu;}
    public void setCharSiu(boolean charSiu){
        edit.putBoolean(FOOD_SETTINGS_CHARSIU, charSiu);
        edit.commit();
        this.charSiu = charSiu;
    }

    public boolean isAjitama() {return ajitama;}
    public void setAjitama(boolean ajitama){
        edit.putBoolean(FOOD_SETTINGS_AJITAMA, ajitama);
        edit.commit();
        this.ajitama = ajitama;
    }
}
