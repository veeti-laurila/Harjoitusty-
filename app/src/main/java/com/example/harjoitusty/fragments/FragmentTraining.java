package com.example.harjoitusty.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.harjoitusty.BattleField;
import com.example.harjoitusty.Home;
import com.example.harjoitusty.Lutemon;
import com.example.harjoitusty.R;
import com.example.harjoitusty.Storage;
import com.example.harjoitusty.TrainingArea;

import java.util.ArrayList;

public class FragmentTraining extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_training, container, false);

        battleField = BattleField.getInstance();
        trainingArea = TrainingArea.getInstance();
        home = Home.getInstance();

        ArrayList<Lutemon> lutemonsTraining = trainingArea.getLutemonsTrainingArea();
        RadioGroup rgMoveTraining = view.findViewById(R.id.RadioGroupMoveTraining);

        // Creates RadioButton for every Lutemon in TrainingArea
        for (Lutemon lutemon : lutemonsTraining) {
            RadioButton rb = new RadioButton(view.getContext());
            rb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            rb.setId(lutemon.getID());
            rgMoveTraining.addView(rb);
        }

        rgMoveTraining.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

            }
        });

        Button buttonMoveTraining = view.findViewById(R.id.buttonMoveTraining);
        RadioGroup rgTraining = view.findViewById(R.id.radioGroupTraining);

        buttonMoveTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rgTraining != null) {
                    Lutemon lutemonRemove = null;
                    int selectedRadioButtonId = rgMoveTraining.getCheckedRadioButtonId();

                    // Adds selected Lutemon to list
                    for (Lutemon lutemon : lutemonsTraining) {
                        if (lutemon.getID() == selectedRadioButtonId) {
                            lutemonRemove = lutemon;
                            break;
                        }
                    }

                    // Moves Lutemon to selected place and removes it from TrainingArea
                    if (lutemonRemove != null) {
                        switch (rgTraining.getCheckedRadioButtonId()) {
                            case (R.id.radioButtonHomeTraining):
                                home.createLutemon(lutemonRemove);
                                home.addLutemonToLutemonsMovedToHome(lutemonRemove);
                                break;
                            case (R.id.radioButtonBattleFieldTraining):
                                battleField.addLutemonToBattleField(lutemonRemove);
                                break;
                        }
                        trainingArea.removeLutemonFromTraining(lutemonRemove.getID());
                    }
                    rgTraining.clearCheck();
                    rgMoveTraining.clearCheck();
                }
            }
        });
        return view;
    }
}