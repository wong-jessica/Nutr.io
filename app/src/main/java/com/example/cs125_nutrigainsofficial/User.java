package com.example.cs125_nutrigainsofficial;

import java.util.ArrayList;

public class User {
    private String userId;
    //private String authID;
    private String email;
    private String username;
    private String age;
    private String gender;
    private ArrayList<String> likes = new ArrayList<>();
    private ArrayList<String> dislikes = new ArrayList<>();
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

    User() {
    }

    User(String id, String email, String name, String age, String gender){
        this.userId = id;
        this.email = email;
        this.username = name;
        this.age = age;
        this.gender = gender;
        this.fat.add(30);
        this.fat.add(50);
        this.fiber.add(30);
        this.fiber.add(50);
        this.sodium.add(30);
        this.sodium.add(50);
        this.calories.add(30);
        this.calories.add(50);
        this.carbs.add(30);
        this.carbs.add(50);
        this.sugar.add(30);
        this.sugar.add(50);
        //this.authID = authid;
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

//    public void setIngredients(ArrayList<String> ingredients) {
//        this.ingredients = ingredients;
//    }

    public void addIngredients(String i){
        this.ingredients.add(i);
    }

    public void setIngredients(ArrayList<String> s){this.ingredients = s;}

    public ArrayList<Integer> getSugar() {
        return sugar;
    }

    public void addSugar(int i) {
        this.sugar.add(i);
    }

    public void setSugar(ArrayList<Integer> i){this.sugar = i;}

    public ArrayList<Integer> getCarbs() {
        return carbs;
    }

    public void addCarbs(int i) {
        this.carbs.add(i);
    }

    public void setCarbs(ArrayList<Integer> c){this.carbs = c;}

    public ArrayList<Integer> getCalories() {
        return calories;
    }

    public void addCalories(int i) {
        this.calories.add(i);
    }

    public void setCalories(ArrayList<Integer> c){this.calories = c;}

    public ArrayList<Integer> getSodium() {
        return sodium;
    }

    public void addSodium(int i) {
        this.sodium.add(i);
    }

    public void setSodium(ArrayList<Integer> s){this.sodium = s;}

    public ArrayList<Integer> getFiber() {
        return fiber;
    }

    public void addFiber(int i) {
        this.fiber.add(i);
    }

    public void setFiber(ArrayList<Integer> f){this.fiber = f;}

    public ArrayList<Integer> getFat() {
        return fat;
    }

    public void addFat(int i) {
        this.fat.add(i);
    }

    public void setFat(ArrayList<Integer> f){this.fat = f;}

    public ArrayList<String> getReligious() {
        return religious;
    }

    public void setReligious(ArrayList<String> religious) {
        this.religious = religious;
    }

    public void addReligious(String r){
        this.religious.add(r);
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public void addAllergies(String i){
        this.allergies.add(i);
    }

    public ArrayList<String> getDietChoice() {
        return dietChoice;
    }

    public void setDietChoice(ArrayList<String> dietChoice) {
        this.dietChoice = dietChoice;
    }

    public void addDietChoice(String d){
        this.dietChoice.add(d);
    }

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }

    public void addLikes(String l){
        this.likes.add(l);
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

    public ArrayList<String> getDislikes(){
        return dislikes;
    }

    public void setDislikes(ArrayList<String> d){
        this.dislikes = d;
    }

    public void addDislikes(String d){
        this.dislikes.add(d);
    }





}