package com.example.harjoitusty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FightLutemonsActivity extends AppCompatActivity {

    TextView textViewFight;
    private BattleField battleField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_lutemons);

        battleField = BattleField.getInstance();

        textViewFight = findViewById(R.id.textViewLutemonFight);

        ArrayList<Lutemon> lutemonsBattleField = battleField.getLutemonsBattleField();
        ArrayList<Lutemon> lutemonsFight = new ArrayList<>();

        // Creates CheckBox for every Lutemon in BattleField
        RadioGroup rgFight = findViewById(R.id.rgFight);
        for (Lutemon lutemon : lutemonsBattleField) {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            cb.setId(lutemon.getID());
            rgFight.addView(cb);
        }

        Button buttonFight = findViewById(R.id.buttonFightLutemons);
        buttonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lutemonsFight.clear();

                // Adds selected Lutemon to list
                for (Lutemon lutemon : lutemonsBattleField) {
                    CheckBox cb = findViewById(lutemon.getID());
                    if (cb.isChecked()) {
                        lutemonsFight.add(lutemon);
                    }
                }

                // Starts the fight
                if (lutemonsFight.size() >= 2) {
                    battleField.fight(lutemonsFight.get(0), lutemonsFight.get(1), textViewFight);
                }
            }
        });
    }
}