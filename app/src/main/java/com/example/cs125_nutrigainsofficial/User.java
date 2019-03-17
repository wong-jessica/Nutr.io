package com.example.cs125_nutrigainsofficial;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String email;
    private String username;
    private String age;
    private String gender;
    private ArrayList<String> likes = new ArrayList<>();
    private ArrayList<String> dietChoice = new ArrayList<>();
    private ArrayList<String> allergies = new ArrayList<>();
    private ArrayList<String> religious = new ArrayList<>();
    private ArrayList<Integer> fat = new ArrayList<>();
    private ArrayList<Integer> fiber = new ArrayList<>();
    private ArrayList<Integer> sodium = new ArrayList<>();
    private ArrayList<Integer> calories = new ArrayList<>();
    private ArrayList<Integer> carbs = new ArrayList<>();
    private ArrayList<Integer> sugar = new ArrayList<>();
    private ArrayList<String> ingredients = new ArrayList<>();
    private ArrayList<String> favorites = new ArrayList<>();

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

    public ArrayList<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<String> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Integer> getSugar() {
        return sugar;
    }

    public void setSugar(ArrayList<Integer> sugar) {
        this.sugar = sugar;
    }

    public ArrayList<Integer> getCarbs() {
        return carbs;
    }

    public void setCarbs(ArrayList<Integer> carbs) {
        this.carbs = carbs;
    }

    public ArrayList<Integer> getCalories() {
        return calories;
    }

    public void setCalories(ArrayList<Integer> calories) {
        this.calories = calories;
    }

    public ArrayList<Integer> getSodium() {
        return sodium;
    }

    public void setSodium(ArrayList<Integer> sodium) {
        this.sodium = sodium;
    }

    public ArrayList<Integer> getFiber() {
        return fiber;
    }

    public void setFiber(ArrayList<Integer> fiber) {
        this.fiber = fiber;
    }

    public ArrayList<Integer> getFat() {
        return fat;
    }

    public void setFat(ArrayList<Integer> fat) {
        this.fat = fat;
    }

    public ArrayList<String> getReligious() {
        return religious;
    }

    public void setReligious(ArrayList<String> religious) {
        this.religious = religious;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public ArrayList<String> getDietChoice() {
        return dietChoice;
    }

    public void setDietChoice(ArrayList<String> dietChoice) {
        this.dietChoice = dietChoice;
    }

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
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