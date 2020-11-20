package com.example.vivianbabiryekulumba.ssappmarkupone.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.ssappmarkupone.R;
import com.example.vivianbabiryekulumba.ssappmarkupone.controllers.BadgeAdapter;
import com.example.vivianbabiryekulumba.ssappmarkupone.splash.LogicalGamesSplash;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFrag extends Fragment {

    private static final String TAG = "GamesFrag";
    int[] progressBadgeArr = {R.drawable.empty_badge_icon, R.drawable.empty_badge_icon, R.drawable.empty_badge_icon,
            R.drawable.empty_badge_icon, R.drawable.empty_badge_icon, R.drawable.empty_badge_icon, R.drawable.empty_badge_icon,
            R.drawable.empty_badge_icon, R.drawable.empty_badge_icon, R.drawable.empty_badge_icon,};
    TextView badgesEarnedTv;
    RecyclerView badgeRecycler;
    ProgressBar nextBadgePbar;
    LinearLayout gameOfTheDayLL;
    TextView gameOfTheDayTv;
    TextView gameOfTheDayThemeTv;
    ImageView gameOfTheDayIv;
    Button playButton;
    TextView chooseSeedTv;

    LinearLayout seedGameCardsLL;
    CardView logicalCardView;
    ImageView logicalCardIV;
    TextView logicalGameCardTitle;
    TextView logicalGameCardConcept;

    ImageView bodilyCardIV;
    TextView bodilyGameCardTitle;
    TextView bodilyGameCardConcept;

    ImageView rhythmCardIV;
    TextView rhythmGameCardTitle;
    TextView rhythmGameCardConcept;

    ImageView naturalistCardIV;
    TextView naturalistGameCardTitle;
    TextView naturalistGameCardConcept;

    ImageView existentialCardIV;
    TextView existentialGameCardTitle;
    TextView existentialGameCardConcept;

    ImageView interpersonalCardIV;
    TextView interpersonalGameCardTitle;
    TextView interpersonalGameCardConcept;

    ImageView intrapersonalCardIV;
    TextView intrapersonalGameCardTitle;
    TextView intrapersonalGameCardConcept;


    ImageView linguisticCardIV;
    TextView linguisticGameCardTitle;
    TextView linguisticGameCardConcept;

    ImageView spatialCardIV;
    TextView spatialGameCardTitle;
    TextView spatialGameCardConcept;

    public static GamesFrag newInstance() {
        return new GamesFrag();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        badgesEarnedTv = view.findViewById(R.id.games_badges_earned);
        badgeRecycler = view.findViewById(R.id.badge_recycler);
        nextBadgePbar = view.findViewById(R.id.next_badge_progress_bar);
        gameOfTheDayLL = view.findViewById(R.id.games_linearLayout);
        gameOfTheDayTv = view.findViewById(R.id.gameOfTheDayTv);
        gameOfTheDayThemeTv = view.findViewById(R.id.gameOfTheDayThemeTv);
        gameOfTheDayIv = view.findViewById(R.id.gameOfTheDayImageV);
        playButton = view.findViewById(R.id.play_button);
        chooseSeedTv = view.findViewById(R.id.choose_seed_tv);
        seedGameCardsLL = view.findViewById(R.id.seed_cards_ll);

        logicalCardView = view.findViewById(R.id.logical_card_view);
        logicalCardIV = view.findViewById(R.id.logical_games_icon);
        logicalGameCardTitle = view.findViewById(R.id.logical_seed_title_tv);
        logicalGameCardConcept = view.findViewById(R.id.logical_seed_concept_tv);
        bodilyCardIV = view.findViewById(R.id.bodily_games_icon);
        bodilyGameCardTitle = view.findViewById(R.id.bodily_seed_title_tv);
        bodilyGameCardConcept = view.findViewById(R.id.bodily_seed_concept_tv);
        rhythmCardIV = view.findViewById(R.id.rhythm_games_icon);
        rhythmGameCardTitle = view.findViewById(R.id.rhythm_seed_title_tv);
        rhythmGameCardConcept = view.findViewById(R.id.rhythm_seed_concept_tv);
        naturalistCardIV = view.findViewById(R.id.naturalist_games_icon);
        naturalistGameCardTitle = view.findViewById(R.id.naturalist_seed_title_tv);
        naturalistGameCardConcept = view.findViewById(R.id.naturalist_seed_concept_tv);
        existentialCardIV = view.findViewById(R.id.existential_games_icon);
        existentialGameCardTitle = view.findViewById(R.id.existential_seed_title_tv);
        existentialGameCardConcept = view.findViewById(R.id.existential_seed_concept_tv);
        interpersonalCardIV = view.findViewById(R.id.interpersonal_games_icon);
        interpersonalGameCardTitle = view.findViewById(R.id.interpersonal_seed_title_tv);
        interpersonalGameCardConcept = view.findViewById(R.id.interpersonal_seed_concept_tv);
        intrapersonalCardIV = view.findViewById(R.id.intrapersonal_games_icon);
        intrapersonalGameCardTitle = view.findViewById(R.id.intrapersonal_seed_title_tv);
        intrapersonalGameCardConcept = view.findViewById(R.id.intrapersonal_seed_concept_tv);
        linguisticCardIV = view.findViewById(R.id.linguistic_games_icon);
        linguisticGameCardTitle = view.findViewById(R.id.linguistic_seed_title_tv);
        linguisticGameCardConcept = view.findViewById(R.id.linguistic_seed_concept_tv);
        spatialCardIV = view.findViewById(R.id.spatial_games_icon);
        spatialGameCardTitle = view.findViewById(R.id.spatial_seed_title_tv);
        spatialGameCardConcept = view.findViewById(R.id.spatial_seed_concept_tv);

        logicalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogicalGames = new Intent(getActivity(), LogicalGamesSplash.class);
                startActivity(toLogicalGames);
            }
        });

        badgeRecycler.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        BadgeAdapter badgeAdapter = new BadgeAdapter(progressBadgeArr);
        badgeRecycler.setAdapter(badgeAdapter);
        Log.d(TAG, "onCreateView: " + progressBadgeArr.length + badgeAdapter.getItemCount());

        return view;
    }


}
