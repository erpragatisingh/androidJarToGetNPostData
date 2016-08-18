package com.example.admin.survey.appcontroller;

import android.app.Application;
import android.util.Log;


/**
 * Created by pragati on 8/17/16.
 */
public class AppController extends Application {
   // private static final String TAG = SurveyConfiguration.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
// for setting survey configration

//        SurveyConfiguration.init(getApplicationContext(),
//                "organization_id", SurveyConfiguration.SurveyEnvironmentOption.DEV ,
//                "access_key_id",  true,
//                false, //push notification
//                "google_gcm_project_id");


       // Log.i(TAG, "SDKConfigSettings.init() called");
    }
}
