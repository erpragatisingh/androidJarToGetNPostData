/*
package comviva.mahendra.survey.com.sdktogetdatanpostdata.net;

import android.app.Activity;
import android.support.annotation.NonNull;


import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.concurrent.ConcurrentHashMap;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.appconstant.AppConstant;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.controller.AppController;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.MCLog;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.MCUtil;


*/
/**
 * Created by pragati on 8/18/16.
 *
 *   This is helper class for post request
 *//*

public final class VolleyHelper {


    public static  void postRequestVolley (final Activity ctx, String url, @NonNull final ConcurrentHashMap<String,String> params, final int requestCode){
        final VolleyInterface vi = (VolleyInterface) ctx;

        vi.requestStarted(requestCode);
        MCLog.d("URL is::" + url);

        params.put(AppConstant.APP_VERSIONT_TG, MCUtil.getApplicationVersionCode(ctx));
        params.put(AppConstant.APP_PLATFORM_TG, AppConstant.APP_PLATFORM);

        MCLog.d("PARAMS is::" + params.toString());

        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                vi.requestCompleted(response,requestCode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                vi.requestEndedWithError(error,requestCode);
            }
        })
        {
            @NonNull
            @Override
            protected ConcurrentHashMap<String,String> getParams(){
               return params;
            }

            @NonNull
            @Override
            public ConcurrentHashMap<String, String> getHeaders() throws AuthFailureError {
                ConcurrentHashMap<String,String> params = new ConcurrentHashMap<>();
                params.put("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
                params.put("Accept", "application/json");
                return params;
            }
        };
        sr.setRetryPolicy(new DefaultRetryPolicy(
                AppConstant.MY_SOCKET_TIMEOUT_MS ,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(sr);
    }


    @NonNull
    private static String getText(String values) {
        return values!=null&&!values.isEmpty()?values: AppConstant.NA;
    }




}
*/
