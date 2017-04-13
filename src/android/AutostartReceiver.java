package com.aaronrzh.cordova.plugin.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutostartReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        // if (intent.getAction().equals(ACTION)) {
        //     Intent mainActivityIntent = new Intent(context, MainActivity.class);
        //     mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //     context.startActivity(mainActivityIntent);
        // }
    }
}
