package com.creativeitinstitute.quizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    TextView tv_score,tv_qu;
    RadioGroup quiz_grp;
    Button btn_submit;
    RadioButton option1,option2, option3,option4;
    String right_ans = "";
    String given_ans = "";

    List<Quiz> quizList;
    int index = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        quizList = new ArrayList<>();

        tv_score = findViewById(R.id.tv_score);
        tv_score.setText("Score : "+score);
        quiz_grp = findViewById(R.id.quiz_grp);


        tv_qu = findViewById(R.id.tv_qu);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);


        Quiz quiz = new Quiz("Bangladesh is bordered by two countries. Which ones?","India and Myanmar","Nepal and Bhutan","India and Nepal","Myanmar and Nepal","India and Myanmar");
        quizList.add(quiz);

        quizList.add(new Quiz("question 1","answer1","answer2","answer3","answer4", "answer1"));
        quizList.add(new Quiz("question 2","answer1","answer2","answer3","answer4", "answer2"));
        quizList.add(new Quiz("question 3","answer1","answer2","answer3","answer4", "answer3"));
        quizList.add(new Quiz("question 4","answer1","answer2","answer3","answer4", "answer4"));

        Collections.shuffle(quizList);


        btn_submit = findViewById(R.id.btn_submit);
        
        setUpQuiz(index);


        quiz_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int checkedID = radioGroup.getCheckedRadioButtonId();
                switch (checkedID){
                    case R.id.option1:
                        given_ans = option1.getText().toString().trim();
                        break;
                    case R.id.option2:
                        given_ans = option2.getText().toString().trim();
                        break;
                    case R.id.option3:
                        given_ans = option3.getText().toString().trim();
                        break;
                    case R.id.option4:
                        given_ans = option4.getText().toString().trim();
                        break;
                }

            }
        });


        btn_submit.setOnClickListener(view ->{

            if (given_ans .equals(right_ans)){

                score += 5;
                tv_score.setText("Score : "+score);
                Toast.makeText(this, "Right Answer", Toast.LENGTH_SHORT).show();
                index++;
                if(index > quizList.size()){
                    index = 0;
                    Collections.shuffle(quizList);
                }
                setUpQuiz(index);

            }else{
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
            }




        });

    }

    private void setUpQuiz(int index) {
        tv_qu.setText(quizList.get(index).question);

        option1.setText(quizList.get(index).getAnswer1());
        option2.setText(quizList.get(index).getAnswer2());
        option3.setText(quizList.get(index).getAnswer3());
        option4.setText(quizList.get(index).getAnswer4());

        right_ans = quizList.get(index).getRight_answer();

        option1.setChecked(false);
        option2.setChecked(false);
        option3.setChecked(false);
        option4.setChecked(false);
    }
}