// Referensi ubah warna http://www.gadgetsaint.com/tips/change-statusbar-color-android/#.XOC8RXUzbeQ
package com.submission.picodiploma.moviecatalogue;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;

public class MyColorUtility {
    public static void darkenStatusBar(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(
                    darkenColor(
                            ContextCompat.getColor(activity, color)
                    )
            );
        }
    }

    public static void darkenNavigationBar(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(
                    darkenColor(
                            ContextCompat.getColor(activity, color)
                    )
            );
        }
    }

    private static int darkenColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }
}
