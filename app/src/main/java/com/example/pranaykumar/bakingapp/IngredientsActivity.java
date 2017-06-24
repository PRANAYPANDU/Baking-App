package com.example.pranaykumar.bakingapp;

import static com.example.pranaykumar.bakingapp.R.id.ingredients;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import com.example.pranaykumar.bakingapp.databinding.ActivityIngredientsBinding;
import java.util.ArrayList;

public class IngredientsActivity extends AppCompatActivity {
ActivityIngredientsBinding ingredientsBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ingredients);
    setTitle("Ingredients");
    ingredientsBinding= DataBindingUtil.setContentView(this,R.layout.activity_ingredients);
    Intent intent=getIntent();
    Bundle bundle1=intent.getExtras();
    Bundle bundle= (Bundle) bundle1.get("ingredients");
    String textViewText="";

    Log.d("O_MY", String.valueOf(bundle.size()));
    for(int i=0;i<bundle.size();i++){
      ArrayList<String> currentIng=bundle.getStringArrayList(String.valueOf(i));
      textViewText=textViewText+String.valueOf(i+1)+"."+currentIng.get(2)+":"+currentIng.get(0)+" "+currentIng.get(1)+"\n";
    }
    ingredientsBinding.ingredientsTextView.setText(textViewText);

  }
}
