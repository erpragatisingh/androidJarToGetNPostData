/*
package comviva.mahendra.survey.com.sdktogetdatanpostdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

*/
/**
 * Created by pragati on 8/18/16.
 *
 *    This is initial configuration file for setup SDK.
 *    it contains all information and data for validation/indentification of user.
 *
 *
 *//*

public class SurveyConfiguration {
    private static final String TAG = SurveyConfiguration.class.getSimpleName();
    public static final String ORGANIZATION_ID="organizationId";
    public static final String SURVEY_ENVIRONMENT="surveyEnvironment";
    public static final String GCM_PROJECT_ID="gcmProjectID";
    public static final String GCM_NOTIFICATIONS_ENABLE="gcmNotificationsEnable";
    //Key values
    public static final String ENV_DEV="dev";
    public static final String ENV_PROD="prod";
    public enum SurveyEnvironmentOption{DEV,PROD};
    public static Context context;

    public SurveyConfiguration(Context context) {
        SurveyConfiguration.context = context;



    }

*/
/*
*  First user will call init method to configure app with sdk.
*
*  this method called from application Application class
*
 *//*

    public static void  init(
            Context ctx,
            String organization_id,// organisationId provoded by sdk provider afer register
            SurveyEnvironmentOption survey_environment,  // survey Environment
            String access_key_id,  // access id provoded by sdk provider afer register
            boolean enable_gcm, // user want to get gcm service
            boolean enable_push_notifications, // if user want to enable or disable service for getnotification
            String google_gcm_project_id ) // google project id
    {



    }




    public static void configureSurveyEnvironment(SurveyEnvironmentOption surveyEnvironmentOption) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        if (surveyEnvironmentOption == SurveyEnvironmentOption.PROD) {
            editor.putString(SURVEY_ENVIRONMENT, ENV_PROD);

        } else {
            editor.putString(SURVEY_ENVIRONMENT, ENV_DEV);

        }
        editor.commit();
    }

    public static SurveyEnvironmentOption getSurveyEnvironmentOption() {
        SurveyEnvironmentOption surveyEnvironmentOption = null;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String sOption = prefs.getString(SURVEY_ENVIRONMENT, ENV_DEV);
        if (sOption.equals(ENV_PROD)) {
            surveyEnvironmentOption = SurveyEnvironmentOption.PROD;
        } else {
            surveyEnvironmentOption = SurveyEnvironmentOption.DEV;
        }
        Log.i("Configuration", surveyEnvironmentOption.toString());
        return surveyEnvironmentOption;
    }
}
*/
