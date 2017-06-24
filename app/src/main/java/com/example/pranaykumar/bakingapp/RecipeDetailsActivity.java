package com.example.pranaykumar.bakingapp;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.example.pranaykumar.bakingapp.databinding.ActivityRecipeDetailsBinding;

public class RecipeDetailsActivity extends AppCompatActivity {

ActivityRecipeDetailsBinding recipeDetailsBinding;
  private RecipeDetailsAdapter adapter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe_details);
    recipeDetailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_recipe_details);


    Intent intent=getIntent();
    Bundle b=intent.getExtras();
    Recipe currentRecipe=b.getParcelable("recipe");
    setTitle(currentRecipe.getmRecipeName());

    LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    recipeDetailsBinding.stepsRecyclerView.setLayoutManager(layoutManager);
    recipeDetailsBinding.stepsRecyclerView.setHasFixedSize(true);
    adapter=new RecipeDetailsAdapter(currentRecipe.getmSteps());

    recipeDetailsBinding.stepsRecyclerView.setAdapter(adapter);
    final Intent ingredientsIntent=new Intent(RecipeDetailsActivity.this,IngredientsActivity.class);
    Bundle ingredients=new Bundle();
    for(int i=0;i<currentRecipe.getmIngredients().size();i++){
      ingredients.putStringArrayList(String.valueOf(i),currentRecipe.getmIngredients().get(i));
    }
    Log.d("O_MY", "BEFORE="+String.valueOf(ingredients.size()));
    ingredientsIntent.putExtra("ingredients",ingredients);
    recipeDetailsBinding.ingredients.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

        startActivity(ingredientsIntent);
      }
    });
  }

}
