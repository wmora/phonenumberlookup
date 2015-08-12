package com.mercadolibre.phonenumberlookup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);

        phoneNumber.setText(getString(R.string.phone_number, getLineNumber()));
    }

    public String getLineNumber() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String lineNumber = telephonyManager.getLine1Number();

        return lineNumber != null && !lineNumber.isEmpty() ? lineNumber: "unavailable :(";
    }
}
