package com.example.vivianbabiryekulumba.ssappmarkupone.controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vivianbabiryekulumba.ssappmarkupone.R;

public class BadgeAdapter extends RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder> {

    private static final String TAG = "BadgeAdapter";
    private int[] progressBadgeList;

    public BadgeAdapter(int[] progressBadgeList) {
        this.progressBadgeList = progressBadgeList;
    }

    @NonNull
    @Override
    public BadgeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.badge_list_item_view, viewGroup, false);
        return new BadgeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BadgeViewHolder badgeViewHolder, int i) {
        badgeViewHolder.empty_badge_one.setImageResource(R.drawable.empty_badge_icon);
        Log.d(TAG, "onBindViewHolder: " + progressBadgeList.length);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + progressBadgeList.length);
        return progressBadgeList.length;
    }

    public class BadgeViewHolder extends RecyclerView.ViewHolder {

        ImageView empty_badge_one;

        public BadgeViewHolder(@NonNull View itemView) {
            super(itemView);
            empty_badge_one = itemView.findViewById(R.id.empty_badge_icon);
        }
    }
}
