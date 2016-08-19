package comviva.mahendra.survey.com.sdktogetdatanpostdata;

import android.app.Activity;

import com.android.volley.VolleyError;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.net.VolleyInterface;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.MCUtil;

/**
 * Created by pragati on 8/18/16.
 */
public final class SurveyData  implements VolleyInterface{

//private static String response;

 public static final String getSurveyData(){
     return jsonData;
 }

 public static final String getSurveyResponseData(){

     return  responseData;
 }
 public static final void sendResponseData(Map<String, List<String>> mapdata){

     if(null!=mapdata) {
         Map<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
         concurrentHashMap.putAll(mapdata);

         for (String key : concurrentHashMap.keySet()) {
             System.out.println(key + " " + concurrentHashMap.get(key));
         }

     }
 }

    @Override
    public void requestStarted(int requestCode) {

    }

    @Override
    public void requestCompleted(String response, int requestCode) {
       // this.response=response;
    }

    @Override
    public void requestEndedWithError(VolleyError error, int requestCode) {

    }

//    public static void sendResponse(Activity ctx, ConcurrentHashMap<String, String> params){
//
//        if(MCUtil.isNetworkAvailable(ctx)&& null !=params) {
//
//               /* params.put("userid", "983939289883");// for now seeting static user id
//                VolleyHelper.postRequestVolley(ctx
//                        , "AppConstant.URL_HOME", params, 1);
//*/
//            }
//    }


    private static final String responseData="{\n" +
            "  \"answer_one\": \"70\",\n" +
            "  \"answer_two\": \"40\",\n" +
            "  \"answer_three\": \"90\",\n" +
            "  \"answer_four\": \"60\"\n" +
            "}";


    private  static final String jsonData = "{\n" +
            "  \"array_data\": [\n" +
            "    {\n" +
            "  \"question\": \"Where do you live?\",\n" +
            "  \"answer_one\": \"Gurgaon\",\n" +
            "  \"answer_two\": \"Noida\",\n" +
            "  \"answer_three\": \"Delhi\",\n" +
            "  \"answer_four\": \"Faridabad\"\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "  \"question\": \"My Nation is ?\",\n" +
            "  \"answer_one\": \"India\",\n" +
            "  \"answer_two\": \"Noida\",\n" +
            "  \"answer_three\": \"Delhi\",\n" +
            "  \"answer_four\": \"Banglore\"\n" +
            "},\n" +
            "{\n" +
            "  \"question\": \"15 Aug important for ?\",\n" +
            "  \"answer_one\": \"India\",\n" +
            "  \"answer_two\": \"Pakistan\",\n" +
            "  \"answer_three\": \"China\",\n" +
            "  \"answer_four\": \"USA\"\n" +
            "},\n" +
            "{\n" +
            "  \"question\": \"SCALA is a ? \",\n" +
            "  \"answer_one\": \"Programing Language \",\n" +
            "  \"answer_two\": \"Food\",\n" +
            "  \"answer_three\": \"Funcation Based Language\",\n" +
            "  \"answer_four\": \"Object Oriented Language \"\n" +
            "},\n" +
            "{\n" +
            "  \"question\": \"Swift is a ?\",\n" +
            "  \"answer_one\": \"Funcation Based Language \",\n" +
            "  \"answer_two\": \"High Level Language \",\n" +
            "  \"answer_three\": \"Programing Language\",\n" +
            "  \"answer_four\": \"Car\"\n" +
            "}\n" +
            "  ]\n" +
            "  \n" +
            "   \n" +
            "}";
}
