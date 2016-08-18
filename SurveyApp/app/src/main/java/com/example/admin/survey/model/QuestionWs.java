package com.example.admin.survey.model;

import java.util.ArrayList;

/**
 * Created by pragati Singh on 18-08-2016.
 */
public final class QuestionWs {

    public ArrayList<QuestionModel> getArray_data() {
        return array_data;
    }

    public void setArray_data(ArrayList<QuestionModel> array_data) {
        this.array_data = array_data;
    }

    private ArrayList<QuestionModel> array_data;

}
