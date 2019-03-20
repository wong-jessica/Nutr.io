package com.example.cs125_nutrigainsofficial;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity{
    private RecipeAdapter adapter;
    private List<RecipeCard> recipeList;
    private static final String TAG = SearchActivity.class.getName();

//    private FirebaseDatabase FirebaseDB = FirebaseDatabase.getInstance();
//    private DatabaseReference userDB = FirebaseDB.getReference("users");
//    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    private FirebaseUser currentUserID = mAuth.getCurrentUser();
//    private DatabaseReference user = userDB.child(currentUserID.getUid());

    private UserDatabase userDatabase;
    private User db = userDatabase.userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        fillRecipeList();
        connectRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    private void fillRecipeList() {
        recipeList = new ArrayList<>();
        String image = "http://3.bp.blogspot.com/-SLTPZFJnASs/TuXhjiHBbfI/AAAAAAAAAXk/jp35R_rahQ4/s1600/19a58e6b382be502_This_cute_car_like_sticking_tongue_out_1_.jpg";
//        String title = "Chicken Adobo";
//        String source = "Breakfast Club";
//        String rating = "4.5";
//        String ingredients = "flour, egg, milk, chocolate chips";
//        recipe.add(image);
//        recipe.add(title);
//        recipe.add(source);
//        recipe.add(rating);
//        recipe.add(ingredients);
        recipeList.add(new RecipeCard(image, "Chicken Adobo", "Filipino Cuisine Central", "100", "4.9", "chicken, rice, peppercorn, vinegar"));
        recipeList.add(new RecipeCard(image, "Waffles", "Breakfast Club", "123", "3.8", "flour, egg, milk, chocolate chips"));
    }

    private void connectRecyclerView() {
        RecyclerView recipeResults = findViewById(R.id.recipe_results);
        recipeResults.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
        adapter = new RecipeAdapter(recipeList);

        recipeResults.setLayoutManager(layoutManager);
        recipeResults.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recipe_menu, menu);

        MenuItem searchRecipe = menu.findItem(R.id.recipe_search);
        SearchView searchView = (SearchView) searchRecipe.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newQuery) {
                adapter.getFilter().filter(newQuery);
                return false;
            }
        });
        return true;
    }

    private static String encode(String s) {
        try {
            String encoded = URLEncoder.encode(s, "UTF-8");
            return encoded;
        } catch (UnsupportedEncodingException e) {
            return "Unable to encode: " + e.getMessage();
        }
    }

    /**
     * Takes a query and returns a url to send to YummlyAPI.
     * @param q The user's inputted query.
     * @return A URL.
     */
    private static String createQueryCall(String q) {
        final String APP_ID = "e6ee5f7d";
        final String APP_KEY = "bcf55972e39b5e7f20d9b329569a0359";
        String url = String.format("http://api.yummly.com/v1/api/recipes?_app_id=%s&_app_key=%s?", APP_ID, APP_KEY);
        String query = "";
//
//        ArrayList<String> likes = user.getLikes();
//        ArrayList<String> dislikes = user.getDislikes();
//        ArrayList<String> dietChoice = user.getDietChoice();
//        ArrayList<String> allergies = user.getAllergies();
//        ArrayList<String> religious = user.getReligious();
//        ArrayList<Integer> calories = user.getCalories();
//        ArrayList<Integer> carbs = user.getCarbs();
//        ArrayList<Integer> fat = user.getFat();
//        ArrayList<Integer> fiber = user.getFiber();
//        ArrayList<Integer> sodium = user.getSodium();
//        ArrayList<Integer> sugar = user.getSugar();
//        ArrayList<String> ingredients = user.getIngredients();
//
//        if(!q.isEmpty()) {
//            query += "q=" + encode(q) + "&";
//        }
//
////        if(!likes.isEmpty()) {
////            for (String s : likes) {
////                // algorithm to preference foods with likes
////            }
////        }
//
//        Log.i(TAG, "HELLOO");
//        if(!dislikes.isEmpty()) {
//            for (String s : dislikes) {
//                query += "excludedIngredient[]=" + encode(s) + "&";
//            }
//        }
//
////        if(!ingredients.isEmpty()) {
////            for (String s : ingredients) {
////                query += "allowedIngredient[]=" + encode(s) + "&";
////                // algorithm to preference foods with already owned ingredients
////            }
////        }
//
//        if(!dietChoice.isEmpty()) {
//            for (String s : dietChoice) {
//                query += "allowedDiet[]=" + encode(s) + "&";
//            }
//        }
//
//        if(!allergies.isEmpty()) {
//            for (String s : allergies) {
//                query += "allowedAllergy[]=" + encode(s) + "&";
//            }
//        }
//
////        if(!religious.isEmpty()) {
////            for (String s : allergies) {
////                query += "allowedAllergy[]=" + encode(s) + "&";
////            }
////        }
//
//        if(!fat.isEmpty()) {
//            query += String.format("nutrition.FAT.min=%" + (float)fat.get(0)/1000 +
//                    "&nutrition.FAT.max="+ (float)fat.get(1)/1000) + "&";
//        }
//
//        if(!fiber.isEmpty()) {
//            query += String.format("nutrition.FIBTG.min=%" + (float)fiber.get(0)/1000 +
//                    "&nutrition.FIBTG.max="+ (float)fiber.get(1)/1000) + "&";
//        }
//
//        if(!sodium.isEmpty()) {
//            query += String.format("nutrition.NA.min=%" + (float)sodium.get(0)/1000 +
//                    "&nutrition.NA.max="+ (float)sodium.get(1)/1000) + "&";
//        }
//
//        if(!calories.isEmpty()) {
//            query += String.format("nutrition.ENERC_KCAL.min=%" + (float)calories.get(0)/1000 +
//                    "&nutrition.ENERC_KCAL.max="+ (float)calories.get(1)/1000) + "&";
//        }
//
//        if(!carbs.isEmpty()) {
//            query += String.format("nutrition.CHOCDF.min=%" + (float)carbs.get(0)/1000 +
//                    "&nutrition.CHOCDF.max="+ (float)carbs.get(1)/1000) + "&";
//        }
//
//        if(!sugar.isEmpty()) {
//            query += String.format("nutrition.SUGAR.min=%" + (float)sugar.get(0)/1000 +
//                    "&nutrition.SUGAR.max="+ (float)sugar.get(1)/1000) + "&";
//        }
//
//        query += "requirePictures=true";
        return url + q;
    }
}