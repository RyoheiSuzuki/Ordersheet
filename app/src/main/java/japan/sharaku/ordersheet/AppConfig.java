/*
 * Copyright (C) 2015-2016 The Food Restriction Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package japan.sharaku.ordersheet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

public class AppConfig extends Fragment implements View.OnClickListener  {

    private AppSettings appSettings;
    private CheckBox cbMakeItSerious;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_app_settings,
                container, false);

        appSettings = MainActivity.getAppSettings();

        cbMakeItSerious = (CheckBox) v.findViewById(R.id.cb_settings_serious_mode);
        CheckBox cbShowDialog = (CheckBox) v.findViewById(R.id.cb_settings_help_dialog);

        cbMakeItSerious.setChecked(appSettings.isSeriosMode());
        cbShowDialog.setChecked(appSettings.isHelpDialog());

        cbMakeItSerious.setOnClickListener(this);
        cbShowDialog.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.cb_settings_serious_mode:
                appSettings.setSeriosMode(checked);
                if (cbMakeItSerious.isChecked()) {
                    Toast.makeText(
                            view.getContext(),
                            getResources()
                                    .getString(R.string.serious_mode_on_msg),
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(
                            view.getContext(),
                            getResources()
                                    .getString(R.string.serious_mode_off_msg),
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cb_settings_help_dialog:
                appSettings.setHelpDialog(checked);
                break;
        }
    }
}
