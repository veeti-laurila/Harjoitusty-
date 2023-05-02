package com.example.harjoitusty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(getApplicationContext(), AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view) {
        Intent intent = new Intent(getApplicationContext(), ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemons(View view) {
        Intent intent = new Intent(getApplicationContext(), MoveLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToFightLutemons(View view) {
        Intent intent = new Intent(getApplicationContext(), FightLutemonsActivity.class);
        startActivity(intent)   ;
    }
}