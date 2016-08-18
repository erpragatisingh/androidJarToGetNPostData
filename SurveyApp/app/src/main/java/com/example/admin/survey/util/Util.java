package com.example.admin.survey.util;

import android.widget.TextView;

/**
 * Created by pragati on 8/18/16.
 */
public class Util {


    public static final void nullCheckData(final String val, final TextView textView) {
        if (null != val && null != textView) {
            textView.setText(val);
        }
    }
}
