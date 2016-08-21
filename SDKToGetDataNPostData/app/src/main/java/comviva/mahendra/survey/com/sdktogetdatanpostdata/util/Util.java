package comviva.mahendra.survey.com.sdktogetdatanpostdata.util;

import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
/* @author
	 ____                        _   _   ____  _             _
	|  _ \ _ __ __ _  __ _  __ _| |_(_) / ___|(_)_ __   __ _| |__
	| |_) | '__/ _` |/ _` |/ _` | __| | \___ \| | '_ \ / _` | '_ \
	|  __/| | | (_| | (_| | (_| | |_| |  ___) | | | | | (_| | | | |
	|_|   |_|  \__,_|\__, |\__,_|\__|_| |____/|_|_| |_|\__, |_| |_|
                     |___/                             |___/
 *
 *  Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Created by pragati on 8/18/16.
 */
public class Util {


    public static final void nullCheckData(final String val, final TextView textView) {
        if (null != val && null != textView) {
            textView.setText(val);
        }
    }

     public static final void setViewPropertys(final TextView view, final Object tag, final float fontSize,final boolean capslatter, final Typeface tf,final LinearLayout rootView){

         if(null!=view && null!=rootView) {

            final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);
            view.setTag(tag);
            view.setTextSize(fontSize);
            view.setAllCaps(capslatter);
            view.setTypeface(tf);
            view.setPadding(0,30,0,30);
            rootView.addView(view);
        }
    }
}
