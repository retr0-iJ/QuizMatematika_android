package com.example.bootcampandroidday1_immanueljoseph_2301852215;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bootcampandroidday1_immanueljoseph_2301852215.model.ScoreData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE_RESULT = "score_result_object";
    private int LAUNCH_PLAY_ACTIVITY = 1;

    private EditText etUsername;
    private Button btnPlay;
    private Button btnViewScore;

    private ArrayList<ScoreData> scoreDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreDataList = new ArrayList<ScoreData>();

        etUsername = findViewById(R.id.et_username);
        btnPlay = findViewById(R.id.btn_play);
        btnViewScore = findViewById(R.id.btn_viewScore);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validatePlay()){
                    ScoreData scoreData = new ScoreData(etUsername.getText().toString(), 0);

                    Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                    intent.putExtra(PlayActivity.EXTRA_OBJECT_SCORE, scoreData);
                    startActivityForResult(intent, LAUNCH_PLAY_ACTIVITY);
                }else
                    Toast.makeText(MainActivity.this, "Please input your name", Toast.LENGTH_LONG).show();
            }
        });

        btnViewScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewScoreActivity.class);
                for(int i = 0; i < scoreDataList.size(); ++i){
                    ScoreData scoreData = scoreDataList.get(i);
                    intent.putExtra(ViewScoreActivity.EXTRA_OBJECT_VIEW + i, scoreData);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        etUsername.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LAUNCH_PLAY_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                int idx = -1;
                ScoreData scoreData = (ScoreData) data.getSerializableExtra(EXTRA_SCORE_RESULT);

                for (int i = 0; i < scoreDataList.size(); ++i){
                    if(scoreDataList.get(i).getUsername().equals(scoreData.getUsername())) {
                        idx = i;
                        scoreData.setScore(scoreData.getScore() + scoreDataList.get(idx).getScore());
                        break;
                    }
                }

                if (idx == -1) {
                    scoreDataList.add(scoreData);
                }
                else {
                    scoreDataList.set(idx, scoreData);
                }
            }
        }
    }

    private boolean validatePlay(){
        if(etUsername.getText().toString().equals("")) return false;
        return true;
    }
}