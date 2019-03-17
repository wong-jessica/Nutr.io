package com.example.cs125_nutrigainsofficial;

public class User {
    private String userId;
    private String email;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String[] likes;
    private String[] dietChoice;
    private String[] allergies;
    private String[] religious;
    private int fat;
    private int fiber;
    private int sodium;
    private int calories;
    private int carbs;
    private int sugar;
    private String[] ingredients;
    private String[] favorites;

    User(String id, String email, String password, String name, int age, String gender){
        this.userId = id;
        this.email = email;
        this.password = password;
        this.username = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge(){return age;}

    public void setAge(int a){this.age = a;}

    public String getGender(){return gender;}

    public void setGender(String gen){this.gender = gen;}


    public String getUserId() {
        return userId;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
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

    public String[] getReligious() {
        return religious;
    }

    public void setReligious(String[] religious) {
        this.religious = religious;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public String[] getDietChoice() {
        return dietChoice;
    }

    public void setDietChoice(String[] dietChoice) {
        this.dietChoice = dietChoice;
    }

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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