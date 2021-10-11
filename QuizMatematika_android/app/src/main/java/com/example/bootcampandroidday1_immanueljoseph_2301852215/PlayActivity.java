package com.example.bootcampandroidday1_immanueljoseph_2301852215;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bootcampandroidday1_immanueljoseph_2301852215.model.ScoreData;

import java.text.ParseException;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    public static final String EXTRA_OBJECT_SCORE = "extra_object_score";
    private Random rand;
    private TextView tvScore;
    private TextView tvQuestNum1;
    private TextView tvQuestNum2;
    private TextView tvQuestResult;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnNum0;
    private Button btnErase;
    private Button btnSubmit;
    private ScoreData scoreData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        rand = new Random();
        tvScore = findViewById(R.id.tv_score);
        tvQuestNum1 = findViewById(R.id.tv_quest_num1);
        tvQuestNum2 = findViewById(R.id.tv_quest_num2);
        tvQuestResult = findViewById(R.id.tv_quest_result);
        btnNum1 = findViewById(R.id.btn_num1);
        btnNum2 = findViewById(R.id.btn_num2);
        btnNum3 = findViewById(R.id.btn_num3);
        btnNum4 = findViewById(R.id.btn_num4);
        btnNum5 = findViewById(R.id.btn_num5);
        btnNum6 = findViewById(R.id.btn_num6);
        btnNum7 = findViewById(R.id.btn_num7);
        btnNum8 = findViewById(R.id.btn_num8);
        btnNum9 = findViewById(R.id.btn_num9);
        btnNum0 = findViewById(R.id.btn_num0);
        btnErase = findViewById(R.id.btn_erase);
        btnSubmit = findViewById(R.id.btn_submit);

        scoreData = (ScoreData) getIntent().getSerializableExtra(EXTRA_OBJECT_SCORE);

        tvScore.setText("0");
        randomQuestion();
        tvQuestResult.setText("");

        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum1);
            }
        });

        btnNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum2);
            }
        });

        btnNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum3);
            }
        });

        btnNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum4);
            }
        });

        btnNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum5);
            }
        });

        btnNum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum6);
            }
        });

        btnNum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum7);
            }
        });

        btnNum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum8);
            }
        });

        btnNum9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum9);
            }
        });

        btnNum0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatNum(btnNum0);
            }
        });

        btnErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eraseResult();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer add;
                if(validateResult()){
                    add = 10;
                    randomQuestion();
                }else add = -10;
                tvScore.setText(((Integer)
                        (Integer.parseInt(tvScore.getText().toString()) + add)).toString());
                eraseResult();
            }
        });
    }

    @Override
    public void onBackPressed() {
        this.scoreData.setScore(Integer.parseInt(tvScore.getText().toString()));
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.EXTRA_SCORE_RESULT, this.scoreData);
        setResult(Activity.RESULT_OK, returnIntent);
        super.onBackPressed();
    }

    private void randomQuestion(){
        Integer num1, num2;

        num1 = rand.nextInt(100);
        num2 = rand.nextInt(100);

        tvQuestNum1.setText(num1.toString());
        tvQuestNum2.setText(num2.toString());
    }

    private void concatNum(Button btn){
        if(tvQuestResult.getText().toString().equals("0")) tvQuestResult.setText("");
        tvQuestResult.setText(tvQuestResult.getText().toString().concat(btn.getText().toString()));
    }

    private void eraseResult(){
        tvQuestResult.setText("0");
    }

    private boolean validateResult(){
        Integer result;

        try {
            result = Integer.parseInt(tvQuestResult.getText().toString());
        }catch (Exception e){
            return false;
        }

        if((Integer.parseInt(tvQuestNum1.getText().toString()) +
                Integer.parseInt(tvQuestNum2.getText().toString())) ==
                result) return true;
        return false;
    }
}