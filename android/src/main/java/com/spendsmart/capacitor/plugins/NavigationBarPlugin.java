package com.spendsmart.capacitor.plugins;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.graphics.Color;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginMethod;

@CapacitorPlugin(name = "NavigationBar")
public class NavigationBarPlugin extends Plugin {

    @PluginMethod
    public void setColor(PluginCall call) {
        String colorHex = call.getString("color"); // ex: "#FF0000"
        Boolean lightButtons = call.getBoolean("lightButtons", false);

        Activity activity = getActivity();
        if (activity == null) {
            call.reject("Activity not found");
            return;
        }

        Window window = activity.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                // Muda a cor do rodapé
                window.setNavigationBarColor(Color.parseColor(colorHex));

                // Muda a cor dos botões de navegação
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    final int appearance = lightButtons ?
                            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS : 0;
                    window.getInsetsController().setSystemBarsAppearance(
                            appearance,
                            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                    );
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    int flags = window.getDecorView().getSystemUiVisibility();
                    if (lightButtons) {
                        flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                    } else {
                        flags &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                    }
                    window.getDecorView().setSystemUiVisibility(flags);
                }

                call.resolve();
            } catch (Exception e) {
                call.reject("Failed to set navigation bar color: " + e.getMessage());
            }
        } else {
            call.reject("Android version not supported");
        }
    }
}
