package com.example.bootcampandroidday1_immanueljoseph_2301852215;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bootcampandroidday1_immanueljoseph_2301852215.model.ScoreData;

import java.util.ArrayList;

public class ViewScoreAdapter extends RecyclerView.Adapter<ViewScoreAdapter.ViewScoreViewHolder> {

    private ArrayList<ScoreData> scoreboard;

    public ViewScoreAdapter(ArrayList<ScoreData> scoreboard) {
        this.scoreboard = scoreboard;
    }

    @NonNull
    @Override
    public ViewScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_score_layout, parent, false);
        return new ViewScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewScoreViewHolder holder, int position) {
        ScoreData scoreData = scoreboard.get(position);
        holder.tvUsername.setText(scoreData.getUsername());
        holder.tvScore.setText(scoreData.getScore().toString());
    }

    @Override
    public int getItemCount() {
        return scoreboard.size();
    }

    class ViewScoreViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUsername, tvScore;

        public ViewScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvScore = itemView.findViewById(R.id.tv_score);
        }
    }
}
