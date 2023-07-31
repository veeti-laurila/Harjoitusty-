package com.example.harjoitusty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonsViewHolder extends RecyclerView.ViewHolder {

    TextView name, attack, defense, health, experience;
    ImageView picture;

    public LutemonsViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textViewName);
        attack = itemView.findViewById(R.id.textViewAttack);
        defense = itemView.findViewById(R.id.textViewDefense);
        health = itemView.findViewById(R.id.textViewHealth);
        experience = itemView.findViewById(R.id.textViewExperience);
        picture = itemView.findViewById(R.id.imageViewPicture);
    }
}
