package com.example.cs125_nutrigainsofficial;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private List<RecipeCard> recipeList;
    private RecipeAdapter recipeAdapter;
//    final String userID = getIntent().getStringExtra("ID");
    private static final String TAG = SearchActivity.class.getName();


    private FirebaseDatabase FirebaseDB = FirebaseDatabase.getInstance();
    private DatabaseReference userDB = FirebaseDB.getReference("users");
//    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        FirebaseApp.initializeApp(SearchActivity.this);
        Log.d(TAG, "oncreate at least??");

//        fillRecipeList();
//        connectRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();

//        fillRecipeList();
//        connectRecyclerView();
        Log.d(TAG, "DO STUFF");

        TextView recipe_url = (TextView) findViewById(R.id.recipe_url);
        recipe_url.setText("TEST PLS");

        userDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                User user = dataSnapshot.getValue(User.class);
                Log.i("SearchActivity:", createQueryCall("Chicken"));
//                TextView recipe_url = findViewById(R.id.recipe_url);
//                recipe_url.setText(createQueryCall(user,"Chicken"));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("Unable to retrieve: ", error.toException());
            }
        });
    }


    private void fillRecipeList() {
        recipeList = new ArrayList<>();
        // will eventually fill out using parsed json recipe response from API
        // for now using hardcoded inputs
        String url1 = "http://3.bp.blogspot.com/-SLTPZFJnASs/TuXhjiHBbfI/AAAAAAAAAXk/jp35R_rahQ4/s1600/19a58e6b382be502_This_cute_car_like_sticking_tongue_out_1_.jpg";
        recipeList.add(new RecipeCard(url1, "Chicken Adobo", "Filipino Cuisine Central", "100", "4.9", "chicken, rice, peppercorn, vinegar"));
        recipeList.add(new RecipeCard(url1, "Waffles", "Breakfast Club", "123", "3.8", "flour, egg, milk, chocolate chips"));
    }

//    private void connectRecyclerView() {
//        RecyclerView recipeResults = findViewById(R.id.recipe_results);
////        recipeResults.setHasFixedSize(false);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recipeAdapter = new RecipeAdapter(recipeList);
//
//        recipeResults.setLayoutManager(layoutManager);
//        recipeResults.setAdapter(recipeAdapter);
//    }

    public static String encode(String s) {
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
    public String createQueryCall(String q) {
        final String APP_ID = "e6ee5f7d";
        final String APP_KEY = "bcf55972e39b5e7f20d9b329569a0359";
        String url = String.format("http://api.yummly.com/v1/api/recipes?_app_id=%s&_app_key=%s?", APP_ID, APP_KEY);
        String query = "";
        User user = LoginActivity.u;

        ArrayList<String> likes = user.getLikes();
        ArrayList<String> dislikes = user.getDislikes();
        ArrayList<String> dietChoice = user.getDietChoice();
        ArrayList<String> allergies = user.getAllergies();
        ArrayList<String> religious = user.getReligious();
        ArrayList<Integer> calories = user.getCalories();
        ArrayList<Integer> carbs = user.getCarbs();
        ArrayList<Integer> fat = user.getFat();
        ArrayList<Integer> fiber = user.getFiber();
        ArrayList<Integer> sodium = user.getSodium();
        ArrayList<Integer> sugar = user.getSugar();
        ArrayList<String> ingredients = user.getIngredients();

        if(!q.isEmpty()) {
            query += "q=" + encode(q) + "&";
        }

//        if(!likes.isEmpty()) {
//            for (String s : likes) {
//                // algorithm to preference foods with likes
//            }
//        }

        if(!dislikes.isEmpty()) {
            for (String s : dislikes) {
                query += "excludedIngredient[]=" + encode(s) + "&";
            }
        }

//        if(!ingredients.isEmpty()) {
//            for (String s : ingredients) {
//                query += "allowedIngredient[]=" + encode(s) + "&";
//                // algorithm to preference foods with already owned ingredients
//            }
//        }

        if(!dietChoice.isEmpty()) {
            for (String s : dietChoice) {
                query += "allowedDiet[]=" + encode(s) + "&";
            }
        }

        if(!allergies.isEmpty()) {
            for (String s : allergies) {
                query += "allowedAllergy[]=" + encode(s) + "&";
            }
        }

//        if(!religious.isEmpty()) {
//            for (String s : allergies) {
//                query += "allowedAllergy[]=" + encode(s) + "&";
//            }
//        }

        if(!fat.isEmpty()) {
            query += String.format("nutrition.FAT.min=%" + (float)fat.get(0)/1000 +
                    "&nutrition.FAT.max="+ (float)fat.get(1)/1000) + "&";
        }

        if(!fiber.isEmpty()) {
            query += String.format("nutrition.FIBTG.min=%" + (float)fiber.get(0)/1000 +
                    "&nutrition.FIBTG.max="+ (float)fiber.get(1)/1000) + "&";
        }

        if(!sodium.isEmpty()) {
            query += String.format("nutrition.NA.min=%" + (float)sodium.get(0)/1000 +
                    "&nutrition.NA.max="+ (float)sodium.get(1)/1000) + "&";
        }

        if(!calories.isEmpty()) {
            query += String.format("nutrition.ENERC_KCAL.min=%" + (float)calories.get(0)/1000 +
                    "&nutrition.ENERC_KCAL.max="+ (float)calories.get(1)/1000) + "&";
        }

        if(!carbs.isEmpty()) {
            query += String.format("nutrition.CHOCDF.min=%" + (float)carbs.get(0)/1000 +
                    "&nutrition.CHOCDF.max="+ (float)carbs.get(1)/1000) + "&";
        }

        if(!sugar.isEmpty()) {
            query += String.format("nutrition.SUGAR.min=%" + (float)sugar.get(0)/1000 +
                    "&nutrition.SUGAR.max="+ (float)sugar.get(1)/1000) + "&";
        }

        query += "requirePictures=true";
        return url + query;
    }

//    public static String createQueryCall(String q) {
//        return createQueryCall(LoginActivity.u, q);
//    }

//    public static void main(String args[]) {
//        System.out.println(createQueryCall("hello there", [], [], []));
//    }
}