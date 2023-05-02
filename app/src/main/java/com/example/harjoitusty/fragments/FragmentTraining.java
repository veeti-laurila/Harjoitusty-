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

public class FragmentTraining extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_training, container, false);

        home = Home.getInstance();
        trainingArea = TrainingArea.getInstance();
        battleField = BattleField.getInstance();
        storage = Storage.getInstance();

        ArrayList<Lutemon> lutemonsMove = new ArrayList<>();

        ArrayList<Lutemon> lutemonsTraining = trainingArea.getLutemonsTrainingArea();
        RadioGroup rgMoveHome = view.findViewById(R.id.RadioGroupMoveTraining);

        for (Lutemon lutemon : lutemonsTraining) {
            RadioButton rb = new RadioButton(view.getContext());
            rb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            rb.setId(lutemon.getID());
            rgMoveHome.addView(rb);
        }

        Button buttonMoveTraining = view.findViewById(R.id.buttonMoveTraining);

        buttonMoveTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Lutemon lutemon : lutemonsTraining) {
                    RadioButton rb = view.findViewById(lutemon.getID());
                    if (rb.isChecked()) {
                        lutemonsMove.add(lutemon);
                    }
                }

                RadioGroup rgTraining = view.findViewById(R.id.radioGroupTraining);
                switch (rgTraining.getCheckedRadioButtonId()) {
                    case (R.id.radioButtonTrainingAreaHome):
                        for (Lutemon lutemon : lutemonsMove) {
                            home.createLutemon(lutemon);
                            trainingArea.removeLutemonFromTraining(lutemon.getID());
                        }
                        break;
                    case (R.id.radioButtonTrainingAreaFight):
                        for (Lutemon lutemon : lutemonsMove) {
                            battleField.addLutemonToBattleField(lutemon);
                            trainingArea.removeLutemonFromTraining(lutemon.getID());
                        }
                        break;
                };
            }
        });
        return view;
    }
}