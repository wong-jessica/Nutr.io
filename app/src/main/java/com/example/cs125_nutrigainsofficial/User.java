package com.example.cs125_nutrigainsofficial;

import java.util.List;

public class User {
    private String userId;
    private String email;
    private String username;
    //private String password;
    private String age;
    private String gender;
    private List<String> likes;
    private List<String> dietChoice;
    private List<String> allergies;
    private List<String> religious;
    private int fat;
    private int fiber;
    private int sodium;
    private int calories;
    private int carbs;
    private int sugar;
    private List<String> ingredients;
    private List<String> favorites;

    User(String id, String email, String name, String age, String gender){
        this.userId = id;
        this.email = email;
        //this.password = password;
        this.username = name;
        this.age = age;
        this.gender = gender;
    }

    public String getAge(){return age;}

    public void setAge(String a){this.age = a;}

    public String getGender(){return gender;}

    public void setGender(String gen){this.gender = gen;}

    public String getUserId() {
        return userId;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public List<String> getReligious() {
        return religious;
    }

    public void setReligious(List<String> religious) {
        this.religious = religious;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDietChoice() {
        return dietChoice;
    }

    public void setDietChoice(List<String> dietChoice) {
        this.dietChoice = dietChoice;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }





}