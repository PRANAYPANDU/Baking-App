package com.example.pranaykumar.bakingapp;


import java.util.ArrayList;

/**
 * Created by PRANAYKUMAR on 24-06-2017.
 */

public class Recipe{

  private String mRecipeName;
  private ArrayList<ArrayList<String>> mIngredients;
  private ArrayList<ArrayList<String>> mSteps;
  private int mId;
  private int mServings;
  public Recipe(int id,String vRecipeName,ArrayList<ArrayList<String>> vIngredients,ArrayList<ArrayList<String>> vSteps,int servings){
      mRecipeName=vRecipeName;
      mIngredients=vIngredients;
      mSteps=vSteps;
      mServings=servings;
  }

  public String getmRecipeName() {
    return mRecipeName;
  }
  public ArrayList<ArrayList<String>> getmIngredients(){
    return mIngredients;
  }
  public ArrayList<ArrayList<String>> getmSteps(){
    return mSteps;
  }

  public int getmId() {
    return mId;
  }

  public int getmServings() {
    return mServings;
  }
}
