package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject sandwichData = new JSONObject(json);
            JSONObject name = sandwichData.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            String placeOfOrigin = sandwichData.getString("placeOfOrigin");
            String description = sandwichData.getString("description");
            String image = sandwichData.getString("image");
            JSONArray ingredients = sandwichData.getJSONArray("ingredients");

            ArrayList<String> alsoKnownAsList = new ArrayList<String>();
            if (alsoKnownAs != null) {
                for (int i=0;i<alsoKnownAs.length();i++){
                    alsoKnownAsList.add(alsoKnownAs.getString(i));
                }
            }

            ArrayList<String> ingredientsList = new ArrayList<String>();
            if (ingredients != null) {
                for (int i=0;i<ingredients.length();i++){
                    ingredientsList.add(ingredients.getString(i));
                }
            }
            sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin,
                    description, image, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
