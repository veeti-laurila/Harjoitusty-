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

public class FragmentHome extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        battleField = BattleField.getInstance();
        trainingArea = TrainingArea.getInstance();
        home = Home.getInstance();

        ArrayList<Lutemon> lutemonsHome = home.getLutemonsHome();
        RadioGroup rgMoveHome = view.findViewById(R.id.radioGroupMoveHome);

        // Creates RadioButton for every Lutemon in Home
        for (Lutemon lutemon : lutemonsHome) {
            RadioButton rb = new RadioButton(view.getContext());
            rb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            rb.setId(lutemon.getID());
            rgMoveHome.addView(rb);
        }

        rgMoveHome.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

            }
        });

        Button buttonMoveHome = view.findViewById(R.id.buttonMoveHome);
        RadioGroup rgHome = view.findViewById(R.id.radioGroupHome);

        buttonMoveHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rgHome != null) {
                    Lutemon lutemonRemove = null;
                    int selectedRadioButtonId = rgMoveHome.getCheckedRadioButtonId();

                    // Adds selected Lutemon to list
                    for (Lutemon lutemon : lutemonsHome) {
                        if (lutemon.getID() == selectedRadioButtonId) {
                            lutemonRemove = lutemon;
                            break;
                        }
                    }

                    // Moves Lutemon to selected place and removes it from Home
                    if (lutemonRemove != null) {
                        switch (rgHome.getCheckedRadioButtonId()) {
                            case (R.id.radioButtonTrainingAreaHome):
                                trainingArea.addLutemonToTrainingArea(lutemonRemove);
                                trainingArea.train(lutemonRemove);
                                break;
                            case (R.id.radioButtonBattleFieldHome):
                                battleField.addLutemonToBattleField(lutemonRemove);
                                break;
                        }
                        home.removeLutemonFromHome(lutemonRemove.getID());
                    }
                    rgHome.clearCheck();
                    rgMoveHome.clearCheck();
                }
            }
        });
        return view;
    }
}