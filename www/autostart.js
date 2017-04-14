var exec = require('cordova/exec');

module.exports = {
    enable: function (bool, success, fail) {
        exec(success, fail, 'Autostart', 'enable', [bool]);
    },
    state: function (success, fail) {
        exec(function (state) {
            success && success(state == 1 || state == 0);
        }, fail, 'Autostart', 'state', null);
    }
}
