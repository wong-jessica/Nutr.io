# CS125NutriGainsOfficial
Project for CS125 Next Generation Search Systems
Summary:
  Our app, called Nutr.io is meant to help users decide what to make based on what ingredients they have and their likes/dislikes,  allergies, etc.  We are building a personal user model so that recipes are uniquely catered to each user. 
  
  When the app is started up, LoginActivity is brought up.  Inside this activity view, we have two buttons 
  where the user can register or sign in to their account.  If the user is registering, InputPreferencesActivity
  is brought up where the user can input their preferences.  InputPreferencesActivity leads to the IngredientsActivity
  where the user can input their existing ingredients.  If the user is signing in, then SearchActivity is brought up
  where recipes catered towards the user are displayed.  To do this, a url is built up using the user's 
  preferences and then this url is sent to the Yummly API and the correct results are pulled.  We are actively putting in user 
  information to the Firebase database so that the correct information can be retrieved when we are making API calls.
