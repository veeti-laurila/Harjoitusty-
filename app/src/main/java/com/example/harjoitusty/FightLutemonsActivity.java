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
    private Storage storage;
    private BattleField battleField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_lutemons);

        storage = Storage.getInstance();
        battleField = BattleField.getInstance();

        ArrayList<Lutemon> lutemons = storage.getLutemons();
        ArrayList<Lutemon> lutemonsFight = new ArrayList<>();

        RadioGroup rgFight = findViewById(R.id.rgFight);
        for (Lutemon lutemon : lutemons) {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            cb.setId(lutemon.getID());
            rgFight.addView(cb);
        }

        Button buttonFight = findViewById(R.id.buttonFightLutemons);
        buttonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Lutemon lutemon : lutemons) {
                    CheckBox cb = new CheckBox(getApplicationContext());
                    if (cb.isChecked()) {
                        lutemonsFight.add(lutemon);
                    }
                }
            }
        });

        textViewFight = findViewById(R.id.textViewLutemonFight);
    }
}