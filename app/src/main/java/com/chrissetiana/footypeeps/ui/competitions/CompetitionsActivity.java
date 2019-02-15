package com.chrissetiana.footypeeps.ui.competitions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chrissetiana.footypeeps.R;

public class CompetitionsActivity extends Fragment {

    public CompetitionsActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_competitions, container, false);
    }
}
