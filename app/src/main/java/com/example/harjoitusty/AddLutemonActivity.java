package com.example.harjoitusty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        name = findViewById(R.id.editTextName);
    }

    // returns name
    public String getName() {
        String lutemonName = name.getText().toString();
        return lutemonName;
    }

    // returns random ID
    public int getID() {
        double ID = Math.random() * 100;
        int id = (int)ID;
        return id;
    }

    // Creates new Lutemon
    public void addLutemon(View view) {
        RadioGroup rgColor = findViewById(R.id.RadioGroupColor);

        switch (rgColor.getCheckedRadioButtonId()) {
            case R.id.radioButtonWhite:
                Storage.getInstance().addLutemon(new White(getName(), getID()));
                Home.getInstance().createLutemon(new White(getName(), getID()));
                break;
            case R.id.radioButtonGreen:
                Storage.getInstance().addLutemon(new Green(getName(), getID()));
                Home.getInstance().createLutemon(new Green(getName(), getID()));
                break;
            case R.id.radioButtonPink:
                Storage.getInstance().addLutemon(new Pink(getName(), getID()));
                Home.getInstance().createLutemon(new Pink(getName(), getID()));
                break;
            case R.id.radioButtonOrange:
                Storage.getInstance().addLutemon(new Orange(getName(), getID()));
                Home.getInstance().createLutemon(new Orange(getName(), getID()));
                break;
            case R.id.radioButtonBlack:
                Storage.getInstance().addLutemon(new Black(getName(), getID()));
                Home.getInstance().createLutemon(new Black(getName(), getID()));
                break;
        }

        name.getText().clear();
        rgColor.clearCheck();
    }
}