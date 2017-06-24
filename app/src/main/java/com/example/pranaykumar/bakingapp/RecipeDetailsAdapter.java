package com.example.pranaykumar.bakingapp;

import android.content.Context;
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

public class RecipeDetailsAdapter extends RecyclerView.Adapter<RecipeDetailsAdapter.RecipeDetailsAdapterViewHolder>{
  Context context;
  private ArrayList<ArrayList<String>> mStepsData;
  public RecipeDetailsAdapter(ArrayList<ArrayList<String>>stepsData){
    mStepsData=stepsData;
  }

  @Override
  public RecipeDetailsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    context=parent.getContext();
    int layoutForListItem=R.layout.list_item_step_details;
    LayoutInflater inflater=LayoutInflater.from(context);
    View view=inflater.inflate(layoutForListItem,parent,false);

    return new RecipeDetailsAdapterViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecipeDetailsAdapterViewHolder holder, int position) {
    ArrayList<String> currentStep=mStepsData.get(position);
    holder.mStepDesc.setText(currentStep.get(0));
  }

  @Override
  public int getItemCount() {
    return mStepsData.size();
  }

  public class RecipeDetailsAdapterViewHolder extends ViewHolder {
    public final TextView mStepDesc;
    public RecipeDetailsAdapterViewHolder(View itemView) {
      super(itemView);
      mStepDesc=(TextView)itemView.findViewById(R.id.step_desc);
    }
  }
}
