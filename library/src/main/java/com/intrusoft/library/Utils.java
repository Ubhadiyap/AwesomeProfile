package com.intrusoft.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.util.TypedValue;

/**
 * Created by kaushal on 10/12/16.
 */
class Utils {
    final static int DEFAULT_TINT = Color.BLACK;
    final static int DEFAULT_ALPHA = 50;
    final static String TAG_IMAGE = "FrissonView";
    final static int TIDE_COUNT = 3;
    final static int TIDE_HEIGHT_DP = 30;

    static int getPixelForDp(Context context, int displayPixels) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, displayPixels, context.getResources().getDisplayMetrics());
    }

    static Path getWavePath(float width, float height, float amplitude, float shift, float divide) {
        Path path = new Path();
        float quadrant = height - amplitude;
        float x, y;
        path.moveTo(0, 0);
        path.lineTo(0, quadrant);
        for (int i = 0; i < width + 10; i = i + 10) {
            x = (float) i;
            y = quadrant + amplitude * (float) Math.sin(((i + 10) * Math.PI / 180) / divide + shift);
            path.lineTo(x, y);
        }
        path.lineTo(width, 0);
        path.close();
        return path;
    }
}
