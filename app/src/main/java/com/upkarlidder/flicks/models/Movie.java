package com.upkarlidder.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ulidder on 7/24/16.
 */
public class Movie {

    String posterPath;
    String title;
    String overView;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overView = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJsonArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for(int x = 0; x < array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }
}
