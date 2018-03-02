package com.udacity.sandwichclub.utils;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
        JSONObject mainObject = new JSONObject(json);

        JSONObject minObj = mainObject.getJSONObject("name");

        String mainName = minObj.getString("mainName");
        JSONArray alsoKnownAs = minObj.getJSONArray("alsoKnownAs");

        String placeOfOrigin = mainObject.getString("placeOfOrigin");

        String description = mainObject.getString("description");

        String image = mainObject.getString("image");


        Log.v("my_tag", "mainName is: " + mainName);
        Log.v("my_tag", "placeOfOrigin is: " + placeOfOrigin);
        Log.v("my_tag", "image is: " + image);
        Log.v("my_tag", "description is: " + description);

        JSONArray ingredientsArray = mainObject.getJSONArray("ingredients");
        List<String> alsoKnownAsList = new ArrayList<>();

        for (int i = 0; i < alsoKnownAs.length(); i++) {
            String alsoKnownAs1 = alsoKnownAs.getString(i);
            alsoKnownAsList.add(alsoKnownAs1);
        }

        List<String> ingredientsList = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredientsList.add(ingredientsArray.getString(i));
        }

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
        return sandwich;

    } catch (JSONException e) {
        e.printStackTrace();
    }

        return null;
    }
}
