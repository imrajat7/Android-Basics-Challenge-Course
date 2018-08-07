package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Q1_ANSWER = R.id.question_1_radio_1;
    int Q2_ANSWER = R.id.question_2_radio_1;
    int Q3_ANSWER = R.id.question_3_radio_3;
    int Q4_ANSWER = R.id.question_4_check_box_2;
    String Q5_ANSWER = "manifest";
    String Q6_ANSWER = "Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View v)
    {
        int numberOfCorrectQuestion=0;
        int numberOfNonCorrectQuestion=0;

        if(checkQuestion1()) {
            numberOfCorrectQuestion++;
        }
        else {
            numberOfNonCorrectQuestion++;
        }

        if(checkQuestion2()) {
            numberOfCorrectQuestion++;
        }
        else {
            numberOfNonCorrectQuestion++;
        }

        if(checkQuestion3()) {
            numberOfCorrectQuestion++;
        }
        else {
            numberOfNonCorrectQuestion++;
        }

        if(checkQuestion4()) {
            numberOfCorrectQuestion++;
        }
        else {
            numberOfNonCorrectQuestion++;
        }

        if(checkQuestion5()) {
            numberOfCorrectQuestion++;
        }
        else {
            numberOfNonCorrectQuestion++;
        }

        if(checkQuestion6()) {
            numberOfCorrectQuestion++;
        }
        else {
            numberOfNonCorrectQuestion++;
        }

        Context context = getApplicationContext();
        CharSequence text = "You got "+ numberOfCorrectQuestion + " correct out of 6";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private boolean checkQuestion1() {
        RadioGroup r = (RadioGroup)findViewById(R.id.question_1_radio_group);

        if(r.getCheckedRadioButtonId() == Q1_ANSWER)
            return true;

        else
            return false;
    }

    private boolean checkQuestion2() {
        RadioGroup r = (RadioGroup) findViewById(R.id.question_2_radio_group);

        if(r.getCheckedRadioButtonId() == Q2_ANSWER) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkQuestion3() {
        RadioGroup r = (RadioGroup) findViewById(R.id.question_3_radio_group);

        if(r.getCheckedRadioButtonId() == Q3_ANSWER) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkQuestion4() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_4_check_box_1);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_4_check_box_2);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_4_check_box_3);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_4_check_box_4);

        if(c2.isChecked() && c4.isChecked()) {
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean checkQuestion5() {
        EditText r = (EditText)findViewById(R.id.question_5_edit_text);

        return r.getText().toString().equalsIgnoreCase(Q5_ANSWER);
    }

    private Boolean checkQuestion6() {
        EditText r = (EditText)findViewById(R.id.question_question_6_edit_text);

        return r.getText().toString().equalsIgnoreCase(Q6_ANSWER);
    }


}
