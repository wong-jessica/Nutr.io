package com.example.cs125_nutrigainsofficial;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserDatabase {
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

    private FirebaseDatabase FirebaseDB = FirebaseDatabase.getInstance();
    private DatabaseReference userDB = FirebaseDB.getReference("users");
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser currentUserID = mAuth.getCurrentUser();
    private DatabaseReference user = userDB.child(currentUserID.getUid());

    public User userRef;

    private void setLikes() {
        user.child("likes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String like = child.getValue(String.class);
                    likes.add(like);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(likes.size() != 0)
            userRef.setLikes(likes);
    }

    private void setDislikes() {
        user.child("dislikes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String dislike = child.getValue(String.class);
                    dislikes.add(dislike);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(dislikes.size() != 0)
            userRef.setDislikes(dislikes);
    }

    private void setdietChoice() {
        user.child("dietChoice").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String diet = child.getValue(String.class);
                    dietChoice.add(diet);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(dietChoice.size() != 0)
            userRef.setDietChoice(dietChoice);
    }

    private void setAllergies() {
        user.child("allergies").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String allergy = child.getValue(String.class);
                    allergies.add(allergy);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(allergies.size() != 0)
           userRef.setAllergies(allergies);
    }

    private void setReligious() {
        user.child("religious").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String religion = child.getValue(String.class);
                    religious.add(religion);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(religious.size() != 0)
            userRef.setReligious(religious);
    }

    private void setFat() {
        user.child("fat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Integer f = child.getValue(Integer.class);
                    fat.add(f);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(fat.size() != 0)
            userRef.setFat(fat);
    }

    private void setFiber() {
        user.child("fiber").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Integer f = child.getValue(Integer.class);
                    fiber.add(f);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(fiber.size() != 0)
            userRef.setFiber(fiber);
    }

    private void setSodium() {
        user.child("sodium").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Integer s = child.getValue(Integer.class);
                    sodium.add(s);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(sodium.size() != 0)
            userRef.setSodium(sodium);
    }

    private void setCalories() {
        user.child("calories").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Integer c = child.getValue(Integer.class);
                    calories.add(c);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(calories.size() != 0)
            userRef.setCalories(calories);
    }

    private void setCarbs() {
        user.child("carbs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Integer c = child.getValue(Integer.class);
                    carbs.add(c);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(carbs.size() != 0)
            userRef.setCarbs(carbs);
    }

    private void setSugar() {
        user.child("sugar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Integer s = child.getValue(Integer.class);
                    sugar.add(s);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(sugar.size() != 0)
            userRef.setSugar(sugar);
    }

    public void setIngredients() {
        user.child("ingredients").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String i = child.getValue(String.class);
                    ingredients.add(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(ingredients.size() != 0)
            userRef.setIngredients(ingredients);
    }

    public void setFavorites() {
        user.child("favorites").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String f = child.getValue(String.class);
                    favorites.add(f);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        if(favorites.size() != 0)
            userRef.setFavorites(favorites);
    }

    public void createUser(){
        setLikes();
        setDislikes();
        setdietChoice();
        setAllergies();
        setReligious();
        setFat();
        setFiber();
        setSodium();
        setCalories();
        setCarbs();
        setSugar();
        setIngredients();
        setFavorites();
    }


}
