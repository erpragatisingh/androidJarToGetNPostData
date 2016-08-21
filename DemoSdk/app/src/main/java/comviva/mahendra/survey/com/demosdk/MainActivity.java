package comviva.mahendra.survey.com.demosdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button btnSurvey= (Button) findViewById(R.id.btn_survey);
        btnSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,
                        comviva.mahendra.survey.com.sdktogetdatanpostdata.activity.SurveyLauncherActivity.class));
            }
        });
    }
}
