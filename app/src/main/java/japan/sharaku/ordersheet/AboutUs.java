/*
 * Copyright (C) 2018 Sharaku Japan Inc.
 * Create Date: 2018/1/21
 * Author: Ryohei Suzuki
 */

package japan.sharaku.ordersheet;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AboutUs extends Fragment implements View.OnClickListener {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_about_us,
                container, false);

        TextView appVersion = (TextView) v.findViewById(R.id.tvVersion);
        Button btChangelog = (Button) v.findViewById(R.id.about_us_bt_changelog);
        WebView webViewCredits = (WebView) v.findViewById(R.id.webViewCredits);

        btChangelog.setOnClickListener(this);

        webViewCredits.loadUrl("file:///android_asset/credential.html");

        int versionCode = BuildConfig.VERSION_CODE;

        appVersion.setText("build " + versionCode);

        return v;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.about_us_bt_changelog:
                try {
                    InputStream changelogIS = view.getResources().getAssets().open("update_history.txt");
                    String s = readTextFile(changelogIS);

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage(s);
                    builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toString();
    }
}
