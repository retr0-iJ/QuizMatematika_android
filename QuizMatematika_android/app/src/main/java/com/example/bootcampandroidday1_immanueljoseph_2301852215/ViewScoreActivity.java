package com.example.bootcampandroidday1_immanueljoseph_2301852215;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.bootcampandroidday1_immanueljoseph_2301852215.model.ScoreData;

import java.util.ArrayList;

public class ViewScoreActivity extends AppCompatActivity {

    public static final String EXTRA_OBJECT_VIEW = "extra_object_view";
    private RecyclerView rvScoreboard;
    private ViewScoreAdapter viewScoreAdapter;
    private ArrayList<ScoreData> scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);

        scoreboard = new ArrayList<ScoreData>();

        Intent intent = getIntent();
        int i = 0;
        while(intent.hasExtra(EXTRA_OBJECT_VIEW + i)){
            ScoreData scoreData = (ScoreData) intent.getSerializableExtra(EXTRA_OBJECT_VIEW + i);
            scoreboard.add(scoreData);
            ++i;
        }

        rvScoreboard = findViewById(R.id.rv_scoreboard);
        viewScoreAdapter = new ViewScoreAdapter(scoreboard);
        rvScoreboard.setAdapter(viewScoreAdapter);
        rvScoreboard.setLayoutManager(new LinearLayoutManager(this));
    }
}