package com.example.msap3;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.example.msap3.ServiceRestart.ServiceBroadcastReceiver;

public class MainActivity extends Activity {
    Context mainContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        mainContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ServiceBroadcastReceiver.scheduleJob(getApplicationContext());
        } else {

            com.example.msap3.HelperLaunchServiceClass.launchService(getApplicationContext());
        }
        finish();
    }
}
