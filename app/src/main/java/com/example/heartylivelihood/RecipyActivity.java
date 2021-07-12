package com.example.heartylivelihood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static android.graphics.Color.BLACK;

public class RecipyActivity extends AppCompatActivity {

    ListView list;
    Custom_Recipe adapter;

    String[] food={
            "Baked Yogurt",
            "Chilli Oil Avocado Salad",
            "Basil Pesto & Walnut Chicken Breast ",
            "Coconut Milk Porridge",
            "Oat Milk Smoothie",
            "Cheesy Potato and Quinoa Cake",
            "Almond, ginger and custard apple smoothie"
    };
    Integer[] imageId={
            R.drawable.recipe1,
            R.drawable.recipe2,
            R.drawable.recipe3,
            R.drawable.recipe4,
            R.drawable.recipe5,
            R.drawable.recipe6,
            R.drawable.recipe7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipy);

        adapter=new Custom_Recipe(RecipyActivity.this,food,imageId);

        list=findViewById(R.id.listviewRecipe);
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
                    startActivity(new Intent(RecipyActivity.this, MainActivity.class));
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
            Toast.makeText(RecipyActivity.this,"You have selected the settings",Toast.LENGTH_LONG).show();
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