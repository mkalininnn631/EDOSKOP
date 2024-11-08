package com.example.edoskop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import android.content.Intent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            mDatabase.child(user.getUid()).get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    String username = task.getResult().getValue(String.class);
                    welcomeTextView.setText("Добро пожаловать, " + username + "!");
                }
            });
        }

        findViewById(R.id.favoritesButton).setOnClickListener(view ->
                startActivity(new Intent(ProfileActivity.this, FavoritesActivity.class)));
        findViewById(R.id.myRecipesButton).setOnClickListener(view ->
                startActivity(new Intent(ProfileActivity.this, MyRecipesActivity.class)));
        findViewById(R.id.searchRecipesButton).setOnClickListener(view ->
                startActivity(new Intent(ProfileActivity.this, SearchRecipesActivity.class)));
    }
}

