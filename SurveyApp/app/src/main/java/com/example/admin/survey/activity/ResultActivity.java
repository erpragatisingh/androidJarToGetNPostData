package com.example.admin.survey.activity;

import android.os.Build;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.admin.survey.R;

import com.example.admin.survey.util.Util;

import com.example.admin.survey.model.SurveyResponseVO;
import com.google.gson.Gson;

import comviva.mahendra.survey.com.sdktogetdatanpostdata.SurveyData;

/**
 * Created by pragati on 8/17/16.
 */
public final class ResultActivity extends BaseActivity {
    private static final String TAG = ResultActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       // to enable back option for activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//  initalization of views and set data to views

        initViewAndSetData();

    }

    private void initViewAndSetData() {
        SurveyResponseVO surveyResult= new Gson().fromJson(SurveyData.getSurveyResponseData(), SurveyResponseVO.class);

        Util.nullCheckData(getString(R.string.result)+surveyResult.getAnswer_one(),(TextView) findViewById(R.id.tv_result_first));
        Util.nullCheckData(getString(R.string.result)+surveyResult.getAnswer_two(),(TextView) findViewById(R.id.tv_result_second));
        Util.nullCheckData(getString(R.string.result)+surveyResult.getAnswer_three(),(TextView) findViewById(R.id.tv_result_third));
        Util.nullCheckData(getString(R.string.result)+surveyResult.getAnswer_four(),(TextView) findViewById(R.id.tv_result_fourth));

    }




}
