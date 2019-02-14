package com.chrissetiana.footypeeps.ui.standings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chrissetiana.footypeeps.R;

public class StandingsFragment extends Fragment {

    public StandingsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_standings, container, false);
    }
}
