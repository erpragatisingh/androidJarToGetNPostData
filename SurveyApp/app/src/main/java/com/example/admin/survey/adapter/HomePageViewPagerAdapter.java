package com.example.admin.survey.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.admin.survey.util.Util;
import com.example.admin.survey.model.QuestionModel;
import com.example.admin.survey.R;

import java.util.List;

/**
 * Created by pragati on 8/18/16.
 */
public class HomePageViewPagerAdapter extends PagerAdapter {
    private List<QuestionModel> questionModelList;

    public HomePageViewPagerAdapter(List<QuestionModel> questionModelList) {
        this.questionModelList = questionModelList;

    }

    @Override
    public Object instantiateItem(ViewGroup container,final int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // initalization of view and set values
        View page = inflater.inflate(R.layout.fragment_lyout, null);
        nullCheckData( questionModelList.get(position).getAnswer_one(),(CheckBox) page.findViewById(R.id.ch_ans_one)  );
        nullCheckData( questionModelList.get(position).getAnswer_two(), (CheckBox) page.findViewById(R.id.ch_ans_two) );
        nullCheckData(questionModelList.get(position).getAnswer_three(),  (CheckBox) page.findViewById(R.id.ch_ans_three));
        nullCheckData(questionModelList.get(position).getAnswer_four(),  (CheckBox) page.findViewById(R.id.ch_ans_four) );
        Util.nullCheckData(questionModelList.get(position).getQuestion(), (TextView) page.findViewById(R.id.tv_qus)  );

        ((ViewPager) container).addView(page, 0);
        page.setTag("myview" + position);
        return page;
    }

    @Override
    public int getCount() {
        return questionModelList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {

        ((ViewPager) collection).removeView((View) view);
    }

    // check of null values and view
    private final void  nullCheckData(String value, CheckBox viewCheckBox) {
        if (null != value && null !=viewCheckBox) {
            viewCheckBox.setText(value);
        }
    }


}