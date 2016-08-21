package com.example.admin.survey.activity;


import android.content.Intent;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.admin.survey.model.QuestionWs;
import com.example.admin.survey.R;
import com.example.admin.survey.adapter.HomePageViewPagerAdapter;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.SurveyData;


public final class MainActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewpagerHomePage;
    private QuestionWs questionWs;
    private Map<String,List<String>> answerHashMap;
    private List<String>  selectedValuesList;
    private Button finishButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   SurveyConfiguration  surveyConfiguration =new SurveyConfiguration(getApplicationContext());

        viewpagerHomePage = (ViewPager) findViewById(R.id.viewpager_home_page);

        final Button nextButton   = (Button)    findViewById(R.id.bt_nxt);
        finishButton              = (Button)    findViewById(R.id.bt_finish);

        nextButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);
        viewpagerHomePage.addOnPageChangeListener(this);

        // Reading survey data from SDK and set pager adapter && set listner on pager

        setData();

    }

    // Reading survey data from SDK
    private void setData() {
        questionWs = new Gson().fromJson(SurveyData.getSurveyData(), QuestionWs.class);

        if (null != questionWs) {
            viewpagerHomePage.setAdapter(new HomePageViewPagerAdapter(questionWs.getArray_data()));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bt_nxt:
                // Collect selected value
                collectResult( );
                break;

            case R.id.bt_finish:
                // Collect selected value
                collectResult();
                // On Finish click goto Result Screen
               // startActivity(new Intent(MainActivity.this,ResultActivity.class));
                startActivity(new Intent(MainActivity.this,comviva.mahendra.survey.com.sdktogetdatanpostdata.MainActivity.class));
                // send all collected data to SDK
                SurveyData.sendResponseData(answerHashMap);
        }
    }


    private void collectResult(){
        // get view of pager adpter with tag which we already set in adapter
        View view = (View) viewpagerHomePage.findViewWithTag("myview" + viewpagerHomePage.getCurrentItem());
        CheckBox checkBoxFirst  = (CheckBox)view.findViewById(R.id.ch_ans_one);
        CheckBox checkBoxSecond  = (CheckBox)view.findViewById(R.id.ch_ans_two);
        CheckBox checkBoxThird  = (CheckBox)view.findViewById(R.id.ch_ans_three);
        CheckBox checkBoxFour   = (CheckBox)view.findViewById(R.id.ch_ans_four);
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
        else{Toast.makeText(getApplicationContext(),getString(R.string.error),Toast.LENGTH_SHORT).show();}
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(null!=selectedValuesList && selectedValuesList.isEmpty()) {
            viewpagerHomePage.setCurrentItem(position);
            Toast.makeText(getApplicationContext(),getString(R.string.error),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPageSelected(int position) {

        if (position==questionWs.getArray_data().size()-1){
            finishButton.setVisibility(View.VISIBLE);
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
}




