package com.aaronrzh.cordova.plugin.autostart;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

import android.app.Activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.ComponentName;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.json.JSONException;

import android.util.Log;

public class AutostartPlugin extends CordovaPlugin {
    private static final String LOG_TAG = "AutostartPlugin";

    public AutostartPlugin() {
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        if (action.equalsIgnoreCase("enable")) {
            Log.d(LOG_TAG, "set enable: " + args.get(0).toString());
            setEnable(args.getBoolean(0));
            callbackContext.success("OK");
        } else if (action.equalsIgnoreCase("state")) {
            callbackContext.success(isEnabled());
        }
        return true;
    }

    private void setEnable(boolean enable) {
        int state = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        if (enable) {
            state = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        }
        Context context = cordova.getActivity().getApplicationContext();
        ComponentName autostartReceiver = new ComponentName(context, AutostartReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(autostartReceiver, state, PackageManager.DONT_KILL_APP);
    }

    private int isEnabled() {
        Context context = cordova.getActivity().getApplicationContext();
        ComponentName autostartReceiver = new ComponentName(context, AutostartReceiver.class);
        PackageManager pm = context.getPackageManager();
        int state = pm.getComponentEnabledSetting(autostartReceiver);
        return state;
    }
}
