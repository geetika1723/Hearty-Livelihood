package com.example.heartylivelihood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static android.graphics.Color.BLACK;

public class GainActivity extends AppCompatActivity
{
    ListView list;
    Custom_Gain adapter;
    String food[]={
            "Rice",
            "Milk",
            "Nuts and nut butters",
            "Red meats",
            "Potatoes and starches",
            "Salmon and oily fish",
            "Homemade protein smoothies"
    };
    Integer imageId[]={
            R.drawable.rice,
            R.drawable.milk,
            R.drawable.nuts,
            R.drawable.meat,
            R.drawable.potatoes,
            R.drawable.fish,
            R.drawable.protien
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain);
        adapter=new Custom_Gain(GainActivity.this,food,imageId);

        list=findViewById(R.id.listview);
        list.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.getOverflowIcon().setColorFilter(BLACK , PorterDuff.Mode.SRC_ATOP);

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
            getSupportActionBar().setDisplayShowTitleEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(GainActivity.this, MainActivity.class));
                }
            });
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==R.id.signout)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        else if(item.getItemId()==R.id.setting)
        {
            Toast.makeText(GainActivity.this,"You have selected the settings",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.search)
        {
            SearchView searchView=(SearchView) item.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s)
                {
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String s)
                {
                    adapter.getFilter().filter(s);
                    return false;
                }
            });
        }
        return true;
    }
}