package com.example.heartylivelihood;

import android.app.Activity;


import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Custom_Lose extends ArrayAdapter<String> implements Filterable {
    public final Activity context;
    private String[] food;
    private Integer[] imageId;
    String[] food1;
    final Integer[] imageId1;


    public Custom_Lose(Activity context, String[] food, Integer[] imageId)
    {
        super(context,R.layout.activity_custom__lose,food);
        this.context = context;
        this.food=food;
        this.imageId=imageId;
        food1=food;
        imageId1=imageId;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_custom__lose,null,true);
        TextView txtTitle=rowView.findViewById(R.id.txt);
        ImageView imageView=rowView.findViewById(R.id.img);
        txtTitle.setText(food[position]);
        txtTitle.setTextColor(Color.WHITE);
        imageView.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,LoseInfo.class);
                intent.putExtra("key_lose",food[position]);
                context.startActivity(intent);
            }
        });
        return rowView;
    }
    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String[] filteredList=new String[food1.length];
            if(charSequence.toString().isEmpty())
            {
                filteredList=food1;
            }
            else {
                int k=0;
                for (int i=0;i<food1.length;i++)
                {
                    if (food1[i].toLowerCase().equals(charSequence.toString()))
                        filteredList[k++]=food1[i];
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            food=(String []) filterResults.values;
            if (charSequence.toString().isEmpty()) {
                imageId=imageId1;
            }
            else
            {
                int k=0;
                for (int i=0;i<food1.length;i++)
                {
                    if (food1[i].toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        imageId[k]=imageId1[i];
                        k++;
                    }
                }
            }
            notifyDataSetChanged();
        }
    };
}