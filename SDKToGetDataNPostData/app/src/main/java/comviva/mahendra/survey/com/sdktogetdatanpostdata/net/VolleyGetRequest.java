package comviva.mahendra.survey.com.sdktogetdatanpostdata.net;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.controller.AppController;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.MCLog;

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
