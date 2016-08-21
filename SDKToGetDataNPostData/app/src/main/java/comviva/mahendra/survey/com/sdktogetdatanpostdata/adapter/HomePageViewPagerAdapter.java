package comviva.mahendra.survey.com.sdktogetdatanpostdata.adapter;

import android.app.Activity;

import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;


import comviva.mahendra.survey.com.sdktogetdatanpostdata.appconstant.AppConstant;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.model.QuestionModel;
import comviva.mahendra.survey.com.sdktogetdatanpostdata.util.Util;

/**
 * Created by pragati on 8/18/16.
 */
public class HomePageViewPagerAdapter extends PagerAdapter {
    private List<QuestionModel> questionModelList;
    private Activity context;
    public HomePageViewPagerAdapter(List<QuestionModel> questionModelList, Activity mainActivity) {
        this.questionModelList = questionModelList;
        this.context=mainActivity;

    }

    @Override
    public Object instantiateItem(ViewGroup container,final int position) {
        // create root layout of pager adapter
        final LinearLayout rootLayout = new LinearLayout(context);
        // Defining the LinearLayout layout parameters.In this case I want to fill its parent

        final LinearLayout.LayoutParams lpRoot = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        // set orientation of layout
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setLayoutParams(lpRoot);

        final TextView qustionTextView=new TextView(context);
        Util.setViewPropertys(qustionTextView,AppConstant.QUESTION,16.00f,true,Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);


        final CheckBox ansOneCheckBox=new CheckBox(context);
        Util.setViewPropertys(ansOneCheckBox,AppConstant.ANSWER_ONE,16.00f,true,Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);

        final CheckBox ansSecondCheckBox=new CheckBox(context);
        Util.setViewPropertys(ansSecondCheckBox,AppConstant.ANSWER_TWO,16.00f,true,Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);


        final  CheckBox ansThreeCheckBox=new CheckBox(context);
        Util. setViewPropertys(ansThreeCheckBox,AppConstant.ANSWER_THREE,16.00f,true,Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);


       final CheckBox ansFourCheckBox=new CheckBox(context);
        Util.setViewPropertys(ansFourCheckBox,AppConstant.ANSWER_FOUR,16.00f,true,Typeface.create(Typeface.DEFAULT_BOLD,Typeface.BOLD),rootLayout);


        nullCheckData( questionModelList.get(position).getAnswer_one(),  ansOneCheckBox );
        nullCheckData( questionModelList.get(position).getAnswer_two(),  ansSecondCheckBox );
        nullCheckData(questionModelList.get(position).getAnswer_three(),  ansThreeCheckBox );
        nullCheckData(questionModelList.get(position).getAnswer_four(),  ansFourCheckBox  );
        Util.nullCheckData(questionModelList.get(position).getQuestion(), qustionTextView   );


        ((ViewPager) container).addView(rootLayout, 0);
        rootLayout.setTag(AppConstant.VIEW_PAGER_TAG + position);
        return rootLayout;
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