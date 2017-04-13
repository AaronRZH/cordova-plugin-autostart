package com.aaronrzh.cordova.plugin.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.Exception;

public class AutostartReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "AutostartReceiver";
    private static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            PackageManager packageManager = context.getPackageManager();
            Intent newIntent = new Intent();
            try {
                newIntent = packageManager.getLaunchIntentForPackage(context.getPackageName());
                context.startActivity(newIntent);
            } catch (Exception e) {
                Log.i(LOG_TAG, e.toString());
            }
        }
    }
}
