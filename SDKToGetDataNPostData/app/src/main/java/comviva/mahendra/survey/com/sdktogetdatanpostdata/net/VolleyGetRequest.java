package comviva.mahendra.survey.com.sdktogetdatanpostdata.net;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.controller.AppController;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.MCLog;
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
 *  this is class for HTTPS get request
 *
 */
public final class VolleyGetRequest {

    public static final void getRequestVolley(final Activity ctx,final String url,final int requestCode){
        final VolleyInterface vi = (VolleyInterface) ctx;

        vi.requestStarted(requestCode);
        MCLog.d("URL is::" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        MCLog.i(response);
                        vi.requestCompleted(response, requestCode);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                MCLog.i(error.getLocalizedMessage());
                vi.requestEndedWithError(error, requestCode);
            }
        });
         AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
