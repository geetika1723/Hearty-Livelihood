package com.example.heartylivelihood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GainInfo extends AppCompatActivity {
    public String title;
    public static final String TAG="DataBase";
    DatabaseReference myref;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_info);

        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("key_gain");
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Topics");
        myref=ref.child("Gain weight").child(title);

        t1=findViewById(R.id.name);
        t2=findViewById(R.id.calorie);
        t3=findViewById(R.id.right_time);
        t4=findViewById(R.id.worst_time);
        t5=findViewById(R.id.best_consume);
        t6=findViewById(R.id.fat);
        t7=findViewById(R.id.sodium);
        t8=findViewById(R.id.carbo);
        t9=findViewById(R.id.fiber);
        t10=findViewById(R.id.sugar);
        t11=findViewById(R.id.protien);
        t12=findViewById(R.id.benifits);

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailGain temp=snapshot.getValue(DetailGain.class);

                t1.setText(temp.title);
                t2.setText(temp.calorie);
                t3.setText(temp.right_time);
                t4.setText(temp.worst_time);
                t5.setText(temp.best_consume);
                t6.setText(temp.fat);
                t7.setText(temp.sodium);
                t8.setText(temp.carbo);
                t9.setText(temp.fiber);
                t10.setText(temp.sugar);
                t11.setText(temp.protien);
                t12.setText(temp.benifits);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG,"Failed to read Value",error.toException());
                Toast.makeText(GainInfo.this, "Failed to load post", Toast.LENGTH_SHORT).show();

            }
        });
    }
}