package com.example.petapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CadastroPetActivity extends AppCompatActivity {

    ArrayList<Pet> listaDePet;
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle("Cadastro");

        listaDePet  = (ArrayList<Pet>) getIntent().getSerializableExtra("lista_pet");
        Log.i("Pet","Cadastro carregado com sucesso");

        repositorioPet = new RepositorioPet(this);

    }

    public void cadastrar(View view) {
        EditText editTextNomePet = findViewById(R.id.editTextNomePet);
        EditText editTextIdadePet = findViewById(R.id.editTextIdadePet);

        String nome = editTextNomePet.getText().toString();
        String idade = editTextIdadePet.getText().toString();

        if (nome.isEmpty() || idade.isEmpty()){
            Toast.makeText(this, "Preenche os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Pet pet = new Pet();
            pet.nome = nome;
            pet.idade = Integer.parseInt(idade);
            repositorioPet.adcionarPet(pet);
            Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}