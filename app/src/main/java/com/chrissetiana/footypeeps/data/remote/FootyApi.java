package com.chrissetiana.footypeeps.data.remote;

import android.text.TextUtils;

import com.chrissetiana.footypeeps.data.model.FootyCompetitions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public interface FootyApi {

    static List<FootyCompetitions> getJSONData(String data) {
        if (TextUtils.isEmpty(data)) {
            return null;
        }

        List<FootyCompetitions> list = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
