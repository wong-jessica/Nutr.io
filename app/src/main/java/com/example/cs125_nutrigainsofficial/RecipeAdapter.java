package com.example.cs125_nutrigainsofficial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private List<RecipeCard> recipeList;
    private List<RecipeCard> recipeListFilled;

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        ImageView recipe_image;
        TextView recipe_name;
        TextView recipe_source;
        TextView recipe_cook_time;
        TextView recipe_rating;
        TextView recipe_ingredients;

        RecipeViewHolder(View itemView) {
            super(itemView);
            recipe_image = itemView.findViewById(R.id.recipe_image);
            recipe_name = itemView.findViewById(R.id.recipe_name);
            recipe_source = itemView.findViewById(R.id.recipe_source);
            recipe_cook_time = itemView.findViewById(R.id.recipe_cook_time);
            recipe_rating = itemView.findViewById(R.id.recipe_rating);
            recipe_ingredients = itemView.findViewById(R.id.recipe_ingredients);
        }
    }

    RecipeAdapter(List<RecipeCard> recipeList) {
        this.recipeList = recipeList;
        recipeListFilled = new ArrayList<>(recipeList);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new RecipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        RecipeCard currentRecipe = recipeList.get(position);
//        holder.recipe_image.setImageResource(currentRecipe.getRecipeImage());
        Picasso.get().load(currentRecipe.getRecipeImage()).into(holder.recipe_image);
        holder.recipe_name.setText(currentRecipe.getRecipeName());
        holder.recipe_source.setText(currentRecipe.getRecipeSource());
        holder.recipe_cook_time.setText(currentRecipe.getRecipeCookTime());
        holder.recipe_rating.setText(currentRecipe.getRecipeRating());
        holder.recipe_ingredients.setText(currentRecipe.getRecipeIngredients());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
