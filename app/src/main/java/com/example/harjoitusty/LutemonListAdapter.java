package com.example.harjoitusty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonsViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonsViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_lutemons_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonsViewHolder holder, int position) {
        holder.name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.defense.setText("Puolustus: " + lutemons.get(position).getDefense());
        holder.health.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.experience.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.picture.setImageResource(lutemons.get(position).getPicture());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
