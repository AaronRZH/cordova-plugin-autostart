package com.aaronrzh.cordova.plugin.autostart;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

import android.content.Context;

public class AutostartPlugin extends CordovaPlugin {
    private static final String LOG_TAG = "AutostartPlugin";

    public AutostartPlugin() {
    }

    @override
    protected void pluginInitialize() {
        LOG.w(LOG_TAG, cordova.getActivity().getLocalClassName());
    }
}
