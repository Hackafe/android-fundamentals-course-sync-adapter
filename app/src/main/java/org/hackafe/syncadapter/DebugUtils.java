package org.hackafe.syncadapter;

import android.os.Bundle;

/**
 * Created by groupsky on 24.06.15.
 */
public class DebugUtils {

    public static String toString(Bundle bundle) {
        String text = "";
        if (bundle != null) {
            for (String key: bundle.keySet()) {
                text += ", "+key+"="+bundle.get(key);
            }
            text = "{"+bundle+"}";
        } else {
            text = "null";
        }
        return text;
    }

}
