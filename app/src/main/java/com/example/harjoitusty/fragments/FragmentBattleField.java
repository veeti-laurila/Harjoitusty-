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
import com.example.harjoitusty.TrainingArea;

import java.util.ArrayList;

public class FragmentBattleField extends Fragment {

    private BattleField battleField;
    private TrainingArea trainingArea;
    private Home home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_battlefield, container, false);

        battleField = BattleField.getInstance();
        trainingArea = TrainingArea.getInstance();
        home = Home.getInstance();

        ArrayList<Lutemon> lutemonsBattleField = battleField.getLutemonsBattleField();
        RadioGroup rgMoveBattleField = view.findViewById(R.id.RadioGroupMoveBattleField);

        // Creates RadioButton for every Lutemon in BattleField
        for (Lutemon lutemon : lutemonsBattleField) {
            RadioButton rb = new RadioButton(view.getContext());
            rb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            rb.setId(lutemon.getID());
            rgMoveBattleField.addView(rb);
        }

        rgMoveBattleField.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

            }
        });

        Button buttonMoveBattleField = view.findViewById(R.id.buttonMoveBattleField);
        RadioGroup rgBattleField = view.findViewById(R.id.radioGroupBattleField);

        buttonMoveBattleField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rgBattleField != null) {
                    Lutemon lutemonRemove = null;
                    int selectedRadioButtonId = rgMoveBattleField.getCheckedRadioButtonId();

                    // Adds selected Lutemon to list
                    for (Lutemon lutemon : lutemonsBattleField) {
                        if (lutemon.getID() == selectedRadioButtonId) {
                            lutemonRemove = lutemon;
                            break;
                        }
                    }

                    // Moves Lutemon to selected place and removes it from BattleField
                    if (lutemonRemove != null) {
                        switch (rgBattleField.getCheckedRadioButtonId()) {
                            case (R.id.radioButtonHomeBattleField):
                                home.createLutemon(lutemonRemove);
                                home.addLutemonToLutemonsMovedToHome(lutemonRemove);
                                break;
                            case (R.id.radioButtonTrainingAreaBattleField):
                                trainingArea.addLutemonToTrainingArea(lutemonRemove);
                                trainingArea.train(lutemonRemove);
                                break;
                        }
                        battleField.removeLutemonFromBattleField(lutemonRemove.getID());
                    }
                    rgBattleField.clearCheck();
                    rgMoveBattleField.clearCheck();
                }
            }
        });
        return view;
    }
}