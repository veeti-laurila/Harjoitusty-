package com.example.harjoitusty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListLutemonsActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;
    private LutemonListAdapter adapter;
    private ArrayList<Lutemon> lutemons;
    private ArrayList<Lutemon> removedLutemons;
    private ArrayList<Lutemon> experiencedLutemons;
    private ArrayList<Lutemon> trainedLutemons;
    private ArrayList<Lutemon> lutemonsMovedToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        storage = Storage.getInstance();
        lutemons = storage.getLutemons();

        removedLutemons = null;
        experiencedLutemons = null;
        trainedLutemons = null;
        lutemonsMovedToHome = null;

        recyclerView = findViewById(R.id.rvLutemonsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LutemonListAdapter(getApplicationContext(), lutemons);
        recyclerView.setAdapter(adapter);

        Button buttonUpdate = findViewById(R.id.buttonUpdate);

        // Updates the list in RecyclerView
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removedLutemons = BattleField.getInstance().getRemovedLutemons();
                if (!removedLutemons.isEmpty()) {
                    String name = removedLutemons.get(0).getName();
                    int i = 0;
                    for (i = 0; i < lutemons.size(); i++) {
                        if (lutemons.get(i).getName().equals(name)) {
                            lutemons.remove(i);
                            removedLutemons.remove(0);
                            adapter.notifyItemRemoved(i);
                            break;
                        }
                    }
                }

                experiencedLutemons = BattleField.getInstance().getExperiencedLutemons();
                if (!experiencedLutemons.isEmpty()) {
                    String name = experiencedLutemons.get(0).getName();
                    int j = 0;
                    for (j = 0; j < lutemons.size(); j++) {
                        if (lutemons.get(j).getName().equals(name)) {
                            lutemons.get(j).setExperience(1);
                            lutemons.get(j).setAttack(1);
                            lutemons.get(j).setHealth(experiencedLutemons.get(0).getHealth());
                            experiencedLutemons.remove(0);
                            adapter.notifyItemChanged(j);
                            break;
                        }
                    }
                }

                trainedLutemons = TrainingArea.getInstance().getTrainedLutemons();
                if (!trainedLutemons.isEmpty()) {
                    String name = trainedLutemons.get(0).getName();
                    int k = 0;
                    for (k = 0; k < lutemons.size(); k++) {
                        if (lutemons.get(k).getName().equals(name)) {
                            lutemons.get(k).setExperience(1);
                            lutemons.get(k).setAttack(1);
                            trainedLutemons.remove(0);
                            adapter.notifyItemChanged(k);
                            break;
                        }
                    }
                }

                lutemonsMovedToHome = Home.getInstance().getLutemonsMovedToHome();
                if (!lutemonsMovedToHome.isEmpty()) {
                    String name = lutemonsMovedToHome.get(0).getName();
                    int l = 0;
                    for (l = 0; l < lutemons.size(); l++) {
                        if (lutemons.get(l).getName().equals(name)) {
                            lutemons.get(l).setHealth(lutemons.get(l).getMaxHealth());
                            lutemonsMovedToHome.remove(0);
                            adapter.notifyItemChanged(l);
                            break;
                        }
                    }
                }
            }
        });
    }
}