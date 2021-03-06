package com.example.imransk.androidinterviewquestion;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Imran Sk on 5/15/2017.
 */

public class simple_question extends AppCompatActivity implements View.OnClickListener {

    TextView tvquestion, tvanswer, tvtotallength_yy, tvpresentindex_xx;
    Button bleft, bshow, bright;
    String[] simple_question, simple_answer;
    int index;
    // variable and object for text to speace
    TextToSpeech ttsobject;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

//code for title bar
        LinearLayout question_ll = (LinearLayout) findViewById(R.id.questionpage_title_bar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.question_title_bar);
        Button bspeak = (Button) findViewById(R.id.bspeak);
        Button bmute = (Button) findViewById(R.id.bmute);
// This text view is for title bar
        TextView tv_catagory = (TextView) findViewById(R.id.tv_question_title_bar);
        tv_catagory.setText("Simple Question");


// Initialization text view
        tvquestion = (TextView) findViewById(R.id.tvquestion);
        tvanswer = (TextView) findViewById(R.id.tvanswer);
        tvtotallength_yy = (TextView) findViewById(R.id.tvyy);
        tvpresentindex_xx = (TextView) findViewById(R.id.tvxx);
// Initialization button
        bleft = (Button) findViewById(R.id.bleft);
        bshow = (Button) findViewById(R.id.bshowans);
        bright = (Button) findViewById(R.id.bright);
// onclick Lestiner for 3 button alse speak and mute button
        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bright.setOnClickListener(this);
        bspeak.setOnClickListener(this);
        bmute.setOnClickListener(this);



// importing string from values folder
        simple_question = getResources().getStringArray(R.array.simple_ques);
        simple_answer = getResources().getStringArray(R.array.simple_ans);

//setting value to our variable and four textview
        index = 0;
        tvquestion.setText(simple_question[index]);
        tvanswer.setText("Press Answer button to see..");
        tvpresentindex_xx.setText(String.valueOf(index + 1));
        tvtotallength_yy.setText(String.valueOf("/" + simple_question.length));
//TTS object and Listeners initialization
        ttsobject = new TextToSpeech(com.example.imransk.androidinterviewquestion.simple_question.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    result = ttsobject.setLanguage(Locale.US);
                } else {
                    Toast.makeText(getApplicationContext(), "Features not supported in your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bleft:
                tvanswer.setText("Press Answer button to see..");
                index--;
                if (index == -1) {
                    index = simple_question.length - 1;
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                } else {

                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                }


                break;
            case R.id.bright:
                tvanswer.setText("Press Answer button to see..");
                index++;
                if (index == simple_question.length) {
                    index = 0;
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                } else {

                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                }

                break;

            case R.id.bshowans:
                tvanswer.setText(simple_answer[index]);
                break;

            case R.id.bspeak:

                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                    Toast.makeText(getApplicationContext(), "Features not supported in your device", Toast.LENGTH_SHORT).show();

                }else {
                    if (tvanswer.getText().toString().equals("Press Answer button to see..")){

                    }else {

                        ttsobject.speak(simple_answer[index],TextToSpeech.QUEUE_FLUSH,null);
                    }
                }
                break;
            case R.id.bmute:

                if(ttsobject!=null){
                    ttsobject.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsobject!=null){
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }
}
