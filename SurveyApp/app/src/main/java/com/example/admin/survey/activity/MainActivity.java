package com.example.admin.survey.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.survey.model.QuestionWs;
import com.example.admin.survey.R;
import com.example.admin.survey.adapter.HomePageViewPagerAdapter;

import com.google.gson.Gson;


import comviva.mahendra.survey.com.sdktogetdatanpostdata.SurveyData;


public final class MainActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager viewpagerHomePage;
    private QuestionWs questionWs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   SurveyConfiguration  surveyConfiguration =new SurveyConfiguration(getApplicationContext());

        viewpagerHomePage = (ViewPager) findViewById(R.id.viewpager_home_page);
        final Button nextButton            = (Button)    findViewById(R.id.bt_nxt);
        final Button finishButton            = (Button)    findViewById(R.id.bt_finish);


        nextButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);

        // set listner on pager

        setPageListner(finishButton);

        // Reading survey data from SDK and set pager adapter

        setData();

    }



    // Reading survey data from SDK
    private void setData() {

        questionWs = new Gson().fromJson(SurveyData.getSurveyData(), QuestionWs.class);


        if (null != questionWs) {

            viewpagerHomePage.setAdapter(new HomePageViewPagerAdapter(questionWs.getArray_data()));
        }
    }

    private void setPageListner(final Button finishButton) {
        viewpagerHomePage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

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
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bt_nxt:

                viewpagerHomePage.setCurrentItem(viewpagerHomePage.getCurrentItem()+1);

                break;

            case R.id.bt_finish:

                startActivity(new Intent(MainActivity.this,ResultActivity.class));

        }
    }



}
