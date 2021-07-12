package com.example.heartylivelihood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecipeInfo extends AppCompatActivity {

    public String title;
    public static final String TAG="DataBase";
    DatabaseReference myref;
    private TextView t1,t2,t3,t4,t5,t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);

        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("key_recipe");
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Topics");
        myref=ref.child("Healthy Recipes").child(title);

        t1=findViewById(R.id.name);
        t2=findViewById(R.id.time);
        t3=findViewById(R.id.difficulty);
        t4=findViewById(R.id.about);
        t5=findViewById(R.id.integredients);
        t6=findViewById(R.id.baking);

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailHeatlhyRecipe temp=snapshot.getValue(DetailHeatlhyRecipe.class);

                t1.setText(temp.title);
                t2.setText(temp.time);
                t3.setText(temp.difficulty);
                t4.setText(temp.about);
                t5.setText(temp.integredients);
                t6.setText(temp.baking);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG,"Failed to read Value",error.toException());
                Toast.makeText(RecipeInfo.this, "Failed to load post", Toast.LENGTH_SHORT).show();

            }
        });
    }
}