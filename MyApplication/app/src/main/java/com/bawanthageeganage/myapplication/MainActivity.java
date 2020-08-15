package com.bawanthageeganage.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button main_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_pass=findViewById(R.id.main_pass);
    }

    public void pass(View view) {
        openLoginActivity();
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void fingerPrint(View view) {
        startActivity(new Intent(getApplicationContext(),fingerPrintActivity.class));
    }
}
