package com.example.harjoitusty.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.harjoitusty.BattleField;
import com.example.harjoitusty.Home;
import com.example.harjoitusty.Lutemon;
import com.example.harjoitusty.R;
import com.example.harjoitusty.Storage;
import com.example.harjoitusty.TrainingArea;

import java.util.ArrayList;

public class FragmentFight extends Fragment {

    private Home home;
    private Storage storage;
    private TrainingArea trainingArea;
    private BattleField battleField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fight, container, false);

        home = Home.getInstance();
        trainingArea = TrainingArea.getInstance();
        battleField = BattleField.getInstance();
        storage = Storage.getInstance();

        ArrayList<Lutemon> lutemonsMove = new ArrayList<>();

        ArrayList<Lutemon> lutemonsBattleField = battleField.getLutemonsBattleField();
        RadioGroup rgMoveBattleField = view.findViewById(R.id.RadioGroupMoveFight);

        for (Lutemon lutemon : lutemonsBattleField) {
            RadioButton rb = new RadioButton(view.getContext());
            rb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            rb.setId(lutemon.getID());
            rgMoveBattleField.addView(rb);
        }

        Button buttonMoveHome = view.findViewById(R.id.buttonMoveFight);

        buttonMoveHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Lutemon lutemon : lutemonsBattleField) {
                    RadioButton rb = view.findViewById(lutemon.getID());
                    if (rb.isChecked()) {
                        lutemonsMove.add(lutemon);
                    }
                }

                RadioGroup rgBattleField = view.findViewById(R.id.radioGroupFight);
                switch (rgBattleField.getCheckedRadioButtonId()) {
                    case (R.id.radioButtonBattleFieldTraining):
                        for (Lutemon lutemon : lutemonsMove) {
                            trainingArea.addLutemonToTrainingArea(lutemon);
                            battleField.removeItemFromBattleField(lutemon.getID());
                        }
                        break;
                    case (R.id.radioButtonBattleFieldHome):
                        for (Lutemon lutemon : lutemonsMove) {
                            home.createLutemon(lutemon);
                            battleField.removeItemFromBattleField(lutemon.getID());
                        }
                        break;
                };
            }
        });
        return view;
    }
}