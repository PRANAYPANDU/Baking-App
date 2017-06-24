package com.example.pranaykumar.bakingapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import org.w3c.dom.Text;

/**
 * Created by PRANAYKUMAR on 24-06-2017.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesAdapterViewHolder> {

  private ArrayList<Recipe> mRecipesData;

  public RecipesAdapter(ArrayList<Recipe> recipes) {
    mRecipesData=recipes;
  }

  @Override
  public RecipesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    int layoutForGridItem=R.layout.grid_item;
    LayoutInflater inflater=LayoutInflater.from(parent.getContext());

    View view=inflater.inflate(layoutForGridItem,parent,false);
    return new RecipesAdapterViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecipesAdapterViewHolder holder, int position) {
    holder.mRecipeName.setText(mRecipesData.get(position).getmRecipeName());
  }
  @Override
  public int getItemCount() {
    if(null==mRecipesData)return 0;
    return mRecipesData.size();
  }

  public void setmRecipesData(ArrayList<Recipe> mRecipesData) {
    this.mRecipesData = mRecipesData;
    notifyDataSetChanged();
  }

  public class RecipesAdapterViewHolder extends ViewHolder {

    public final TextView mRecipeName;
    public RecipesAdapterViewHolder(View itemView) {
      super(itemView);
      mRecipeName=(TextView)itemView.findViewById(R.id.recipe_name);

    }
  }
}
