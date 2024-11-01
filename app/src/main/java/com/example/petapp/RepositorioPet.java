package com.example.petapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPet extends SQLiteOpenHelper {


    public RepositorioPet(@Nullable Context context) {
        super(context, "pet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table pet" +
                "(id integer not null primary key," +
                "nome text," + "idade integer)";
        sqLiteDatabase.execSQL(sql);
        Log.i("log", "Criado a tabelta pet");

    }

    public void adcionarPet(Pet pet){
        String sql = "insert into pet values(null,'" + pet.nome + "'," + pet.idade + ")";
        Log.i("pet", "SQL insert pet:" + sql);
        super.getWritableDatabase().execSQL(sql);
    }

    public List<Pet> listarPet(){
        ArrayList<Pet> lista = new ArrayList<Pet>();
        String sql = "select * from PET";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();

        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0);
            pet.nome = cursor.getString(1);
            pet.idade = cursor.getInt(2);
            lista.add(pet);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
