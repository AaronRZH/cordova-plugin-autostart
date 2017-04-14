# __Autostart plugin__
---
This plugin will automatically start your app after the every boot. You can enable or disable the autostart function in your app.

## Supported Platforms
---
* Android

## Usage
---
Enable the automatic startup after the boot

    cordova.plugins.autoStart.enable(true, successCB(enable: boolean): Function, failCB: Function);

Disable the automatic startup after the boot

    cordova.plugins.autoStart.enable(false, successCB(enable: boolean): Function, failCB: Function]);

GET the state of this plugin

    cordova.plugins.autoStart.state(successCB(enabled: boolean): Function, failCB: Function);

## License    
This software is released under the Apache 2.0 License.  
© 2015 Toni Korin
