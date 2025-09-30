package com.spendsmart.capacitor.plugins;

import com.getcapacitor.Logger;

public class NavigationBar {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }
}
