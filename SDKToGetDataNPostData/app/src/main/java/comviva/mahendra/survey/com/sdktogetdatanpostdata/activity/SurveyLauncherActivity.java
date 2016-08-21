package comviva.mahendra.survey.com.sdktogetdatanpostdata.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import comviva.mahendra.survey.com.sdktogetdatanpostdata.SurveyData;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.adapter.HomePageViewPagerAdapter;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.appconstant.AppConstant;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.model.QuestionWs;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.view.WrapContentHeightViewPager;


public final class SurveyLauncherActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewpagerHomePage;
    private QuestionWs questionWs;
    private Map<String,List<String>> answerHashMap;
    private List<String>  selectedValuesList;
    private Button finishButton;
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout rootLayout = new LinearLayout(this);
        // specifying vertical orientation
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lpLinearLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        rootLayout.setPadding(30,20,30,20);
         // set LinearLayout as a root element of the screen
        setContentView(rootLayout, lpLinearLayout);

        // Defining the layout parameters of the Pager
        LinearLayout.LayoutParams lpHomePager = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        viewpagerHomePage = new WrapContentHeightViewPager(this);
        viewpagerHomePage.setLayoutParams(lpHomePager);
        rootLayout.addView(viewpagerHomePage);

            nextButton   = new Button(this);
         setButtonProperty(nextButton,rootLayout,AppConstant.NEXT,AppConstant.NEXT,Color.CYAN);

        finishButton    = new Button(this);
        finishButton.setVisibility(View.GONE);
        setButtonProperty(finishButton,rootLayout,AppConstant.FINISH,AppConstant.FINISH,Color.CYAN);


        nextButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);
        viewpagerHomePage.addOnPageChangeListener(this);


        // Reading survey data from SDK and set pager adapter && set listner on pager
        questionWs = new Gson().fromJson(SurveyData.getSurveyData(), QuestionWs.class);
        setData();

    }

    // Reading survey data from SDK
    private void setData() {


        if (null != questionWs) {
            viewpagerHomePage.setAdapter(new HomePageViewPagerAdapter(questionWs.getArray_data(),SurveyLauncherActivity.this));
        }
    }

    @Override
    public void onClick(View v) {

        if(v.getTag().equals(AppConstant.NEXT)){
            // Collect selected value

            collectResult( );

        }if(v.getTag().equals(AppConstant.FINISH)){
            // Collect selected value
            collectResult();
            // On Finish click goto Result Screen

            startActivity(new Intent(SurveyLauncherActivity.this,ResultActivity.class));
            // send all collected data to SDK
            SurveyData.sendResponseData(answerHashMap);
        }


    }


    private void collectResult(){
        // get view of pager adpter with tag which we already set in adapter
        View view = (View) viewpagerHomePage.findViewWithTag(AppConstant.VIEW_PAGER_TAG + viewpagerHomePage.getCurrentItem());
        CheckBox checkBoxFirst  = (CheckBox)view.findViewWithTag(AppConstant.ANSWER_ONE );
        CheckBox checkBoxSecond  = (CheckBox)view.findViewWithTag(AppConstant.ANSWER_TWO);
        CheckBox checkBoxThird  = (CheckBox)view.findViewWithTag(AppConstant.ANSWER_THREE);
        CheckBox checkBoxFour   = (CheckBox)view.findViewWithTag(AppConstant.ANSWER_FOUR);
            selectedValuesList = new ArrayList<>();

        if(checkBoxFirst.isChecked()){selectedValuesList.add(checkBoxFirst.getText().toString());}
        if(checkBoxSecond.isChecked()){selectedValuesList.add(checkBoxSecond.getText().toString());}
        if(checkBoxThird.isChecked()){selectedValuesList.add(checkBoxThird.getText().toString());}
        if(checkBoxFour.isChecked()){selectedValuesList.add(checkBoxFour.getText().toString());}

        if(null!=selectedValuesList && !selectedValuesList.isEmpty())
        {
            answerHashMap.put(questionWs.getArray_data().get(viewpagerHomePage.getCurrentItem()).getQuestion(), selectedValuesList);

            viewpagerHomePage.setCurrentItem(viewpagerHomePage.getCurrentItem()+1);
        }
        else{Toast.makeText(getApplicationContext(),AppConstant.ERROR,Toast.LENGTH_SHORT).show();}
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(null!=selectedValuesList && selectedValuesList.isEmpty()) {
            viewpagerHomePage.setCurrentItem(position);
         }
    }

    @Override
    public void onPageSelected(int position) {

        if (position==questionWs.getArray_data().size()-1){
            finishButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.GONE);

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    protected void onStart() {
        super.onStart();
        if(null==answerHashMap) {
            selectedValuesList=new ArrayList<>();
            answerHashMap = new HashMap<>();
        }else{
            selectedValuesList.clear();
            answerHashMap.clear();
        }



    }


    private void setButtonProperty(Button button,LinearLayout rootlayout,String labelText,Object tag,int color){
        LinearLayout.LayoutParams lpForView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if(null!=button && null!=rootlayout) {
            button.setText(labelText);
            button.setTag(tag);
            button.setBackgroundColor(color);
            // Setting the parameters on the nextButton
            button.setLayoutParams(lpForView);
            rootlayout.addView(button);
        }

    }
}




