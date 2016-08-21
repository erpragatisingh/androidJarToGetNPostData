package comviva.mahendra.survey.com.sdktogetdatanpostdata.activity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.SurveyData;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.appconstant.AppConstant;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.model.SurveyResponseVO;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.Util;

/**
 * Created by pragati on 8/17/16.
 */
public final class ResultActivity extends BaseActivity {
   // private static final String TAG = ResultActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SurveyResponseVO surveyResult= new Gson().fromJson(SurveyData.getSurveyResponseData(), SurveyResponseVO.class);

        final LinearLayout rootLayout = new LinearLayout(this);

        // In this case I want to fill its parent
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootLayout.setPadding(30,20,30,20);

        this.setContentView(rootLayout,linearLayout);
        // to enable back option for activity
        setUpActionBar();
        TextView questionTextView   = new TextView(this);
        Util.setViewPropertys(questionTextView,AppConstant.QUESTION,16.00f,true, Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);

        TextView ansFirstTextView   = new TextView(this);
        Util.setViewPropertys(ansFirstTextView,AppConstant.ANSWER_ONE,16.00f,true, Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);

        TextView ansSecondTextView   = new TextView(this);
        Util.setViewPropertys(ansSecondTextView,AppConstant.ANSWER_TWO,16.00f,true, Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);

        TextView ansThirdTextView   = new TextView(this);

        Util.setViewPropertys(ansThirdTextView,AppConstant.ANSWER_THREE,16.00f,true, Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);



        TextView ansFourTextView   = new TextView(this);
        Util.setViewPropertys(ansFourTextView,AppConstant.ANSWER_FOUR,16.00f,true, Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);


        Util.nullCheckData(AppConstant.RESULT, questionTextView );

        Util.nullCheckData(AppConstant.RESULT +surveyResult.getAnswer_one(),ansFirstTextView );

        Util.nullCheckData(AppConstant.RESULT+surveyResult.getAnswer_two(),  ansSecondTextView  );
        Util.nullCheckData(AppConstant.RESULT+surveyResult.getAnswer_three(),  ansThirdTextView);
        Util.nullCheckData(AppConstant.RESULT+surveyResult.getAnswer_four(),  ansFourTextView );



    }

    private void setUpActionBar() {
        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


}
