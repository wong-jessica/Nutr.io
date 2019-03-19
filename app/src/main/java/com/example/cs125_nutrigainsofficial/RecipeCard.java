package com.example.cs125_nutrigainsofficial;

public class RecipeCard {
    private String recipe_image;
    private String recipe_name;
    private String recipe_source;
    private String recipe_cook_time;
    private String recipe_rating;
    private String recipe_ingredients;

    public RecipeCard(String recipe_image, String recipe_name, String recipe_source,
                      String recipe_cook_time, String recipe_rating, String recipe_ingredients) {
        this.recipe_image = recipe_image;
        this.recipe_name = recipe_name;
        this.recipe_source = recipe_source;
        this.recipe_cook_time = recipe_cook_time;
        this.recipe_rating = recipe_rating;
        this.recipe_ingredients = recipe_ingredients;
    }

    public String getRecipeImage() {
        return recipe_image;
    }

    public String getRecipeName() {
        return recipe_name;
    }

    public String getRecipeSource() {
        return recipe_source;
    }

    public String getRecipeCookTime() {
        return recipe_cook_time;
    }

    public String getRecipeRating() {
        return recipe_rating;
    }

    public String getRecipeIngredients() {
        return recipe_ingredients;
    }
}
