package com.example.stevetran.pantryraider.Pantry.SavedRecipe;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SavedRecipe implements Serializable {

    public String title;
    public String description;
    public String imageUrl;
    public String instructionUrl;
    public String label;
    public int rid;

    public static ArrayList<SavedRecipe> getRecipesFromFile(String filename, Context context){
        final ArrayList<SavedRecipe> recipeList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("recipes.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray recipes = json.getJSONArray("recipes");

            // Get Recipe objects from data
            for(int i = 0; i < recipes.length(); i++){
                SavedRecipe recipe = new SavedRecipe();

                recipe.title = recipes.getJSONObject(i).getString("title");
                recipe.description = recipes.getJSONObject(i).getString("description");
                recipe.imageUrl = recipes.getJSONObject(i).getString("image");
                recipe.instructionUrl = recipes.getJSONObject(i).getString("url");
                recipe.label = recipes.getJSONObject(i).getString("dietLabel");
                recipe.rid = recipes.getJSONObject(i).getInt("rid");
                recipeList.add(recipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipeList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}