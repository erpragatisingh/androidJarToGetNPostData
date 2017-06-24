# android Jar To Get Data  @https://www.mahindracomviva.com/

1>This app will get some data of question and multiple choice answer from sdk (i.e. i have to make it separate from app) and
2> then this data  will display in app (Question with four option) and on last question there is button of submit.
3> then, app will get some response and again this response i have to show on result / status page.


Note:- Data/JSON is hard coded in SDK, due to server unavailability 


// By using < SDKToGetDataNPostData > project jar we can perform survey that provide

1> It will provide question with multiple choice option with user interface.

2> After submission of all answer when user press finish button it will show result.




Steps of integration :-

1 > if We want to launch Survey add a button and on button click event 
  write line given below

 startActivity(new Intent(MainActivity.this,SurveyLauncherActivity.class));


2> Then Add 

 <activity android:name="comviva.mahendra.survey.com.sdktogetdatanpostdata.activity.SurveyLauncherActivity"/>

and
 
<activity 
android:name="comviva.mahendra.survey.com.sdktogetdatanpostdata.activity.ResultActivity"
android:parentActivityName="comviva.mahendra.survey.com.sdktogetdatanpostdata.activity.SurveyLauncherActivity"
             
 />

in Manifest file.


3> add following line in dependencies of app.build gradle 

 compile 'com.google.code.gson:gson:2.3.1'
 compile files('libs/surveySDK.jar')


https://www.mahindracomviva.com/
