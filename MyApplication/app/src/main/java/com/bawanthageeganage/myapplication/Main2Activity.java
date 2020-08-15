package com.bawanthageeganage.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Main2Activity extends AppCompatActivity {

    FirebaseFirestore db;
    Button unlockBtn,sendBtn;
    TextView showSomething;

    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showSomething = findViewById(R.id.showSomething);
        unlockBtn = findViewById(R.id.sendBtn);
        sendBtn = findViewById(R.id.sendBtn);


    }
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    // logout from the menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        return true;
    }


    public void unlock(View view) {

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        reference.setValue(1);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.unlocked);
        mp.start();


    }

    public void lock(View view) {

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        reference.setValue(0);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.locked);
        mp.start();
    }
}



